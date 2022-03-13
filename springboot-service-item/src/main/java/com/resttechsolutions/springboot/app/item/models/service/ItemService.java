package com.resttechsolutions.springboot.app.item.models.service;

import com.resttechsolutions.springboot.app.item.models.Item;

import java.util.List;

public interface ItemService {

    public List<Item> findAll();
    public Item findById(Long id, Integer amount);
}
