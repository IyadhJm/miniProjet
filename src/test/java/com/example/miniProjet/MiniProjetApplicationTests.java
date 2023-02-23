package com.example.miniProjet;

import com.example.miniProjet.entity.Categories;
import com.example.miniProjet.entity.Produit;
import com.example.miniProjet.service.CategoriesService;
import com.example.miniProjet.service.ProduitService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
class MiniProjetApplicationTests {
	@Autowired
	private   CategoriesService catServ;
	@Test
	void contextLoads() {
		Categories expectedCategorie = Categories.builder()
				.name("name cat")
				.qt(1)
				.build();
		Categories savedCategorie = catServ.create(expectedCategorie);
		assertNotNull(savedCategorie);
		assertNotNull(expectedCategorie.getName() , savedCategorie.getName());
	}

}
