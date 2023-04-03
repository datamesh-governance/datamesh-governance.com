[Data Mesh Governance](https://www.datamesh-governance.com/) / [Policies](https://www.datamesh-governance.com/#policies) / [Interoperability](https://www.datamesh-governance.com/#interoperability) / Data Product Specification

# Open Data Product Specification

Category: Interoperability

## Context

How do we specify the syntax and semantics of data products in a standardized way?

## Decision

We specify data products with the [Open Data Product Specification 2.0](https://open-data-product-initiative.github.io/open-data-product-spec-2.0/).

### Example

```json
{
   "product":{
      "en":{
         "name":"Pets of the year",
         "productID":"123456are",
         "valueProposition":"Design a customised petstore using a data product that describes pets with their habits, preferences and characteristics.",
         "description":"This is an example of a Petstore product.",
         "productSeries":"Lovely pets data products",
         "visibility":"private",
         "status":"draft",
         "version":"0.1",
         "categories":[
            "pets"
         ],
         "standards":[
            "ISO 24631-6"
         ],
         "tags":[
            "pet"
         ],
         "brandSlogan":"Passion for the data monetization",
         "type":"derived data",
         "logoURL":"https://data-product-business.github.io/open-data-product-spec/images/logo-dps-ebd5a97d.png",
         "OutputFileFormats":[
            "json",
            "xml",
            "csv",
            "zip"
         ],
         "useCases":[
            {
               "useCase":{
                  "useCaseTitle":"Build attractive and lucrative petstore!",
                  "useCaseDescription":"Use case description how succesfull petstore chain was established in Abu Dhabi",
                  "useCaseURL":"https://marketplace.com/usecase1"
               }
            }
         ]
      },
      "recommendedDataProducts":[
          "https://marketplace.com/dataproduct.json, https://marketplace.com/dataproduct-another.json"
          ],      
      "pricingPlans":{
         "en":[
            {
               "name":"Premium subscription 1 year",
               "priceCurrency":"EUR",
               "price":"50.00",
               "billingDuration":"year",
               "unit":"recurring",
               "maxTransactionQuantity":"unlimited"
            },
            {
               "name":"Premium Package Monthly",
               "priceCurrency":"EUR",
               "price":"5.00",
               "billingDuration":"month",
               "unit":"recurring",
               "maxTransactionQuantity":10000
            },
            {
               "name":"Freemium Package",
               "priceCurrency":"EUR",
               "price":"0.00",
               "billingDuration":"month",
               "unit":"recurring",
               "maxTransactionQuantity":1000
            },
            {
               "name":"Revenue sharing",
               "priceCurrency":"percentage",
               "price":"5.50",
               "billingDuration":"month",
               "unit":"revenue-sharing",
               "maxTransactionQuantity":20000
            }
         ]
      },
      "dataOps":{
         "infrastructure":{
            "platform":"Azure",
            "storageTechnology":"Azure SQL",
            "storageType":"sql",
            "containerTool":"helm",
            "format":"yaml",
            "status":"development",
            "schemaLocationURL":"http://http://192.168.10.1/schemas/2016/petshopML-2.3/schema/petstore.xsd",
            "scriptURL":"http://192.168.10.1/rundatapipeline.yml",
            "deploymentDocumentationURL":"http://192.168.10.1/datapipeline",
            "dataLineageTool":"Collibra",
            "dataLineageOutput":"http://192.168.10.1/lineage.json",
            "hashType":"SHA-2",
            "checksum":"7b7444ab8f5832e9ae8f54834782af995d0a83b4a1d77a75833eda7e19b4c921"
         }
      },
      "dataAccess":{
         "type":"API",
         "authenticationMethod":"OAuth",
         "specification":"OAS",
         "format":"JSON",
         "documentationURL":"https://swagger.com/petstore.json"
      },
      "dataQuality":{
         "accuracy":100,
         "completeness":100,
         "consistency":100,
         "timeliness":"high",
         "validity":100,
         "uniqueness":100,
         "dataQualityAssuranceMethods":"Data quality assurance suite of tools and methods include both data quality auditing (DQA) tools designed for use by external audit teams and routine data quality assessment (RDQA) tools designed for capacity building and self-assessment."
      },
      "SLA":{
         "updateFrequency":{
            "unit":"hours",
            "value":1
         },
         "uptime":{
            "unit":"percentage",
            "value":99
         },
         "responseTime":{
            "unit":"milliseconds",
            "value":200
         },
         "nullValues":{
            "unit":"percentage",
            "value":0.01
         },
         "support":{
            "company":{
               "phoneNumber":"",
               "phoneServiceHours":"",
               "chatURL":"",
               "chatServiceHours":"",
               "chatResponseTime":"",
               "email":"",
               "emailServiceHours":"",
               "emailResponseTime":"",
               "documentationURL":"",
               "guidesURL":""
            },
            "community":{
               "stackoverflowURL":"",
               "forumURL":"",
               "slackURL":"",
               "twitterURL":""
            }
         },
         "observability":{
            "logsURL":"https://logs.com",
            "dashboardURL":"https://dashboard.com",
            "uptimeURL":"https://uptime.com"
         }
      },
      "license":{
         "scope":{
            "definition":"The purpose of this license is to determine the terms and conditions applicable to the licensing of the data product, whereby Data Holder grants Data User the right to use the data.",
            "language":"en-us",
            "restrictions":"Data User agrees not to, directly or indirectly, participate in the unauthorized use, disclosure or conversion of any confidential information.",
            "geographicalArea":[
               "EU",
               "US"
            ],
            "permanent":false,
            "exclusive":false,
            "rights":[
               "Reproduction",
               "Display",
               "Distribution",
               "Adaptation",
               "Reselling",
               "Sublicensing",
               "Transferring"
            ]
         },
         "privacy":{
            "containsPersonalData":true,
            "applicaplePrivacyLaws":[
               "General Data Protection Regulation",
               "Personal Information Protection and Electronic Documents Act (PIPEDA)",
               "California Consumer Privacy Act (CCPA)"
            ],
            "dpaURL":"http://192.168.10.1/dpaconditions"
         },
         "termination":{
            "terminationConditions":"Cancellation before 30 days. After the expiry of the right of use, the product and its derivatives must be removed.",
            "continuityConditions":"Expired license will automatically continued without written cancellation (termination) by Data Holder"
         },
         "governance":{
            "damages":"During the term of license, except for the force majeure or the Data Holders reasons, Data User is required to follow strictly in accordance with the license. If Data User wants to terminate the license early, it needs to pay a certain amount of liquidated damages.",
            "confidentiality":"Data User undertakes to maintain confidentiality as regards all information of a technical (such as, by way of a non-limiting example, drawings, tables, documentation, formulas and correspondence) and commercial nature (including contractual conditions, prices, payment conditions) gained during the performance of this license.",
            "applicableLaws":"This license shall be interpreted, construed and enforced in accordance with the law of Finland, Incl. Copyright Act 404/1961.",
            "warranties":"Data Holder makes no warranties, express or implied, guarantees or conditions with respect to your use of the data product. To the extent permitted under local law, Data Holder disclaims all liability for any damages or losses, including direct, consequential, special, indirect, incidental or punitive, resulting from Data User use of the data product.",
            "audit":"Data Holder will reasonably cooperate with Data User by providing available additional information concerning the data product. Each party will bear its own costs with respect to the audit procedures.",
            "forceMajeure":"Each party may suspend the fulfilment of its contractual obligations, when the said fulfilment is impossible or objectively too costly due to an unforeseeable impediment independent from the parties, such as for example: strike, boycott, lockout, fire, war (declared or not), civil war, riots and revolutions, requisitions, embargo, power blackouts, extraordinary breakage of machinery, delays in the delivery of components or raw materials."
         }
      },
      "dataHolder":{
         "taxID":"12243434-12",
         "vatID":"12243434-12",
         "businessDomain":"Data Product Business",
         "logoURL":"https://mindmote.fi/logo.png",
         "description":"Digital Economy services and tools",
         "URL":"https://mindmote.fi",
         "telephone":"+358 45 232 2323",
         "streetAddress":"Koulukatu 1",
         "postalCode":"33100",
         "addressRegion":" Pirkanmaa",
         "addressLocality":"Tampere",
         "addressCountry":"Finland",
         "aggregateRating":"",
         "ratingCount":1245,
         "slogan":"",
         "parentOrganization":""
      }
   }
}
```

## Consequences

- The Open Data Product Specification is designed for data that is traded, e.g., on a marketplace. 
- The specification is not optimized to describe data products as a deployment unit. The DataOps section attributes are limited, but could be extended.
- The specification is extendable, custom attributes can be set with an `x-` prefix.
- Data product owners need to create and curate an [Open Data Product Specification](https://open-data-product-initiative.github.io/open-data-product-spec-2.0/) JSON file.
- Currently, there is no tooling support available in data platforms nor data catalogs.
- Licensed under [https://creativecommons.org/licenses/by-sa/4.0/](https://creativecommons.org/licenses/by-sa/4.0/)
- We accept to be early adaptor. We are not aware of any other company using this specification.

## Automation

The JSON file or REST-API endpoint can be created throught the data platform for deployed data products.

It may be a foundation for further automation through the data platform.
