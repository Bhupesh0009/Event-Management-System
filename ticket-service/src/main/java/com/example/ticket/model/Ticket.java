package com.example.ticket.model;

public class Ticket {
    private Long id;
    private Long participantId;
    private Long eventId;
    private String status; // e.g., BOOKED, CANCELLED
    private Double price;

    public Ticket() {}

    public Ticket(Long id, Long participantId, Long eventId, String status, Double price) {
        this.id = id;
        this.participantId = participantId;
        this.eventId = eventId;
        this.status = status;
        this.price = price;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getParticipantId() { return participantId; }
    public void setParticipantId(Long participantId) { this.participantId = participantId; }

    public Long getEventId() { return eventId; }
    public void setEventId(Long eventId) { this.eventId = eventId; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
}
