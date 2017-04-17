package com.tmm.web;

import com.google.gson.Gson;
import com.tmm.domain.Bill;
import com.tmm.domain.Product;
import com.tmm.domain.ProductDetails;
import com.tmm.dto.BillDto;
import com.tmm.service.BillRepository;
import com.tmm.service.ProductDetailsRepository;
import com.tmm.service.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Captain Wang on 17/4/17.
 */

@RestController
public class SaleController {

    private Gson gson = new Gson();
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private ProductDetailsRepository productDetailsRepository;

    @PostMapping("/product")
    @ResponseBody
    public Product addProduct(@RequestBody String body) {

        Product product = gson.fromJson(body, Product.class);
        System.out.println(product.toString());
        productRepository.save(product);

        return product;
    }


    @GetMapping("/product")
    @ResponseBody
    public List<Product> getAllProducts() {

        List<Product> productList = new ArrayList<Product>();
        productList.addAll(productRepository.findAll());
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
    public BillDto addBill(@RequestBody String body) {

        BillDto billDto = gson.fromJson(body, BillDto.class);

        System.out.println(billDto.toString());
        Bill bill = new Bill();
        bill.setCustomerId(billDto.getCustomerId());
        bill.setDetails(billDto.getDetails());
        bill.setTotalPrices(billDto.getTotalPrices());
        Bill billId = billRepository.save(bill);
        List<ProductDetails> productDetails = new ArrayList<ProductDetails>(billDto.getProducts());

        for (int i = 0; i < billDto.getProducts().size(); i++) {
            productDetailsRepository.save(productDetails.get(i));
        }
        return billDto;
    }

    @GetMapping("/bill")
    @ResponseBody
    public BillDto getBills(@RequestParam Long billId) {
        BillDto billDto = new BillDto();
        return billDto;
    }

}
