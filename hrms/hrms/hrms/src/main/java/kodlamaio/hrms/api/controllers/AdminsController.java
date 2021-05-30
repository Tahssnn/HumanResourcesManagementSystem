package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.AdminService;
import kodlamaio.hrms.core.utilties.results.DataResult;
import kodlamaio.hrms.core.utilties.results.Result;
import kodlamaio.hrms.entities.concretes.Admin;

@RestController
@RequestMapping("/api/admins")
public class AdminsController {
	
	private AdminService adminService;

	@Autowired
	public AdminsController(AdminService adminService) {
		super();
		this.adminService = adminService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Admin>> getall(){
		return this.adminService.getAll();
	}
	
	@PostMapping("add")
	public Result add(@RequestBody Admin admin) {
		return this.adminService.add(admin);
		
	}
	

}
