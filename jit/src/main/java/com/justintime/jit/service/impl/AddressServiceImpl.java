package com.justintime.jit.service.impl;

import com.justintime.jit.entity.Address;
import com.justintime.jit.repository.AddressRepository;
import com.justintime.jit.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

        @Autowired
        private AddressRepository addressRepository;

        public List<Address> getAllAddresses() {
            return addressRepository.findAll();
        }

        public Optional<Address> getAddressById(Long id) {
            return addressRepository.findById(id);
        }

        public Address saveAddress(Address address) {
            return addressRepository.save(address);
        }

        public Address updateAddress(Long id, Address addressDetails) {
            return addressRepository.findById(id).map(address -> {
                address.setAddressLine1(addressDetails.getAddressLine1());
                address.setAddressLine2(addressDetails.getAddressLine2());
                address.setCity(addressDetails.getCity());
                address.setState(addressDetails.getState());
                address.setCountry(addressDetails.getCountry());
                address.setLatitude(addressDetails.getLatitude());
                address.setLongitude(addressDetails.getLongitude());
                address.setUpdatedDttm(addressDetails.getUpdatedDttm());
                address.setRestaurant(addressDetails.getRestaurant());
                return addressRepository.save(address);
            }).orElseThrow(() -> new RuntimeException("Address not found with id: " + id));
        }

        public void deleteAddress(Long id) {
            addressRepository.deleteById(id);
        }
    }


