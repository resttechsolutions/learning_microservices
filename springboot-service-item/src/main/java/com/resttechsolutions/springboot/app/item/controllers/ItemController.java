package com.resttechsolutions.springboot.app.item.controllers;

import com.resttechsolutions.springboot.app.item.models.Item;
import com.resttechsolutions.springboot.app.item.models.service.ItemService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

//    @Qualifier("serviceFeign")
    @Qualifier("serviceRestTemplate")
    private final ItemService service;

    public ItemController(ItemService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public List<Item> list(){
        return service.findAll();
    }

    @GetMapping("/st")
    public String string(){
        return "Hello world";
    }

    @GetMapping("/list/{id}/amount/{amount}")
    public Item detail(@PathVariable Long id, @PathVariable Integer amount){
        return service.findById(id, amount);
    }
}
