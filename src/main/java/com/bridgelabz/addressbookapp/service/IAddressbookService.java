package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressbookDTO;
import com.bridgelabz.addressbookapp.model.AddressbookData;

import java.util.List;

public interface IAddressbookService {

    List<AddressbookData> getAddressbookData();

    AddressbookData getAddressbookDataById(int personId);

    AddressbookData createAddressbookData(AddressbookDTO addressbookDTO);

    AddressbookData updateAddressbookData(int personId,AddressbookDTO addressbookDTO);

    void deleteAddressbookData(int personId);

    List<AddressbookData> getAddressbookByCity(String city);

    List<AddressbookData> getAddressBookByState(String state);

    List<AddressbookData> getAddressBookByZip(String zip);

    List<AddressbookData> getAddressBookByName(String name);

    List<AddressbookData> sortAddressBookByCity();

    List<AddressbookData> sortAddressBookByState();

    List<AddressbookData> sortAddressBookByZip();

    List<AddressbookData> sortAddressBookByName();
}
