package org.sid.banquerest.web;


import org.sid.banquerest.entities.Compte;
import org.sid.banquerest.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
@Component //dire a spring que @Autowired c'est un composant spring
@Path("/banque")

public class CompteRestJaxRSApi {
    @Autowired
    private CompteRepository compteRepository;

    @Path("/comptes")
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public List<Compte> comptes(){
        return compteRepository.findAll();
    }
    @Path("/comptes/{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Compte compte(@PathParam(value = "id") Long id){
        return compteRepository.findById(id).get();
    }
    @Path("/comptes")
    @POST
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Compte saveCompte(  Compte compte){
        return compteRepository.save(compte);
    }
    @Path("/comptes/{id}")
    @PUT
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Compte updateCompte(Compte compte,@PathParam("id") Long id){
        compte.setId(id);
        return compteRepository.save(compte);
    }
    @Path("/comptes/{id}")
    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    public void deleteCompte(@PathParam(value = "id") Long id){
         compteRepository.deleteById(id);
    }

}
