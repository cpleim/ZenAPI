
# ZenAPI - RESTful API by Zennet Labs

## Introduction
This API provides access to data stored in the ***MongoDB NoSQL*** database.

*Its purpose is to keep **100% synchronized the stock databases** hosted in the local micro servers, in order to provide a real-time stock on the e-commerce Website and Statistics.*


## Technologies used
 - Main language: **Java (jdk 1.7.0_79)** 
 - RESTful Client: **Jersey 2.19** 
 - HTTP Server: **Apache Tomcat v8.5.39** 
 - Database: **MongoDB 2.11.4**

This API has been developed under *Eclipse IDE for Enterprise Java Developers. Version: 2019-03 (4.11.0) Build id: 20190314-1200* (macOS Mojave - 10.14.4)

## Endpoints usage

To test/debug the API endpoints, we use **PostMan** software *https://www.getpostman.com*

All the services of the API are under `localhost:8080/services/v1/*` where * is the endpoint to use.

*E.g: **[GET]** `localhost:8080/zenapi/services/v1/users` --> Return all users.*

A detailed list of all the methods with their corresponding endpoints can be found in the ***Zennet Labs Workspace*** in PostMan.

## Endpoints

[**Basic Users Manipulation**](#updateUser)
  * [Update User](#updateUser)
  * [Search for a User](#findUser)
  * [Delete a User](#deleteUser)
  * [Create a User](#createUser)
  * [Show all Users](#showUsers)
  
   [**Basic Server testing/responses**](#showStatus)
  * [Show Status Message](#showStatus)
  * [Show Main Page](#showMainPage)



## ![](https://img.shields.io/badge/-PUT-blue.svg) /zenapi/services/v1/users/ - Update a user <a name="updateUser"></a>

 ## Description
*Updates the parameters of an existing user.*

## Parameters
|Parameter|Value|Parameter type|Data type|
|--|--|--|--|
|**userId**| `{userId String}`|**path**|**String**|
|**body**|`{"name":"Carlos Schmidt"}`|**body**|**String**|

## Response Messages
|HTTP Status Code|Reason|Content-Type
|--|--|--|
|**200**| **OK**: `{ User profile }`|`application/json`
|**400**| **Bad Request**: `{"error":"error description", "status":"FAIL"}`|`application/json`
|**401**| **Unauthorized:** The request did not include an authentication token or the authentication token was expired.|
|**403**| **Forbidden:** You do not have the necessary permissions to access this resource.|

## Request URL

   ```bash
Method: PUT
URL: http://localhost:8080/zenapi/services/v1/users/{userId}
```

## Expected response body
```json
    {
        "id": "5ca7ba6377c89fabd4f588f2",
        "name": "Juan Schmidt"
      } 
```


## ![](https://img.shields.io/badge/-GET-green.svg) /zenapi/services/v1/users/ - Search for a user <a name="findUser"></a>


## Description
*Search for a certain user through his `userId` String.*

## Input Parameters

 - **userId String**
 
## Parameters
|Parameter|Value|Description|Parameter type|Data type|
|--|--|--|--|--|
|**userId**| `{userId String}`|The `userId` String is automatically generated when the user is created.|**path**|**String**|


## Response Messages
|HTTP Status Code|Reason|Content-type
|--|--|--|
|**200**| **OK**: `{ }`|`application/json`
|**400**| **Bad Request**: `{"error":"error description", "status":"FAIL"}`|`application/json`
|**403**| **Forbidden:** You do not have the necessary permissions to access this resource.|

## Request URL

```bash
Method: GET
URL: http://localhost:8080/zenapi/services/v1/users/{userId}
```

## Expected response body
```json
    {
        "id": "5ca7ba6377c89fabd4f588f2",
        "name": "Juan Perez"
      } 
  ```    


## ![](https://img.shields.io/badge/-DEL-red.svg) /zenapi/services/v1/users/ - Delete a User <a name="deleteUser"></a>


## Description
*Deletes a user and all associated data.*
***Be careful...***

## Input Parameters

 - **userId String**
 
## Parameters
|Parameter|Value|Description|Parameter type|Data type|
|--|--|--|--|--|
|**userId**| `{userId String}`|**-**|**path**|**String**|


## Response Messages
|HTTP Status Code|Reason|Content-type|
|--|--|--|
|**200**| **OK**|`application/json`
|**400**| **Bad Request**: `{"error":"error description", "status":"FAIL"}`|`application/json`
|**401**| **Unauthorized:** The request did not include an authentication token or the authentication token was expired.|
|**403**| **Forbidden:** You do not have the necessary permissions to access this resource.|

## Request URL

```bash
Method: DELETE
URL: http://localhost:8080/zenapi/services/v1/users/{userId}
```

## ![](https://img.shields.io/badge/-POST-orange.svg) /zenapi/services/v1/users/ - Create a new User <a name="createUser"></a>


## Description
*Create a new user if it does not exist in the database.*

## Input Parameters

 - **new user object** is required.
 
## Parameters
|Parameter|Value|Description|Parameter content type|
|--|--|--|--|
|**body**| `{"name":"Juan Perez"}`|**New User**|`application/json`|


## Response Messages
|HTTP Status Code|Reason|Content-type
|--|--|--|
|**201**| **Created**: `{ user profile }`|`application/json`
|**400**| **Bad Request**: `{"error":"error description", "status":"FAIL"}`|`application/json`
|**401**| **Unauthorized:** The request did not include an authentication token or the authentication token was expired.|
|**403**| **Forbidden:** You do not have the necessary permissions to access this resource.|

## Request URL

```bash
Method: POST
URL: http://localhost:8080/zenapi/services/v1/users
```
## Expected response body
```json
    {
        "id": "5ca7ba6377c89fabd4f588f2",
        "name": "Juan Perez"
      } 
  ``` 


## ![](https://img.shields.io/badge/-GET-green.svg) /zenapi/services/v1/users/ - Show all Users <a name="showUsers"></a>


## Description
*Returns the collection of user objects stored in the database.*


## Response Messages
|HTTP Status Code|Reason|Content-Type
|--|--|--|
|**200**| **OK**: `{ users collection }`|`application/json`
|**400**| **Bad Request**: `{"error":"error description", "status":"FAIL"}`|`application/json`
|**401**| **Unauthorized:** The request did not include an authentication token or the authentication token was expired.|-
|**403**| **Forbidden:** You do not have the necessary permissions to access this resource.|-

## Request URL

```bash
Method: GET
URL: http://localhost:8080/zenapi/services/v1/users
```

## Expected response body
```json
     {
      "users": [{
        "id": "0001",
        "name": "Jhon Doe"
      }, {
        "id": "0002",
        "name": "Juan Perez"
      }]
    }
```

## ![](https://img.shields.io/badge/-GET-green.svg) /zenapi/services/v1/message/status - Show Status Message <a name="showStatus"></a>

## Description
 *Return a text/plain status message*


## Response Messages
|HTTP Status Code|Reason|Content-Type
|--|--|--|
|**200**| **OK**|`text/plain`|
|**404**| **Not Found.**| `text/html`


## Request URL

```bash
Method: GET
URL: http://localhost:8080/zenapi/services/v1/message/status
```

## Expected response body

    API is Running.-


## ![](https://img.shields.io/badge/-GET-green.svg) /zenapi/ - Show Main Page<a name="showMainPage"></a>


## Description
*Shows the Apache server home page.*


## Response Messages
|HTTP Status Code|Reason|Content-Type
|--|--|--|
|**200**| **OK**|`text/html`|
|**404**| **Not Found.**| `text/html`

## Request URL

 ```bash
Method: GET
URL: http://localhost:8080/zenapi/
```

## Expected response body

```html
<html>
    <body>
        <h1>It Works!</h1>
        <h2>ZenAPI - RESTful API by Zennet Labs ~ONLY FOR INTERNAL USE~</h2>
        <h4>Version 1 - 
            
            <i>Codename Faciem</i>
        </h4>
        <p>
            <script> document.write(new Date()); </script>
        </p>
        <p>
            <i>Development Build - Powered by Java</i>
        </p>
    </body>
</html>
```


