package com.osho.carrental.service.repository;

import com.osho.carrental.model.Customer;

import java.util.List;

public interface CustomerServiceRepository {

    //---- PROJECT REQUIREMENTS ----//
    List<Customer> getAllCustomers();


    //-- NOT PROJECT REQUIREMENTS --//
    int getCustomerIdByEmail(String Email); // Added 221226
    Customer addCustomer(Customer customer);
    void deleteCustomer(Customer customer);
}
