package com.example.miniProjet.service;
import com.example.miniProjet.controller.CategoriesController;
import com.example.miniProjet.entity.Categories;
import com.example.miniProjet.entity.Produit;
import com.example.miniProjet.repository.CategoriesRepository;
import com.example.miniProjet.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
@Service
public class ProduitService {
    ProduitRepository produitRepository;
    @Autowired
    CategoriesRepository categoriesRepository;
    @Autowired
    CategoriesController categoriesController;

    Categories categories ;
    @Autowired
    public ProduitService(ProduitRepository produitRepository){
        this.produitRepository = produitRepository;
    }


    public List<Produit> getAllListProduit(){
        return produitRepository.findAll();
    }
    public Produit findById (Long id){
        return produitRepository.findById(id).orElseThrow(()-> new RuntimeException("entity not found"));
    }


    public Produit create (Produit produit , long id){
        categories = categoriesRepository.findById(id).orElse(null);
        produit.setCategories(categories);
        LocalDate date = LocalDate.now();
        produit.setDateCreation(date);
        produit.setDateModif(date);

        return produitRepository.save(produit);
    }
    public Produit update (Produit produit ,Long id){

        categories = categoriesRepository.findById(id).orElse(null);
        produit.setCategories(categories);
        LocalDate date = LocalDate.now();
        produit.setDateModif(date);
        return produitRepository.saveAndFlush(produit);
    }
    public boolean delete(long id){
        Produit produit = produitRepository.findById(id).orElseThrow(()-> new RuntimeException("entity not found"));
        produitRepository.delete(produit);
        return true;
    }
}
