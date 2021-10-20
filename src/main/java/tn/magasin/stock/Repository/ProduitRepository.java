package tn.magasin.stock.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.magasin.stock.entity.Produit;
@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {
}