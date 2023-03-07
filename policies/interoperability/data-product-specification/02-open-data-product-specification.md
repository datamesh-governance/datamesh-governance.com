[Data Mesh Governance](https://www.datamesh-governance.com/) / [Policies](https://www.datamesh-governance.com/#policies) / [Interoperability](https://www.datamesh-governance.com/#interoperability) / Data Product Specification

# Open Data Product Specification

Category: Interoperability

## Context

How do we specify the syntax and semantics of data products in a standardized way?

## Decision

We specify data products with the Open Data Product Specification.

## Consequences

- Data product owners need to create and curate an [Open Data Product Specification](https://opendataproducts.org/) JSON file ([Example](https://opendataproducts.org/#hello-world-example)).
- A data product specification can help to define the characteristics, behavior, requirements, and usage of data products in a data mesh.
- The Open Data Product Specification focuses on the usage of data products, such as pricing, data access and SLAs.
- The specification can refer to a pipeline implementation, but lacks of syntax and semantics descriptions.
- Currently, there is no tooling support available in our data platform nor data catalog.
- Licensed under [https://creativecommons.org/licenses/by-sa/4.0/](https://creativecommons.org/licenses/by-sa/4.0/)
- We accept to be early adaptor. We are not aware of any other company using this specification.

## Automation

The JSON file needs to be curated manually by the domain team when developing and maintaining a data product.

It may be a foundation for further automation through the data platform.

## Monitoring
