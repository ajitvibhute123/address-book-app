package com.bridgelabz.addressbookapp.services;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.exceptions.AddressBookException;
import com.bridgelabz.addressbookapp.model.AddressBookData;
import com.bridgelabz.addressbookapp.repository.AddressBookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class AddressBookService implements IAddressBookService {

    @Autowired
    private AddressBookRepository addressbookRepository;

    List<AddressBookData> addressbookDataList = new ArrayList<>();

    @Override
    public List<AddressBookData> getAddressBookData() {
        return addressbookRepository.findAll();
    }

    @Override
    public AddressBookData getAddressBookDataById(int personId) {
        return addressbookRepository.findById(personId)
                .orElseThrow(()->new AddressBookException("Person Not found"));
    }

    @Override
    public AddressBookData createAddressBookData(AddressBookDTO addressbookDTO) {
        AddressBookData addressbookData = null;
        addressbookData = new AddressBookData (addressbookDTO);
        log.debug("AddressBookData: "+addressbookData.toString());
        return addressbookRepository.save(addressbookData);
    }

    @Override
    public AddressBookData updateAddressBookData(int personId, AddressBookDTO addressbookDTO) {
        AddressBookData addressbookData = this.getAddressBookDataById(personId);
        addressbookData.updateAddressBookdata(addressbookDTO);
        return addressbookRepository.save(addressbookData);
    }

    @Override
    public void deleteAddressBookData(int personId) {
        AddressBookData addressbookData = this.getAddressBookDataById(personId);
        addressbookRepository.delete(addressbookData);
    }
}