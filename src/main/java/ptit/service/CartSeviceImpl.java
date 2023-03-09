package ptit.service;

import java.util.List;


import org.springframework.stereotype.Service;


import ptit.entity.Cart;
import ptit.repository.CartDAO;
@Service
//@Transactional
public class CartSeviceImpl implements CartService {
	//@Autowired
	private CartDAO cartDAO;
	@Override
	public List<Cart> findAll() {
		return this.cartDAO.findALL();
	}

	
//
//	@Override
//	public void deleteById(Long id) {
//		return this.cartDAO.delete(id);
//		
//	}

	@Override
	public List<Cart> showCart() {
		
		return this .cartDAO.showCart();
	}


	@Override
	public void save(Cart cart) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public List<Cart> findCarByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

}
