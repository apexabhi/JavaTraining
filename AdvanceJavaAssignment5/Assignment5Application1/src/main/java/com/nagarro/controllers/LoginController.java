package com.nagarro.controllers;
import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.dto.Book;
import com.nagarro.dto.User;
import com.nagarro.service.BookService;
import com.nagarro.service.UserService;

@Controller
public class LoginController {
	@Autowired
	private UserService us;
	@Autowired
	private BookService bs;
	@RequestMapping("/LogIn")
	public ModelAndView logIn(HttpServletRequest request, HttpServletResponse response) {
		HttpSession httpSession = request.getSession();
		ModelAndView mv = new ModelAndView();
		String uname = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		if(us.checkUser(uname, pwd)) {
			httpSession.setAttribute("username",uname);
			System.out.println("login successfull");
			return new ModelAndView("redirect:/show");
			
		}
		httpSession.setAttribute("msg", "Invalid credentials!! Please Try To Login Again!!");
		System.out.println("login unsuccessful");
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping("/SignUp")
	public ModelAndView signUp(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		HttpSession httpSession = request.getSession();
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		User user=new User();
		user.setPassword(pwd);
		user.setUserId(userid);
		us.saveUser(user);
		httpSession.setAttribute("msg", "Registration Successful!!");
		System.out.println("Registration successful");
		mv.setViewName("index");
		return mv;
	}
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public ModelAndView addBook(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value="bookcode") int bookCode, @RequestParam(value="bookname") String bookName,
			@RequestParam(value="author") String author,@RequestParam(value="added") String date) {
		HttpSession httpSession = request.getSession();
		Book b=new Book(bookCode,bookName,author,date);
		System.out.println(b.getBookCode());
		System.out.println(b.getBookName());
		System.out.println(b.getAuthor());
		System.out.println(b.getDate());
		bs.addBook(b);
		httpSession.setAttribute("msg1", "The book added successfully!");
		return new ModelAndView("redirect:/show");
	}
	
	@RequestMapping("/delete")
	public ModelAndView deleteBook(HttpServletRequest request, HttpServletResponse response,@RequestParam("code") int code) {
		bs.deleteBook(code);
		HttpSession httpSession = request.getSession();
		httpSession.setAttribute("msg1", "The book deleted successfully!");
		return new ModelAndView("redirect:/show");
		
	}
	
	@RequestMapping("/edit")
	public ModelAndView editBook( HttpServletRequest request, HttpServletResponse response,@RequestParam(value="bookcode") int bookCode, @RequestParam(value="bookname") String bookName,
			@RequestParam(value="author") String author,@RequestParam(value="added") String date) {
		HttpSession httpSession = request.getSession();
		Book book=new Book(bookCode,bookName,author,date);
		bs.update(book, bookCode);
		httpSession.setAttribute("msg1", "The book updated successfully!");
		return new ModelAndView("redirect:/show");
	}
	@RequestMapping("/Logout")
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		HttpSession httpSession = request.getSession();
		httpSession.setAttribute("msg", "The user logged out successfully");
		httpSession.removeAttribute("username");
		mv.setViewName("index");
		System.out.println("Logout Successful");
		return mv;
	}
	
	@RequestMapping("/show")
	public ModelAndView showBook(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		Book[] book=bs.getBooks();
		if(book!=null) {
			mv.addObject("books",book);
		}
		mv.setViewName("libraryhome");
		return mv;
	}
}