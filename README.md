# Library REST
To work in this REST, you need to follow this API:

## Author
- URL: https://secret-waters-63016.herokuapp.com/authors
- Object example:
```javascript
{
"id": 1,
"firstName": "Jordão",
"lastName": "Macedo",
}
```
#### POST
To create a new **author**, you need to send an object Author for the URL.
#### GET all
To get all **authors**, go to URL.
#### GET one
To get one **author**, go to: https://secret-waters-63016.herokuapp.com/authors/:id 
Replace `:id` with an exising id.
#### DELETE
To delete an **author**, go to: https://secret-waters-63016.herokuapp.com/authors/:id 
Replace `:id` with an exising id using HTTP DELETE method.
#### PUT
To update an **author**, send the new author object to: https://secret-waters-63016.herokuapp.com/authors/:id 
Replace `:id` with an exising id using HTTP PUT method.

## Publisher
- URL: https://secret-waters-63016.herokuapp.com/publishers
- Object example
```javascript
{
"id": 1,
"name": "Editora X"
}
```
### Methods:
- POST
- GET all
- GET one
- DELETE
- PUT

## Pub
- URL: https://secret-waters-63016.herokuapp.com/pubs
- Object example
```javascript
{
"id": 1,
"title": "Harry Potter e a Câmara Secreta",
"description": "Após as sofríveis férias na casa dos ...",
"type": "LIVRO",
"author": {
    "id": 1
},
"publisher": {
    "id": 1
}
}
```
### Methods:
- POST
- GET all
- GET one
- DELETE
- PUT
