package tn.magasin.stock.Repository;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.magasin.stock.entity.Stock;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StockRepositoryTest {
    @Autowired
    private StockRepository stockTest;
    private static final Logger l = LogManager.getLogger(FournisseurRepository.class);

    @Test
    void selectExistsFournisseur() {
        //given
        Stock stock=new Stock();
        stock.setLibelleStock("fezfefe");
        stockTest.save(stock);


        //whene

        Boolean result=stockTest.stockEmpty(1l);
        l.info("stock si empty ? "+result);


        //where
        assertThat(result).isFalse();





    }
}