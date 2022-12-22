# AWS Athena as Query Engine

Category: Data Platform
Platform: AWS  

## Context

We use AWS for many of our operational systems.
We use [AWS S3 as Storage for Data Products](architecture-decisions/aws-s3-as-storage-for-data-products.md).

How can we analyze data stored on S3?

## Decision

We use AWS Athena as Query Engine.

## Consequences

- We can use SQL to analyze data stored in S3 buckets
- Data virtualization tools, such as Quicksight, Looker, Tableau can access data products
- Data structures need to be defined in Glue Data Catalog
- Multiple file formats supported
- Serverless pricing model
- May become expensive for regular queries, such es data quality checks and monitoring
- For scheduled queries, an external scheduler is required

## Considered Alternatives

- AWS Redshift Spectrum
- S3 select

## Automation

- Athena databases can be created with Terraform
- A [dbt-athena](https://github.com/Tomme/dbt-athena) integration is available to leverage dbt models with athena
