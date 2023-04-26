[Data Mesh Governance](https://www.datamesh-governance.com/) / [Policies](https://www.datamesh-governance.com/#policies) / [Isolation](https://www.datamesh-governance.com/#isolation) / Environments

# Multiple Isolated Environments

Category: Isolation  
Status: Proposed

## Context

We need a place where we can develop and test data products before going to production.

We are not allowed to access production data for developing and testing purposes.

## Decision

We have multiple isolated environments:

- **DEV** for data product development. No guarantees on SLOs and data quality of other data products.
- **TEST / INT / UAT / STAGING / PRE-PROD** for integration tests with curated sample data.
- **PROD** for production with SLOs and data contracts applied.

The environments are structurally identical.

## Consequences

- The data platform needs to provide these isolated environments
- Data product developers need to deploy their data products on all environments
- Data product owners need to make sure that good-enough sample data is available in TEST environment for meaningful integration tests
  - Specific test-data requirements are defined in the data contract
- TBD: Do I need to sign a data contract on each environment?

## Automation

- The platform uses GitOps to provide structurally identical platforms
- Data product developers use GitOps to deploy data products on each environment