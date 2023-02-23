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
	private ProduitService prodServ;

	private CategoriesService categoriesService;
	@Test
	void contextLoads() {


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

}
