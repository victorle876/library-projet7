package com.victor.library2.model.dto;

import com.victor.library2.model.entity.Pret;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UtilisateurDTO {

    private Long id;

    private String username;

    private String prenom;

    private String mail;

    private String password;

    private Integer age;

    private String statut;

    private Date createdAt;

    private Date updatedAt;

    private List<Pret> prets;


   /* @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "user_role",
            joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")})
    private List<Role> roles;*/

}

