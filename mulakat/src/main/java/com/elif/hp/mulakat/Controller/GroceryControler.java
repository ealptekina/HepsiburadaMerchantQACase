package com.elif.hp.mulakat.Controller;

import com.elif.hp.mulakat.Model.Grocery;
import com.elif.hp.mulakat.Service.GroceryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/grocery")
public class GroceryControler {

    private final GroceryService groceryService;

    public GroceryControler(GroceryService groceryService) {
        this.groceryService = groceryService;
        groceryService.fillData();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    private ResponseEntity<List<Grocery>> getAll() {

        List<Grocery> allGroceries = groceryService.findAll();

        if (allGroceries.size() == 0)
            return (ResponseEntity<List<Grocery>>) ResponseEntity.notFound();

        return ResponseEntity.ok(allGroceries);
    }

    @RequestMapping(value = "/findByName/{name}", method = RequestMethod.GET)
    private ResponseEntity<Grocery> findByName(@PathVariable("name") String name) {

        Grocery grocery = groceryService.findByName(name);

        if (grocery == null)
            return (ResponseEntity<Grocery>) ResponseEntity.notFound(); // throws 404

        return ResponseEntity.ok(grocery); // thrwos 200
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    private ResponseEntity<Grocery> save(@RequestBody Grocery grocery) {

        if (grocery.getId() != 0)
            return (ResponseEntity<Grocery>) ResponseEntity.badRequest(); // throws 400

        try {
            Grocery savedGrocery = groceryService.save(grocery);
            return ResponseEntity.ok(savedGrocery);
        } catch (Exception e) {
            return (ResponseEntity<Grocery>) ResponseEntity.badRequest();
        }
    }
}
