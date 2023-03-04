# Data Contract

Category: Definitions  
Status: Proposed

## Context

What is a data contract?

## Decision

A data contract is a formal agreement between two parties (data product provider and data product consumer) or by the data product provider to all potential users. 
It  specifies the guarantees about a provided data set and expectations converning data product access.

It covers:

* Data product name
* Data product provider
  * Data product owner contact details
* Data product consumer
  * Responsible consumer contact details
* Purpose
* Output port
  * Technology (files, tables, topics)
  * Format (Parquet, Delta, JSON, ...)
  * Global address
* Syntax
  * Field names and types
  * Primary and foreign keys
  * Partitions
* Semantics
  * Context-specific description of datasets and fields
  * Used well-known keys
  * Documentation
* Service-level objectives
  * Interval of change
  * Latency
  * Completeness
  * Freshness
  * Availability
  * Performance
  * Data volume
* Allowed usage patterns
  * Query frequency
* Security
  * The IAM role definition to grant
* Data classification
* Contract duration
  * Test data delivery date
  * Production data delivery date
  * Next contract reassessment date
* Costs and Billing

**Example**

| Name                            | Value                                                                                                                                                                                                                                                                                                                                                    |
|---------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Data product**                | Webshop Orders                                                                                                                                                                                                                                                                                                                                           |
| **Data product provider**           | Domain: Checkout<br>Data Product Owner: Nicky Cree (nicky.cree@example.com)                                                                                                                                                                                                                                                                              |
| **Data product consumer**           | Domain: Controlling<br>Responsible contact: Aubrey Harlow (aubrey.harlow@example.com)                                                                                                                                                                                                                                                                    |
| **Purpose**                         | Build a demand forecasting model                                                                                                                                                                                                                                                                                                                         |
| **Output port**                     | BigQuery<br>Global Address: https://example.com/dataproducts/checkout/orders (Entrypoint to JDBC Connection URL, schema definition, documentation, observability metrics)                                                                                                                                                                                |
| **Syntax**                          | Tables: orders, order_items                                                                                                                                                                                                                                                                                                                              |
| **Semantics**                       | All successful orders that have been made in the online shop.<br> PII NOT INCLUDED                                                                                                                                                                                                                                                                       |
| **Used well-known keys**            | order_id<br>webshop_customer_id<br>customer_number<br>address_id<br>paypal_transaction_id                                                                                                                                                                                                                                                                |
| **Service-level objectives**        | _Interval of change:_ Continuous streaming<br>_Latency:_ < 60 seconds<br>_Completeness:_ All orders since 2020-01-01T00:00:00Z<br/>_Freshness:_ Near real time, max. 60 seconds delay<br>_Availability:_ 99.9%<br>_Performance:_ Query all orders of last 12 months < 30 seconds<br>_Data volume:_ 5,000-10,000 orders per day expected, ~50 KiB / order |
| **Allowed usage patterns**          | Max queries per minute: 10<br/>Max data processing per day: 1 TiB<br/>Pub/Sub subscriptions                                                                                                                                                                                                                                                              |
| **Security**                        | IAM service-account: serviceAccount:controlling-data-consumer@example-prod-data.iam.gserviceaccount.com                                                                                                                                                                                                                                                  |
| **Data Classification**             | internal                                                                                                                                                                                                                                                                                                                                                 |
| **Costs and Billing**               | Implementation and operational costs are covered by the checkout domain until 2023-12-31.                                                                                                                                                                                                                                                                |
| **Test data delivery date**         | 2023-04-01                                                                                                                                                                                                                                                                                                                                               |
| **Production data delivery date**   | 2023-05-01                                                                                                                                                                                                                                                                                                                                               |
| **Next contract reassessment date** | 2024-01-01                                                                                                                                                                                                                                                                                                                                               | 


## Consequences

- A data contract gives clear expectations and requirements for building the  data product
- The contract must be fulfilled, but the internal implementation can change
- The data product can be extended as long as it is backward compatible with the contract
- A defined purpose is a motivation for the domain team to share the data with others in the first place
- Agreed service levels can be monitored, with an alerting system in place


## Automation

- The data contract can be formalized as a YAML document
  - A YAML specification needs to be defined
  - The plaform can check, if the data contract is well-defined
- Data platform capabilities to export data contract to other systems, such as data catalog, data product inventory, data quality systems
- Reassessment reminders and processes