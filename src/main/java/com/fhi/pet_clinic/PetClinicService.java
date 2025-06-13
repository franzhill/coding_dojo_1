package com.fhi.pet_clinic;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class PetClinicService 
{
    private final PetClinicRepository clinicRepository;

    public PetClinicService(PetClinicRepository clinicRepository) {
        this.clinicRepository = clinicRepository;
    }

    @Transactional
    public void createClinic() 
    {
        PetClinic petClinic = new PetClinic();
        petClinic.setName("Happy Paws PetClinic");

        Customer customer1 = new Customer();
        customer1.setName("Alice");

        Pet pet1 = new Pet();
        pet1.setName("Fluffy");

        customer1.setPets(List.of(pet1));

        petClinic.setCustomers(List.of(customer1));

        // TODO : Relationships are not properly set yet
        //         You must set the bidirectional links and fix cascading

        clinicRepository.save(petClinic);
    }
}
