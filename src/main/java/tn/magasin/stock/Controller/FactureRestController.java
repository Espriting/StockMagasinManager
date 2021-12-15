package tn.magasin.stock.Controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import tn.magasin.stock.IService.IFactureService;
import tn.magasin.stock.IService.IUserService;
import tn.magasin.stock.entity.Facture;
import tn.magasin.stock.entity.User;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

@RequestMapping("/facture")
@Api(tags = "Facture management")
public class FactureRestController {
    @Autowired
    IFactureService factureService;
    @Autowired
    IUserService userService;


    @ApiOperation(value = "Récupérer la liste des Factures")
    @GetMapping("/retrieve-all-factures")
    @ResponseBody
    public List<Facture> getFactures() {
        List<Facture> listFactures = factureService.retrieveALLFactures();
        return listFactures;
    }
// Service Avancé
    @ApiOperation(value = "Récupérer la liste des Factures par clients")
    @GetMapping("/retrieve-all-factures-By-Client/{idUser}")
    @ResponseBody
    public List<Facture> getFacturesByClient(@PathVariable("idUser") Long idUser) {
       User user = userService.getUserById(idUser);
        List<Facture> listFactures = factureService.retrieveALLFacturesByUser(user);
        return listFactures;
    }

    @ApiOperation(value = "Récupérer une facture")
    @GetMapping("/retrieve-facture/{facture-id}")
    @ResponseBody
    public Optional<Facture> retrieveFacture(@PathVariable("facture-id") Long idFacture) {
        return factureService.retrieveFacture(idFacture);
    }
//Service Avancé
    @ApiOperation(value = "Ajouter une Facture par id client")
    @PostMapping("/addFacture/{id}")
    public Facture addFacture(@RequestBody Facture f,@PathVariable(value="id")Long id){
        Facture facture= factureService.addFacture(f,id);
        return facture;
    }


    @ApiOperation(value = "Supprimer une facture")
    @DeleteMapping("/remove-facture/{facture-id}")
    @ResponseBody
    public void removeFacture(@PathVariable("facture-id") Long factureId) {
        factureService.deleteFactureById(factureId);
    }

    @ApiOperation(value = "Modifier une facture")
    @PutMapping("/modify-facture")
    @ResponseBody
    public Facture modifyFacture(@RequestBody Facture facture) {
        return factureService.updateFacture(facture);
    }

    @ApiOperation(value = "Ajouter une facture")
    @PostMapping("/add-facture")
    @ResponseBody
    public Facture addfacture(@RequestBody Facture f) {
        Facture facture = factureService.addfacture(f);
        return facture;
    }

  /*  @ApiOperation(value = "Récupérer facture par client")
    @GetMapping("/retrieve-facture{user-id}")
    @ResponseBody

        public List<Facture> retrieveFactureByClient(@PathVariable("user-id") Long id) {
            return factureService.retrieveFactureByClient(id);
        }*/

}




