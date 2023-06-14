# RockpaperscissorsBackend

This is the backend of a Rock-Paper-Scissors game application built with Spring Boot. Here you can find the [frontend code](https://github.com/ChrisAL94/rockpaperscissors-frontend).

## Build

To build use the IntellJ UI oder execute `./gradlew build` in the root dir.

## Deploy

Use the IntellJ UI to run the Application or execute `java -jar build/libs/rockpaperscissors-backend-0.0.1-SNAPSHOT.jar`. Application runs on `http://localhost:8080/`.

## Database

The application is using a Postgres database. You can use your local installation or leverage docker to deploy a postgres instance by executing `cd src/main/kotlin/resources/postgres` && `docker compose up -d`

## Logs & Metrics

Logs are persisted in ./logs/test-logback.log. Metrics are accessible via 'http://localhost:8080/actuator/prometheus' 

## RestApi

### Play Game
Endpoint: `POST /api/v1/game`

##### Request
- **Body Parameters**:
    - `gameDto` (GameDto): Game data.
        - `username` (String): User's username.
        - `userSymbol` (String): User's symbol.

##### Response
- `200 OK` on success
- **Response Body**:
    - `gameResultDTO` (GameResultDTO): Game result data.
        - `...` (properties of the game result)

### Get User Game History
Endpoint: `GET /api/v1/gameHistory/{username}`

Get the game history for a specific user.

##### Request
- **Path Parameters**:
    - `username` (String): User's username.

##### Response
- `200 OK` on success
- **Response Body**:
    - `gameHistoryDto` (GameHistoryDto): Game history data.
        - `...` (properties of the game history)

#### Get All Users Game History
Endpoint: `GET /api/v1/gameHistory`

Get the game history for all users.

##### Response
- `200 OK` on success
- **Response Body**:
    - `gameHistoryDtos` (Array of GameHistoryDto): Array of game history data.
        - `...` (properties of the game history)

### Get All Users
Endpoint: `GET /api/v1/user`

Get a list of all registered users.

##### Response
- `200 OK` on success
- **Response Body**:
    - `users` (Array of String): Array of usernames.

#### Register New User
Endpoint: `POST /api/v1/user`

Register a new user.

##### Request
- **Body Parameters**:
    - `username` (String): User's username.

##### Response
- `200 OK` on success

## Running unit tests

Run `./gradlew test` to execute the unit tests.