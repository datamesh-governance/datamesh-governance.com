# Data Product Descriptor Specification

Category: Interoperability

## Context

How do we specify the syntax and semantics of data products in a standardized way?

## Decision

We specify data products with Data Product Descriptor Specification.

## Consequences

- Data product owners need to create and curate a [Data Product Descriptor Specification](https://dpds.opendatamesh.org/resources/specifications/1.0.0-DRAFT/) JSON or YAML file ([Example](https://github.com/opendatamesh-initiative/odm-specification-dpdescriptor/blob/main/examples/tripexecution/data-product-descriptor.dpd.json)).
- A data product specification can help to define the characteristics, behavior, requirements, and usage of data products in a data mesh.
- The Data Product Descriptor Specification is similar to OpenAPI and AsyncAPI specifications, that are familiar with our backend engineers.
- Currently there is no tooling support available in our data platform nor data catalog.
- Licensed under Apache License 2.0
- We accept to be early adaptor. We are not aware of any other company using this specification.

## Automation

## Monitoring
