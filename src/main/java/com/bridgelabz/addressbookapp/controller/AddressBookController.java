package com.bridgelabz.addressbookapp.controller;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.dto.ResponseDTO;
import com.bridgelabz.addressbookapp.model.AddressBookData;
import com.bridgelabz.addressbookapp.services.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/addressbookapp")
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
}