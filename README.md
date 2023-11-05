
# spring-jwt-login

Sample for Spring Security OAuth2 with JWT token

## Register

`POST /auth/register`

    curl --location 'http://localhost:8080/api/auth/register' \--data-raw '{
    "username": "johndoe",
    "email": "johndoe@user.com",
    "password": "1234" }'

### Response

    HTTP/200 Ok | User created successfully. 

### Login

`GET /auth/login`

    curl --location 'http://localhost:8080/api/auth/login' \--data '{
    "username": "johndoe",
    "password": "1234" }'

### Response

    HTTP/200 OK 

    {
    "authenticationToken": "eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJqb2huZG9lIiwiaWF0IjoxNjk5MjE3Mjc5LCJleHAiOjE2OTkyNTMyNzl9.uwBqRW5ke5XnzqlUiBTY5ieUW6ifHBvYJVtnwEa_x3MKVHFO6o-FJlyvXe6vSK_P",
    "username": "johndoe" 
    }
