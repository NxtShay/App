# _CO-2 Demo_

## FOR FRONTEND

1. Install
```bash
   docker-compose
```
2. Go to demo folder
3. 
```bash 
sudo docker-compose up --build
```

In the following I am doing my best to describe the restful interface and the database.

*Hint:* To manage my requests I use the app `Insomnia`.

### User table
     String userName,   String userPassword,    String firstNamename,   String lastName,
     String zipCode,    Integer peopleInHouse,  Boolean heating,    Boolean electricity,
     String car,    Integer kilometers, Integer holidayCar, Integer holidayPlane,
     Integer holidayTrain,  String food,    Boolean pvSystem,   Boolean recyclingGlass,
     Boolean recyclingPlastic,  Boolean recyclingPaper, Boolean recyclingMetal, 
     Boolean recyclingFoodwaste, String washing,

`userName`,`userPassword`,`lastName`,`firstName` are needed to create a new user - the other fields can be *null*, as such:

```json
    [{
    "userName":"mrbraggins",
    "userPassword":"password",
    "firstName":"Bilbo",
    "lastName":"Baggins"
    }]
```
`POST` to `http://localhost:8080/api/v1/user`

Multiple users can be added at the same time. Other fields can be updated later, as such:

```json
  {"userName":"mrbraggins",
  "zipCode":"37073",
  "food":"2-3 times a week",
  "car":"large"}
```
`PUT` to `http://localhost:8080/api/v1/user`

The information can be accessed, as such:

`GET` to `http://localhost:8080/api/v1/user/username/mrbraggins`

The `userName` is *unique* and serves as key.

### Recommondations
    String recommondation,  String basedOn, String zipCode

`recommondation` is needed to create a new recommondation, but either `basedOn` or `zipCode` should be assigned a value, 
since they can be used to search the recommondations later on. New recommondations can be created as follows:

```json
    [
      {"recommondation":"Try switisch to green energy!",
        "basedOn":"electricity",
        "zipCode":null},
      {"recommondation":"Did you know, that there is a zero waste store in Göttingen?", 
        "basedOn":null,
        "zipCode":"37073"},
      {"recommondation":"Did you ever think about switching your big car for an electric car or hybrid?", 
        "basedOn":"car",
        "zipCode":null}
    ]   
```

`POST` to `http://localhost:8080/api/v1/recommondation`

And searched with:

`GET` to `http://localhost:8080/api/v1/recommondation/basedon/electricity`

or 

`GET` to `http://localhost:8080/api/v1/recommondation/zipcode/37073`

### Challenges
    String challenge,  String category, Integer score

All fields are needed to create a challenge. New challenges can be created as follows:

```json
    [
      { "challenge":"TRecycle clothing. Don't throw it out, but repair it!",
        "category":"living",
        "score":5},
      {	"challenge":"Living without plastic is easier, than you think. Most cities have a zero waste store and regular farmer markets. Why don't you try not buying anything plastic for a week?",
        "category":"consuming",
        "score":10},
      {	"challenge":"Switch five of your everyday-product into something more sustainable. For example a bambus toothbrush!",
        "category":"living",
        "score":5}
    ]
```
`POST` to `http://localhost:8080/api/v1/challenge`

We can check how many challenges we have with:

`GET` to `http://localhost:8080/api/v1/challenge/size`

and access a challenge with `id` in range `[1,size]` as follows:

`GET` to `http://localhost:8080/api/v1/challenge/id/2`

## FOR DEVELOPER

### Prerequisites

1. Install `docker`
2. Install Java 16, e.g. via `openjdk-16`
3. Install maven. Please make sure you are running a maven version compatible with the Java 16 Release, e.g. maven version `3.8.1`

**Disclaimer**: `mvn` version `3.8.1` as well as `openjdk-16` are not in Ubuntu 20.04 repositories.

### Running the database

This application uses a My-SQL database to persist data.

To start the database, simply run 
```bash
docker run --rm --name co2mysqldemo -p 3306:3306 --env MYSQL_ROOT_PASSWORD=secret --env MYSQL_DATABASE=demo  mysql
```
Or use the `docker-compose.yml` to build database and simply run
```bash
docker-compose up
```
**Disclaimer** If fields in the database are changed, then it is not enough to run `docker-compose stop` but the data has to be thrown out with `docker-compose down`

### Running the application

You can import the project in an IDE of your choice and go on from there, or you can run the application on the command line using `maven` via
```bash
mvn spring-boot:run
```

### Interacting with the application

#### Uploading data

You can upload data using any tool of your choice to perform REST calls, e.g.
```bash
curl --header "Content-Type: application/json" \
--request POST \
--data '[{"firstName":"Frodo","lastName":"Baggins"}]' \
http://localhost:8080/api/v1/user

curl --header "Content-Type: application/json" \
--request POST \
--data '[{"firstName":"Bilbo","lastName":"Baggins"}]' \
http://localhost:8080/api/v1/user
```

#### Downloading data

You can download data using any tool of your choice to perform REST calls, e.g.
```bash
curl http://localhost:8080/api/v1/user/id/1
curl http://localhost:8080/api/v1/user/id/2
curl http://localhost:8080/api/v1/user/name/Baggins
```
Running these commands assume you have inserted data into the application using the commands from the previous chapter.

### Architecture of the application

This application does not use the best practice for software architecture, as we do not fully de-couple layers using inversion of control.

However, the following layers are present:
```
    View
      ^
      |
   Service
      |
      v
     Data 
```
The `view` should handle incoming requests, the `data` layer should write to the database.

The `service` layer should take care of the "business logic", i.e. **mapping between input logic and data logic**.

Typically speaking, this means mapping between DTOs (Data Transfer Objects) and Entities.

The typical use case here is that you would not always necessarily need all the information from a data object returned via a request.

