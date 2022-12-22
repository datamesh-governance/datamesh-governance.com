# AWS S3 as Storage for Data Products

Category: Data Platform
Platform: AWS  

## Context

How do we store analytical data, so that they can be processed efficiently and shared with other teams as data products?

Most teams use Apache Kafka to exchange data and publish domain events.
On average, we expect a total of 10 TB analytical data per team.

Many domain teams use AWS services for their operational systems.

## Decision

We use AWS S3 as storage for data products.

## Consequences

- Scalable storage, with a pay-per-use cost model
- Costs ~30 USD/TB for standard storage class
- Managed connectors available, such as [Amazon S3 Sink Connector for Confluent Platform](https://docs.confluent.io/cloud/current/connectors/cc-s3-sink.html#amazon-s3-sink-connector-for-ccloud)
- Engineers need to learn and use appropriate file formats
- Data syntax needs to be configured in a meta store (Glue Metastore)
- No native integration for data analytics tools (Looker, Tableau, ...)
- AWS IAM to manage access management

## Considered Alternatives

- AWS Redshift

## Automation

- S3 buckets can be created with Terraform
