package com.bridgelabz.addressbookapp.repository;

import com.bridgelabz.addressbookapp.model.AddressBookData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressBookRepository extends JpaRepository<AddressBookData,Integer> {
    @Query(value = "select * from contact_details order by city",nativeQuery = true)
    List<AddressBookData> sortByCity();

    @Query(value = "select * from contact_details where city = :city",nativeQuery = true)
    List<AddressBookData> findAllByCity(String city);

    @Query(value = "select * from contact_details order by state",nativeQuery = true)
    List<AddressBookData> sortByState();

    @Query(value = "select * from contact_details where state = :state",nativeQuery = true)
    List<AddressBookData> findAllByState(String state);

    @Query(value = "select * from contact_details order by zip",nativeQuery = true)
    List<AddressBookData> sortByZip();

    @Query(value = "select * from contact_details where zip = :zip",nativeQuery = true)
    List<AddressBookData> findAllByZip(String zip);

    @Query(value = "select * from contact_details order by name",nativeQuery = true)
    List<AddressBookData> sortByName();

}