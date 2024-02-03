package com.WorkersDataBase.service.contact;

import com.WorkersDataBase.data.contact.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactGetService {
    private final ContactRepository repository;

}
