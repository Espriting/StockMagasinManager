package tn.magasin.stock.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.magasin.stock.entity.DetailProduit;
@Repository
public interface DetailProduitRepository extends JpaRepository<DetailProduit, Long> {
}