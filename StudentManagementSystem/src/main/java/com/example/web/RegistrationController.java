package com.example.web;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.bean.Student;
import com.example.repo.StudentRepository;

/**
 * @author vinod.nagulkar
 *
 */
@Controller
public class RegistrationController {

	@Autowired
	Student stud;
	
	@Autowired(required=true)
	@Qualifier("myRep")
	StudentRepository myRepository;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String openHomePage() {
		return "home";
	}
	/*
	 * =============================================================================
	 * ============================Login============================================
	 */

	@RequestMapping(value = "/loginOpener", method = RequestMethod.GET)
	public String loginPageOpener(Model model) {
		model.addAttribute("loginForm", new Student());
		return "login";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String login(Model model,@ModelAttribute("loginForm")Student student,RedirectAttributes redirectAttributes) 
	{
		
		Student s=myRepository.findByEmail(student.getEmail());
		
		if(student.getEmail().equals(s.getEmail()) && student.getPassword().contentEquals(s.getPassword()))
		{
		  model.addAttribute("studlogininfo", s);
		  return "dashboard";
		}
		
		else {
			redirectAttributes.addFlashAttribute("loginerror", "Please enter username & password.");
		}
		redirectAttributes.addFlashAttribute("error", "Wrong Username or password!");

		return "redirect:/loginOpener";
		
	}

	/*
	 * ======================================================================================================================
	 * ========================Registration==================================================================================
	 */
	@RequestMapping(value = "/registerOpener", method = RequestMethod.GET)
	public String registerStudent(Model model) {
		model.addAttribute("registrationForm", stud);
		return "registration";

	}

	
	@RequestMapping(value = "/register", method = {RequestMethod.POST,RequestMethod.GET})
	public String saveStudent(Model model, @ModelAttribute("registrationForm") Student stud,RedirectAttributes redirectAttributes) {
		
		if(stud.getId()==null) 
		{
			Student s=myRepository.findByEmail(stud.getEmail());
			if(s==null)
			myRepository.save(stud);
			else
			{
				redirectAttributes.addFlashAttribute("error", "Email ID already registered with different user!");
				return "redirect:registerOpener";
			}
		}
		else if(stud.getId()!=null) 
		{
		myRepository.save(stud);
		}
		
		model.addAttribute("getStudent", stud);
		return "home";

	}

	@RequestMapping(value = "/viewStudent")
	public String displayStudent(Model model) {

		model.addAttribute("getAllStudents", myRepository.findAll());
		return "viewStudents";

	}
	
	/*
*========================================================================================================================
*password reset
*============================================================================================================================
*/
	
	@RequestMapping(value="/ForgetPassword", method = RequestMethod.GET)
	public String passwordResetOpener(Model model) 
	{
		
		model.addAttribute("passwordResetForm", new Student());
		return "passwordResetForm";
		
	}
	
	@RequestMapping(value="/resetPassword")
	public String resetPassword(Model model, @ModelAttribute("passwordResetForm")Student student)
	{
		myRepository.updatePassword(student.getEmail(),student.getPassword());
		return "redirect:loginOpener/";
		
	}
	
	
	/* =====================================================student update========================================================================
	 * ==========================================================================================================================*/
	
	@RequestMapping(value="/updateStudent", method=RequestMethod.GET)
	public String editStudent(Model model,@RequestParam("id")Integer id,RedirectAttributes redirectAttributes) 
	{
		
		Student stud=myRepository.getOne(id);
		model.addAttribute("registrationForm", stud);
		
		model.addAttribute("student", stud);
		redirectAttributes.addFlashAttribute("success","Record added successfully!!!");
		redirectAttributes.addFlashAttribute("error","Ooops! Something went wrong!");
		return "registration";
		
	}
	
	@RequestMapping(value="/deleteStudent")
	public String deleteStudent(Model model,@RequestParam("id")Integer id) 
	{
		
		Student s=myRepository.getOne(id);
		myRepository.delete(s);
		return "redirect:/viewStudent";
	}
	@ModelAttribute("getAllStudents")
	public List<Student> getAllStudents(Model model) 
	{
		return myRepository.findAll();
		
		
	}
	
	@RequestMapping("aboutus")
	public String viewAboutUsPage(Model model) 
	{
		return "aboutus";
		
	}
	
	@RequestMapping("contactus")
	public String viewContactUsPage() 
	{
		return "contactus";
	}
	
	
	@RequestMapping("/services")
	public String viewServices() {
		
		return "service";
		
	}
	
	@RequestMapping("/java")
	public String viewJavaPage() {
		return "java";
	}
	
	@RequestMapping("/angular")
	public String viewAngularPage() {
		return "angular";
	}
}
