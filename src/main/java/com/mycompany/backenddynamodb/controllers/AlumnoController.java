package com.mycompany.backenddynamodb.controllers;


import com.mycompany.backenddynamodb.entity.alumno;
import com.mycompany.backenddynamodb.repository.alumnoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alumnos")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class AlumnoController {
    @Autowired
    private alumnoRepository personRepository;

    @PostMapping
    public alumno save(@RequestBody alumno person){
        return personRepository.save(person);
    }

    @GetMapping("/{id}")
    public alumno findById(@PathVariable(value = "id") String id){
        return personRepository.findById(id);
    }

    @GetMapping
    public List<alumno> findAll(){
        return personRepository.findAll();
    }

    @PutMapping("/{id}")
    public String update(@PathVariable(value = "id") String id,
    @RequestBody alumno person){
        return personRepository.update(id, person);
    }


    @DeleteMapping("/{id}")
    public String delete(@PathVariable(value = "id") String id){
        return personRepository.delete(id);
    }
    
}
