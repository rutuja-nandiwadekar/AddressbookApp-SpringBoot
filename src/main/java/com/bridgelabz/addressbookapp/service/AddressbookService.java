package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressbookDTO;
import com.bridgelabz.addressbookapp.exception.AddressbookException;
import com.bridgelabz.addressbookapp.model.AddressbookData;
import com.bridgelabz.addressbookapp.repository.AddressbookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
public class AddressbookService implements IAddressbookService {

    @Autowired
    private AddressbookRepository addressbookRepository;

    /*
     * @Purpose : This method is used to get all Addressbook data
     */
    @Override
    public List<AddressbookData> getAddressbookData() {

        return addressbookRepository.findAll();
    }

    /*
     * @Purpose : This method is used to get Addressbook data by Id
     * @Param : personId
     */
    @Override
    public AddressbookData getAddressbookDataById(int personId) {
        return addressbookRepository
                .findById(personId)
                .orElseThrow(()->new AddressbookException("Person with perssonId "+personId+" doesnot exists"));
    }

    /*
     * @Purpose : This method is used to create new Addressbook data
     * @Param : addressbookDTO
     */
    @Override
    public AddressbookData createAddressbookData(AddressbookDTO addressbookDTO) {
        AddressbookData addressbookData = null;
        addressbookData = new AddressbookData(addressbookDTO);
        log.debug("AddressbookData: "+addressbookData.toString());
        return addressbookRepository.save(addressbookData);
    }

    /*
     * @Purpose : This method is used to update Addressbook data
     * @Param : personId, addressbookDTO
     */
    @Override
    public AddressbookData updateAddressbookData(int personId, AddressbookDTO addressbookDTO) {
        AddressbookData addressbookData = this.getAddressbookDataById(personId);
        addressbookData.updateAddressBookdata(addressbookDTO);
        return addressbookRepository.save(addressbookData);
    }

    /*
     * @Purpose : This method is used to delete Addressbook data
     * @Param : personId
     */
    @Override
    public void deleteAddressbookData(int personId) {
        AddressbookData addressbookData = this.getAddressbookDataById(personId);
        addressbookRepository.delete(addressbookData);
    }

    /*
     * @Purpose : This method is used to get Addressbook data by city name
     * @Param : city
     */
    @Override
    public List<AddressbookData> getAddressbookByCity(String city) {
        return addressbookRepository.getByCity(city);
    }

    /*
     * @Purpose : This method is used to get Addressbook data by state name
     * @Param : state
     */
    @Override
    public List<AddressbookData> getAddressBookByState(String state) {
        return addressbookRepository.getByState(state);
    }

    /*
     * @Purpose : This method is used to get Addressbook data by zip
     * @Param : zip
     */
    @Override
    public List<AddressbookData> getAddressBookByZip(String zip) {
        return addressbookRepository.getByZip(zip);
    }

    /*
     * @Purpose : This method is used to get Addressbook data by name
     * @Param : name
     */
    @Override
    public List<AddressbookData> getAddressBookByName(String name) {
        return addressbookRepository.getByName(name);
    }

    /*
     * @Purpose : This method is used to sort Addressbook data by city
     */
    @Override
    public List<AddressbookData> sortAddressBookByCity() {
        return addressbookRepository.sortByCity();
    }

    /*
     * @Purpose : This method is used to sort Addressbook data by state
     */
    @Override
    public List<AddressbookData> sortAddressBookByState() {
        return addressbookRepository.sortByState();
    }

    /*
     * @Purpose : This method is used to sort Addressbook data by zip
     */
    @Override
    public List<AddressbookData> sortAddressBookByZip() {
        return addressbookRepository.sortByZip();
    }

    /*
     * @Purpose : This method is used to sort Addressbook data by name
     */
    @Override
    public List<AddressbookData> sortAddressBookByName() {
        return addressbookRepository.sortByName();
    }

}