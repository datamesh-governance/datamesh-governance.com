# Data Mesh Governance by Example

A curated list of examples for [Data Mesh](https://www.datamesh-architecture.com) guiding values, architecture decisions, and global policies to support a federated governance group.


![Data Mesh Governance](images/governance.png)

The data mesh governance group consists of representatives from the domain teams and the data platform team.

They are temporarily supported by a subject-matter experts, to address special issues, e.g. concerning legal, compliance, and security.

Together, they make sure that data products in the mesh are interoperable and can be used securely. For this, they agree on a few architectural decisions and global policies. To make it easy for domain teams to implement the policies, they specify the requirements for the data platform to automate the policies as much as possible.

However, it is always up to the domain teams to adhere to the policies.



## Guiding Values

The following proposed guiding values are based on the guiding values, described by Zhamak Dehghani in her book in chapter 5.

- Minimize global decisions
- Optimize for generalist majority
- Embrace bounded contexts
- Standardize for interoperability
- Enforce consistent security 
- Design for automation 

## Architecture Decisions

While it is not the federated governance group's actual job to define the architecture of the data platform, 
architecture decisions have consequences for global policies and vice versa, e.g. for policy automation and monitoring.

Architecture decisions and policies are both formulated as Architecture Decision Records (ADRs) using this [template](policies/template.md).

_Note that some examples are only applicable in certain contexts or with specific data platforms._


### Data Platform

- [AWS S3 as Storage for Data Products](architecture-decisions/data-platform/aws-s3-as-storage-for-data-products.md)
- [AWS Athena as Query-Engine](architecture-decisions/data-platform/aws-athena-as-query-engine.md)
- AWS Redshift as Data Platform
- GCP BigQuery as Data Platform
- GCP Cloud Storage as Storage for Data Products
- Azure Synapse Analytics as Data Platform
- [Azure ADLS as Storage for Data Products](architecture-decisions/data-platform/azure-adls-as-storage-for-data-products.md)
- Snowflake as Data Platform
- [Databricks as Data Platform](architecture-decisions/data-platform/databricks-as-data-platform.md)
- Presto as On-Premise Query-Engine
- MinIO as On-Premise Storage for Data Products

## Policies

### Interoperability
- [Data Product Specification](policies/interoperability/data-product-specification.md)
- Address scheme
- File Format
  - [Parquet File Format](policies/interoperability/file-format/parquet-file-format.md)
  - [Delta File Format](policies/interoperability/file-format/delta-file-format.md)
  - [JSON File Format](policies/interoperability/file-format/json-file-format.md)
  - Multi-format
- Table Naming Conventions
- Column Naming Conventions
- File Name Conventions
- Partitioning Keys
- Timestamp as ISO-8601 Strings
- Money amounts in cents as integers
- Common IDs
- Common Fields Names
- Bitemporal Timestamp Fields

### Isolation
- [Separate Account per Domain Team](policies/isolation/separate-account-per-domain-team.md)
- Separate Database per Domain Team
- Separate Schema per Domain Team
- Bucket Structure
  - One bucket for organization
  - Bucket per team
  - Bucket per data product

### Discoverability
- Data Catalog
  - [AWS Glue Data Catalog](policies/discoverability/data-catalog/aws-glue-data-catalog-as-data-catalog.md)
  - GCP Dataplex
  - Azure Purview
  - Databricks Unity
  - Collibra
  - Atlan
  - Confluence
- [Tagging Tables as Data Products](policies/discoverability/tagging-tables-as-data-products-databricks-unity-data-catalog-tagging.md)
- Mandatory Ownership Information
- Mandatory Tags

### Quality
- [Retire unused data products after 6 months](policies/quality/retire-unused-data-products.md)
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

### Ownership (TBD)
- Ownership for New Data Products
- Ownership for Legacy Data Products

### Other
- Generic Policy

## Template

- [Template](policies/template.md)
