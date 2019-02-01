# UserresourceApi

All URIs are relative to *https://localhost:8084/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**challengeUserUsingPOST**](UserresourceApi.md#challengeUserUsingPOST) | **POST** /xl-spaceship/user/challengeUser | Challenge User
[**createUserUsingPOST**](UserresourceApi.md#createUserUsingPOST) | **POST** /xl-spaceship/user/createUser | Create User
[**getAllOpponentUsersUsingGET**](UserresourceApi.md#getAllOpponentUsersUsingGET) | **GET** /xl-spaceship/user/getAllOpponentUsers | get all opponent users
[**getAllUsersUsingGET**](UserresourceApi.md#getAllUsersUsingGET) | **GET** /xl-spaceship/user/getAllUsers | Get all users
[**getUserByUserNameUsingGET**](UserresourceApi.md#getUserByUserNameUsingGET) | **GET** /xl-spaceship/user/getUserByUserName | Get user by username


<a name="challengeUserUsingPOST"></a>
# **challengeUserUsingPOST**
> InlineResponse200 challengeUserUsingPOST(pGameRequest)

Challenge User

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.UserresourceApi;


UserresourceApi apiInstance = new UserresourceApi();
PGameRequest pGameRequest = new PGameRequest(); // PGameRequest | pGameRequest
try {
    InlineResponse200 result = apiInstance.challengeUserUsingPOST(pGameRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserresourceApi#challengeUserUsingPOST");
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

<a name="createUserUsingPOST"></a>
# **createUserUsingPOST**
> PUser createUserUsingPOST(pUser)

Create User

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.UserresourceApi;


UserresourceApi apiInstance = new UserresourceApi();
PUser pUser = new PUser(); // PUser | pUser
try {
    PUser result = apiInstance.createUserUsingPOST(pUser);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserresourceApi#createUserUsingPOST");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **pUser** | [**PUser**](PUser.md)| pUser |

### Return type

[**PUser**](PUser.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getAllOpponentUsersUsingGET"></a>
# **getAllOpponentUsersUsingGET**
> List&lt;InlineResponse2001&gt; getAllOpponentUsersUsingGET(userId)

get all opponent users

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.UserresourceApi;


UserresourceApi apiInstance = new UserresourceApi();
String userId = "userId_example"; // String | userId
try {
    List<InlineResponse2001> result = apiInstance.getAllOpponentUsersUsingGET(userId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserresourceApi#getAllOpponentUsersUsingGET");
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

<a name="getAllUsersUsingGET"></a>
# **getAllUsersUsingGET**
> List&lt;InlineResponse2001&gt; getAllUsersUsingGET()

Get all users

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.UserresourceApi;


UserresourceApi apiInstance = new UserresourceApi();
try {
    List<InlineResponse2001> result = apiInstance.getAllUsersUsingGET();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserresourceApi#getAllUsersUsingGET");
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

<a name="getUserByUserNameUsingGET"></a>
# **getUserByUserNameUsingGET**
> PUser getUserByUserNameUsingGET(userId)

Get user by username

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.UserresourceApi;


UserresourceApi apiInstance = new UserresourceApi();
String userId = "userId_example"; // String | userId
try {
    PUser result = apiInstance.getUserByUserNameUsingGET(userId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserresourceApi#getUserByUserNameUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **String**| userId |

### Return type

[**PUser**](PUser.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

