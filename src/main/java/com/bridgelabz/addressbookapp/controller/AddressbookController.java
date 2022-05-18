package com.bridgelabz.addressbookapp.controller;

import com.bridgelabz.addressbookapp.dto.AddressbookDTO;
import com.bridgelabz.addressbookapp.dto.ResponseDTO;
import com.bridgelabz.addressbookapp.model.AddressbookData;
import com.bridgelabz.addressbookapp.service.IAddressbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/addressbook")
public class AddressbookController {

    @Autowired
    private IAddressbookService addressbookService;

    @RequestMapping(value = {"", "/", "/getall"})
    public ResponseEntity<ResponseDTO> getAddressbookData() {
        List<AddressbookData> addressbookDataList = null;
        addressbookDataList = addressbookService.getAddressbookData();
        ResponseDTO respDTO = new ResponseDTO("Get Call Successful", addressbookDataList);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @GetMapping("/get_by_id/{personId}")
    public ResponseEntity<ResponseDTO> getAddressbookData(@PathVariable(value = "personId") int personId) {
        AddressbookData addressbookData = null;
        addressbookData = addressbookService.getAddressbookDataById(personId);
        ResponseDTO responseDTO = new ResponseDTO("Get Call Success for id: " +personId ,addressbookData);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addAddressbookData(@Valid @RequestBody AddressbookDTO addressbookDTO) {
        AddressbookData addressbookData = null;
        addressbookData = addressbookService.createAddressbookData(addressbookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Created Addressbook Data for: ",addressbookData);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @PutMapping("/update/{personId}")
    public ResponseEntity<ResponseDTO> updateAddressbookData(@PathVariable int personId, @Valid @RequestBody AddressbookDTO addressbookDTO){
        AddressbookData addressbookData = null;
        addressbookData = addressbookService.updateAddressbookData(personId, addressbookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated Addressbook Data for: ",addressbookData);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @DeleteMapping("/delete_by_id/{personId}")
    public ResponseEntity<ResponseDTO> deleteAddressbookData(@PathVariable("personId") int personId) {
        addressbookService.deleteAddressbookData(personId);
        ResponseDTO responseDTO = new ResponseDTO("Deleted successfully","Deleted id: "+personId);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @GetMapping("/get_by_city/{city}")
    public ResponseEntity<ResponseDTO> getAddressbookByCity(@PathVariable String city) {
        List <AddressbookData> addressbookDataList = null;
        addressbookDataList = addressbookService.getAddressbookByCity(city);
        ResponseDTO responseDTO = new ResponseDTO("Get addressbook by city " ,addressbookDataList);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @GetMapping("/get_by_state/{state}")
    public ResponseEntity<ResponseDTO> getAddressBookByState(@PathVariable String state){
        List<AddressbookData> addressbookDataList = null;
        addressbookDataList = addressbookService.getAddressBookByState(state);
        ResponseDTO responseDTO = new ResponseDTO("Get AddressBook By State ",addressbookDataList);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @GetMapping("/get_by_zip/{zip}")
    public ResponseEntity<ResponseDTO> getAddressBookByZip(@PathVariable String zip){
        List<AddressbookData> addressbookDataList = null;
        addressbookDataList = addressbookService.getAddressBookByZip(zip);
        ResponseDTO responseDTO = new ResponseDTO("Get AddressBook By Zip ",addressbookDataList);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }
    @GetMapping("/get_by_name/{name}")
    public ResponseEntity<ResponseDTO> getAddressBookByName(@PathVariable String name){
        List<AddressbookData> addressbookDataList = null;
        addressbookDataList = addressbookService.getAddressBookByName(name);
        ResponseDTO responseDTO = new ResponseDTO("Get AddressBook By Name ",addressbookDataList);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @GetMapping("/sort_by_city")
    public ResponseEntity<ResponseDTO> sortAddressBookByCity(){
        List<AddressbookData> addressbookDataList = null;
        addressbookDataList = addressbookService.sortAddressBookByCity();
        ResponseDTO responseDTO = new ResponseDTO("sort AddressBook By City ",addressbookDataList);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @GetMapping("/sort_by_state")
    public ResponseEntity<ResponseDTO> sortAddressBookByState(){
        List<AddressbookData> addressbookDataList = null;
        addressbookDataList = addressbookService.sortAddressBookByState();
        ResponseDTO responseDTO = new ResponseDTO("sort AddressBook By State ",addressbookDataList);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @GetMapping("/sort_by_zip")
    public ResponseEntity<ResponseDTO> sortAddressBookByZip(){
        List<AddressbookData> addressbookDataList = null;
        addressbookDataList = addressbookService.sortAddressBookByZip();
        ResponseDTO responseDTO = new ResponseDTO("sort AddressBook By Zip ",addressbookDataList);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @GetMapping("/sort_by_name")
    public ResponseEntity<ResponseDTO> sortAddressBookByName(){
        List<AddressbookData> addressbookDataList = null;
        addressbookDataList = addressbookService.sortAddressBookByName();
        ResponseDTO responseDTO = new ResponseDTO("sort AddressBook By Name ",addressbookDataList);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

}
