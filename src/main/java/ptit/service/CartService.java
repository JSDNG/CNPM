package ptit.service;

import java.util.List;

import ptit.entity.Cart;



public interface CartService {
	List<Cart> findAll();

   

    

    void save(Cart cart);
    
    void deleteById(Long id);
    
    List<Cart> showCart();
    
    List<Cart> findCarByName(String name);
}
