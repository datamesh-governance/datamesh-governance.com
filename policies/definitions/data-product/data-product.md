# Data Product

[//]: # (Data Product as self-contained deployment unit)

Category: Definitions  
Status: Proposed  

## Context

What do we mean when we say _a data product_?

## Decision

In our context, a data product is _a self-contained deployment unit_ that contains all components to process, interpret and share _analytical data_.

A data product includes:

- Data transformation code
- Output port definitions
- Input port definitions
- Discovery and observability APIs
- Documentation
- SLOs
- Access control
- Platform dependencies (compute and storage resources)

**Conceptual Distinction**

When we say _a data product_, we explicitly do not mean these related concepts: 
 
- _Data as a Product:_ The data mesh _principle_ to apply product thinking on analytical data
- _Data is our Product:_ We sell data to our customers
- _Data Contract:_ The agreement under which data is made accessible

## Consequences

- A data product is a software component that needs to be developed and maintained by a dedicated team
- No organizational dependencies to other teams to implement it
- The definition of a data product with all its components can be specified in one Git repository
- Data products can be interconnected and may rely on other data products
- This definition is in line with Zhamak Dehghani's description of a data product as an architecture quantum

## Automation

- A data product can be specified as a Terraform module that deploys the data product on the data platform through a CI/CD pipeline
- The data platform team is responsible to provide the Terraform module

