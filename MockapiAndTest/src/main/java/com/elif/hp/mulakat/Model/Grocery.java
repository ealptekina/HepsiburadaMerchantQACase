package com.elif.hp.mulakat.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Grocery implements Serializable {

    private int id;
    private String name;
    private double price;
    private int stok;


}
