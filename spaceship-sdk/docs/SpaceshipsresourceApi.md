# SpaceshipsresourceApi

All URIs are relative to *https://localhost:8080/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getSpaceShipsShapesUsingGET**](SpaceshipsresourceApi.md#getSpaceShipsShapesUsingGET) | **GET** /xl-spaceship/spaceships/getspaceshipsshapes | Get spaceships shapes
[**lockGameBoardUsingPUT**](SpaceshipsresourceApi.md#lockGameBoardUsingPUT) | **PUT** /xl-spaceship/spaceships/lockboard | Lock game board
[**placeSpaceshipUsingPOST**](SpaceshipsresourceApi.md#placeSpaceshipUsingPOST) | **POST** /xl-spaceship/spaceships/placespaceship | Place spaceship into game board
[**receiveFireUsingPUT**](SpaceshipsresourceApi.md#receiveFireUsingPUT) | **PUT** /xl-spaceship/spaceships | Receive fire
[**unLockGameBoardUsingPUT**](SpaceshipsresourceApi.md#unLockGameBoardUsingPUT) | **PUT** /xl-spaceship/spaceships/unlockboard | Unlock game board


<a name="getSpaceShipsShapesUsingGET"></a>
# **getSpaceShipsShapesUsingGET**
> List&lt;InlineResponse2003&gt; getSpaceShipsShapesUsingGET()

Get spaceships shapes

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SpaceshipsresourceApi;


SpaceshipsresourceApi apiInstance = new SpaceshipsresourceApi();
try {
    List<InlineResponse2003> result = apiInstance.getSpaceShipsShapesUsingGET();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SpaceshipsresourceApi#getSpaceShipsShapesUsingGET");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;InlineResponse2003&gt;**](InlineResponse2003.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="lockGameBoardUsingPUT"></a>
# **lockGameBoardUsingPUT**
> lockGameBoardUsingPUT()

Lock game board

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SpaceshipsresourceApi;


SpaceshipsresourceApi apiInstance = new SpaceshipsresourceApi();
try {
    apiInstance.lockGameBoardUsingPUT();
} catch (ApiException e) {
    System.err.println("Exception when calling SpaceshipsresourceApi#lockGameBoardUsingPUT");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="placeSpaceshipUsingPOST"></a>
# **placeSpaceshipUsingPOST**
> InlineResponse2004 placeSpaceshipUsingPOST(spaceshipRequest)

Place spaceship into game board

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SpaceshipsresourceApi;


SpaceshipsresourceApi apiInstance = new SpaceshipsresourceApi();
SpaceshipRequest spaceshipRequest = new SpaceshipRequest(); // SpaceshipRequest | spaceshipRequest
try {
    InlineResponse2004 result = apiInstance.placeSpaceshipUsingPOST(spaceshipRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SpaceshipsresourceApi#placeSpaceshipUsingPOST");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **spaceshipRequest** | [**SpaceshipRequest**](SpaceshipRequest.md)| spaceshipRequest |

### Return type

[**InlineResponse2004**](InlineResponse2004.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="receiveFireUsingPUT"></a>
# **receiveFireUsingPUT**
> InlineResponse2002 receiveFireUsingPUT(salvoShot)

Receive fire

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SpaceshipsresourceApi;


SpaceshipsresourceApi apiInstance = new SpaceshipsresourceApi();
SalvoShot salvoShot = new SalvoShot(); // SalvoShot | salvoShot
try {
    InlineResponse2002 result = apiInstance.receiveFireUsingPUT(salvoShot);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SpaceshipsresourceApi#receiveFireUsingPUT");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **salvoShot** | [**SalvoShot**](SalvoShot.md)| salvoShot |

### Return type

[**InlineResponse2002**](InlineResponse2002.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="unLockGameBoardUsingPUT"></a>
# **unLockGameBoardUsingPUT**
> unLockGameBoardUsingPUT()

Unlock game board

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SpaceshipsresourceApi;


SpaceshipsresourceApi apiInstance = new SpaceshipsresourceApi();
try {
    apiInstance.unLockGameBoardUsingPUT();
} catch (ApiException e) {
    System.err.println("Exception when calling SpaceshipsresourceApi#unLockGameBoardUsingPUT");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

