package madsi.dia.controleur;

import madsi.dia.doa.Boutiquedoa;
import madsi.dia.model.Boutique;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.Servlet;
import javax.xml.ws.Response;
import java.net.URI;
import java.util.List;
@RestController
public class BoutiqueControleur {
@Autowired

    /*String acceuil;
    @GetMapping ("/Acceuil")
    public String Acceuil(Model model){
    model.addAttribute("Acceuil",acceuil);
    return "Acceuil";
    }*/


    //afficher tous les produits
    private Boutiquedoa dia;
    @GetMapping(value = "Produits")
    public List<Boutique> afficheproduit(){
        return dia.findAll();
    }
    //recherche par id
    @GetMapping(value = "Produit/{id}")
    public Boutique rechercheid(@PathVariable int id) {
        return dia.findById(id);
    }
    //enregistrement d'un produit
    @PostMapping(value = "/save")
    public void enregistrerProduit(@RequestBody Boutique bq){
        dia.save(bq);
    }
    //ajouter un produit
    @PostMapping(value = "/produits")
    public ResponseEntity<Void>ajouterptoduit(@RequestBody Boutique bq){
        Boutique bq1 = dia.save(bq);
        if (bq == null ){
            return ResponseEntity.noContent().build();
        }
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(bq1.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }


}
