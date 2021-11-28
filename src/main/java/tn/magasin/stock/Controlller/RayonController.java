package tn.magasin.stock.Controlller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.magasin.stock.Service.RayonService;
import tn.magasin.stock.entity.Produit;
import tn.magasin.stock.entity.Rayon;

import java.util.List;

@RestController
@RequestMapping("/api/rayon")
public class RayonController {
    @Autowired
    public  RayonService rayonService;

    public RayonController(RayonService rayonService) {
        this.rayonService = rayonService;
    }
    @GetMapping("/getAllRayons")
    public ResponseEntity<List<Rayon>> geRayons(){

        return new ResponseEntity<>(rayonService.retrieveAllRayon(), HttpStatus.OK);
    }

    @DeleteMapping("/deleteRayon/{id}")
    public ResponseEntity<String> deleteRayon(@PathVariable(value="id") long id){
        rayonService.deleteRayonById(id);
                 return new ResponseEntity<String>("Rayon_is_deleted",HttpStatus.OK);


    }

        @PutMapping("/updateRayon")
    public ResponseEntity<Rayon> UpdateRayon(@RequestBody Rayon rayon){
        if(rayonService.updateRayon(rayon) instanceof Rayon){
            return new ResponseEntity<>(rayonService.updateRayon(rayon),HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(rayonService.updateRayon(rayon),HttpStatus.EXPECTATION_FAILED);
        }
    }
    @PostMapping("/addRayon")
    public ResponseEntity<Rayon> addRayon(@RequestBody Rayon rayon){
            return new ResponseEntity<>(rayonService.addRayon(rayon),HttpStatus.CREATED);
    }
    @GetMapping("/getRayonById/{id}")
    public Rayon getStockById(@PathVariable(value="id") long id){
        return rayonService.retrieveRayon(id);
    }
    @PostMapping("addProductToRayon/{idRayon}")
    public ResponseEntity<String> addProductToRayon(@PathVariable(value="idRayon") long idRayon,@RequestBody Produit produit){
        Rayon retrieveRayon=rayonService.retrieveRayon(idRayon);
        if(!retrieveRayon.getProduits().contains(produit)){
            retrieveRayon.getProduits().add(produit);
            rayonService.updateRayon(retrieveRayon);
            return new ResponseEntity<String>("Product_added",HttpStatus.OK);
        }
        else return new ResponseEntity<String>("product_is_exist",HttpStatus.ACCEPTED);


    }

}
