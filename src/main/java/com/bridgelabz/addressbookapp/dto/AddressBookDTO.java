package com.bridgelabz.addressbookapp.dto;

public class AddressBookDTO {
    public String name;
    public long phNumber;

    public AddressBookDTO(String name, long phNumber) {
        this.name = name;
        this.phNumber = phNumber;
    }

    @Override
    public String toString() {
        return "AddressBookDTO{" +
                "name='" + name + '\'' +
                ", phNumber=" + phNumber +
                '}';
    }
}