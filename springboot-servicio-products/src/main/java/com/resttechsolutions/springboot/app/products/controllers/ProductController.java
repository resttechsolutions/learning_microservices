package com.resttechsolutions.springboot.app.products.controllers;

import com.resttechsolutions.springboot.app.products.models.entity.Product;
import com.resttechsolutions.springboot.app.products.models.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
public class ProductController {

    private final IProductService service;
    private final Environment env;

    @Value("${server.port}")
    private Integer port;

    public ProductController(IProductService service, Environment env) {
        this.service = service;
        this.env = env;
    }

    @GetMapping("/list")
    public List<Product> list(){
        return service.findAll().stream().map(p -> {
//                    p.setPort(Integer.parseInt(Objects.requireNonNull(env.getProperty("local.server.port"))));
            p.setPort(port);
            return p;
                }).collect(Collectors.toList());
    }

    @GetMapping("/list/{id}")
    public Product detail(@PathVariable long id){
        Product product = service.findById(id);

//        product.setPort(Integer.parseInt(env.getProperty("local.server.port")));
        product.setPort(port);

        return product;
    }
}
