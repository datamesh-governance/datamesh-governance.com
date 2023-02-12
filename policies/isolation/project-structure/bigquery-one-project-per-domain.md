# One project per domain

Category: Interoperability  
Platform: BigQuery

[//]: # (order:3)

## Context

For consistency, we want a uniform structure and naming of our BigQuery projects.

## Decision

We agree on a set of conventions for our BigQuery projects, datasets and tables:

### Project ID

Requirements:
- 6-30 characters
- letters, numbers, and hyphens
- Cannot be in use or previously used

Format:

`<orgname>[-<env>]-data-<domain>`

Elements:
- **&lt;orgname&gt;** is the short name of our organization.
- **&lt;env&gt;** represents the environment, such as _dev_ and _test_. Omitted for _prod_ to keep the default short.
- **data** is the indication that this is a data mesh specific project.
- **&lt;domain&gt;** is the short name of the domain team.


### Datasets

- **source** for raw and imported data
- **staging** for cast, cleaned, renamed source data
- **objects** for cleaned and curated stateful business objects.
- **events** for cleaned and curated immutable business events.
- **manual** for manually managed data.
- **intermediates** for intermediary data structures.
- **aggregations** for use-case specific aggregations

If applicable, more datasets can be defined by adding a suffix, separated by an underscore, e.g. `source_googleanalytics`, `source_salesforce`, `source_kafka`.

### Tables / Views

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

- `acme-data-search`
  - `source`
    - `src_googleanalytics__activity_search`
  - `staging`
    - `stg_googleanalytics__activity_search`
  - `objects`
    - `users_latest`
    - `users_history`
  - `events`
    - `search_performed`
    - `search_result_clicked`
  - `manual`
    - `country_codes`
  - `intermediates`
    - `search_performed_with_result_clicked`
  - `aggregations`
    - `searches__top100_queries_by_day`
- `acme-data-articles`
- `acme-data-checkout`
- `acme-data-fulfillment`
- `acme-test-data-search`


## Consequences

- Uniform structure for all projects
- If a domain has multiple data products, they share the same datasets
- Typically, _objects_, _events_, and _aggregations_ may be part of a data contract and published to other teams.

## Automation

The BigQuery project structure can be set up through a self-service web-app, when a new data product is created.

A dbt hook can be implemented that makes sure that all models use the defined prefixes.
