# springSample
## Practice code to learn Spring Boot.

#### 06/21/2017

This project uses Spring Boot to implement a web applicaiton requiring selective Basic Authentication (as in on specific URLs only), and displays the username once logged in.

These are the URLs availabe:
* http://localhost:8080/
* http://localhost:8080/login

Run this with this:

``java -jar springSample-0.0.1-SNAPSHOT.war``

P.S. I couldn't make it work by packaging it as a jar (the WEB-INF didn't get packaged in the root when packaging that way).

### Update
#### 06/22/2017

Modified the application to be a user management application, where users can add/remove and modify user details (those users currently can't login (Added to TODO list)).
This *iteration* also uses _spring-boot-starter-data-jpa_ and _sqlite-jdbc_ for data storage/retrieval.

Reduced home URL footprint to:
* http://localhost:8080/

Run it like this:

``java -jar springSample-0.1.war``