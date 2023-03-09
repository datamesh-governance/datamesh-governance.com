[Data Mesh Governance](https://www.datamesh-governance.com/) / [Policies](https://www.datamesh-governance.com/#policies) / [Discoverability](https://www.datamesh-governance.com/#discoverability)

# Tagging Tables as Data Products

Category: Discoverability  
Platform: Databricks  

## Context

We use Databricks as data platform (TODO Link to architecture decision record).  
We use Databricks Unity Catalog as data catalog (TODO Link to architecture decision record).

Unity Catalog is a metastore and includes all schemas and tables of tables, that are both team-internal (like bronze and silver tables) and data exposed for others as data-products.

How do we identify data products in the Unity Catalog?

## Options

__A: Separate Catalog for data products__

A separate catalog "data products": Data products are registered in a separate catalog, called "data products". Each team has its own schema. Each table represents a data product. Tables are managed as external tables.

__B: Separate Schema for data products__

Each team has its own catalog. Each catalog has a schema with the name `DATA_PRODUCTS`. All tables in this schema are considered as a data products. A table can be a managed table, external table or view.

__C: Tagging__

Tables that represent a data product are tagged with a [table property](https://docs.databricks.com/sql/language-manual/sql-ref-syntax-ddl-tblproperties.html#tblproperties) `data_product_name` stating the name of the data product. This implies that the table is a data product.

__D: Prefix__

Data products are prefixed with `DP_`.

__E: Access Control__

Every table is a potential data product. We use access control to provide access for other teams.


## Decision

We use a [table property](https://docs.databricks.com/sql/language-manual/sql-ref-syntax-ddl-tblproperties.html#tblproperties) to identify data products.

Each data product must have these tags sets:

| property_key        | property_value                          |
|---------------------|-----------------------------------------|
| data_product_name   | (The readable name of the data product) |
| data_product_domain | (The name of the domain)                |
| data_product_team   | (The name of the team)                  |


## Consequences

- Data consumers can search for the tag `data_product_name` in the Unity catalog to identify data products.
- Table properties are part of the proprietary Databricks SQL syntax, hence we increase vendor lock-in to Databricks.
- Table properties can be assigned during table creation, and altered later.
- No external data catalog needed.

## Automation

- Something similar to Google's Data Product Template: https://cloud.google.com/architecture/describe-organize-data-products-resources-data-mesh#the_data_product_template

```
CREATE TABLE INVENTORY_HISTORY(sku string, quantity int, updated TIMESTAMP)
LOCATION 'abfss://container@storageaccount.dfs.core.windows.net/fulfillment/inventory_history';
TBLPROPERTIES(
'data_product_name' = 'inventory_history',
'data_product_domain' = 'fulfillment',
'data_product_team' = 'FUFI'
)
;
```

- Automated tests: Poll the [Unity Catalog API](https://api-docs.databricks.com/rest/latest/unity-catalog-api-specification-2-1.html), query for all tables and evaluate the `properties` field in `TableInfo` object responses.