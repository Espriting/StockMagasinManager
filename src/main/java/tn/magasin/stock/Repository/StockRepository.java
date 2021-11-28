package tn.magasin.stock.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.magasin.stock.entity.Stock;
@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
            @Query("SELECT CASE WHEN COUNT(p)>0 THEN TRUE ELSE FALSE END from Produit p join Stock s on p.stock.idStock=?1")
            boolean stockEmpty(Long Id);
}