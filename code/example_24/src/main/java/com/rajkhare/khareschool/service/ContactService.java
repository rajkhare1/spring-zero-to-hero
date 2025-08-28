package com.rajkhare.khareschool.service;

import com.rajkhare.khareschool.models.Contact;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ContactService {

    public boolean saveMessageDetails(Contact contact) {
        boolean isSaved = true;
        //TODO - need to persist the data into DB table
        log.info(contact.toString());
        return isSaved;
    }

}
