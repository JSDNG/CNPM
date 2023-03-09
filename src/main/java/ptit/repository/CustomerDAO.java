package ptit.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ptit.entity.Customer;

@Repository
public interface CustomerDAO extends JpaRepository<Customer ,Long>{

	List<Customer> findALL();

	Optional<Customer> findById(Long customerID);

//	Customer Save(Customer customer);
//
//	Customer UpDate(BigInteger staffID, Staff staff);
//
//	Customer ReMove(BigInteger staffID);
//	

}
