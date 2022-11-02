# AWS Glue Data Catalog as Data Catalog for Data Products

Platform: AWS  
Status: Proposed

## Context

We use [AWS S3 as Storage for Data Products](/architecture-decisions/aws-s3-as-storage-for-data-products.md) and [AWS Athena as Query Engine](/architecture-decisions/data-platform/aws-athena-as-query-engine.md).
Athena already forces us to define table structure in the metastore _AWS Glue Data Catalog_.

How can we register data products in a central place for other teams to discover and understand data products?

## Decision

We use AWS Glue Data Catalog as Data Catalog for Data Products

![Example of a table in AWS Glue Data Catalog](/images/aws-glue-data-catalog-table.png)

## Consequences

- One AWS accounts has exactly one AWS Glue Data Catalog
- One Data Catalog can contain multiple databases
- One database can contain multiple tables
- A table refers to an S3 data store that can live in the same AWS account or in another AWS account
- The AWS Glue Data Catalog is basically a Hive Metastore, that integrates well with many data tools
- Databases and tables defined in AWS Glue Data Catalog are also available in AWS Lake Formation for further data governance capabilities
- AWS Glue Data Catalog search capabilities are limited, e.g. cannot search for tables tagged with a specific property, such as `dataproduct=true`
- No cross-account searches or references. We need a policy under which AWS account we register data products
- As [AWS Glue API](https://docs.aws.amazon.com/glue/latest/dg/aws-glue-api-catalog.html) is available for further automation

## Considered Alternatives

- A third party data catalog
- A Wiki page listing data products

## Automation

- not required, a Glue Data Catalog catalog is created by default with an AWS account