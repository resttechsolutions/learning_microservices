package com.resttechsolutions.springboot.app.item.models.service;

import com.resttechsolutions.springboot.app.item.clients.RestProductClient;
import com.resttechsolutions.springboot.app.item.models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("serviceFeign")
@Primary
public class ItemServiceFeign implements ItemService{

/*    @Autowired
    private RestProductClient feignClient;*/

    @Override
    public List<Item> findAll() {
        return null;
//        return feignClient.list().stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer amount) {
        return null;
//        return new Item(feignClient.detail(id), amount);
    }
}
