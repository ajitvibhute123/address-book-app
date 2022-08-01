package com.bridgelabz.addressbookapp.model;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name ="contact_details")
public @Data class AddressBookData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "person_Id")
    private int personId;
    private String name;
    private String phoneNumber;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String email;

    public AddressBookData(int personId, AddressBookDTO addressbookDTO) {
        this.personId = personId;
        this.updateAddressBookdata(addressbookDTO);

    }
    public void updateAddressBookdata(AddressBookDTO addressbookDTO) {
        this.name = addressbookDTO.name;
        this.phoneNumber = addressbookDTO.phoneNumber;
        this.address = addressbookDTO.address;
        this.city = addressbookDTO.city;
        this.state = addressbookDTO.state;
        this.zip = addressbookDTO.zip;
        this.email = addressbookDTO.email;
    }
}