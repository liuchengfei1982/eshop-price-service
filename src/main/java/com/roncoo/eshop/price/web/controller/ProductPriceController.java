package com.roncoo.eshop.price.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.roncoo.eshop.price.model.ProductPrice;
import com.roncoo.eshop.price.service.ProductPriceService;

@RestController
@RequestMapping("/product-price")
public class ProductPriceController {

	@Autowired
	private ProductPriceService productPriceService;

	//http://192.168.56.102:8763/product-price/add?value=222&id=1&productId=2
	@RequestMapping("/add") 
	@ResponseBody
	public String add(ProductPrice productPrice) {
		try {
			productPriceService.add(productPrice);
		} catch (Exception e) {
			e.printStackTrace(); 
			return "error";
		}
		return "success";
	}
	
	@RequestMapping("/update") 
	@ResponseBody
	public String update(ProductPrice productPrice) {
		try {
			productPriceService.update(productPrice); 
		} catch (Exception e) {
			e.printStackTrace(); 
			return "error";
		}
		return "success";
	}
	
	@RequestMapping("/delete") 
	@ResponseBody
	public String delete(Long id) {
		try {
			productPriceService.delete(id); 
		} catch (Exception e) {
			e.printStackTrace(); 
			return "error";
		}
		return "success";
	}
	
	@RequestMapping("/findById") 
	@ResponseBody
	public ProductPrice findById(Long id){
		try {
			return productPriceService.findById(id);
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		return new ProductPrice();
	}

	@RequestMapping("/findByProductId")
	@ResponseBody
	public ProductPrice findByProductId(Long productId){
		try {
			return productPriceService.findByProductId(productId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ProductPrice();
	}
	
}
