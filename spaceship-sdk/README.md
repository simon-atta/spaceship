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
import io.swagger.client.api.SpaceshipresourceApi;

import java.io.File;
import java.util.*;

public class SpaceshipresourceApiExample {

    public static void main(String[] args) {
        
        SpaceshipresourceApi apiInstance = new SpaceshipresourceApi();
        String userId = "userId_example"; // String | userId
        try {
            List<InlineResponse200> result = apiInstance.getSpaceshipsByUserIdUsingGET(userId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SpaceshipresourceApi#getSpaceshipsByUserIdUsingGET");
            e.printStackTrace();
        }
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *https://localhost:8080/*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*SpaceshipresourceApi* | [**getSpaceshipsByUserIdUsingGET**](docs/SpaceshipresourceApi.md#getSpaceshipsByUserIdUsingGET) | **GET** /xl-spaceship/spaceship/getSpaceshipsByUserId | Get spaceship by user id
*SpaceshipresourceApi* | [**getSpaceshipsListUsingGET**](docs/SpaceshipresourceApi.md#getSpaceshipsListUsingGET) | **GET** /xl-spaceship/spaceship/getSpaceshipsList | List of all spaceship
*SpaceshipresourceApi* | [**initializeSpaceshipUsingPOST**](docs/SpaceshipresourceApi.md#initializeSpaceshipUsingPOST) | **POST** /xl-spaceship/spaceship/initialize | Initialize spaceship


## Documentation for Models

 - [InlineResponse200](docs/InlineResponse200.md)
 - [PSpaceshipRequest](docs/PSpaceshipRequest.md)
 - [Spaceship](docs/Spaceship.md)
 - [SpaceshipRequest](docs/SpaceshipRequest.md)
 - [SpaceshipResponse](docs/SpaceshipResponse.md)


## Documentation for Authorization

All endpoints do not require authorization.
Authentication schemes defined for the API:

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author



