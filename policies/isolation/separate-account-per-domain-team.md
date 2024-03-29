[Data Mesh Governance](https://www.datamesh-governance.com/) / [Policies](https://www.datamesh-governance.com/#policies) / [Isolation](https://www.datamesh-governance.com/#isolation)

# Separate Account per Domain Team

Category: Isolation  
Platform: AWS  

## Context

We use AWS as our data platform and store data on S3.

How can we isolate the internal data and used services from other teams?

## Decision

We give each team a separate AWS account.


## Consequences

- Highly separated environments, by default
- Data is protected, by default
- Access to data products needs to actively be managed by IAM policies on S3 buckets
- We need a data catalog to discover available data projects
- Other teams cannot break things in our account
- We need to ensure that data flows within a data center only to avoid egress costs
- We can use [AWS Organizations](https://aws.amazon.com/organizations/) to create and manage AWS accounts
- Simple AWS cost overview through AWS Cost Explorer
- Billing is consolidated by the AWS organization

## Considered Alternatives

- Single account for all teams and isolation on IAM policies

## Automation

- The data platform team is asked to automate the creation of AWS accounts using self-services 
- e.g. by a pull-request in a Terraform repository
- e.g. by a self-service in backstage.io
