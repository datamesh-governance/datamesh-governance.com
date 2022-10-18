# Databricks as Data Platform

Category: Platform / Architecture Decision  
Status: Proposed at 2022-10-18  
Tags: platform, architecture decision, databricks  

## Context

For data mesh, a self-serve data platform is required.
We don't want to build this completely by outselves, but want to tailor an existing data platform to our data mesh needs.

We use Microsoft Azure for our operational systems. We are a regulated company in the finance sector. We rely heavily on Tableau for our reports.

## Decision

We use Azure Databricks as our central data platform.

![](https://d33wubrfki0l68.cloudfront.net/a15cf04d5877ccea0a278c4c0318a1f491702425/2bbf4/images/databricks.png.webp)

## Consequences

- Business partner is Microsoft, no separate contract with Databricks, Inc required.
- Expected costs: XXX USD/month
- Analytical data is stored as files in Azure Data Lake Storage Gen2 (TODO: Link to Policy)
- Software developers will mostly write transformations as notebooks using PySpark, SQL or Scala

## Options

- Azure Synapse Analytics
- Snowflake deployed to Azure

## Automation

- There is an excellent Terraform provider for Databricks available to setup infrastructure: https://registry.terraform.io/providers/databricks/databricks/latest/docs

## Verification / Adherence / Monitoring

- How to monitor the policy adoption?
- How to detect policy drift?
