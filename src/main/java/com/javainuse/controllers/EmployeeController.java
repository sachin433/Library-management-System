package com.javainuse.controllers;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.comviva.bookshelf.BookRowMapper1;
import com.comviva.bookshelf.Books;
import com.comviva.bookshelf.Transaction;
import com.javainuse.model.Employee;
import com.javainuse.service.EmployeeService;
@Controller

public class EmployeeController {

	
	Mapper mymap = new Mapper();
	@Autowired
	EmployeeService employeeService;
	
	
	
	public ModelAndView home(){
		return new ModelAndView("index");
	}
	@RequestMapping("/login")
	public ModelAndView loginpage() {
		return new ModelAndView("login", "emp", new Employee());
	}

	/*@RequestMapping(value="/login_user", method = RequestMethod.POST)
	public ModelAndView login_user() {
		return new ModelAndView("addEmployee", "emp", new Employee());
	}
	*/
	@RequestMapping("/welcome")
	public ModelAndView firstPage() {
		return new ModelAndView("welcome");
	}
	
	@RequestMapping(value = "/addNewEmployee", method = RequestMethod.GET)
	public ModelAndView show() {
		//ModelAndView mv=new ModelAndView("addEmployee");
		//Employee emp = new Employee();
		//mv.addObject(emp);
		
		return new ModelAndView("addEmployee", "emp", new Employee());
		//return mv;
	}
	
	//, method = RequestMethod.POST
	@PostMapping(value = "/login_user")
	public ModelAndView login_user(@ModelAttribute("emp") Employee emp) {
		/*ModelAndView mv=new ModelAndView("index");
		ModelAndView mv2=new ModelAndView("login");
		//Employee emp = new Employee();
		//mv.addObject(emp);*/
		ModelAndView mv=new ModelAndView("login");
		ModelAndView mv2=new ModelAndView("account");
		String employeeid = emp.getEmpId();
		String emppassword = emp.getPassword();
		//System.out.print("Hello");
		Employee result = mymap.EmployeeAvailable(employeeid, emppassword);
		//System.out.print(result);
		if(result == null) {
			mv.addObject("message", "Incorrect details");
			return mv;
		}
		else {
			mv2.addObject("eid", result.getEmpId());
			mv2.addObject("ename", result.getEmpName());
			mv2.addObject("eemail", result.getEmpEmail());
			return mv2; 
		}
		
		//System.out.println(result + "hello");
		//employeeService.insertEmployee(emp);
		//return new ModelAndView("account");
	}
	@RequestMapping(value = "/addNewEmployee", method = RequestMethod.POST)
	public ModelAndView processRequest(@ModelAttribute("emp") Employee emp) {
		//ModelAndView mv=new ModelAndView("index");
		//ModelAndView mv2=new ModelAndView("login");
		//Employee emp = new Employee();
		//mv.addObject(emp);
		
		employeeService.insertEmployee(emp);
		
		List<Employee> employees = employeeService.getAllEmployees();
		ModelAndView model = new ModelAndView("getEmployees");
		model.addObject("employees", employees);
		return model;
	}

	@RequestMapping("/getEmployees")
	public ModelAndView getEmployees() {
		List<Employee> employees = employeeService.getAllEmployees();
		ModelAndView model = new ModelAndView("getEmployees");
		model.addObject("employees", employees);
		return model;
	}
	
	
	@RequestMapping("/search")
	public ModelAndView book_search(@RequestParam String name) {
	
		BookRowMapper1 user1=new BookRowMapper1();
		List<Books> query=user1.BookAvailable(name);
		
		ModelAndView mv = new ModelAndView();
		   System.out.println("query size is"+query.size());
	
		      if(query.size()==0)
				return new ModelAndView("menu");
			else
		      {
		    	   //request.setAttribute("query", query);
				//mv.addObject("query", query.getBookNo());
				mv.addObject("query",query);
				//request.getRequestDispatcher("/success.jsp").forward(request, response);
				return mv;
		      }
		//return new ModelAndView("menu");
	}
	
	@RequestMapping(value="/history",method = RequestMethod.GET)
	public ModelAndView book_search_history(@RequestParam String EmpId) {

		BookRowMapper1 user1=new BookRowMapper1();
		List<Transaction> query=user1.getTransactions(EmpId);
		
		ModelAndView mv = new ModelAndView();
		   System.out.println("query size is"+query.size());
	
		      if(query.size()==0)
				return new ModelAndView("menu");
			else
		      {
				
		    	   //request.setAttribute("query", query);
				//mv.addObject("query", query.getBookNo());
				mv.addObject("query",query);
				//request.getRequestDispatcher("/success.jsp").forward(request, response);
				return mv;
		      }
		
	}
	
	@RequestMapping(value="/Bookstatus",method = RequestMethod.GET)
	public ModelAndView book_return(@RequestParam String BookNo) {
		
		ModelAndView mv = new ModelAndView("product_single");
	
		mv.addObject("BookNo",BookNo);
		
				return mv;
		      }
	

	@RequestMapping(value="/Book_alert",method = RequestMethod.GET)
	public ModelAndView book_alert(@RequestParam String BookNo) {
		
		ModelAndView mv = new ModelAndView("book-alert");
	
		mv.addObject("BookNo",BookNo);
		
				return mv;
		      }
	
	

	@RequestMapping(value="/confirm",method = RequestMethod.GET)
	public ModelAndView confirm(@RequestParam String BookNo) {
		
		ModelAndView mv = new ModelAndView("confirm");
	
		mv.addObject("BookNo",BookNo);
		
				return mv;
		      }
	
	

	@RequestMapping(value="/issue",method = RequestMethod.GET)
	public ModelAndView bookissue(@RequestParam String BookNo,@RequestParam String EmpId) {
		
		ModelAndView mv1 = new ModelAndView();
		ModelAndView mv2 = new ModelAndView("history1");
		BookRowMapper1 user1=new BookRowMapper1();
		int success=user1.Transaction(EmpId,BookNo);
		System.out.println("value of success"+success);
		 if(success==-1)
		 { mv1.setViewName("limitexceeded");
		   return mv1;
		 }
		 else
		 {
		  mv2.addObject("EmpId",EmpId);
		 
		   return mv2;
		 }	
				
				
				  
					 
		      }
	
	
	}
	
	

