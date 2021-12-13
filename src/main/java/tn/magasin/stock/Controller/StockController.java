package tn.magasin.stock.Controller;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import tn.magasin.stock.Service.ProduitService;
import tn.magasin.stock.Service.StockService;
import tn.magasin.stock.entity.Stock;

import java.util.List;

@RestController
@RequestMapping("/api/stock")
public class StockController {
    @Autowired
    public StockService stockService;
    @Autowired
    public ProduitService produitService;

    public StockController(StockService stockService, ProduitService produitService) {
        this.stockService = stockService;
        this.produitService = produitService;
    }

    @GetMapping("/getAllStock")
    public List<Stock> getStocks(){
        return stockService.retrieveAllStock();
    }

    @DeleteMapping("/deleteStock/{id}")
    public void deleteStock(@PathVariable(value="id") long id){
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
    @PostMapping("/addStock")
    public ResponseEntity<Stock> addStock(@RequestBody Stock stock){

        return new ResponseEntity<>(stockService.addStock(stock),HttpStatus.OK);
    }
    @GetMapping("/exhaustStock")
    public ResponseEntity<List<Stock>> getExhaustStock(){
        return new ResponseEntity<>(stockService.ExhaustedStock(),HttpStatus.ACCEPTED);
    }
}
