package com.zendron.demo.controller;

import com.zendron.demo.model.People;
import com.zendron.demo.repository.PeopleRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/people"})
public class PeopleController {

    private PeopleRepository peopleRepository;

    PeopleController(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @GetMapping
    public List findAll() {
        return peopleRepository.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity findById(@PathVariable long id) {
        return peopleRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public People create(@RequestBody People people) {
        return peopleRepository.save(people);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity update(@PathVariable("id") long id, @RequestBody People people) {

        return peopleRepository.findById(id)
                .map(record -> {
                    record.setName(people.getName());
                    record.setEmail(people.getEmail());
                    record.setPhone(people.getPhone());
                    People updated = peopleRepository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity <?> delete(@PathVariable long id) {
        return peopleRepository.findById(id)
                .map(record -> {
                    peopleRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

}
