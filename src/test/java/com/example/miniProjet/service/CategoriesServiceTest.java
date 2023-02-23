package com.example.miniProjet.service;

import com.example.miniProjet.entity.Categories;
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
class CategoriesServiceTest {
@Autowired
  private   CategoriesService catServ;
@Autowired
    private CategoriesRepository categoriesRepository;
@Autowired
private ProduitRepository produitRepository;


@Test
   void SaveCategorieSucces(){
    Categories expectedCategorie = Categories.builder()
            .name("name cat")
            .qt(1)
            .build();
    Categories savedCategorie = catServ.create(expectedCategorie);
    assertNotNull(savedCategorie);
    assertNotNull(expectedCategorie.getName() , savedCategorie.getName());


}
    @Test
     void DeleteCategorieSucces(){

        Categories expectedCategorie = Categories.builder()
                .id(15)
                .name("name cat")
                .qt(1)
                .build();
        Categories savedCat=catServ.create(expectedCategorie);


         boolean isDelted= catServ.delete(savedCat.getId());
        assertTrue(isDelted);
        Optional<Categories> optionalCategories=categoriesRepository.findById(savedCat.getId());
        assertFalse(optionalCategories.isPresent());
    }

    @Test
    void FindAllSucces() {
        List<Categories> foundCategorie = catServ.getAllListCategories();
        assertNotNull(foundCategorie);

    }
    @Test
    void FindByIdSucces() {
        Categories categories= new Categories();
        Categories found = catServ.findById(24L);

        assertNotNull(found);
        assertEquals( 10,categories.getId(), found.getId());

    }

}