package com.innso.exercise.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.hateoas.server.EntityLinks;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Message Entity.
 */
@Entity
@Table(name = "message")
@JsonIgnoreProperties("customerFile")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "creation_date")
    private LocalDate creationDate;

    @Column(name = "author_name")
    private String authorName;

    @Column(name = "content")
    private String content;

    @Enumerated(EnumType.STRING)
    @Column(name = "channel")
    private Channel channel;

    public Message() {
    }

    public Message(LocalDate creationDate, String authorName, String content, Channel channel) {
        this.creationDate = creationDate;
        this.authorName = authorName;
        this.content = content;
        this.channel = channel;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + getId() +
                ", creationDate='" + getCreationDate() + "'" +
                ", authorName='" + getAuthorName() + "'" +
                ", content='" + getContent() + "'" +
                ", channel=" + getChannel() + "'" +
                "}";
    }
}