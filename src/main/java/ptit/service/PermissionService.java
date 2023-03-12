package ptit.service;

import java.util.List;
import java.util.Optional;

import ptit.entity.Permission;

public interface PermissionService {
	Optional<Permission> findById(Long permissionID);
	
	List<Permission> findAll();
	
}
