# Encryption at rest

Category: Security  
Platform: Databricks/...  
Status: Proposed  
Tags: encryption  

## Context

Our threat model is defined here [add link to your internal threat model].
Analytical data may contain sensitive data that needs to be protected from attackers.

## Decision

We store analytical domain data and data products only on Storage Accounts (that have data at rest enabled by default).

We use Microsoft-managed encryption keys (MMK).

## Consequences

- Data on disk is encrypted with AES-256.
- Read and write performance may be decreased
- Encryption and decryption is transparently handled by platform, no negative effects on developer experience

## Follow-Up Questions


## Considered Alternatives

- Customer-managed keys (CMK) for Azure storage accounts
- Application level encryption for every data product with custom encryption keys
- No encryption at rest for noncritical data.

## Automation

- Data platform guarantees encryption at rest 

## Verification / Adherence / Monitoring

- Not required, encryption-at-rest is enabled in all Storage Accounts

