package com.WorkersDataBase.data.contract.contact;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    boolean existsByEmail(String email);
}
