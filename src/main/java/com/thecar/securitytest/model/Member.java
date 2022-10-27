package com.thecar.securitytest.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "seq", nullable = false)
    private Long seq;

    private String username;
    private String password;
    private String name;
    private String gender;
    private String age;
    private String email;
    private String phoneNumber;


}
