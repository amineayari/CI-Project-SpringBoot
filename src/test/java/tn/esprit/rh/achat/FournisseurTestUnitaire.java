package tn.esprit.rh.achat;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.rh.achat.entities.CategorieFournisseur;
import tn.esprit.rh.achat.entities.Fournisseur;
import tn.esprit.rh.achat.repositories.DetailFournisseurRepository;
import tn.esprit.rh.achat.services.IFournisseurService;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class FournisseurTestUnitaire {
    @Autowired
    IFournisseurService fournisseurService;

    @Test
    public void testAddFournisseur(){
        List<Fournisseur> fournisseurs=fournisseurService.retrieveAllFournisseurs();
        int size=fournisseurs.size();
        Fournisseur f=new Fournisseur("11111","fournisseur", CategorieFournisseur.ORDINAIRE);
        Fournisseur savedFournisseur=fournisseurService.addFournisseur(f);
        Assert.assertEquals(size+1,fournisseurService.retrieveAllFournisseurs().size());
        Assert.assertNotNull(savedFournisseur.getLibelle());
        fournisseurService.deleteFournisseur(savedFournisseur.getIdFournisseur());
    }
    @Test
    public void testGetFournisseurs() {
        List<Fournisseur> fournisseurs = fournisseurService.retrieveAllFournisseurs();
        int size =fournisseurs.size();
        log.info("initialize size of the list");
        Fournisseur f = new Fournisseur("fournisseur1","fournir", CategorieFournisseur.ORDINAIRE);
        Fournisseur o = new Fournisseur("fournisseur2","fournir2", CategorieFournisseur.CONVENTIONNE);
        Fournisseur savedFournisseur= fournisseurService.addFournisseur(f);
        log.info("ajouter un fournisseur 1");
        Fournisseur savedFournisseur2= fournisseurService.addFournisseur(o);
        log.info("ajouter un fournisseur 2");
        Assert.assertEquals(size+2, fournisseurService.retrieveAllFournisseurs().size());
        log.info("if size=size+2 alors test accepte");
        Assert.assertNotNull(savedFournisseur.getLibelle());
        fournisseurService.deleteFournisseur(savedFournisseur.getIdFournisseur());
        fournisseurService.deleteFournisseur(savedFournisseur2.getIdFournisseur());
        log.info("supprimer les fournisseurs");
    }


    @Test
    public void testRemoveFournisseur() {
        Fournisseur f= new Fournisseur("fournisseur3","azdq", CategorieFournisseur.CONVENTIONNE);
        Fournisseur savedFournisseur= fournisseurService.addFournisseur(f);
        log.info("ajouter un fournisseur");
        fournisseurService.deleteFournisseur(savedFournisseur.getIdFournisseur());
        log.info("supprimer le fournisseur");
        Assert.assertNull(fournisseurService.retrieveFournisseur(savedFournisseur.getIdFournisseur()));

    }
}
