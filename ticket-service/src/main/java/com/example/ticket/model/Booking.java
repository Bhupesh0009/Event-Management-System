package com.example.ticket.model;
public class Booking {
    private String id;
    private String eventId;
    private String customerId;
    private String date;
    private int tickets;
    public Booking(){} public Booking(String id,String eventId,String customerId,String date,int tickets){this.id=id;this.eventId=eventId;this.customerId=customerId;this.date=date;this.tickets=tickets;}
    public String getId(){return id;} public void setId(String id){this.id=id;}
    public String getEventId(){return eventId;} public void setEventId(String eventId){this.eventId=eventId;}
    public String getCustomerId(){return customerId;} public void setCustomerId(String customerId){this.customerId=customerId;}
    public String getDate(){return date;} public void setDate(String date){this.date=date;}
    public int getTickets(){return tickets;} public void setTickets(int tickets){this.tickets=tickets;}
}
