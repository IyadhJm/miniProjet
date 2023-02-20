package com.example.miniProjet.service;

import com.example.miniProjet.entity.Categories;
import com.example.miniProjet.entity.Produit;
import com.example.miniProjet.repository.CategoriesRepository;
import com.example.miniProjet.repository.ProduitRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class ProduitServiceTest {
    @Autowired
    private   ProduitService prodServ;
    @Autowired
    private  CategoriesService categoriesService;
    @Autowired
    private  CategoriesRepository categoriesRepository;
    @Autowired
    private ProduitRepository produitRepository;




    @Test
    void SaveProduitSucces(){
          Categories categories = new Categories();
          Categories savedCategorie = categoriesService.create(categories);
        Produit expectedProduit = Produit.builder()
                .name("name prod")
                .qt(1)
                .disponible(true)
                .categories(savedCategorie)
                .build();
        Produit savedProduit = prodServ.create(expectedProduit, expectedProduit.getCategoriesId());
        assertNotNull(savedProduit);
        assertNotNull(expectedProduit.getName() , savedProduit.getName());


    }

    @Test
    void UpdateProduitSucces(){

        Categories categories = categoriesRepository.findById(12L).orElse(null);
        assertNotNull(categories);
        Produit produit = produitRepository.findById(47L).orElse(null);

                produit.setName("name prodUpdate1");
        produit.setQt(33);
                produit.setDisponible(true);
                produit.setCategories(categories);

        Produit savedProd=prodServ.create(produit, produit.getCategoriesId());

        Produit upadateProduit = savedProd;
        savedProd = prodServ.update(upadateProduit, produit.getCategoriesId());


        assertNotNull(upadateProduit);
        assertNotNull(upadateProduit.getName() , savedProd.getName());


    }


    @Test
    void DeleteProduitSucces(){
        Categories categories = new Categories();
        Categories savedCategorie = categoriesService.create(categories);
        Produit expectedProduit = Produit.builder()
                .id(49)
                .name("name prod")
                .qt(1)
                .disponible(true)
                .categories(savedCategorie)
                .build();
        Produit savedProd=prodServ.create(expectedProduit, expectedProduit.getCategoriesId());

       boolean isDelted= prodServ.delete(savedProd.getId());
        assertTrue(isDelted);
        Optional<Produit>optionalProduit=produitRepository.findById(savedProd.getId());
        assertFalse(optionalProduit.isPresent());
    }

    @Test
    void FindAllSucces() {
        List<Produit> foundProduit = prodServ.getAllListProduit();
        assertNotNull(foundProduit);
        assertEquals(4, foundProduit.size());
    }
    @Test
    void FindByIdSucces() {
       Produit produit = new Produit();
        Produit found = prodServ.findById(10L);

        assertNotNull(found);
        assertEquals( 10,produit.getId(), found.getId());

    }

}