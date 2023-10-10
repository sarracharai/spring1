package com.example.demo;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entities.Categorie;
import com.example.demo.entities.Produit;
import com.example.demo.repos.ProduitRepository;

@SpringBootTest
class ProduitsApplicationTests {
	
	@Autowired 
	private ProduitRepository produitRepository; //injection de dependences
	
	@Test
	public void testCreateProduit() {
	Produit prod = new Produit("Ps hp",1500.500,new Date());
	produitRepository.save(prod);
	}
	
	@Test
	public void testFindProduit()
	{
	Produit p = produitRepository.findById(2L).get();
	System.out.println(p);
	}
	
	@Test
	public void testUpdateProduit()
	{
	Produit p = produitRepository.findById(2L).get();
	p.setPrixProduit(2000.0);
	produitRepository.save(p);
	System.out.println(p);
	}
	
	
	@Test
	public void testDeleteProduit()
	{
	produitRepository.deleteById(1L);;
	}
	
	@Test
	public void testFindAllProduits()
	{
	List<Produit> prods = produitRepository.findAll();
	for (Produit p : prods)
	{
	System.out.println(p);
	}

	}
	
	
	@Test
	public void testFindProduitByNom()
	{
	List<Produit> prods = produitRepository.findByNomProduit("PC Lenovo");
	for (Produit p : prods)
	{
	System.out.println(p);
	}
	}
	
	
	@Test
	public void testFindByNomProduitContains ()
	{
	List<Produit> prods=produitRepository.findByNomProduitContains("P");
	for (Produit p : prods)
	{
	System.out.println(p);
	} 
	}
	
	
	@Test
	public void testfindByNomPrix()
	{
	List<Produit> prods = produitRepository.findByNomPrix("PC Lenovo", 1000.0);
	for (Produit p : prods)
	{
	System.out.println(p);
	}
	}
	
	@Test
	public void testfindByCategorie()
	{
	Categorie cat = new Categorie();
	cat.setIdCat(1L);
	List<Produit> prods = produitRepository.findByCategorie(cat);
	for (Produit p : prods)
	{
	System.out.println(p);
	}
	}
	

	@Test
	public void findByCategorieIdCat()
	{
	List<Produit> prods = produitRepository.findByCategorieIdCat(1L);
	for (Produit p : prods)
	{
	System.out.println(p);
	}
	 }
	
	@Test
	public void testfindByOrderByNomProduitAsc()
	{
	List<Produit> prods =
	produitRepository.findByOrderByNomProduitAsc();
	for (Produit p : prods)
	{
	System.out.println(p);
	}
	}
	
	@Test
	public void testTrierProduitsNomsPrix()
	{
	List<Produit> prods = produitRepository.trierProduitsNomsPrix();
	for (Produit p : prods)
	{
	System.out.println(p);
	}
	}
	
	
	

	



}

