package com.rajkhare.khareschool.service;

import com.rajkhare.khareschool.constants.EazySchoolConstants;
import com.rajkhare.khareschool.model.Person;
import com.rajkhare.khareschool.model.Roles;
import com.rajkhare.khareschool.repository.PersonRepository;
import com.rajkhare.khareschool.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private RolesRepository rolesRepository;

    public boolean createNewPerson(Person person){
        boolean isSaved = false;
        Roles role = rolesRepository.getByRoleName(EazySchoolConstants.STUDENT_ROLE);
        person.setRoles(role);
        person = personRepository.save(person);
        if (null != person && person.getPersonId() > 0)
        {
            isSaved = true;
        }
        return isSaved;
    }
}