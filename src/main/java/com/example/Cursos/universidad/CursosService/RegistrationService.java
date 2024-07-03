package com.example.Cursos.universidad.CursosService;


import com.example.Cursos.universidad.Models.Registration;
import com.example.Cursos.universidad.Models.Student;
import com.example.Cursos.universidad.Repo.RegistrationRepo;
import com.example.Cursos.universidad.Repo.StudentsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class RegistrationService {

    private StudentsRepo studentsRepo;
    private RegistrationRepo registrationRepo;

    private int contRegistration = 0;

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


    public Registration updateRegistration(Long id, Registration registration) throws Exception {
        Optional<Registration> registrationOptional = this.registrationRepo.findById(id);
        if(registrationOptional.isPresent()){
            Registration registrationToUpdate = registrationOptional.get();
            if(registration.getRegisterDate() != null){
                registrationToUpdate.setRegisterDate(registration.getRegisterDate());
            }
            if(registration.getUnregisterDate() != null && contRegistration < 1){
                contRegistration++;
                registrationToUpdate.setUnregisterDate(registration.getUnregisterDate());
            } else {
                throw new Exception("cannot update");
            }
            if(registration.getStudents() != null){
                Optional<Student> studentFind = this.studentsRepo.findById(registration.getStudents().getId());
                if(studentFind.isPresent()){
                registrationToUpdate.setStudent(registration.getStudents());
                }else {
                    throw new Exception("Student not found");
                }
            }
            return registrationRepo.save(registrationToUpdate);
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Registration not found");
        }
    }
}