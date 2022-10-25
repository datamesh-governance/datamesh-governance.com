# Retire unused data products

Category: Quality  
Platform: BigQuery  
Status: Proposed  
Tags: retire, BigQuery

## Context

Unused data products create no value, but require effort to maintain.

## Decision

We retire data products that are unused for 6 months.
We warn the team, if a data product is unused for 5 months.

## Consequences

- Data catalog contains valued data products
- Data Access audit logs (Cloud Audit Logs) must be enabled (enabled by default)

## Follow-Up Questions

- How to retire a data product?
- How and when to archive data?

## Automation

We do not want automated retirement.

## Monitoring

- Access audit log of BigQuery and check for usages per resource grouped by data products

? filter out monitoring requests

- How to monitor the policy adoption?
- How to detect policy drift?
