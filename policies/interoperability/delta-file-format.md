# Delta File Format

Category: Interoperability  
Platform: Databricks, Azure Synapse Analytics, Generic Data Lake  
Status: Proposed  

## Context

Data products are stored as files on Azure Data Lake Storage Gen2 ([Data Product Storage](../../architecture-decisions/data-platform/azure-adls-as-storage-for-data-products.md)).

To ensure interoperability and consistent usage patterns, we want to agree on a common file format.

We assume that data products frequently will be combined across domains.

## Decision

We use Apache Parquet for data products.

## Consequences

- Low storage and IO costs
- Fast querying and processing
- Software engineers need to learn Parquet file format.
- Append only
- binary ->  efficient storage -> IO optimized
- column-oriented -> efficient JOIN operations
- (limited) meta data included
- machine-readable

## Follow-Up Questions

- Partitioning
- How to document the schema?
- Timestamp format
- How to model mutable data (like master and reference data)?

## Considered Alternatives

- JSON
- Delta
- Multi-format

## Automation

- Databricks comes with Parquet support out of the box
- Tutorials provided by enabling team

## Verification / Adherence / Monitoring

- Query all data products ([GOV-12](datacatalog.md)) periodically and try to deserialize latest file
- Query all data products ([GOV-12](datacatalog.md)) periodically and check suffix
- Webhook after each data product publishing with tag `serialization:parquet`