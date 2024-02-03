package com.WorkersDataBase.service.tools.workerValidTool;

import com.WorkersDataBase.data.contact.Contact;
import com.WorkersDataBase.data.worker.Worker;

public class GetWorkers {
    public static Worker getValidWorker(){
        Worker worker = new Worker();
        worker.setFirstName("Daniel");
        worker.setLastName("Winiarczyk");
        worker.setPersonalNumber("77082383532");

        Contact contact = new Contact("dw@gmail.com");
        contact.setWorker(worker);
        worker.setContact(contact);

        return worker;
    }
}
