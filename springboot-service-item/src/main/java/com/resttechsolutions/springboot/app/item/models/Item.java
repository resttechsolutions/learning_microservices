package com.resttechsolutions.springboot.app.item.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    private Product product;
    private Integer amount;

    public Double getTotal(){
        return this.product.getPrice() * this.amount.doubleValue();
    }
}
