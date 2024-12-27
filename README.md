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

#### Start vocabulary-quiz-service
_This is the core service to handle business logic_

```
.\gradlew.bat :vocabulary-quiz-service:bootRun
```

### System design can Access online version here
https://excalidraw.com/#json=HByQ5fExZwR97lhqav2ag,KuFS3dMkGINJT_lQ9VU1SQ