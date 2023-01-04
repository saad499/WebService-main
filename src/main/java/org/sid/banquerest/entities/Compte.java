package org.sid.banquerest.entities;
;
import lombok.*;
import org.sid.banquerest.enums.TypeCompte;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;
@XmlRootElement
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder
@XmlType(namespace="test1", name = "Compte")
//@XmlTransient
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double solde;
    @Temporal(TemporalType.DATE)
    private Date dateCreation;
    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private TypeCompte type;





}
