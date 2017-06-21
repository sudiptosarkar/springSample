# springSample
## Practice code to learn Spring Boot.

This project uses Spring Boot to implement a web applicaiton requiring selective Basic Authentication (as in on specific URLs only), and displays the username once logged in.

These are the URLs availabe:
* http://localhost:8080/
* http://localhost:8080/login

Run this with this:

``java -jar springSample-0.0.1-SNAPSHOT.war``

P.S. I couldn't make it work by packaging it as a jar (the WEB-INF didn't get packaged in the root when packaging that way).