# datamesh-governance.com

## Global Policies

[Template](policies/_template)


### Data Platform

- AWS Athena as Data Platform
- AWS Redshift as Data Platform
- GCP BigQuery as Data Platform
- Azure Synapse Analytics as Data Platform
- Snowflake as Data Platform
- Databricks as Data Platform
- S3 as Storage for Data Products
- GCP as Storage for Data Products
- BigQuery as Storage for Data Products
- Azure ADLS as Storage for Data Products

### Isolation
- Separate Account per Domain Team
- Separate Database per Domain Team
- Separate Schema per Domain Team
- Bucket/Folder Structure
    - 1 bucket for organization
    - 1 bucket per team
    - 1 bucket per data product
- Address scheme

### Interoperability
- Parquet File Format
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

### Documentation
- Documentation in Wiki
- Documentation in Data Catalog
- Mandatory Fields for Data Products
- Schema Format

### Access Control
- Access granted through AWS IAM Policies
- ACLs managed by Domain Teams

### Consent Management
- Consents Provided by Checkout Domain

### Privacy & Compliance
- Right to be Forgotten By Tombstone Events
- Data Stored in Customer's Business Region
- Data Classification Scheme
- PII Anonymization Requirements
- Data Retention Periods

### Security
- Encryption at Rest
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


