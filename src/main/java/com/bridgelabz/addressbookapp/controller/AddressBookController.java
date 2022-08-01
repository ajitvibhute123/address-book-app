package com.bridgelabz.addressbookapp.controller;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.dto.ResponseDTO;
import com.bridgelabz.addressbookapp.model.AddressBookData;
import com.bridgelabz.addressbookapp.services.IAddressBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/addressbookapp")
@Slf4j
public class AddressBookController {
    /* S2-UC-3-Ability for the Services Layer to store the AddressBook Data - Note that Services Layer is not storing, updating */
    @Autowired
    IAddressBookService addressbookService;

    @RequestMapping(value = {"", "/", "/get"})
    public ResponseEntity<ResponseDTO> getAddressBookData() {
        List<AddressBookData> addressbookDataList = null;
        addressbookDataList = addressbookService.getAddressBookData();
        ResponseDTO responseDTO = new ResponseDTO("Get call success",addressbookDataList);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @GetMapping("/get/{personId}")
    public ResponseEntity<ResponseDTO> getAddressBookData(@PathVariable(value = "personId") int personId) {
        AddressBookData addressbookData = null;
        addressbookData = addressbookService.getAddressBookDataById(personId);
        ResponseDTO responseDTO = new ResponseDTO("Get Call Success for id is successfully",addressbookData);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addAddressBookData(@Valid @RequestBody AddressBookDTO addressbookDTO) {
        AddressBookData addressbookData = null;
        addressbookData = addressbookService.createAddressBookData(addressbookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Created Address Book Data successfully ",addressbookData);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @PutMapping("/update/{personId}")
    public ResponseEntity<ResponseDTO> updateAddressBookData(@PathVariable int personId,@Valid @RequestBody AddressBookDTO addressbookDTO){
        AddressBookData addressbookData = null;
        addressbookData = addressbookService.updateAddressBookData(personId,addressbookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated Address Book data successfully ",addressbookData);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{personId}")
    public ResponseEntity<ResponseDTO> deleteAddressBookData(@PathVariable("personId") int personId) {
        addressbookService.deleteAddressBookData(personId);
        ResponseDTO responseDTO = new ResponseDTO("Deleted data successfully","person id: "+personId);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }
    @GetMapping("/sortByCity")
    public ResponseEntity<ResponseDTO> sortAddressBookByCity(){
        List<AddressBookData> addressbookDataList = null;
        addressbookDataList = addressbookService.sortAddressBookByCity();
        ResponseDTO responseDTO = new ResponseDTO("sort AddressBook By City Success",addressbookDataList);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @GetMapping("/getByCity/{city}")
    public ResponseEntity<ResponseDTO> getAddressBookByCity(@PathVariable String city){
        List<AddressBookData> addressbookDataList = null;
        addressbookDataList = addressbookService.getAddressBookByCity(city);
        ResponseDTO responseDTO = new ResponseDTO("Get AddressBook By City Success",addressbookDataList);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @GetMapping("/sortByState")
    public ResponseEntity<ResponseDTO> sortAddressBookByState(){
        List<AddressBookData> addressbookDataList = null;
        addressbookDataList = addressbookService.sortAddressBookByState();
        ResponseDTO responseDTO = new ResponseDTO("sort AddressBook By State Success",addressbookDataList);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @GetMapping("/getByState/{state}")
    public ResponseEntity<ResponseDTO> getAddressBookByState(@PathVariable String state){
        List<AddressBookData> addressbookDataList = null;
        addressbookDataList = addressbookService.getAddressBookByState(state);
        ResponseDTO responseDTO = new ResponseDTO("Get AddressBook By State Success",addressbookDataList);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @GetMapping("/sortByZip")
    public ResponseEntity<ResponseDTO> sortAddressBookByZip(){
        List<AddressBookData> addressbookDataList = null;
        addressbookDataList = addressbookService.sortAddressBookByZip();
        ResponseDTO responseDTO = new ResponseDTO("sort AddressBook By Zip Success",addressbookDataList);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @GetMapping("/getByZip/{zip}")
    public ResponseEntity<ResponseDTO> getAddressBookByZip(@PathVariable String zip){
        List<AddressBookData> addressbookDataList = null;
        addressbookDataList = addressbookService.getAddressBookByZip(zip);
        ResponseDTO responseDTO = new ResponseDTO("Get AddressBook By Zip Success",addressbookDataList);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @GetMapping("/sortByName")
    public ResponseEntity<ResponseDTO> sortAddressBookByName(){
        List<AddressBookData> addressbookDataList = null;
        addressbookDataList = addressbookService.sortAddressBookByName();
        ResponseDTO responseDTO = new ResponseDTO("sort AddressBook By Name Success",addressbookDataList);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }
}