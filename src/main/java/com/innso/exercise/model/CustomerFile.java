package com.innso.exercise.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

/**
 * Customer File Entity.
 */
@Entity
@Table(name = "customer_file")
public class CustomerFile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "client_name")
    private String clientName;

    @Column(name = "opening_date")
    private LocalDate openingDate;

    @Column(name = "reference")
    private String reference;

    @OneToMany(targetEntity = Message.class, cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private Set<Message> messages;

    public CustomerFile() {
    }

    public CustomerFile(String clientName, LocalDate openingDate, String reference, Set<Message> messages) {
        this.clientName = clientName;
        this.openingDate = openingDate;
        this.reference = reference;
        this.messages = messages;
    }

    public void addMessage(Message message){
        this.messages.add(message);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public LocalDate getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(LocalDate openingDate) {
        this.openingDate = openingDate;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Set<Message> getMessages() {
        return messages;
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }

    @Override
    public String toString() {
        return "Customer File{" +
                "id=" + getId() +
                ", clientName='" + getClientName() + "'" +
                ", openingDate='" + getOpeningDate() + "'" +
                ", reference='" + getReference() + "'" +
                "}";
    }
}