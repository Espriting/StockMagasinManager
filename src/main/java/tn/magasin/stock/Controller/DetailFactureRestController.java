package tn.magasin.stock.Controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.magasin.stock.IService.IDetailFactureService;
import tn.magasin.stock.IService.IFactureService;
import tn.magasin.stock.entity.DetailFacture;
import tn.magasin.stock.entity.Facture;
import tn.magasin.stock.entity.User;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

@RequestMapping("/detailfacture")
@Api(tags = "DetailFacture management")
public class DetailFactureRestController {
    @Autowired
    IDetailFactureService detailFactureService ;
    @Autowired
    IFactureService factureService ;
    @ApiOperation(value = "Récupérer la liste des DetailFactures")
    @GetMapping("/retrieve-all-Detailfactures")
    @ResponseBody
    public List<DetailFacture> getDetailFactures() {
        List<DetailFacture> listDetailFactures = detailFactureService.retrieveAllDetailFactures();
        return listDetailFactures;
    }
    //Service Avancé
    @ApiOperation(value = "Récupérer la liste des DetailFacture par facture")
    @GetMapping("/retrieve-all-Detailfactures-By-Facture/{idFacture}")
    @ResponseBody
    public List<DetailFacture> retrieveDetailFactureByFacture (@PathVariable("idFacture") Long idFacture){
        Optional<Facture> facture=factureService.retrieveFacture(idFacture);
        List<DetailFacture> listedetailfactures= detailFactureService.retrieveDetailFactureByFacture(facture);
        return listedetailfactures;
    }
    @ApiOperation(value = "Récupérer un Detailfacture")
    @GetMapping("/retrieve-Detail/Detailfacture-id")
    @ResponseBody
    public DetailFacture retrieveDetailfacture(@PathVariable("Detailfacture-id") Long idDetailfacture) {
        return detailFactureService.retrieveDetailFacture(idDetailfacture);
    }

    @ApiOperation(value = "Ajouter un Detailfacture")
    @PostMapping("/add-Detailfacturee")
    @ResponseBody
    public DetailFacture addDetailfacture(@RequestBody DetailFacture d) {
        return detailFactureService.addDetailFacture(d);
}
    @ApiOperation(value = "Supprimer un DetailFacture")
    @DeleteMapping("/remove-DetailFacture/{DetailFacture-id}")
    @ResponseBody
    public void removeDetailFacture(@PathVariable("DetailFacture-id") Long idDetailfacture) {
        detailFactureService.deleteDetailFacture(idDetailfacture);
    }

    @ApiOperation(value = "Modifier un DetailFacture")
    @PutMapping("/modify-DetailFacture")
    @ResponseBody
    public DetailFacture modifyDetailFacture(@RequestBody DetailFacture detailFacture ){
        return detailFactureService.updateDetailFacture(detailFacture);
    }

}
