package com.resttechsolutions.springboot.app.item.clients;

import com.resttechsolutions.springboot.app.item.models.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/*@FeignClient(name = "product-service")*/
public interface RestProductClient {

    @GetMapping("/list")
    public List<Product> list();

    @GetMapping("/list/{id}")
    public Product detail(@PathVariable Long id);
}
