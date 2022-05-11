package com.bridgelabz.addressbookapp.repository;

import com.bridgelabz.addressbookapp.model.AddressbookData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressbookRepository extends JpaRepository<AddressbookData,Integer> {

}
