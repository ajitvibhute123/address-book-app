package com.bridgelabz.addressbookapp.services;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.exceptions.AddressBookException;
import com.bridgelabz.addressbookapp.model.AddressBookData;
import com.bridgelabz.addressbookapp.repository.AddressBookRepository;
import lombok.extern.slf4j.Slf4j;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class AddressBookService implements IAddressBookService {
	
	@Autowired
    private ModelMapper modelMapper;

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
   public AddressBookData createAddressBookData(AddressBookDTO addressbookDTO){
     
    	AddressBookData addressBookData = modelMapper.map(addressbookDTO, AddressBookData.class);
        log.debug("AddressBookData: "+addressBookData.toString());
        return addressbookRepository.save(addressBookData);
    }

    @Override
    public AddressBookData updateAddressBookData(int personId, AddressBookDTO addressbookDTO) {
        AddressBookData addressbookData = this.getAddressBookDataById(personId);
        //addressbookData.updateAddressBookdata(addressbookDTO);
        modelMapper.map(addressbookDTO, addressbookData);
        return addressbookRepository.save(addressbookData);
    }

    @Override
    public void deleteAddressBookData(int personId) {
        AddressBookData addressbookData = this.getAddressBookDataById(personId);
        addressbookRepository.delete(addressbookData);
    }
    @Override
    public List<AddressBookData> sortAddressBookByCity() {
        return addressbookRepository.sortByCity();
    }

    @Override
    public List<AddressBookData> getAddressBookByCity(String city) {
        return addressbookRepository.findAllByCity(city);
    }

    @Override
    public List<AddressBookData> sortAddressBookByState() {
        return addressbookRepository.sortByState();
    }

    @Override
    public List<AddressBookData> getAddressBookByState(String state) {
        return addressbookRepository.findAllByState(state);
    }

    @Override
    public List<AddressBookData> sortAddressBookByZip() {
        return addressbookRepository.sortByZip();
    }

    @Override
    public List<AddressBookData> getAddressBookByZip(String zip) {
        return addressbookRepository.findAllByZip(zip);
    }

    @Override
    public List<AddressBookData> sortAddressBookByName() {
        return addressbookRepository.sortByName();
    }

}