# Event Management Microservices

Three independent Spring Boot services with CRUD APIs and localhost ports:

- Event Service: http://localhost:8081/events
- Participant Service: http://localhost:8082/participants
- Ticket Service: http://localhost:8083/tickets

## Run individually
In each service folder:
```bash
mvn spring-boot:run
```

## Sample cURL
```bash
# Create event
curl -X POST http://localhost:8081/events -H "Content-Type: application/json" -d '{"name":"Conf","location":"Delhi","date":"2025-09-01"}'

# List participants
curl http://localhost:8082/participants

# Create ticket
curl -X POST http://localhost:8083/tickets -H "Content-Type: application/json" -d '{"participantId":1,"eventId":1,"status":"BOOKED"}'
```
