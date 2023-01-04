package org.sid.banquerest.web;

import org.sid.banquerest.entities.Compte;
import org.sid.banquerest.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//import javax.jws.WebMethod;
//import javax.jws.WebParam;
//import javax.jws.WebService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Component
//@WebService(name = "banqueWS")
public class CompteWsSOAP {
    @Autowired
    private CompteRepository compteRepository;
    //@WebMethod(operationName = "comptes")
    public List<Compte> compteList(){
        return  compteRepository.findAll();
    }
    //@WebMethod(operationName = "comptes/{id}")
    //public Compte compte(@WebParam(name = "id") Long id){
        //return compteRepository.findById(id).get();
    //}

}
