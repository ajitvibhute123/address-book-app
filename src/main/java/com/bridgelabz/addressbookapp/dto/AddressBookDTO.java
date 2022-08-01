package com.bridgelabz.addressbookapp.dto;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
public @ToString class AddressBookDTO {
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Address-book name is Invalid")
    @NotEmpty(message = "Address-book name cannot be null")
    public String name;

    @Pattern(regexp = "^[91]+[ ]?[6-9]{1}[0-9]{9}$" ,message = "Phone number is invalid")
    @NotEmpty(message = "Phone number should not be empty")
    public String phoneNumber;

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Address is Invalid")
    @NotEmpty(message = "Address should not be empty")
    public String address;

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "City name is Invalid")
    @NotEmpty(message = "City name  cannot be null")
    public String city;

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "state name is Invalid")
    @NotEmpty(message = "State name  cannot be null")
    public String state;

    @Pattern(regexp = "^[1-9]{1}[0-9]{2}[ ]?[0-9]{3}$" ,message = "Zip name is invalid")
    @NotEmpty(message = "Zip code must not be null")
    public String zip;

    @Pattern(regexp = "^[a-z]+[a-z0-9+_.-]*[@][a-z0-9]+[.][a-z]{2,4}[.]*([a-z]{2,3})*$", message = "email is invalid")
    @NotEmpty(message = "email should not be empty")
    public String email;


}