package com.spring.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	@Autowired
	EmployeeDao employeeDao;
	
	@RequestMapping("/")
	public String home() {
		return "index";
	}
	@RequestMapping("/addEmp")
	public String addEmpForm(Model model) {
		model.addAttribute("employee", new Employee());
		return "addEmpForm";	
	}
	@RequestMapping(value="/view")
	public ModelAndView save(@ModelAttribute("employee") Employee employee) {
		employeeDao.save(employee);
		return new ModelAndView("redirect:/viewEmp");
	}
	@RequestMapping("/viewEmp")
	public ModelAndView viewEmpDetails(@ModelAttribute Employee employee) {
		List<Employee> employeeList = employeeDao.getEmployeeRSE();
		return new ModelAndView("viewEmpDetails","list",employeeList);
	}
	@RequestMapping(value="/edit/{empId}")
	public ModelAndView edit(@PathVariable int empId) {
		Employee employee = employeeDao.getEmployeeById(empId) ;
		return new ModelAndView("empeditform","command",employee);
	}
	@RequestMapping(value="/delete/{empId}")
	public ModelAndView delete(@PathVariable int empId) {
		employeeDao.delete(empId);
		return new ModelAndView("redirect:/viewEmp");
	}
}