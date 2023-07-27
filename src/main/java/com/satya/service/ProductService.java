package com.satya.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satya.model.Product;
import com.satya.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
	
	public List<Product> saveAllProduct(List<Product> productList){
		return productRepository.saveAll(productList);
	}
	
	public List<Product> getProducts(){
		return productRepository.findAll();
	}
	
	public Product getProductById(int id) {
		return productRepository.findById(id).orElse(null);
	}

	public List<Product> getProductByName(String name) {
		return productRepository.findByName(name);
	}
	
	public String deleteProduct(int id) {
		productRepository.deleteById(id);
		return "Deleted Product having id = "+id;
	}
	
	public Product updateProduct(Product product) {
		Product currentProduct = productRepository.findById(product.getId()).orElse(null);
		currentProduct.setName(product.getName());
		currentProduct.setDescription(product.getDescription());
		return productRepository.save(currentProduct);
	}
}
