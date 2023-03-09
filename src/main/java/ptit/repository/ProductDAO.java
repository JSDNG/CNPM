package ptit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ptit.entity.Product;


@Repository
public interface ProductDAO extends JpaRepository<Product, Long> {
	@Query("select NEW prit.entity.Product "+
            "(c.productID, c.name, c.description, c.price,c.quantity,c.status,"
            + "c.accountID,l.images,ca.title ) "+
            "from Product  as c AND category as ca AND listImage as l where "
            + "c.categoryID=ca.categoryID AND c.list_imageID=l.list_imageID")
	
	List<Product> findAll();
	
	Product findProductById(Long productID);
	
	
// tim danh sach product theo cetegory
	 @Query("FROM Product WHERE categoryID = :categoryID")
	    List<Product> findProductCategoryALL(long categoryID);
	
	 
// tim 1 san pham theo ten cua no
	 @Query("select NEW prit.entity.Product "+
	            "(c.productID, c.name, c.description, c.price,c.quantity,c.status,"
	            + "c.accountID,l.images,ca.title ) "+
	            "from Product  as c AND category as ca AND listImage as l where c.name LIKE %:name% "
	            + "AND c.categoryID=ca.categoryID AND c.list_imageID=l.list_imageID")
	Product findProductByName(@Param("name") String name);
}
