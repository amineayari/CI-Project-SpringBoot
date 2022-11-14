package tn.esprit.rh.achat;


import lombok.extern.slf4j.Slf4j;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.*;

import tn.esprit.rh.achat.repositories.OperateurRepository;

import static org.junit.jupiter.api.Assertions.*;


import java.util.HashSet;


@SpringBootTest
@Slf4j
public class OperateurServiceImplTest {

    @Autowired
    OperateurRepository operateurRepository;


    Operateur operateur = new Operateur(null, "Patrel", "Piére", "Pass12", new HashSet<>());


    @Test
    public void testAddOperateur() {
        log.info("on va tester  l'ajout d'un nouveau produit: " + operateur.toString());
        operateurRepository.save(operateur);
        assertTrue(operateurRepository.findById(Long.parseLong("1")).isPresent());


    }

    @Test
    public void testRetrieveAllOperateurs() {
        assertTrue(operateurRepository.findAll().iterator().hasNext());
    }

    @Test
    public void testDeleteOperateur() {
        log.info("on va tester la supprission du produit: " + operateur.toString());
        operateurRepository.delete(operateur);
        assertFalse(operateurRepository.findById(Long.parseLong("1")).isPresent());
    }


}