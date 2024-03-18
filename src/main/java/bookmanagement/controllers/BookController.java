package bookmanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import bookmanagement.models.AuthorDTO;
import bookmanagement.models.BookRequestDTO;
import bookmanagement.models.BookResponseDTO;
import bookmanagement.persistant.AuthorRepository;
import bookmanagement.persistant.BookRepository;
import bookmanagement.utils.ResultMessage;

@Controller
public class BookController {
	@Autowired
	BookRepository book_repo;
	
	@Autowired
	AuthorRepository author_repo;
	
	@GetMapping("/")
	public String header() {
		return "header";
	}
	
	@RequestMapping(value="/books",method=RequestMethod.GET)
	public String display(ModelMap model) {
		List<BookResponseDTO> books=book_repo.findAll();

		model.addAttribute("books",books);
		return "display";
		
	}
	
	
	@GetMapping("/addbook")
	public ModelAndView add(ModelMap model) {
		List<AuthorDTO> authors=author_repo.findAll();
		model.addAttribute("authors",authors);
		
		return new ModelAndView("add_book","book",new BookRequestDTO());
	}
	
	@PostMapping("/addbook")
	public String add (@ModelAttribute("book")@Validated BookRequestDTO book,BindingResult bResult,ModelMap m){

	BookRepository book_repo=new  BookRepository();
	if(bResult.hasErrors()) {
		m.addAttribute("book",book);
		return "add_book";
		
	}
	
	else {
		ResultMessage rm=book_repo.add(book);
		if(rm.getResult()==0) {
			m.addAttribute("errors",rm.getMessage());
			m.addAttribute("book",book);
			return "add_book";
		}
		
		return "redirect:/books";
		
	}
	
}
	@GetMapping("/edit/{code}")
	public ModelAndView edit(@PathVariable String code) {
		BookResponseDTO book=book_repo.findByCode(code);

		return new ModelAndView("edit_book","book",book);
	}
	
	
	@PostMapping("/edit")
	public String edit(@ModelAttribute("book")@Validated BookRequestDTO book,BindingResult bResult,ModelMap m) {
		if(bResult.hasErrors()) {
			m.addAttribute("book",book);
			return "edit_book";
			
		}
		
		
		else {
			int rs=book_repo.edit(book);
			if(rs==0) {
				m.addAttribute("errors", "Database SQL Exception");
				m.addAttribute("book", book);
				return "edit_book";				
			}
			//response.sendRedirect("books");
			return "redirect:/books";
	}
				
	}
	
	
	@GetMapping("/delete/{code}")
	public String delete(@PathVariable String code) {
		
		book_repo.delete(code);
		return "redirect:/books";	
		}

	
	
	
	
	}
	
	
	

