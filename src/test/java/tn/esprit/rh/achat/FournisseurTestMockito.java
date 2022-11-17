package tn.esprit.rh.achat;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.rh.achat.entities.DetailFournisseur;
import tn.esprit.rh.achat.entities.Fournisseur;
import tn.esprit.rh.achat.repositories.DetailFournisseurRepository;
import tn.esprit.rh.achat.repositories.FournisseurRepository;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import tn.esprit.rh.achat.repositories.SecteurActiviteRepository;
import tn.esprit.rh.achat.services.FournisseurServiceImpl;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class FournisseurTestMockito {
    @Mock
    FournisseurRepository fournisseurRepo;


    @InjectMocks
    FournisseurServiceImpl fournisseurServiceImpl;

    @Mock
    FournisseurRepository fournisseurRepository;
    @Mock
    DetailFournisseurRepository detailFournisseurRepository;
    @Mock
    ProduitRepository produitRepository;
    @Mock
    SecteurActiviteRepository secteurActiviteRepository;
    private Fournisseur fournisseur;


    @Test
    void test_retrieveAllFournisseurs_ok() {

        Mockito.when(fournisseurRepository.findAll()).thenReturn(new ArrayList());
        List<Fournisseur> response= fournisseurServiceImpl.retrieveAllFournisseurs();
        Assert.assertEquals(0, response.size());
    }
    @Test
    void test_addFournisseur_ok() {
        DetailFournisseur df= new DetailFournisseur();
        fournisseur = new Fournisseur();
        df.setIdDetailFournisseur(1L);
        //mock
        Mockito.when(fournisseurRepository.save(any())).thenReturn(fournisseur);
        //call function
        fournisseurServiceImpl.addFournisseur(fournisseur);
        //assert
        assertEquals(1L,df.getIdDetailFournisseur());
    }
    @Test
    void test_deleteFournisseur_ok() {
        Long fournisseurId = 1L;
        doNothing().when(fournisseurRepository).deleteById(fournisseurId);
        fournisseurServiceImpl.deleteFournisseur(fournisseurId);
        verify(fournisseurRepository, times(1)).deleteById(fournisseurId);
    }
}
