package com.bridgelabz.addressbookapp.services;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBookData;

import java.util.List;

public interface IAddressBookService {
    List<AddressBookData> getAddressBookData();

    AddressBookData getAddressBookDataById(int personId);

    AddressBookData createAddressBookData(AddressBookDTO addressbookDTO);

    AddressBookData updateAddressBookData(int personId,AddressBookDTO addressbookDTO);

    void deleteAddressBookData(int personId);

    List<AddressBookData> sortAddressBookByCity();

    List<AddressBookData> getAddressBookByCity(String city);

    List<AddressBookData> sortAddressBookByState();

    List<AddressBookData> getAddressBookByState(String state);

    List<AddressBookData> sortAddressBookByZip();

    List<AddressBookData> getAddressBookByZip(String state);

    List<AddressBookData> sortAddressBookByName();
}