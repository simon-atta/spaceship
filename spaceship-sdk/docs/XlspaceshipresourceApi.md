# XlspaceshipresourceApi

All URIs are relative to *https://localhost:8080/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getSpaceShipBoardUsingGET**](XlspaceshipresourceApi.md#getSpaceShipBoardUsingGET) | **GET** /xl-spaceship/getspaceshipboard | Get XL-Spaceship board
[**getSpaceshipByidUsingGET**](XlspaceshipresourceApi.md#getSpaceshipByidUsingGET) | **GET** /xl-spaceship/getxlspaceshipbyid | Get XL-Spaceship by id
[**getSpaceshipsByUserIdUsingGET**](XlspaceshipresourceApi.md#getSpaceshipsByUserIdUsingGET) | **GET** /xl-spaceship/getxlspaceshipsbyuserId | Get XL-Spaceship by user id
[**getSpaceshipsListUsingGET**](XlspaceshipresourceApi.md#getSpaceshipsListUsingGET) | **GET** /xl-spaceship/getxlspaceshipslist | List of all XL-spaceship
[**initializeSpaceshipUsingPOST**](XlspaceshipresourceApi.md#initializeSpaceshipUsingPOST) | **POST** /xl-spaceship/initialize | Initialize XL-spaceship


<a name="getSpaceShipBoardUsingGET"></a>
# **getSpaceShipBoardUsingGET**
> InlineResponse200 getSpaceShipBoardUsingGET()

Get XL-Spaceship board

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.XlspaceshipresourceApi;


XlspaceshipresourceApi apiInstance = new XlspaceshipresourceApi();
try {
    InlineResponse200 result = apiInstance.getSpaceShipBoardUsingGET();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling XlspaceshipresourceApi#getSpaceShipBoardUsingGET");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**InlineResponse200**](InlineResponse200.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getSpaceshipByidUsingGET"></a>
# **getSpaceshipByidUsingGET**
> InlineResponse2001 getSpaceshipByidUsingGET(spaceshipId)

Get XL-Spaceship by id

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.XlspaceshipresourceApi;


XlspaceshipresourceApi apiInstance = new XlspaceshipresourceApi();
Long spaceshipId = 789L; // Long | spaceshipId
try {
    InlineResponse2001 result = apiInstance.getSpaceshipByidUsingGET(spaceshipId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling XlspaceshipresourceApi#getSpaceshipByidUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **spaceshipId** | **Long**| spaceshipId |

### Return type

[**InlineResponse2001**](InlineResponse2001.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getSpaceshipsByUserIdUsingGET"></a>
# **getSpaceshipsByUserIdUsingGET**
> List&lt;InlineResponse2001&gt; getSpaceshipsByUserIdUsingGET(userId)

Get XL-Spaceship by user id

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.XlspaceshipresourceApi;


XlspaceshipresourceApi apiInstance = new XlspaceshipresourceApi();
String userId = "userId_example"; // String | userId
try {
    List<InlineResponse2001> result = apiInstance.getSpaceshipsByUserIdUsingGET(userId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling XlspaceshipresourceApi#getSpaceshipsByUserIdUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **String**| userId |

### Return type

[**List&lt;InlineResponse2001&gt;**](InlineResponse2001.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getSpaceshipsListUsingGET"></a>
# **getSpaceshipsListUsingGET**
> List&lt;InlineResponse2001&gt; getSpaceshipsListUsingGET()

List of all XL-spaceship

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.XlspaceshipresourceApi;


XlspaceshipresourceApi apiInstance = new XlspaceshipresourceApi();
try {
    List<InlineResponse2001> result = apiInstance.getSpaceshipsListUsingGET();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling XlspaceshipresourceApi#getSpaceshipsListUsingGET");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;InlineResponse2001&gt;**](InlineResponse2001.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="initializeSpaceshipUsingPOST"></a>
# **initializeSpaceshipUsingPOST**
> initializeSpaceshipUsingPOST(xLSpaceshipRequest)

Initialize XL-spaceship

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.XlspaceshipresourceApi;


XlspaceshipresourceApi apiInstance = new XlspaceshipresourceApi();
XLSpaceshipRequest xLSpaceshipRequest = new XLSpaceshipRequest(); // XLSpaceshipRequest | xLSpaceshipRequest
try {
    apiInstance.initializeSpaceshipUsingPOST(xLSpaceshipRequest);
} catch (ApiException e) {
    System.err.println("Exception when calling XlspaceshipresourceApi#initializeSpaceshipUsingPOST");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **xLSpaceshipRequest** | [**XLSpaceshipRequest**](XLSpaceshipRequest.md)| xLSpaceshipRequest |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

