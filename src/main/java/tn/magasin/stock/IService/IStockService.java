package tn.magasin.stock.IService;

import org.springframework.http.ResponseEntity;
import tn.magasin.stock.entity.Rayon;
import tn.magasin.stock.entity.Stock;

import java.util.List;
import java.util.Optional;

public interface  IStockService {
    List<Stock> retrieveAllStock();
    Stock addStock(Stock stock);
    void deleteStockById(Long Id);
    // Boolean deleteStockByObject(User user);
   Stock updateStock(Stock stock);
    Optional<Stock> retrieveStock(Long Id);
    List<Stock> ExhaustedStock();
}
