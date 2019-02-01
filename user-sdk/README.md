# swagger-java-client

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn deploy
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>io.swagger</groupId>
    <artifactId>swagger-java-client</artifactId>
    <version>1.0.0</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "io.swagger:swagger-java-client:1.0.0"
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

* target/swagger-java-client-1.0.0.jar
* target/lib/*.jar

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import io.swagger.client.*;
import io.swagger.client.auth.*;
import io.swagger.client.model.*;
import io.swagger.client.api.UserresourceApi;

import java.io.File;
import java.util.*;

public class UserresourceApiExample {

    public static void main(String[] args) {
        
        UserresourceApi apiInstance = new UserresourceApi();
        PGameRequest pGameRequest = new PGameRequest(); // PGameRequest | pGameRequest
        try {
            InlineResponse200 result = apiInstance.challengeUserUsingPOST(pGameRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling UserresourceApi#challengeUserUsingPOST");
            e.printStackTrace();
        }
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *https://localhost:8084/*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*UserresourceApi* | [**challengeUserUsingPOST**](docs/UserresourceApi.md#challengeUserUsingPOST) | **POST** /xl-spaceship/user/challengeUser | Challenge User
*UserresourceApi* | [**createUserUsingPOST**](docs/UserresourceApi.md#createUserUsingPOST) | **POST** /xl-spaceship/user/createUser | Create User
*UserresourceApi* | [**getAllSpaceshipsUsingGET**](docs/UserresourceApi.md#getAllSpaceshipsUsingGET) | **GET** /xl-spaceship/user/getAllSpaceships | Get all spaceships
*UserresourceApi* | [**getAllUsersUsingGET**](docs/UserresourceApi.md#getAllUsersUsingGET) | **GET** /xl-spaceship/user/getAllUsers | Get all users
*UserresourceApi* | [**initializeSpaceshipUsingPOST**](docs/UserresourceApi.md#initializeSpaceshipUsingPOST) | **POST** /xl-spaceship/user/assignSpaceship | Initialize spaceship


## Documentation for Models

 - [Game](docs/Game.md)
 - [GameRequest](docs/GameRequest.md)
 - [GameResponse](docs/GameResponse.md)
 - [InlineResponse200](docs/InlineResponse200.md)
 - [InlineResponse2001](docs/InlineResponse2001.md)
 - [InlineResponse2002](docs/InlineResponse2002.md)
 - [PGameRequest](docs/PGameRequest.md)
 - [PSpaceshipRequest](docs/PSpaceshipRequest.md)
 - [PUser](docs/PUser.md)
 - [Player](docs/Player.md)
 - [SpaceShipProtocal](docs/SpaceShipProtocal.md)
 - [SpaceshipResponse](docs/SpaceshipResponse.md)
 - [User](docs/User.md)
 - [UserVo](docs/UserVo.md)
 - [XlspaceshipuserchallengeUserChallengerPlayer](docs/XlspaceshipuserchallengeUserChallengerPlayer.md)
 - [XlspaceshipuserchallengeUserChallengerPlayerGame](docs/XlspaceshipuserchallengeUserChallengerPlayerGame.md)
 - [XlspaceshipuserchallengeUserChallengerPlayerSpaceShipProtocal](docs/XlspaceshipuserchallengeUserChallengerPlayerSpaceShipProtocal.md)


## Documentation for Authorization

All endpoints do not require authorization.
Authentication schemes defined for the API:

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author



