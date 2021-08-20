## Prerequisites

You can run tests locally with corresponding profiles using a local appium driver hub. Endpoint to the local hub should be provided in `pom.xml` like

```
<profile>
  <id>web</id>
  <activation>
    <activeByDefault>false</activeByDefault>
  </activation>
  <properties>
    <suite.file>./src/test/resources/webTNG.xml</suite.file>
    <ts.appium>http://0.0.0.0:4723/wd/hub</ts.appium>
  </properties>
</profile>
```

Also, you can run these tests via EPAM mobile cloud.
You must set an environment variable `EPAM_MOBILECLOUD_TOKEN` with your
token.
Note that token could contain `/`, but test runner will encode those symbols
and `MalformedURLException` will be avoided.

## Tests running

There are 6 profiles:

- Android native application (local)

```
mvn clean test -P native
```

- Android web application (local)

```
mvn clean test -P web
```

- Android native application (mobile cloud)

```
mvn clean test -P cloudAndroidNative
```

- Android web application (mobile cloud)

```
mvn clean test -P cloudAndroidWeb
```

- iOS native application (mobile cloud)

```
mvn clean test -P cloudIosNative
```

- iOS web application (mobile cloud)

```
mvn clean test -P cloudIosWeb
```