# Data Product Storage

Category: Interoperability  
Platform: Databricks, Azure Synapse Analytics, Generic Data Lake  
Status: Proposed  
Tags: platform, storage, data lake

## Context

We use Databricks as our data platform ([databricks-as-data-platform](databricks-as-data-platform.md)).

Data product producers need to store data products, so that other domains can easily access and query the data.

Ease of use, performance, and egress-costs are to be considered.


## Decision

We store the data of data products as files on Azure Data Lake Storage Gen2.

We use the same Azure region for all data products (Germany West Central) in the same VPC to avoid egress costs.


## Consequences

- Performance optimized for machine learning and batch processing
- Higher costs for SQL access (e.g. Tableau), as a separate SQL warehouse instance is neccessary
- ADLS is not natively integrated in the Databricks platform, access management is cumbersome
- Storage costs are reasonable, when a optimized file format is used
- A metastore is required to define table structures/schemas


## Follow-up questions:

- ownership (who creates the bucket)
- which Resource group (billing): central vs. domain's
- ACL: who grants access
- ACL: how is it integrated?
- As we use files, supported file format must be defined
- Folder structure / isolation
  - 1 bucket for organization
  - 1 bucket per team
  - 1 bucket per data product
- private data sets vs. published data products

## Considered Alternatives

- Azure Blob Storage

## Automation

- Terraform create Azure Storage Accounts
- Domain teams create a pull request with new storage account


