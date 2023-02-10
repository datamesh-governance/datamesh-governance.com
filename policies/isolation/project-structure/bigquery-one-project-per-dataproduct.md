# BigQuery Project Structure and Naming Conventions (one project per data product)

Category: Interoperability  
Platform: BigQuery

## Context

For consistency, we want a uniform structure and naming of our BigQuery projects.

BigQuery has a strict hierarchy:

- GCP Account 
  - Project
    - Dataset 
      - Tables
      - Views

## Decision

We agree on a set of naming conventions for our BigQuery projects, datasets, and tables:

### Project ID

Requirements:
- 6-30 characters
- letters, numbers, and hyphens
- Globally unique, cannot be in use or previously been used

Format:

`<orgname>[-<env>]-data-<domain>-<dataproduct>`

Elements:
- **&lt;orgname&gt;** is the short name of our organization.
- **&lt;env&gt;** represents the environment, such as _dev_ and _test_. Omitted for _prod_, to keep the default short.
- **data** is the indication that this is a data mesh specific project.
- **&lt;domain&gt;** is the short name of the domain team.
- **&lt;dataproduct&gt;** is the short name of the data product.

Examples:
- `acme-data-search-queries`
- `acme-data-search-top100byday`
- `acme-data-search-clicksbycat`
- `acme-data-articles-articles`
- `acme-data-checkout-orders`
- `acme-data-checkout-customers`
- `acme-data-fufi-shipments`
- `acme-data-fufi-inventory`
- `acme-dev-data-search-queries`
- `acme-test-data-search-queries`
- `acme-test-data-search-top100byday` ⚠️ too long


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

- `acme-data-search-queries`
  - `source`
    - `src_googleanalytics__activity_search`
  - `staging`
    - `stg_googleanalytics__activity_search`
  - `events`
    - `search_performed`
    - `search_result_clicked`
  - `manual`
    - `country_codes`
- `acme-data-search-top100byday`
  - `aggregations`
    - `searches__top100_queries_by_day`
- `acme-data-search-clicksbycat`
- `acme-data-articles-articles`
- `acme-data-checkout-orders`
- `acme-data-checkout-customers`
  - `objects`
    - `customers`
  - `aggregations`
    - `customers_anonymized`
- `acme-data-fufi-shipments`
- `acme-data-fufi-inventory`



## Consequences

- As the project ID is limited to only 30 characters, short names for domain and data product need to be defined. Can become hard to understand. A longer project name can be used for clarity.
- High isolation per data product
- Typically, _objects_, _events_, and _aggregations_ may be part of a data contract and published to other teams.
- If sources are required by different data products in the same domain, source data might become be redundant. This can be mitigated by providing cleaned version of the source as a separate data product, and downstream data products link to it. 

## Automation

The BigQuery project structure can be set up through a self-service web-app, when a new data product is created.

A dbt hook can be implemented that makes sure that all models use the defined prefixes.