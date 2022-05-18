package com.bridgelabz.addressbookapp.repository;

import com.bridgelabz.addressbookapp.model.AddressbookData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressbookRepository extends JpaRepository<AddressbookData,Integer> {

    @Query(value = "select * from contact_details where city = :city",nativeQuery = true)
    List<AddressbookData> getByCity(String city);

    @Query(value = "select * from contact_details where state = :state",nativeQuery = true)
    List<AddressbookData> getByState(String state);

    @Query(value = "select * from contact_details where zip = :zip",nativeQuery = true)
    List<AddressbookData> getByZip(String zip);

    @Query(value = "select * from contact_details where name = :name",nativeQuery = true)
    List<AddressbookData> getByName(String name);

    @Query(value = "select * from contact_details order by city",nativeQuery = true)
    List<AddressbookData> sortByCity();

    @Query(value = "select * from contact_details order by state",nativeQuery = true)
    List<AddressbookData> sortByState();

    @Query(value = "select * from contact_details order by zip",nativeQuery = true)
    List<AddressbookData> sortByZip();

    @Query(value = "select * from contact_details order by name",nativeQuery = true)
    List<AddressbookData> sortByName();

}
