package tn.magasin.stock.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.magasin.stock.IService.IStockService;
import tn.magasin.stock.Repository.StockRepository;
import tn.magasin.stock.entity.Rayon;
import tn.magasin.stock.entity.Stock;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class StockService  implements IStockService {
    public final StockRepository stockRepository;
    public final ObjectMapper  objectMapper;

    public StockService(StockRepository stockRepository, ObjectMapper objectMapper) {
        this.stockRepository = stockRepository;
        this.objectMapper = objectMapper;
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
        Stock oldStock=stockRepository.findById(stock.getIdStock()).orElse(new Stock());
        BeanUtils.copyProperties(stock,oldStock);
        return stockRepository.saveAndFlush(stock);
    }

    @Override
    public Optional<Stock> retrieveStock(Long Id) {
        return stockRepository.findById(Id);
    }
}
