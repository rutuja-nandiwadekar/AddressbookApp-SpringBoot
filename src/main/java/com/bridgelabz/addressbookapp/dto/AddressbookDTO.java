package com.bridgelabz.addressbookapp.dto;

public class AddressbookDTO {
    public String name;
    public String phoneNumber;

    public AddressbookDTO(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "AddressbookDTO{" +
                "name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
