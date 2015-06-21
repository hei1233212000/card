### Prerequisites
[JDK 8 later][JDK8 build] and [Maven][Maven site] or maven plugin in your IDE

Be sure that your `JAVA_HOME` environment variable points to the `jdk1.8` folder
extracted from the JDK download if you are NOT use IDE to run the application.

### Run Application
Run on [Jetty][Jetty site]

    clean compile package -DskipTests jetty:run
Or, run on [Tomcat][Tomcat site]

    clean compile package -DskipTests tomcat7:run
Or, run on [Glassfish][Glassfish site]

    clean compile package -DskipTests embedded-glassfish:run

### Start testing
After the server is started, go to [http://localhost:8080/][Local Root Path]

[JDK8 build]: http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html
[Maven site]: http://maven.apache.org/download.cgi
[Jetty site]: http://eclipse.org/jetty/
[Tomcat site]: http://tomcat.apache.org/index.html
[Glassfish site]: https://glassfish.java.net/
[Local Root Path]: http://localhost:8080/