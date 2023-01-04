package org.sid.banquerest.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.banquerest.enums.TypeCompte;

import javax.persistence.*;
import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor
public class CompteDTO {
    private double solde;
    private TypeCompte type;
}
