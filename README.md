# projectHotel
Application for making/managing hotel reservations

## Getting started
1. Import project to your IDE.
2. Set up your appserver(Preferably Tomcat)
3. Now, connection to mySQL database
- set up a new database in your mySQL
- open file "/src/main/resources/META-INF/persistence.xml".
Then type in name of your database, user, password in:
```
<property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/name_of_database" />
<property name="javax.persistence.jdbc.user" value="user" />
<property name="javax.persistence.jdbc.password" value="password" />
```

After this operation, the application is ready to start

## Technologies used
- Java 8
- Spring (Framework, Data)
- JPA(Hibernate)
- mySQL
- .jsp
- Bootstrap

## TODO
- Spring security authentication
- Making reservation by guest
- Much more
