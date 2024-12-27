### Requirement
Java version 17 or above

### Build packages

```
.\gradlew.bat clean build
```

### Start servers

#### Start Auth server
_Auth server is using Spring Authorization Server to build up a OAuth2 server that manages clients, access tokens, users,.._

```
.\gradlew.bat :auth-server:bootRun
```
