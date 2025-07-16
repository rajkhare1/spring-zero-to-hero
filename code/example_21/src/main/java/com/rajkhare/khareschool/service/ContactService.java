package com.rajkhare.khareschool.service;

import com.rajkhare.khareschool.model.Contact;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    private static Logger log = LoggerFactory.getLogger(ContactService.class);

    public boolean saveMessageDetails(Contact contact) {
        boolean isSaved = true;
        //TODO - need to persist the data into DB table
        log.info(contact.toString());
        return isSaved;
    }

}
