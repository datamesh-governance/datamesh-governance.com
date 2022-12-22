# Retire unused data products after 6 months

Category: Quality  
Platform: BigQuery  

## Context

Unused data products create no value. 
They require effort to maintain.

## Decision

We retire data products that are unused for 6 months.

We warn the team, if a data product is unused for 5 months.

## Consequences

- Data catalog contains only high-valued data products
- Data Access audit logs (Cloud Audit Logs) must be enabled (enabled by default)

## Follow-Up Questions

- How to actually retire a data product?
- How and when to archive data?

## Automation

We do not want automated retirement.

The platform should add a tag for unsued data products and send emails to the ownership team.

## Monitoring

- Check BigQuery audit log for usages per resource grouped by data products
- A dashboard with unused data products
