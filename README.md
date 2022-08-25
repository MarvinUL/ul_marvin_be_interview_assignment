
## Assignment

Implement an application which represents basic project management flow. It will store all records in database (preferably in-memory
database).

**Project** model should be used when implementing endpoints. Project status can be *IN_PROGRESS* or *FINISHED*.


```
Long id;
String name;
StatusEnum status;
LocalDateTime dateCreated;
boolean archived;
```


### Endpoints

The following table describes the endpoints that should be implemented.



|Endpoint|Description|Request body|Response body|
|--------|-----------|------------|-------------|
|POST /projects|Create new project|```{"name":"test", "status":"IN_PROGRESS"}```|```{"id": "234", "name": "test", "status":"IN_PROGRESS", "dateCreated":"2021-08-03T17:33", "archived":false}```
|GET /projects|Get all projects that are NOT archived| |```[{"id":"234", "name":"test", "status":"IN_PROGRESS", "dateCreated":"2021-03-16T17:33", "archived":false}, {"id":"112", "name":"demo", "status":"FINISHED", "dateCreated":"2021-02-23T11:32", "archived":false}]```|
|PUT /projects/{id}|Archive project| |```{"id":"234", "name":"test", "status":"IN_PROGRESS", "dateCreated":"2021-03-16T17:33", "archived":true}```|
