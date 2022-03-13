package com.resttechsolutions.springboot.app.item.models.service;

import com.resttechsolutions.springboot.app.item.models.Item;
import com.resttechsolutions.springboot.app.item.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service("serviceRestTemplate")
public class ItemServiceImpl implements ItemService{

    private final RestTemplate restClient;

    public ItemServiceImpl(RestTemplate restClient) {
        this.restClient = restClient;
    }

    @Override
    public List<Item> findAll() {

        List<Product> productList = new ArrayList<>();

        if (restClient.getForObject("http://product-service/list", Product[].class).length > 0)
            productList = Arrays.asList(restClient.getForObject("http://product-service/list", Product[].class));

        return productList.stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer amount) {
        Map<String, String> pathVariables = new HashMap<>();

        pathVariables.put("id", id.toString());

        Product product = restClient.getForObject("http://product-service/list/{id}", Product.class, pathVariables);

        return new Item(product, amount);
    }
}
