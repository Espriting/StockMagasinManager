package tn.magasin.stock.Repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import tn.magasin.stock.Service.CommandeService;
import tn.magasin.stock.Service.LivraisonService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@Slf4j
public class LivraisonRepositoryTest {
    @Mock
    private LivraisonRepository livraisonRepository;
    @InjectMocks
    LivraisonService ls;

}
