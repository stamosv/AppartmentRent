## Begin/Use application.

- Begin Application with **mvn spring-boot:run** in terminal.
- Use "Postman" to trigger the REST calls.
- Authenticate via **/authenticate** REST call. POST | http://localhost:8080/authenticate
1. Body | raw 
2.
```json
{
 "username" : "vstamos",
 "password" : "vstamos"
}
```
   
- Save the generated token of authentication to use it for further REST calls. For Example:
```json
{
    "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ2c3RhbW9zIiwiZXhwIjoxNTY4NTkwNTM4LCJpYXQiOjE1Njg1NzI1Mzh9.D8bvnm3R3g-BTrqmUxWvTHErPdCxVTvuV_Es5xHt8thQ3ysBahXo2Eddk5p9RPAO7J_Gxrm0qR1Y4sP9raiWNg"
}
```
- Trigger any other REST call. For example:
1. GET | http://localhost:8080/retrieveFullList
2. Headers | Key: Authorization | Value ("Bearer" + " " + token) : 
```
Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ2c3RhbW9zIiwiZXhwIjoxNTY4NTg3MTIyLCJpYXQiOjE1Njg1NjkxMjJ9.Y6MYgm-F3ER9AHt3_XP5KqRyWNwNbS0HhVJXh0X781ngVdIXnqisEQkOt48anDzyAMdoCkTfJ9uFh0474Fpl0Q 
```

---

## Exposed endpoints.

The exposed endpoints are the following:

1. **/postReview** : This endpoint saves a new review for a unit. The review will include the unit entity, a score and/or a comment.
2. **/searchUnits/{searchWord}** : This endpoint searchs for units based on user's input.
3. **/retrieveFullList** : This endpoint retrieves all of units that are stored in database.
4. **/sortUnitsAsc** : This endpoint retrieves all of units that are stored in database in ascending order based on score
5. **/sortUnitsDesc** : This endpoint retrieves all of units that are stored in database in descending order based on score
6. **/retrievePageUnits/{page}** : This endpoints retrieves units based on a specific page
7. **/authenticate** : This endpoint authenticates users based on username/password and returns a token back front-end layer
 
 