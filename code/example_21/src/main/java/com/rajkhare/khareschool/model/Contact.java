package com.rajkhare.khareschool.model;

import lombok.Data;
/*
 @Data annotation is provided by Lombok library which generates:
 getter, setter, equals(), toString() methods & Constructor at compile time.
 This makes our code short and clean
* */
@Data
public class Contact {

    private String name;
    private String mobileNum;
    private String email;
    private String subject;
    private String message;

}
