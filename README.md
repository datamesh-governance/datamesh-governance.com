# datamesh-governance.com

## Data Mesh Governance by Example

A curated list of examples for Data Mesh guiding values, architecture decisions, and global policies to support a federated governance team.

Architecture descions and policies are formulated as Architecture Decision Records (ADRs) using this [template](policies/_template.md).

_Note that some examples are only applicable in certain contexts or with specific data platforms._


## Guiding Values

- Minimize global decisions
- Embrace bounded contexts
- Standardize for interoperability
- Enforce consistent security 
- Design for automation 

## Architecture Decisions

### Data Platform

- AWS Athena as Query-Engine
- AWS Redshift as Data Platform
- AWS S3 as Storage for Data Products
- AWS Lake Formation as Data Catalog
- GCP BigQuery as Data Platform
- GCP BigQuery as Storage for Data Products
- GCP Cloud Storage as Storage for Data Products
- GCP Dataplex as Data Catalog
- Azure Synapse Analytics as Data Platform
- [Azure ADLS as Storage for Data Products](policies/platform/data-product-storage.md)
- Azure Purview as Data Catalog
- Snowflake as Data Platform
- [Databricks as Data Platform](policies/platform/databricks-as-data-platform.md)
- Databricks Unity as Data Catalog
- Collibra as Data Catalog
- Atlan as Data Catalog
- Simple Wiki Page as Data Catalog
- Presto as On-Premise Query-Engine
- MinIO as On-Premise Storage for Data Products

### Structure
- Separate Account per Domain Team
- Separate Database per Domain Team
- Separate Schema per Domain Team
- Bucket/Folder Structure
    - 1 bucket for organization
    - 1 bucket per team
    - 1 bucket per data product
- Address scheme

## Policies

### Interoperability
- JSON File Format
- [Parquet File Format](policies/interoperability/parquet-file-format.md)
- Delta File Format
- Partitioning Keys
- Timestamp as ISO-8601 Strings
- Money amounts in cents as integers
- Common ID Naming Conventions
- Context Mapping (?)

### Discoverability
- Registration of Data Product in Wiki
- Registration of Data Product in Data Catalog
- Mandatory Ownership Information
- Mandatory Tags

### Quality
- Minimum level quality of a data product

### Documentation
- Documentation in Wiki
- Documentation in Data Catalog
- Mandatory Fields for Data Products
- Schema Format

### Access Control
- Access granted through AWS IAM Policies
- ACLs managed by Domain Teams
- Reassess after x month

### Consent Management
- Consents Provided by Checkout Domain

### Privacy & Compliance
- Data Classification Scheme (restricted, sensitive, unrestricted)
- Data Stored in Customer's Business Region
- PII Anonymization
- PHI (protected health info)
- Data Retention Periods
- Right to be Forgotten By Tombstone Events

### Security
- [Encryption at Rest](policies/security/encryption-at-rest.md)
- Encryption at Transit
- VPC

### Monitoring
- Observability Metrics
- Cost reporting

### Domain Ownership (TBD)
- Ownership for New Data Products
- Ownership for Legacy Data Products

### Other
- Generic Policy

## Template

- [Template](policies/_template.md)

