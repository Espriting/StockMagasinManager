package tn.magasin.stock.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import tn.magasin.stock.Service.StockService;
import tn.magasin.stock.entity.Stock;

import java.util.List;

@RestController
@RequestMapping("/api/stock")
public class StockController {
    @Autowired
    public StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping("/getAllStock")
    public List<Stock> getStocks(){
        return stockService.retrieveAllStock();
    }

    @DeleteMapping("/deleteStock/{id}")
    public void deletStock(@PathVariable(value="id") long id){
        stockService.deleteStockById(id);

    }

    @PutMapping("/updateStock")
    public ResponseEntity<Stock> UpdateStock(@RequestBody Stock stock)throws Exception{


        return new ResponseEntity<>(stockService.updateStock(stock), HttpStatus.OK);
    }

    @GetMapping("/getStockById/{id}")
    public Stock getStockById(@PathVariable(value="id") long id){
       return stockService.retrieveStock(id).orElse(new Stock());

    }
}
