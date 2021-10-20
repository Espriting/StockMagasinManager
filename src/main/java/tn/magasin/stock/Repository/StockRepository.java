package tn.magasin.stock.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.magasin.stock.entity.Stock;
@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
}