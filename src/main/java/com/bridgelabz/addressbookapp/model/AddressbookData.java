package com.bridgelabz.addressbookapp.model;

import com.bridgelabz.addressbookapp.dto.AddressbookDTO;
import lombok.Data;

public  @Data class AddressbookData {

    private int personId;
    private String name;
    private String phoneNumber;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String email;

    public AddressbookData(int personId, AddressbookDTO addressbookDTO) {
        this.personId = personId;
        this.updateAddressBookdata(addressbookDTO);

    }
    public void updateAddressBookdata(AddressbookDTO addressbookDTO) {
        this.name = addressbookDTO.name;
        this.address = addressbookDTO.address;
        this.city = addressbookDTO.city;
        this.state = addressbookDTO.state;
        this.zip = addressbookDTO.zip;
        this.phoneNumber = addressbookDTO.phoneNumber;
        this.email = addressbookDTO.email;
    }
}
