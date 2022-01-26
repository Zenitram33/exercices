package com.innso.exercise.controller;

import com.innso.exercise.model.CustomerFile;
import com.innso.exercise.model.Message;
import com.innso.exercise.repository.CustomerFileRepository;
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
 * REST controller for managing {@link com.innso.exercise.model.CustomerFile}.
 */
@RestController
@RequestMapping("/api")
public class CustomerFileController {

    @Autowired
    CustomerFileRepository customerFileRepo;

    @Autowired
    MessageRepository messageRepo;

    /**
     * {@code GET  /customer-files} : get all the customer files.
     *
     * @return the list of customer files in body with status {@code 200 (OK)}.
     * or with status {@code 204 (Non Content)} if there is no customer file stored
     */
    @GetMapping("/customer-files")
    public ResponseEntity<List<CustomerFile>> getAllCustomerFiles(){

        List<CustomerFile> customerFiles = new ArrayList<>();

        customerFileRepo.findAll().forEach(customerFiles::add);

        if(customerFiles.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else{
            return new ResponseEntity<>(customerFiles, HttpStatus.OK);
        }
    }

    /**
     * {@code POST  /customer-files} : Create a new customer file.
     *
     * @param paramCustomerFile : the customer file to create.
     * @return in the body the new customer file, with status {@code 201 (Created)}.
     */
    @PostMapping("/customer-files")
    public ResponseEntity<CustomerFile> createCustomerFile(@RequestBody CustomerFile paramCustomerFile){

        CustomerFile savedCustomerFile = customerFileRepo.save(new CustomerFile(
                paramCustomerFile.getClientName() , LocalDate.now(), paramCustomerFile.getReference(), paramCustomerFile.getMessages()
        ));

        return new ResponseEntity<>(savedCustomerFile, HttpStatus.CREATED);
    }

    /**
     * {@code PUT  /customer-files/{id} : update a customer file corresponding to the Id given in parameters.
     * If a property is not in the JSON request, we keep actual value.
     *
     * @param paramCustomerFile : the customer file to update.
     * @param id : the id of the customer file.
     * @return in the body the updated customer file, with status {@code 200}
     * or with status {@code 404 (Not Found)} if there is no customer file with this id
     */
    @PutMapping("/customer-files/{id}")
    public ResponseEntity<CustomerFile> updateCustomerFile(@PathVariable("id") long id, @RequestBody CustomerFile paramCustomerFile){

        Optional<CustomerFile> existingCustomerFile = customerFileRepo.findById(id);

        if(existingCustomerFile.isPresent()){
            CustomerFile updatedCustomerFile = existingCustomerFile.get();

            if(paramCustomerFile.getClientName() != null){
                updatedCustomerFile.setClientName(paramCustomerFile.getClientName());
            }

            if(paramCustomerFile.getReference() != null){
                updatedCustomerFile.setReference(paramCustomerFile.getReference());
            }

            if(paramCustomerFile.getOpeningDate() != null){
                updatedCustomerFile.setOpeningDate(paramCustomerFile.getOpeningDate());
            }

            if(paramCustomerFile.getMessages() != null){
                updatedCustomerFile.setMessages(paramCustomerFile.getMessages());
            }

            return new ResponseEntity<>(customerFileRepo.save(updatedCustomerFile), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * {@code POST  /customer-files/{id}/messages} : Create a new message in the customer file corresponding to the Id given in parameters.
     *
     * @param paramMessage :  the message file to create.
     * @param customerFolderId : the id of the customer file
     * @return in the body the new message, with status {@code 201 (Created)}
     * or with status {@code 404 (Not Found)} if there is no customer file with this id
     */
    @PostMapping("/customer-files/{id}/messages")
    public ResponseEntity<Message> createMessageInACustomerFolder(@PathVariable("id") long customerFolderId,
                                                                  @RequestBody Message paramMessage){

        // Retrieve the customer file corresponding to the id in parameters
        Optional<CustomerFile> optionalCustomerFile = customerFileRepo.findById(customerFolderId);

        if(optionalCustomerFile.isPresent()){
            // Save the message in database
            Message savedMessage = messageRepo.save(new Message(
                    LocalDate.now() , paramMessage.getAuthorName(), paramMessage.getContent(), paramMessage.getChannel()
            ));

            // Add the new message in the customer file
            CustomerFile customerFile = optionalCustomerFile.get();
            customerFile.addMessage(savedMessage);
            customerFileRepo.save(customerFile);

            return new ResponseEntity<>(savedMessage, HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}