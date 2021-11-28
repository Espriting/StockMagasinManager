package tn.magasin.stock.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.magasin.stock.Repository.FactureRepository;

@Service
@Slf4j
public class FactureService {
    public final FactureRepository factureRepository;
    @Autowired
    public FactureService(FactureRepository factureRepository) {
        this.factureRepository = factureRepository;
    }
}
