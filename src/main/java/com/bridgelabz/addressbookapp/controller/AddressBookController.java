package com.bridgelabz.addressbookapp.controller;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.dto.ResponseDTO;
import com.bridgelabz.addressbookapp.model.AddressBookData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddressBookController {
    /* S2-UC-1-Introducing DTO and Model to AddressBook App */

    @RequestMapping(value = {"", "/", "/get"})
    public ResponseEntity<ResponseDTO> getAddressBookData() {
        AddressBookData addressbookData = null;
        addressbookData = new AddressBookData(1, new AddressBookDTO("Krunali", "9561272972"));
        ResponseDTO responseDTO = new ResponseDTO("Get call success", addressbookData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/get/{personId}")
    public ResponseEntity<ResponseDTO> getAddressBookData(@PathVariable(value = "personId") int personId) {
        AddressBookData addressbookData = null;
        addressbookData = new AddressBookData(personId, new AddressBookDTO("Krunali", "9561272972"));
        ResponseDTO responseDTO = new ResponseDTO("Get Call Success for id: ", addressbookData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addAddressBookData(@RequestBody AddressBookDTO addressbookDTO) {
        AddressBookData addressbookData = null;
        addressbookData = new AddressBookData(1, addressbookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Created Employee Payroll Data for: ", addressbookData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{personId}")
    public ResponseEntity<ResponseDTO> updateAddressBookData(@PathVariable int personId, @RequestBody AddressBookDTO addressbookDTO) {
        AddressBookData addressbookData = null;
        addressbookData = new AddressBookData(personId, addressbookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated Employee Payroll Data for: ", addressbookData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{personId}")
    public ResponseEntity<ResponseDTO> deleteAddressBookData(@PathVariable("personId") int personId) {
        ResponseDTO responseDTO = new ResponseDTO("Deleted data successfully", "person id: " + personId);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}