package com.example.Cursos.universidad.CursosService;


import com.example.Cursos.universidad.Models.Registration;
import com.example.Cursos.universidad.Models.Teacher;
import com.example.Cursos.universidad.Repo.RegistrationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistrationService {

    private RegistrationRepo registrationRepo;

    @Autowired
    public RegistrationService(RegistrationRepo registrationRepo) {
        this.registrationRepo = registrationRepo;
    }

    public void createRegistration(Registration registration){
        this.registrationRepo.save(registration);
    }

    public Registration getRegistration(Long id){
        Optional<Registration> registrationOptional = this.registrationRepo.findById(id);
        if(registrationOptional.isPresent()){
            return registrationOptional.get();
        }
        return new Registration();
    }

    public List<Registration> getAllRegistration(){
        return this.registrationRepo.findAll();
    }


    public Registration updateRegistration(Long id, Registration registration){
        Optional<Registration> registrationOptional = this.registrationRepo.findById(id);
        if(registrationOptional.isPresent()){
            Registration registrationToUpdate = registrationOptional.get();
            if(registration.getRegisterDate() != null){
                registrationToUpdate.setRegisterDate(registration.getRegisterDate());
            }
        }
    }
}
