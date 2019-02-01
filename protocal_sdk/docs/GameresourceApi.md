# GameresourceApi

All URIs are relative to *https://localhost:8083/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createNewGameUsingPOST**](GameresourceApi.md#createNewGameUsingPOST) | **POST** /xl-spaceship/protocol/game/new | Create new game
[**disableAutoPilotUsingPUT**](GameresourceApi.md#disableAutoPilotUsingPUT) | **PUT** /xl-spaceship/protocol/game/disableautopilot/{userid}/{gameId} | Disable auto pilot
[**enableAutoPilotUsingPUT**](GameresourceApi.md#enableAutoPilotUsingPUT) | **PUT** /xl-spaceship/protocol/game/enableautopilot/{userid}/{gameId} | Enable auto pilot
[**getAllGamesByUserIdUsingGET**](GameresourceApi.md#getAllGamesByUserIdUsingGET) | **GET** /xl-spaceship/protocol/game/getallgames/{id} | Get all games by user id
[**getGameStatusUsingGET**](GameresourceApi.md#getGameStatusUsingGET) | **GET** /xl-spaceship/protocol/game/{id} | Get game status
[**getSalvoShotsNumberUsingGET**](GameresourceApi.md#getSalvoShotsNumberUsingGET) | **GET** /xl-spaceship/protocol/game/getsalvoshotcount/{id} | Get Salvo Shots Number
[**receiveFireUsingPUT**](GameresourceApi.md#receiveFireUsingPUT) | **PUT** /xl-spaceship/protocol/game/{id} | Receive fire


<a name="createNewGameUsingPOST"></a>
# **createNewGameUsingPOST**
> InlineResponse200 createNewGameUsingPOST(pGameRequest)

Create new game

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.GameresourceApi;


GameresourceApi apiInstance = new GameresourceApi();
PGameRequest pGameRequest = new PGameRequest(); // PGameRequest | pGameRequest
try {
    InlineResponse200 result = apiInstance.createNewGameUsingPOST(pGameRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GameresourceApi#createNewGameUsingPOST");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **pGameRequest** | [**PGameRequest**](PGameRequest.md)| pGameRequest |

### Return type

[**InlineResponse200**](InlineResponse200.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="disableAutoPilotUsingPUT"></a>
# **disableAutoPilotUsingPUT**
> disableAutoPilotUsingPUT(userid, gameId)

Disable auto pilot

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.GameresourceApi;


GameresourceApi apiInstance = new GameresourceApi();
String userid = "userid_example"; // String | userId
String gameId = "gameId_example"; // String | gameId
try {
    apiInstance.disableAutoPilotUsingPUT(userid, gameId);
} catch (ApiException e) {
    System.err.println("Exception when calling GameresourceApi#disableAutoPilotUsingPUT");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userid** | **String**| userId |
 **gameId** | **String**| gameId |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="enableAutoPilotUsingPUT"></a>
# **enableAutoPilotUsingPUT**
> enableAutoPilotUsingPUT(userid, gameId)

Enable auto pilot

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.GameresourceApi;


GameresourceApi apiInstance = new GameresourceApi();
String userid = "userid_example"; // String | userId
String gameId = "gameId_example"; // String | gameId
try {
    apiInstance.enableAutoPilotUsingPUT(userid, gameId);
} catch (ApiException e) {
    System.err.println("Exception when calling GameresourceApi#enableAutoPilotUsingPUT");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userid** | **String**| userId |
 **gameId** | **String**| gameId |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getAllGamesByUserIdUsingGET"></a>
# **getAllGamesByUserIdUsingGET**
> List&lt;InlineResponse200&gt; getAllGamesByUserIdUsingGET(id)

Get all games by user id

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.GameresourceApi;


GameresourceApi apiInstance = new GameresourceApi();
String id = "id_example"; // String | userId
try {
    List<InlineResponse200> result = apiInstance.getAllGamesByUserIdUsingGET(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GameresourceApi#getAllGamesByUserIdUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| userId |

### Return type

[**List&lt;InlineResponse200&gt;**](InlineResponse200.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getGameStatusUsingGET"></a>
# **getGameStatusUsingGET**
> InlineResponse2001 getGameStatusUsingGET(id)

Get game status

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.GameresourceApi;


GameresourceApi apiInstance = new GameresourceApi();
String id = "id_example"; // String | gameId
try {
    InlineResponse2001 result = apiInstance.getGameStatusUsingGET(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GameresourceApi#getGameStatusUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| gameId |

### Return type

[**InlineResponse2001**](InlineResponse2001.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getSalvoShotsNumberUsingGET"></a>
# **getSalvoShotsNumberUsingGET**
> Integer getSalvoShotsNumberUsingGET(id)

Get Salvo Shots Number

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.GameresourceApi;


GameresourceApi apiInstance = new GameresourceApi();
String id = "id_example"; // String | gameId
try {
    Integer result = apiInstance.getSalvoShotsNumberUsingGET(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GameresourceApi#getSalvoShotsNumberUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| gameId |

### Return type

**Integer**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="receiveFireUsingPUT"></a>
# **receiveFireUsingPUT**
> InlineResponse2002 receiveFireUsingPUT(salvoShot, id)

Receive fire

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.GameresourceApi;


GameresourceApi apiInstance = new GameresourceApi();
SalvoShot salvoShot = new SalvoShot(); // SalvoShot | salvoShot
String id = "id_example"; // String | gameId
try {
    InlineResponse2002 result = apiInstance.receiveFireUsingPUT(salvoShot, id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GameresourceApi#receiveFireUsingPUT");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **salvoShot** | [**SalvoShot**](SalvoShot.md)| salvoShot |
 **id** | **String**| gameId |

### Return type

[**InlineResponse2002**](InlineResponse2002.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

