package com.WorkersDataBase.service.getService;

import com.WorkersDataBase.data.contact.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactGetService {
    private final ContactRepository repository;

}
