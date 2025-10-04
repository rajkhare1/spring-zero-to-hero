package com.rajkhare.khareschool.repository;

import com.rajkhare.khareschool.model.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
@Repository stereotype annotations is used to add a bean of this class
type to Spring context and indicate that given bean is used to perform
DB related operations.
* */
@Repository
public interface ContactRepository extends CrudRepository<Contact, Integer> {

    List<Contact> findByStatus(String status);

}
