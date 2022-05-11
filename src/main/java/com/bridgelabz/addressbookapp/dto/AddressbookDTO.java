package com.bridgelabz.addressbookapp.dto;

import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;


public  @ToString class AddressbookDTO {

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Addressbook name is Invalid")
    @NotEmpty(message = "Addressbook name cannot be null")
    public String name;

    @Pattern(regexp = "^[91]+[ ]?[6-9]{1}[0-9]{9}$" ,message = "phonenumber is invalid")
    public String phoneNumber;

    public String address;

    public String city;

    public String state;

    public String zip;

    public String email;

}
