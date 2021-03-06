package com.victor.library2.repository;

import com.victor.library2.model.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

    Optional<Utilisateur> findByMail(String mail);

    Optional<Utilisateur> findByUsername(String username);

    Boolean existsByUsername(String username);
    Boolean existsByPassword(String password);

    Boolean existsByMail(String mail);

}
