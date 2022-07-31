package com.bridgelabz.addressbookapp.services;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBookData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookService implements IAddressBookService {
    @Override
    public List<AddressBookData> getAddressBookData() {
        List<AddressBookData> addressbookDataList = new ArrayList<>();
        addressbookDataList.add(new AddressBookData(1, new AddressBookDTO("Krunali", "9561272972")));
        return addressbookDataList;
    }

    @Override
    public AddressBookData getAddressBookDataById(int personId) {
        AddressBookData addressbookData = null;
        addressbookData = new AddressBookData(personId, new AddressBookDTO("Rohit", "9422101501"));
        return addressbookData;
    }

    @Override
    public AddressBookData createAddressBookData(AddressBookDTO addressbookDTO) {
        AddressBookData addressbookData = null;
        addressbookData = new AddressBookData(1, addressbookDTO);
        return addressbookData;
    }

    @Override
    public AddressBookData updateAddressBookData(int personId, AddressBookDTO addressbookDTO) {
        AddressBookData addressbookData = null;
        addressbookData = new AddressBookData(personId, addressbookDTO);
        return addressbookData;
    }

    @Override
    public void deleteAddressBookData(int personId) {

    }
}