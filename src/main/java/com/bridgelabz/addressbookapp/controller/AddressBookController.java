package com.bridgelabz.addressbookapp.controller;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddressBookController {
    /* UC- 2-Created a Rest Controller to demonstrate the various HTTP Methods */

    @RequestMapping(value = {"", "/", "/get"})
    public ResponseEntity<String> getAddressBookData() {
        return new ResponseEntity<String>("Get Call Success", HttpStatus.OK);
    }

    @GetMapping("/get/{empId}")
    public ResponseEntity<String> getAddressBookData(@PathVariable("empId") int empId) {
        return new ResponseEntity<String>("Get Call Success for id: " + empId, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> addAddressBookData(
            @RequestBody AddressBookDTO addressBookDTO) {
        return new ResponseEntity<String>("Created Address Book Data for: "+ addressBookDTO, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateAddressBookData(@RequestBody AddressBookDTO addressBookDTO){
        return new ResponseEntity<String>("Updated Address Book Data for: "+ addressBookDTO, HttpStatus. OK);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<String> deleteAddressBookData(@PathVariable("empId") int empId){
        return new ResponseEntity<String>("Delete Call Success for id: "+empId, HttpStatus. OK);
    }

}