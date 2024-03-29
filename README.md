# Data Mesh Governance by Example

Curated examples for [Data Mesh](https://www.datamesh-architecture.com) [guiding values](#guiding-values), an [operating model](#operating-model), and [global policies](#policies) to support a federated governance group.

We want this to be an open source collection of policy examples, driven by the community. Contribute by submitting a pull request on the [GitHub repository](https://github.com/datamesh-governance/datamesh-governance.com).

<img src="images/governance.png" alt="Data Mesh Governance" width="1024">

The [data mesh governance group](operating-model/members/members.md) consists of representatives from the domain teams and the data platform team.

They are temporarily supported by a subject-matter experts, to address special issues, e.g. concerning legal, compliance, and security.

Together, they make sure that data products in the mesh are interoperable and can be used securely. For this, they agree on a few architectural decisions and global policies. To make it easy for domain teams to implement the policies, they specify the requirements for the data platform to automate the policies as much as possible.

## Guiding Values

Guiding values are the fundamental beliefs we agree on when implementing data mesh governance. 
They guide us to make the right choices and give justification for our decisions. 

- Promote the usage of data products
- Optimize experience for generalist majority
- Standardize for interoperability
- Enforce consistent security
- Design for automation

## Operating Model

The operating model defines the structure and processes of the  data mesh governance group.
After forming the group with its members, in the first meeting the collaboration mode, communication channels and a policy repository needs to be decided on.

### Members

- [Governance Group Members](operating-model/members/members.md)

### Collaboration Mode

- [Regular online meetings](operating-model/collaboration-mode/meetings.md)
- [Local Data Groups](operating-model/collaboration-mode/local-data-groups.md)
- Asynchronous collaboration (no meetings)

### Decision Making

- [Consent](operating-model/decision-making/consent.md)
- Consensus
- Democratic

### Communication Channels

- [Microsoft Teams Channels](operating-model/communication-channels/microsoft-teams-channels.md)
- [Slack Channels](operating-model/communication-channels/slack-channels.md)
- Email Lists

### Policy Repository

- [Data Mesh Manager](https://datamesh-manager.com/)
- Confluence
- Git

[//]: # (Decision Process, Policy Template, Adoption Tracking Process, Data Platform Requirements and Tracking)

## Policies

[Policy Template](policies/template.md)

### Definitions

[//]: # (- Domain)
- [Data Product](policies/definitions/data-product/data-product.md)
- [Data Contract](policies/definitions/data-contract/data-contract.md)

### Interoperability

- Data Product Specification
  - [dataproduct-specification.com](https://dataproduct-specification.com)
  - [Open Data Product Specification](policies/interoperability/data-product-specification/02-open-data-product-specification.md)
  - [Agile Lab Data Product Specification](policies/interoperability/data-product-specification/03-agilelab-data-product-specification.md)
  - [Data Product Descriptor Specification](policies/interoperability/data-product-specification/04-data-product-descriptor-specification.md)
  - [No Formal Data Product Specification](policies/interoperability/data-product-specification/01-no-formal-data-product-specification.md)
  - Terraform Modul Configuration
- Data Contract Specification
  - [datacontract-specification.com](https://datacontract-specification.com)
- Address scheme
- File Format
  - [Parquet File Format](policies/interoperability/file-format/parquet-file-format.md)
  - [Delta File Format](policies/interoperability/file-format/delta-file-format.md)
  - [JSON File Format](policies/interoperability/file-format/json-file-format.md)
- Partitioning Keys
- Timestamp as ISO-8601 Strings
- Money amounts in cents as integers
- Common IDs
- Well-known Fields Names
- Bitemporal Timestamp Fields
- Naming Conventions (environment, database, table, column, file, bucket, ...)

### Isolation

- Project structure
  - [[BigQuery] One project per data product](policies/isolation/project-structure/bigquery-one-project-per-dataproduct.md)
  - [[BigQuery] One dataset per data product](policies/isolation/project-structure/bigquery-one-dataset-per-dataproduct.md)
  - [[BigQuery] One project per domain team](policies/isolation/project-structure/bigquery-one-project-per-domain-team.md)
  - AWS
  - Snowflake
- Environments
  - Production only
  - [Multiple Isolated Environments](policies/isolation/environments/multiple-isolated-environments.md)
- Central Governance Account
- [Separate Account per Domain Team](policies/isolation/separate-account-per-domain-team.md)
- Separate Database per Domain Team
- Separate Schema per Domain Team


### Discoverability
- Data Product Inventory
  - Confluence Wiki Page
  - [Data Mesh Manager](https://datamesh-manager.com/)
  - Backstage
  - LeanIX
  - Custom Web-Application
  - Data Catalog
- Data Catalog
  - [AWS Glue Data Catalog](policies/discoverability/data-catalog/aws-glue-data-catalog-as-data-catalog.md)
  - GCP Dataplex
  - Azure Purview
  - Databricks Unity
  - Collibra
  - Atlan
- [Tagging Tables as Data Products](policies/discoverability/tagging-tables-as-data-products-databricks-unity-data-catalog-tagging.md)
- Mandatory Ownership Information
- Mandatory Tags

### Quality

- [Retire unused data products after 6 months](policies/quality/retire-unused-data-products.md)
- Minimum level quality of a data product

### Documentation

- Documentation of data products
  - Wiki
  - Data Catalog
- Mandatory Fields for Data Products
- Schema Format

### Access Control

- Access Request
  - Ticket with manual steps
  - Decentralized self-service via Pull Requests
  - Central self-service app with decentralized handlers
- Access granted through AWS IAM Policies
- ACLs managed by domain teams
- Reassess after x month

### Consent Management

- One domain published consents as data product

### Privacy & Compliance

- [Data Classification](policies/privacy/data-classification/data-classification.md)
- PII data separation
- PII Anonymization
- Data Stored in Customer's Business Region
- PHI (protected health info)
- Data Retention Periods
- Right to be Forgotten By Tombstone Events
- Politically exposed person (PEP)
- People in witness protection program

### Security

- [Encryption at Rest](policies/security/encryption-at-rest.md)
- Encryption at Transit
- VPC

### Monitoring

- Observability Metrics
- Cost reporting

### Self-service

- Data Product Creation
  - Self-service app (Backstage.io)
  - Tutorials/guides

### Ownership

- Ownership for New Data Products
- Ownership for Legacy Data Products


## Architecture Decisions

While it is not the federated governance group's actual job to define the architecture of the data platform,
decisions about the platform have consequences for global policies and vice versa, e.g. for policy automation and monitoring.
The governance group always has to keep track of those decisions related to the data platform.

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


## Learn more

### Communities

- [LinkedIn Group: Data Governance - Data mesh](https://www.linkedin.com/groups/9226364/)

### Scientific Literature

- [Wider, Arif & Verma, Sumedha & Akhtar, Atif. (2023). Decentralized Data Governance as Part of a Data Mesh Platform: Concepts and Approaches. ](https://www.researchgate.net/publication/371399084_Decentralized_Data_Governance_as_Part_of_a_Data_Mesh_Platform_Concepts_and_Approaches)

- [Joshi, D., Pratik, S., & Rao, M. P. (2021). Data governance in data mesh infrastructures: The Saxo bank case study. Proceedings of the International Conference on Electronic Business (ICEB), 21, 599–604.](https://aisel.aisnet.org/iceb2021/52/)
