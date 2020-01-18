# Flight Tracking System implemented using EJB and JPA 
 
## Features

Filter though a list of flights using a comprehensive list of options containing country, city, and time available for both departure and arrival.

## Technical considerations

Some filter fields are loaded dynamically. For example, the City field in the filter is populated only after the country is selected and only with the available cities in the respective country.

Web application is implemented with Java servlets that use injected local EJB beans. Also offers remote EJB beans with the same functions via JNDI.

Datasource access is made via the application server, so it has to be configured prior to running the project.