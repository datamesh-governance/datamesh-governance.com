[Data Mesh Governance](https://www.datamesh-governance.com/) / [Policies](https://www.datamesh-governance.com/#policies) / [Discoverability](https://www.datamesh-governance.com/#discoverability) / Data Catalog

# AWS Glue Data Catalog as Data Catalog for Data Products

Category: Discoverability
Platform: AWS  

## Context

We use [AWS S3 as Storage for Data Products](/architecture-decisions/aws-s3-as-storage-for-data-products.md) and [AWS Athena as Query Engine](/architecture-decisions/data-platform/aws-athena-as-query-engine.md).
Athena already forces us to define table structure in the metastore _AWS Glue Data Catalog_.

How can we register data products in a central place for other teams to discover and understand data products?

## Decision

We use AWS Glue Data Catalog as catalog for data products.

We use a central AWS governance account that hosts the data catalog that links to data that lives in domain team's AWS account.

![Example of a table in AWS Glue Data Catalog](https://www.datamesh-governance.com/images/aws-glue-data-catalog-table.png)

## Consequences

- One AWS accounts has exactly one AWS Glue Data Catalog
- One Data Catalog can contain multiple databases
- One database can contain multiple tables
- A table refers to an S3 data store that lives in a domain team's AWS account
- The AWS Glue Data Catalog is basically a Hive Metastore, with all its limitations
- Only data products that live inside AWS cloud and are supported by the AWS Glue Data Catalog can be indexed.
- Databases and tables defined in AWS Glue Data Catalog are also available in AWS Lake Formation for further data governance capabilities
- AWS Glue Data Catalog search capabilities are limited, e.g. cannot search for tables tagged with a specific property, such as `dataproduct=true`
- An [AWS Glue API](https://docs.aws.amazon.com/glue/latest/dg/aws-glue-api-catalog.html) is available for further automation

## Considered Alternatives

- A third party data catalog
- A Wiki page listing data products

## Automation

- Use AWS EventBridge to propagate catalog entries, resources and permissions to the central governance account.
