package ptit.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

import ptit.entity.Account;
import ptit.entity.Permission;
import ptit.entity.Staff;
import ptit.service.AccountService;
import ptit.service.PermissionService;
import ptit.service.StaffService;

@Controller
public class AdminStaff {	
	@Autowired
	private StaffService staffService;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private PermissionService permissionService;
	
	@GetMapping("/admin/staff")
    public String staff(ModelMap model) {
        model.addAttribute("staffs", staffService.findAll());
        return "admin/staff";
    }
	@GetMapping("/admin/addstaff")
	public String addstaff(ModelMap model) {
		List<Permission> permissions = permissionService.findAll();
		model.addAttribute("permissions", permissions);
		Staff newstaff = new Staff();
		Account account = new Account();
		newstaff.setAccount(account);
		model.addAttribute("staffs", newstaff);
		model.addAttribute("message", "Staff Add");
		return"admin/addOrUpdate";
	}
	@PostMapping("/admin/saveOrUpdate")
	public String saveStaff(@Valid @ModelAttribute("staffs") Staff staff, BindingResult result,ModelMap model,
			Account account, @RequestParam(value ="fullname") String fullname ,@RequestParam(value ="sex", required = false, defaultValue = "false") Boolean sex,
			@RequestParam(value = "phone") String phone,@RequestParam(value = "birth")@DateTimeFormat(pattern ="yyyy-MM-dd") Date birth,
			@RequestParam(value ="cccd") String cccd,@RequestParam(value ="email") String email,
			@RequestParam(value ="password") String password,
			@RequestParam(value ="status", required = false,defaultValue = "false") Boolean status,
			SessionStatus statuss){
			Permission permission = new Permission();

			staff.setFullname(fullname);
			staff.setSex(sex);
			staff.setPhone(phone);
			staff.setBirth(birth);
			staff.setCccd(cccd);
			staff.getAccount().setEmail(email);
			staff.getAccount().setPassword(password);
			staff.getAccount().setStatus(status);	
			staff.getAccount().setPermission(permission);
		if (result.hasErrors()) {
		    return "admin/addOrUpdate";
		  }
		// save staff to database
		staffService.save(staff);
		statuss.setComplete();
		return"redirect:/admin/staff";
	}
	@GetMapping("/admin/updatestaff/{staffID}")
	public String updateStaff(@PathVariable Long staffID, ModelMap model
			 ) {
		List<Permission> permissions = permissionService.findAll();
		Optional<Staff> staff = staffService.findById(staffID);
		
		// set staff as a model attribute 
		model.addAttribute("staffs", staff);
		model.addAttribute("permissions", permissions);
		model.addAttribute("message", "Staff Update");
		return"admin/addOrUpdate";
	}
	@GetMapping("/admin/deletestaff/{staffID}")
	public String deleteStaff(@PathVariable Long staffID) {
		this.staffService.deleteById(staffID);
		return"redirect:/admin/staff";
	}
	@GetMapping("/admin/sortstaff")
	public String sortStaff(ModelMap model, @RequestParam Optional<String> field) {
		Sort sort=Sort.by(Direction.ASC, field.orElse("staffID"));
		List<Staff> ls = staffService.findAll(sort);
		model.addAttribute("staffs", ls);
		return"admin/staff";
	}

	
}
