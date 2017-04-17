package com.tmm.web;

import com.tmm.domain.Product;
import com.tmm.dto.BillDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Captain Wang on 17/4/17.
 */

@RestController
public class SaleController {

    @PostMapping("/product")
    @ResponseBody
    public Product addProduct() {
        Product product = new Product();
        return product;
    }


    @GetMapping("/product")
    @ResponseBody
    public List<Product> getProducts(@RequestParam Long productId) {

        List<Product> productList= new ArrayList<Product>();
        Product product = new Product();
        return productList;
    }

    @DeleteMapping("/product")
    @ResponseBody
    public void deleteProduct(@RequestParam Long productId) {


        Product product = new Product();

    }

    @PutMapping("/product")
    @ResponseBody
    public void updateProduct(@RequestParam Long productId) {


        Product product = new Product();

    }

    @PostMapping("/bill")
    @ResponseBody
    public BillDto addBill() {
        BillDto billDto = new BillDto();
        return billDto;
    }

    @GetMapping("/bill")
    @ResponseBody
    public BillDto getBill(@RequestParam Long billId) {
        BillDto billDto = new BillDto();
        return billDto;
    }

}
