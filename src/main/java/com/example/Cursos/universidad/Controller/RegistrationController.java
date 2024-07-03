package com.example.Cursos.universidad.Controller;

import com.example.Cursos.universidad.Models.Registration;
import com.example.Cursos.universidad.Service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/registration")
public class RegistrationController {

    private RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping()
    public ResponseEntity<String> createRegistration(@RequestBody Registration registration){
        try{
            this.registrationService.createRegistration(registration);
            return ResponseEntity.ok("Se creó el registro del curso");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Error: no se pudo crear " + e.getMessage());
        }
    }

    @GetMapping("/{id_registration}")
    public Registration getRegistration(@PathVariable("id_registration") Long id){
        return this.registrationService.getRegistration(id);
    }

    @GetMapping("registrations")
    public List<Registration> getAllRegistrations(){
        return this.registrationService.getAllRegistration();
    }

    @PutMapping("/{id_registration}")
    public Registration updateRegistration(@PathVariable("id_registration") Long id, @RequestBody Registration registration){
        return this.registrationService.updateRegistration(id, registration);
    }

}
