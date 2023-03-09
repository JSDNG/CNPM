package ptit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;

import ptit.entity.Cart;


//@Repository
public interface CartDAO  extends JpaRepository<Cart, Long>{
//	 @Query("from Cart as c ")
	List<Cart> findALL();
//
	Cart delete(Long id);
//
	List<Cart> showCart();
//	@Query("select NEW ptit.entity.Cart "+
//            "(c.cartID ,c.customerID , c.cookie, c.creatDate , ci.quantity,ci.price,p.name) "+
//            "from Cart as c,CartItem as ci, Product as p where c.name LIKE %:name%")
//
  List<Cart> findCartByName(@Param("name") String name);
//
//	

}
