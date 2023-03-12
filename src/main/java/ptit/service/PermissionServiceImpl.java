package ptit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ptit.entity.Permission;
import ptit.repository.PermissionDAO;

@Service
public class PermissionServiceImpl implements PermissionService{
	@Autowired
	private PermissionDAO permissionDAO;
	
	public PermissionServiceImpl(PermissionDAO permissionDAO) {
		this.permissionDAO = permissionDAO;
	}
	@Override
	public List<Permission> findAll() {
		
		return this.permissionDAO.findAll();
	}
	@Override
	public Optional<Permission> findById(Long permissionID) {
		return permissionDAO.findById(permissionID);
	}

	
	
	
}
