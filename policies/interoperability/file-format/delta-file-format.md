[Data Mesh Governance](https://www.datamesh-governance.com/) / [Policies](https://www.datamesh-governance.com/#policies) / [Interoperability](https://www.datamesh-governance.com/#interoperability) / File Format

# Delta File Format

Category: Interoperability  
Platform: Databricks, Azure Synapse Analytics, Generic Data Lake  

## Context

Data products are stored as files on S3 ([AWS S3 as Storage for Data Products](../../../architecture-decisions/data-platform/aws-s3-as-storage-for-data-products.md)).

To ensure interoperability and consistent usage patterns, we want to agree on a common file format.

We assume that data products frequently will be combined across domains.

## Decision

We use Delta as file format for data products.

## Consequences

- Software engineers need to learn Delta and Parquet file format
- Delta is still not a wide-spread format beyond Databricks and Azure, limits use with other tools
- Low storage and IO costs through compression
- Fast querying and processing, as column-oriented file format
- Additional transaction log
- supports update and delete operations -> Do we want to use this feature for data products?
- Files may be fragmented after updates
- Time travel is possible
- Follow-Up Questions
  - Partitioning
  - How to document the schema?
  - Timestamp format
  - How to model mutable data (like master and reference data)?

## Automation

- Databricks comes with Delta support out of the box
- Automated testing: Query all data products periodically and try to deserialize latest file


