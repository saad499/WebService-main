package org.sid.banquerest.web;

import org.sid.banquerest.dtos.CompteDTO;
import org.sid.banquerest.entities.Compte;
import org.sid.banquerest.repositories.CompteRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.List;

@Controller
public class CompteGraphQLController {
    private CompteRepository compteRepository;

    public CompteGraphQLController(CompteRepository compteRepository) {
        this.compteRepository = compteRepository;
    }
    @QueryMapping
    public List<Compte> comptes(){
        return compteRepository.findAll();
    }

    @QueryMapping
    public Compte compte(@Argument Long id){
        return compteRepository.findById(id).orElseThrow(
                ()->new RuntimeException(String.format("compte by Id %s Not Found",id)
                ));
    }

    @MutationMapping
    public Compte saveCompte(@Argument CompteDTO compteDTO){
        Compte compte= Compte.builder()
                .dateCreation(new Date())
                .solde(compteDTO.getSolde())
                .type(compteDTO.getType())
                .build();
        return compteRepository.save(compte);
    }

}
