package ptit.service;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ptit.entity.Product;

public interface ProductService {
 
	Product findProductById(Long productID);

	List<Product> findAll();

	  List<Product> findProductCategoryALL(long categoryID);
	  
	 Product  findProductByName( String name);
	 
	 Page<Product> findAll(Pageable pageable);
}
