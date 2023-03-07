[Data Mesh Governance](https://www.datamesh-governance.com/) / [Operating Model](https://www.datamesh-governance.com/#operating-model) / [Communication Channels](https://www.datamesh-governance.com/#communication-channels)

# Microsoft Teams Channels

## Context

The federated governance group needs to communicate with the rest of the organisation, and vice versa.

We primarily use Microsoft Teams, and every domain team has their own *team* in Microsoft Teams.

## Decision

We use a *Data Mesh* team in Microsoft Teams to collaborate across the organisation. 

In this team, we use the following three Microsoft Teams channels for the Governance Group:

![Microsoft Teams Screenshot](https://www.datamesh-governance.com/images/operating-model-microsoft-teams-channels.png)

### `Governance`

The team API for the federated governance group.

- In this channel, anybody can ask questions, bring topics or concerns.
- In this channel, the group announces news and important decisions. 
- In this channel, facilitators announce upcoming meeting dates with agenda for interested stakeholders to join.
- Audience: All users of the data mesh platform

### `Governance (internal)`
- In this channel, the members of the Federated Governance Group discuss, communicate, and work together.
- Audience: Federated Governance Group

### `Governance Updates`
- In this channel, updates on new or changed global policies and their adoption status are published.
- Use comments in threads to discuss changes.
- Audience: Domain Teams

## Consequences
- Governance Group online meetings can simply be started in the `Governance (internal)` channel. 
  - It is easy to join the group meetings. 
  - The chat is automatically archived as part of the channel. 
- Simple communication
- Uncluttered

## Automation
- Integration with Confluence to post updates on page changes to `Governance Updates` automatically
