# Agile Lab Data Product Specification

Category: Interoperability

## Context

How do we specify the syntax and semantics of data products in a standardized way?

## Decision

We specify data products with Agile Lab's Data Product Specification.

## Consequences

- Data product owners need to create and curate a [Data Product Specification](https://github.com/agile-lab-dev/Data-Product-Specification) YAML file ([Example](https://github.com/agile-lab-dev/Data-Product-Specification/blob/main/example.yaml)).
- A data product specification can help to define the characteristics, behavior, requirements, and usage of data products in a data mesh.
- Currently, there is no tooling support available in our data platform nor data catalog.
- Licensed under Apache License 2.0
- We accept to be early adaptor. We are not aware of any other company using this specification.

## Automation

The YAML file needs to be curated manually by the domain team when developing and maintaining a data product.

It may be a foundation for further automation through the data platform.

## Monitoring
