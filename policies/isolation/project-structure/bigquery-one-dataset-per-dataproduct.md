[Data Mesh Governance](https://www.datamesh-governance.com/) / [Policies](https://www.datamesh-governance.com/#policies) / [Isolation](https://www.datamesh-governance.com/#isolation) / Project Structure

# One dataset per data product

Category: Isolation  
Platform: BigQuery

[//]: # (order:2)

## Context

For consistency, we want a uniform structure and naming of our BigQuery projects.

The structure must fit to BigQuery's strict 3-level-hierarchy:

- project
  - dataset
    - tables
    - views

BigQuery has some naming restrictions:
Project IDs must be 6-30 characters, contain letters, numbers, and hyphens and are globally unique, cannot be in use or have previously been used. Datasets and table names can contain up to 1024 characters, numbers and underscores.

## Decision

We agree on a set of conventions for our BigQuery projects, datasets, and tables:

### Project ID

Format:

`<orgname>[-<env>]-data-<domain>`

Elements:
- **&lt;orgname&gt;** is the short name of our organization.
- **&lt;env&gt;** represents the environment, such as _dev_ and _test_. Omitted for _prod_, to keep the default short.
- **data** is the indication that this is a data mesh specific project.
- **&lt;domain&gt;** is the short name of the domain team.

Examples:
- `acme-data-search`
- `acme-data-articles`
- `acme-data-checkout`
- `acme-data-fulfillment`
- `acme-test-data-checkout`


### Datasets

A BigQuery dataset equals one data product.

Examples:

- `searches`
- `searches_daily_top100`
- `inventory`
- `shelf_warmers`

### Tables and Views

We use prefixes to structure the data models within a data product:

- **src_** for raw and imported data, followed by the source system name and concept, e.g. `src_googleanalytics__activity_search`
- **stg_** casting, cleaning, renaming of source data, e.g. `stg_googleanalytics__activity_search`
- **objects_** for cleaned and curated stateful business objects. Usually with suffix `_latest` or `_history`, e.g. `objects_users_latest`
- **event_** for cleaned and curated immutable business events, e.g. `event_searches`
- **manual_** for manual managed data, e.g. `manual_country_codes`
- **agg_** for use-case specific aggregations, e.g. `agg_searches__total_by_day`

Further naming conventions:

- lowercase
- plural (if applicable)
- Additional context can be added to a concept using double underscores `__`
- avoid technical abbreviations, if not generally known
  - OK: id, gdpr, pii, sku
  - Not OK: cust, acc, shpmnt


## Consequences

- High isolation per data product
- Typically, _objects_, _events_, and _aggregations_ may be part of a data contract and published to other teams.
- If sources are required by different data products in the same domain, source data might become be redundant. This can be mitigated by providing cleaned version of the source as a separate data product, and downstream data products link to it. 

## Automation

The BigQuery project structure can be set up through a self-service web-app, when a new data product is created.

A dbt hook can be implemented that makes sure that all models use the defined prefixes.