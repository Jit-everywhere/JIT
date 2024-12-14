package com.justintime.jit.service;

import com.justintime.jit.entity.Address;

import java.util.List;
import java.util.Optional;

public interface AddressService {

    List<Address> getAllAddresses();
    Optional<Address> getAddressById(Long id);
    Address updateAddress(Long id, Address addressDetails);
    Address saveAddress(Address address);
    void deleteAddress(Long id);
}
