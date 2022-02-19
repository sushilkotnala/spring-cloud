package com.sushil.openapi.controller;

import com.sushil.openapi.api.PetApi;
import com.sushil.openapi.model.Pet;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class PetController implements PetApi {
    @Override
    public ResponseEntity<Void> addPet(@Valid Pet body) {
        return null;
    }

    @Override
    public ResponseEntity<Pet> getPetById(Long petId) {
        return null;
    }

    @Override
    public ResponseEntity<Pet> getPetNewById(Long petId) {
        return null;
    }
}
