package com.innso.exercise.controller;

import com.innso.exercise.model.Message;
import com.innso.exercise.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.innso.exercise.model.Message}.
 */
@RestController
@RequestMapping("/api")
public class MessageController {

    @Autowired
    MessageRepository messageRepo;

    /**
     * {@code GET  /messages} : get all the messages.
     *
     * @return the list of messages in body with status {@code 200 (OK)}.
     * or with status {@code 204 (Non Content)} if there is no message stored
     */
    @GetMapping("/messages")
    public ResponseEntity<List<Message>> getAllMessages(){

        List<Message> messages = new ArrayList<>();

        messageRepo.findAll().forEach(messages::add);

        if(messages.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else{
            return new ResponseEntity<>(messages, HttpStatus.OK);
        }
    }

    /**
     * {@code POST  /messages} : Create a new message.
     *
     * @param paramMessage : the message to create.
     * @return in the body the new message, with status {@code 201 (Created)}.
     */
    @PostMapping("/messages")
    public ResponseEntity<Message> createMessage(@RequestBody Message paramMessage){

        Message savedMessage = messageRepo.save(new Message(
                LocalDate.now() , paramMessage.getAuthorName(), paramMessage.getContent(), paramMessage.getChannel()
        ));

        return new ResponseEntity<>(savedMessage, HttpStatus.CREATED);
    }

    /**
     * {@code PUT  /messages/{id} : update a message corresponding to the Id given in parameters.
     * If a property is not in the JSON request, we keep actual value.
     *
     * @param paramMessage : the message to update.
     * @param id : the id of the message.
     * @return in the body the updated message, with status {@code 200}
     * or with status {@code 404 (Not Found)} if there is no message with this id
     */
    @PutMapping("/messages/{id}")
    public ResponseEntity<Message> updateMessage(@PathVariable("id") long id, @RequestBody Message paramMessage){

        Optional<Message> existingMessage = messageRepo.findById(id);

        if(existingMessage.isPresent()){
            Message updatedMessage = existingMessage.get();

            if(paramMessage.getCreationDate() != null){
                updatedMessage.setCreationDate(paramMessage.getCreationDate());
            }

            if(paramMessage.getContent() != null){
                updatedMessage.setContent(paramMessage.getContent());
            }

            if(paramMessage.getChannel() != null){
                updatedMessage.setChannel(paramMessage.getChannel());
            }

            if(paramMessage.getAuthorName() != null){
                updatedMessage.setAuthorName(paramMessage.getAuthorName());
            }

            return new ResponseEntity<>(messageRepo.save(updatedMessage), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}