package ptit.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ptit.entity.Product;

import ptit.repository.ProductDAO;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductDAO productDAO;
	
	
//	@Override
//	public Product findById(Long id) {
//		
//		return this.productDAO.findById();
//	}

	@Override
	public List<Product> findAll() {
		return this.productDAO.findAll();
	}


	@Override
	public Product findProductById(Long productID) {
		Product product = productDAO.findProductById(productID);
		
		
	return product;
	}


	@Override
	public List<Product> findProductCategoryALL(long categoryID) {
		 List<Product> list=this.productDAO.findProductCategoryALL(categoryID);
		return list;
	}


	@Override
	public Product findProductByName(String name) {
		Product product = productDAO.findProductByName(name);
	
	return product;
	}


	@Override
	public Page<Product> findAll(Pageable pageable) {
		return (Page<Product>) productDAO.findAll(pageable);
	}
	
}
	