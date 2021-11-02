package tn.magasin.stock.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.magasin.stock.IService.IStockService;
import tn.magasin.stock.Repository.StockRepository;
import tn.magasin.stock.entity.Stock;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class StockService  implements IStockService {
    public final StockRepository stockRepository;
    @Autowired
    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public List<Stock> retrieveAllStock() {
        return stockRepository.findAll();
    }

    @Override
    public Stock addStock(Stock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public void deleteStockById(Long Id) {
        stockRepository.deleteById(Id);

    }

    @Override
    public Stock updateStock(Stock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public Optional<Stock> retrieveStock(Long Id) {
        return stockRepository.findById(Id);
    }
}
