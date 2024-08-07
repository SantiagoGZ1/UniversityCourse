package com.example.Cursos.universidad.Service;


import com.example.Cursos.universidad.Exceptions.GeneralException;
import com.example.Cursos.universidad.Models.Courses;
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
    private Courses courses;

    @Autowired
    public RegistrationService(RegistrationRepo registrationRepo) {
        this.registrationRepo = registrationRepo;
    }

    public void createRegistration(Registration registration){
        if(courses.getId() == registration.getCourses().getId()){
            if (courses.getCupos() > 0){
                courses.descontador();
                this.registrationRepo.save(registration);
            }else {
                throw new GeneralException("Max student reached");
            }
        }else{
            throw new GeneralException("Course is not exist");
        }

    }


    public Registration getRegistration(Long id){
        Optional<Registration> registrationOptional = this.registrationRepo.findById(id);
        return registrationOptional.orElseGet(Registration::new);
    }

    public List<Registration> getAllRegistration(){
        return this.registrationRepo.findAll();
    }


    public Registration updateRegistration(Long id, Registration registration) {
        Optional<Registration> registrationOptional = this.registrationRepo.findById(id);
        if(registrationOptional.isPresent()){
            Registration registrationToUpdate = registrationOptional.get();
            if(registration.getRegisterDate() != null){
                registrationToUpdate.setRegisterDate(registration.getRegisterDate());
            }
            if(registrationToUpdate.getCourses() == null){
                registrationToUpdate.setCourses(registration.getCourses());
            } else {
                registrationToUpdate.setCourses(registrationToUpdate.getCourses());
            }
            if(registrationToUpdate.getUnregisterDate() == null){
                registrationToUpdate.setUnregisterDate(registration.getUnregisterDate());
            } 
            if(registration.getStudents() != null){
                Optional<Student> studentFind = this.studentsRepo.findById(registration.getStudents().getId());
                if(studentFind.isPresent()){
                registrationToUpdate.setStudent(registration.getStudents());
                }else {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found");
                }
            }
            return registrationRepo.save(registrationToUpdate);
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Registration not found");
        }
    }
}
