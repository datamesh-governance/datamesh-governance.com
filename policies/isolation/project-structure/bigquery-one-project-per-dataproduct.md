# One project per data product

Category: Interoperability  
Platform: BigQuery

[//]: # (order:1)

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

`<orgname>[-<env>]-dp-<domain>-<dataproduct>`

Elements:
- **&lt;orgname&gt;** is the short name of our organization.
- **&lt;env&gt;** represents the environment, such as _dev_ and _test_. Omitted for _prod_, to keep the default short.
- **dp** is the indication that this is a data product.
- **&lt;domain&gt;** is the short name of the domain team.
- **&lt;dataproduct&gt;** is the short name of the data product.

Examples:
- `acme-dp-search-queries`
- `acme-dp-search-top100byday`
- `acme-dp-search-clicksbycat`
- `acme-dp-articles-articles`
- `acme-dp-checkout-orders`
- `acme-dp-checkout-customers`
- `acme-dp-fufi-shipments`
- `acme-dp-fufi-inventory`
- `acme-dev-dp-search-queries`
- `acme-test-dp-search-queries`
- `acme-test-dp-search-top100byday` ⚠️ too long


### Datasets

- **source** for raw and imported data
- **staging** for cast, cleaned, renamed source data
- **objects** for cleaned and curated stateful business objects.
- **events** for cleaned and curated immutable business events.
- **manual** for manually managed data.
- **intermediates** for intermediary data structures.
- **aggregations** for use-case specific aggregations

If applicable, more datasets can be defined by adding a suffix, separated by an underscore, e.g. `source_googleanalytics`, `source_salesforce`, `source_kafka`.


### Tables and Views

- use the model type as prefix source and staging
  - src_ for source
  - stg_ for staging
- lowercase
- plural (if applicable)
- Additional context can be added to a concept using double underscores `__`, e.g. `searches__top100_by_day`
- avoid technical abbreviations, if not generally known
  - OK: id, gdpr, pii, sku
  - Not OK: cust, acc, shpmnt


### Example

- `acme-dp-search-queries`
  - `source`
    - `src_googleanalytics__activity_search`
  - `staging`
    - `stg_googleanalytics__activity_search`
  - `events`
    - `search_performed`
    - `search_result_clicked`
  - `manual`
    - `country_codes`
- `acme-dp-search-top100byday`
  - `aggregations`
    - `searches__top100_queries_by_day`
- `acme-dp-search-clicksbycat`
- `acme-dp-articles-articles`
- `acme-dp-checkout-orders`
- `acme-dp-checkout-customers`
  - `objects`
    - `customers`
  - `aggregations`
    - `customers_anonymized`
- `acme-dp-fufi-shipments`
- `acme-dp-fufi-inventory`



## Consequences

- As the project ID is limited to only 30 characters, short names for domain and data product need to be defined. Can become hard to understand. A longer project name can be used for clarity.
- High isolation per data product
- Typically, _objects_, _events_, and _aggregations_ may be part of a data contract and published to other teams.
- If sources are required by different data products in the same domain, source data might become be redundant. This can be mitigated by providing cleaned version of the source as a separate data product, and downstream data products link to it. 

## Automation

The BigQuery project structure can be set up through a self-service web-app, when a new data product is created.

A dbt hook can be implemented that makes sure that all models use the defined prefixes.