package com.example.demo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
	
	List<Produit> findByNomProduit(String nom);
	List<Produit> findByNomProduitContains(String nom); 
	
	
	@Query("select p from Produit p where p.nomProduit like %?1 and p.prixProduit > ?2")
	List<Produit> findByNomPrix (String nom, Double prix);

//produit: c'est l'entité produit
	//p.nomProduit c'est le nom :
	//?1 c'est a dire le 1er parametre
}
