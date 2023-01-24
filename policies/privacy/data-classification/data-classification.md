# Data Classification

Category: Privacy  

## Context

Managing and securing personal data, Personally Identifiable Information (PII), and business secrets is critical and subject to multiple legal and compliance requirements.
Violations or leaks can result in serious penalties or harm for the business.

A first step is to define a classification for data types and their sensitivity.

## Decision

### Data Classes
We define data classes around sensitivity levels:

[//]: # (#### Sensitive)

[//]: # ()
[//]: # (- PII)

[//]: # (- Health data)

[//]: # ()
[//]: # (No access for analytical use. May be made available as restricted or internal after applying methods such as hashing, differential privacy.)

[//]: # ()
[//]: # (### Restricted)

[//]: # ()
[//]: # (- Financial data &#40;e.g. account balance, salaries&#41;)

[//]: # (- Contracts)

[//]: # ()
[//]: # (Access upon request for specific needs)

[//]: # ()
[//]: # (#### Internal)

[//]: # ()
[//]: # (- Business transactions &#40;e. g. search queries, orders&#41;)

[//]: # (- Master data &#40;e. g. prices&#41;)

[//]: # ()
[//]: # (Access for everyone in the organization for analytical use cases)

[//]: # ()
[//]: # (#### Public)

[//]: # ()
[//]: # (Data that is purposefully made available to the public)


| Classification | Data Classes                                      | Access Control                                        |
|----------------|---------------------------------------------------|-------------------------------------------------------|
| sensitive      | PII, Personal Data, Public Health Information     | No access for analytical use                          |
| restricted     | Financial data, contracts, customer communication | Access upon request for specific analytical use cases |
| internal       | Business transactions, master data                | Access for everyone in the organization               |
| public         | Public available data, external                   | Access for everyone in the organization               |

By default, we consider all data as _sensitive_, unless specified otherwise.



### Data Classification

Each info type is assigned to a data class and classified:

| Info Type                           | Data Class                          | Classification |
|-------------------------------------|-------------------------------------|----------------|
| first name                          | PII                                 | sensitive      |
| last name                           | PII                                 | sensitive      |
| home address                        | PII                                 | sensitive      |
| email address                       | PII                                 | sensitive      |
| telephone number                    | PII                                 | sensitive      |
| passport number                     | PII                                 | sensitive      |
| social security number              | PII                                 | sensitive      |
| photo of face                       | PII                                 | sensitive      |
| credit card number                  | PII                                 | sensitive      |
| account user name                   | PII                                 | sensitive      |
| financial records                   | PII                                 | sensitive      |
| medical records                     | PII                                 | sensitive      |
| fine-grained geolocation            | PII                                 | sensitive      |
| IP address                          | PII                                 | sensitive      |
| cookie IDs                          | PII                                 | sensitive      |
| device fingerprint                  | PII                                 | sensitive      |
| MAC address                         | PII                                 | sensitive      |
| IMEI                                | PII                                 | sensitive      |
| support tickets                     | Customer communication              | confidential   |
| Net Promoter Score                  | Customer communication (aggregated) | internal       |
| contribution margin                 | Business information                | confidential   |
| account balance                     | Financial data                      | confidential   |
| supplier agreements                 | Contracts                           | confidential   |
| employment contracts                | Contracts                           | confidential   |
| Salary                              | Contracts                           | confidential   |
| partial address (country, zip code) | PII (aggregated)                    | internal       |
| age range                           | PII (aggregated)                    | internal       |
| year of birth                       | PII (aggregated)                    | internal       |
| gender                              | PII (aggregated)                    | internal       |
| industry of employment              | PII (aggregated)                    | internal       |
| prices                              | Master data                         | internal       |
| search queries                      | Business transactions               | internal       |
| orders                              | Business transactions               | internal       |
| product master data                 | Public                              | public         |
| product images                      | Public                              | public         |
| ads                                 | Public                              | public         |
| financial statements                | Public                              | public         |
| weather                             | External                            | public         |
| stock prices                        | External                            | public         |


Note: This list is an example, not complete, and needs to be adjusted and complemented to the specific context for each organization.
Include legal and data privacy experts into the discussion.

## Consequences

- The taxonomy reduces the effort of developers, as they do not have to assess each info type themselves.
- The classification can be used to tag columns in the data catalog
- The classification can be used to handle data according to defined rules

## Automation

The data classes builds the foundation for our Data Catalog taxonomy and are defined as a Terraform module.

The classification of columns can be automated through
[BigQuery PII Classifier](https://github.com/GoogleCloudPlatform/bq-pii-classifier) open-source component
(see blog post [Stop Worrying About BigQuery PII: How to Automate Data Governance at Scale](https://medium.com/google-cloud/stop-worrying-about-bigquery-pii-how-to-automate-data-governance-at-scale-81abb3e47e0c)).

