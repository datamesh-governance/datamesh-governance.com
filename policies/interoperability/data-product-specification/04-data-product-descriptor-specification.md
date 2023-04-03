[Data Mesh Governance](https://www.datamesh-governance.com/) / [Policies](https://www.datamesh-governance.com/#policies) / [Interoperability](https://www.datamesh-governance.com/#interoperability) / Data Product Specification

# Data Product Descriptor Specification

Category: Interoperability

## Context

How do we specify the syntax and semantics of data products in a standardized way?

## Decision

We specify data products with [Data Product Descriptor Specification](https://dpds.opendatamesh.org/resources/specifications/1.0.0-DRAFT/).

### Example

```json
{
    "dataProductDescriptor": "1.0.0",
    "info": {
        "name": "tripExecution",
        "fullyQualifiedName": "urn:dpds:com.company-xyz:dataproducts:tripExecution:1",
        "version": "1.2.3",
        "domain": "Transport Management",
        "owner": {
            "id": "john.doe@company-xyz.com",
            "name": "John Doe"
        }
    },
    "interfaceComponents": {
        "inputPorts": [
            {
                "description": "Through this port trip data is ingested from TMS",
                "$ref": "https://github.com/opendatamesh-initiative/odm-specification-dpdescriptor/blob/main/examples/tripexecution/ports/tms-trip-iport.json"
            }
        ],
        "outputPorts": [
            {
                "description": "This port exposes the last known status of each trip operated in the last 12 months",
                "$ref": "https://github.com/opendatamesh-initiative/odm-specification-dpdescriptor/blob/main/examples/tripexecution/ports/trip-status-oport.json"
            },
            {
                "description": "This port expose all modifications in the status of each trip as events",
                "$ref": "https://github.com/opendatamesh-initiative/odm-specification-dpdescriptor/blob/main/examples/tripexecution/ports/trip-events-oport.json"
            }
        ]
    },
    "internalComponents": {
        "applicationComponents": [
            {
                "description": "The app that ingest data from TMS using a debezium CDC connector",
                "$ref": "https://github.com/opendatamesh-initiative/cd-ingestion-app/blob/main/examples/tripexecution/apps/cdc-ingestion-app.json"
            },
            {
                "description": "The streaming app that process incoming events and transform them into domain events usable downstream",
                "$ref": "https://github.com/opendatamesh-initiative/cd-ingestion-app/blob/main/examples/tripexecution/apps/event-processor-app.json"
            },
            {
                "description": "The app that materialize the status of a Trip from related events and store it on the state store",
                "$ref": "https://github.com/opendatamesh-initiative/cd-ingestion-app/blob/main/examples/tripexecution/apps/db-sink-connector--app.json"
            }
        ],
        "infrastructuralComponents": [
            {
                "description": "The streaming topology used to store incoming technical events and generated domain events",
                "$ref": "https://github.com/opendatamesh-initiative/cd-ingestion-app/blob/main/examples/tripexecution/infra/event-store.json"
            },
            {
                "description": "The database schema used to store the updated status of each Trip",
                "$ref": "https://github.com/opendatamesh-initiative/cd-ingestion-app/blob/main/examples/tripexecution/infra/state-store.json"
            }
        ]
    }
}
```

Source: https://github.com/opendatamesh-initiative/odm-specification-dpdescriptor/blob/main/examples/tripexecution/data-product-descriptor.json

## Consequences

- Data product owners need to create and curate a [Data Product Descriptor Specification](https://dpds.opendatamesh.org/resources/specifications/1.0.0-DRAFT/) JSON or YAML file.
- A data product specification can help to define the characteristics, behavior, requirements, and usage of data products in a data mesh.
- The Data Product Descriptor Specification is similar to OpenAPI and AsyncAPI specifications, that are familiar with our backend engineers.
- Currently, there is no tooling support available in our data platform nor data catalog.
- Licensed under Apache License 2.0
- We accept to be early adaptor. We are not aware of any other company using this specification.

## Automation

- The specification file needs to be curated manually by the domain team when developing and maintaining a data product.
- It may be a foundation for further automation through the data platform.
- The validity of the syntax can be checked through a provided [JSON schema](https://dpds.opendatamesh.org/resources/schemas/1.0.0-DRAFT.json).

