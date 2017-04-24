package com.tmm.web;

import com.google.gson.Gson;
import com.tmm.domain.Bill;
import com.tmm.domain.Product;
import com.tmm.domain.ProductDetails;
import com.tmm.dto.BillDto;
import com.tmm.dto.ProductDTO;
import com.tmm.service.BaseUrlRepository;
import com.tmm.service.BillRepository;
import com.tmm.service.ProductDetailsRepository;
import com.tmm.service.ProductRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
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


    @Autowired
    private BaseUrlRepository baseUrlRepository;

    //
    @PostMapping("/product")
    @ResponseBody
    @ApiOperation(value = "添加商品", httpMethod = "POST", notes = "暂无")
    public Product addProduct(@RequestBody String body) {

        Product product = gson.fromJson(body, Product.class);
        System.out.println(product.toString());
        productRepository.save(product);

        return product;
    }

   //
    @GetMapping("/product")
    @ResponseBody
    @ApiOperation(value = "获取商品列表", httpMethod = "GET", notes = "暂无")
    public List<Product> getAllProducts() {

        List<Product> productList = new ArrayList<Product>();
        productList.addAll(productRepository.findAll());
        return productList;
    }
   //
    @GetMapping(value = "/product/{id}")
    @ResponseBody
    @ApiOperation(value = "通过ID获取商品信息", httpMethod = "GET", notes = "暂无")
    public Product getproductById(@PathVariable("id") Long id) {


        return productRepository.findOne(id);
    }

    //
    @DeleteMapping("/product/{id}")
    @ResponseBody
    @ApiOperation(value = "删除销售单", httpMethod = "DELETE", notes = "暂无")
    public void deleteProduct(@RequestParam Long productId) {


        Product product = new Product();

    }

    //
    @PutMapping("/product/{id}")
    @ResponseBody
    @ApiOperation(value = "修改销售单", httpMethod = "PUT", notes = "暂无")
    public void updateProduct(@PathVariable("id") Long productId) {


        Product product = new Product();

    }
    //
    @PostMapping("/bill")
    @ResponseBody
    @Transactional
    @ApiOperation(value = "添加销售单", httpMethod = "POST", notes = "暂无")
    public BillDto addBill(@RequestBody String body) {
        System.out.println(body);
        BillDto billDto = gson.fromJson(body, BillDto.class);

        System.out.println(billDto.toString());
        Bill bill = new Bill();
        bill.setCustomerId(billDto.getCustomerId());
        bill.setDetails(billDto.getDetails());
        bill.setTotalPrices(billDto.getTotalPrices());
        Bill billId = billRepository.save(bill);

        System.out.println("billId: " + billId.getId());
        for (int i = 0; i < billDto.getProducts().size(); i++) {

            ProductDTO productDTO = new ProductDTO();

            ProductDetails productDetails = new ProductDetails();
            productDTO = billDto.getProducts().get(i);

            productDetails.setDetails(productDTO.getDetails());

            productDetails.setPrice(productDTO.getPrice());
            productDetails.setProductId(productDTO.getProductId());
            productDetails.setQuantity(productDTO.getQuantity());
            productDetails.setBillId(billId.getId());
            System.out.println(productDetails.toString());
            productDetailsRepository.save(productDetails);
        }


        System.out.println("==================================");
        billDto.setId(billId.getId());
        return billDto;
    }


    @GetMapping("/bill")
    @ResponseBody
    @Transactional
    @ApiOperation(value = "获取所有销售单", httpMethod = "GET", notes = "暂无")
    public List<BillDto> getAllBills() {
        List<Bill> billList = new ArrayList<Bill>();
        List<BillDto> billDtoList = new ArrayList<BillDto>();
        billList.addAll(billRepository.findAll());
        for (int i = 0; i < billList.size(); i++) {
            BillDto billDto = new BillDto();

            billDto.setId(billList.get(i).getId());
            billDto.setCustomerId(billList.get(i).getCustomerId());
            billDto.setDetails(billList.get(i).getDetails());
            billDto.setTotalPrices(billList.get(i).getTotalPrices());
            List<ProductDetails> productDetails = new ArrayList<ProductDetails>();
            productDetails.addAll(productDetailsRepository.findProductDetailsByBillId(billDto.getId()));
            List<ProductDTO> productDTOList = new ArrayList<ProductDTO>();
            for (int j = 0; j < productDetails.size(); j++) {
                ProductDTO productDTO = new ProductDTO();

                productDTO.setProductId(productDetails.get(j).getProductId());
                productDTO.setDetails(productDetails.get(j).getDetails());
                productDTO.setPrice(productDetails.get(j).getPrice());
                productDTO.setQuantity(productDetails.get(j).getQuantity());

                productDTOList.add(productDTO);
            }

            billDto.setProducts(productDTOList);
            billDtoList.add(billDto);

        }

        return billDtoList;
    }
    @ApiOperation(value = "通过ID获取销售单", httpMethod = "GET", notes = "暂无")
    @GetMapping(value = "/bill/{billId}")
    @ResponseBody
    @Transactional
    public BillDto getBillById(@PathVariable Long billId) {
        BillDto billDto = new BillDto();
        Bill bill = new Bill();

        bill = billRepository.findOne(billId);


        billDto.setId(bill.getId());
        billDto.setCustomerId(bill.getCustomerId());
        billDto.setDetails(bill.getDetails());
        billDto.setTotalPrices(bill.getTotalPrices());
        List<ProductDetails> productDetails = new ArrayList<ProductDetails>();
        productDetails.addAll(productDetailsRepository.findProductDetailsByBillId(billDto.getId()));
        List<ProductDTO> productDTOList = new ArrayList<ProductDTO>();
        for (int j = 0; j < productDetails.size(); j++) {
            ProductDTO productDTO = new ProductDTO();

            productDTO.setProductId(productDetails.get(j).getProductId());
            productDTO.setDetails(productDetails.get(j).getDetails());
            productDTO.setPrice(productDetails.get(j).getPrice());
            productDTO.setQuantity(productDetails.get(j).getQuantity());

            productDTOList.add(productDTO);
        }

        billDto.setProducts(productDTOList);


        return billDto;
    }

    @ApiOperation(value = "通过ID删除销售单", httpMethod = "DELETE", notes = "暂无")
    @DeleteMapping(value = "/bill/{billId}")
    @ResponseBody
    @Transactional
    public void deleteBillById(@PathVariable Long billId) {

        billRepository.delete(billId);
        productDetailsRepository.deleteByBillId(billId);
    }




}
