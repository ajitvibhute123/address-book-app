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
        return addressbookDataList;
    }

    @Override
    public AddressBookData getAddressBookDataById(int personId) {
        return addressbookDataList.stream()
                .filter(addressbookData -> addressbookData.getPersonId()==personId)
                .findFirst()
                .orElseThrow(()->new AddressBookException("Person Not found"));
    }

    @Override
    public AddressBookData createAddressBookData(AddressBookDTO addressbookDTO) {
        AddressBookData addressbookData = null;
        addressbookData = new AddressBookData(addressbookDataList.size() + 1, addressbookDTO);
        log.debug("AddressBookData: "+addressbookData.toString());
        addressbookDataList.add(addressbookData);
        return addressbookRepository.save(addressbookData);
    }

    @Override
    public AddressBookData updateAddressBookData(int personId, AddressBookDTO addressbookDTO) {
        AddressBookData addressbookData = this.getAddressBookDataById(personId);
        addressbookData.updateAddressBookdata(addressbookDTO);
        addressbookDataList.set(personId - 1, addressbookData);
        return addressbookData;
    }

    @Override
    public void deleteAddressBookData(int personId) {
        addressbookDataList.remove(personId - 1);
        }
}