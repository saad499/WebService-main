package org.sid.banquerest.web;


import org.sid.banquerest.entities.Compte;
import org.sid.banquerest.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.*;
import java.util.List;

//@RestController
@RequestMapping("/banque")
public class CompteRestControllerApi {
    @Autowired
    private CompteRepository compteRepository;

    @GetMapping(path = "/comptes",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE,})
    public List<Compte> comptes(){
        return compteRepository.findAll();
    }
    @GetMapping(path = "/comptes/{id}",produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
    public Compte compte(@PathVariable(value = "id") Long id){
        return compteRepository.findById(id).get();
    }
    @PostMapping(path = "/comptes",consumes = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
    public Compte saveCompte( @RequestBody Compte compte){
        return compteRepository.save(compte);
    }
   @PutMapping(path = "/comptes/{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
    public Compte updateCompte(@RequestBody Compte compte,@PathVariable("id") Long id){
        compte.setId(id);
        return compteRepository.save(compte);
    }
    @DeleteMapping(path = "/comptes/{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
    public void deleteCompte(@PathVariable(value = "id") Long id){
         compteRepository.deleteById(id);
    }

}
