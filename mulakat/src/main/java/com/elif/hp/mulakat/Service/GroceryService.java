package com.elif.hp.mulakat.Service;

import com.elif.hp.mulakat.Model.Grocery;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("groceryService")
public class GroceryService {

    private static List<Grocery> allGroceries = new ArrayList<>();

    public void fillData() {
        Grocery g1 = new Grocery();
        g1.setId(1);
        g1.setName("apple");
        g1.setPrice(3d);
        g1.setStok(100);
        allGroceries.add(g1);

        Grocery g2 = new Grocery();
        g2.setId(2);
        g2.setName("grapes");
        g2.setPrice(5d);
        g2.setStok(50);
        allGroceries.add(g2);
    }

    public List<Grocery> findAll() {
        return allGroceries;
    }

    public Grocery findByName(String name) {
        return allGroceries.stream().filter(grocery -> grocery.getName().equals(name)).findFirst().get();
    }

    public Grocery save(Grocery grocery) {
        allGroceries.add(grocery);
        return grocery;
    }

}