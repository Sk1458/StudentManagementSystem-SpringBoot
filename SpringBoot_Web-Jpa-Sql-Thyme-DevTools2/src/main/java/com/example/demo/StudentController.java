package com.example.demo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {

	@Autowired
	StuMgmtRepo srepo;
	
	@RequestMapping("/home")
	public String home() {
		
		return "home";
	}
	
	@RequestMapping(value = "/insert") //@RequestMapping are GET method by default, so we need not mention method = RequestMethod.GET
	public String insert(Model model) {
		StuMgmtEntity ent = new StuMgmtEntity();
		model.addAttribute("stuForm", ent);
		
		return "insert";
	}
	
	@RequestMapping(value = "/displayStudents", method = RequestMethod.POST)
	public String enteredValue(@ModelAttribute ("stuForm") StuMgmtEntity stuForm, Model model) {
		
		Optional<StuMgmtEntity> existingStudent = srepo.findById(stuForm.getId());
		
		if(existingStudent.isPresent()) {
			model.addAttribute("errorMessage", "Id already exists");
			return "insert";
		}
		else {
			srepo.save(stuForm);
			
			model.addAttribute("stuData", List.of(stuForm));
			
			return "displayStudents";
		}
	}
	
	@RequestMapping(value = "/update")
	public String update(Model model) {
		StuMgmtEntity ent2 = new StuMgmtEntity();
		model.addAttribute("upForm", ent2);
		
		return "update";
	}
	
	@RequestMapping(value = "/updateStatus")
	public String updateStatus(@ModelAttribute ("upForm") StuMgmtEntity upForm, Model model) {
		
		Optional<StuMgmtEntity> existingEntityOpt = srepo.findById(upForm.getId());
		
		if(existingEntityOpt.isPresent()) {
			 StuMgmtEntity existingEntity = existingEntityOpt.get();
		        
			 	if (upForm.getName() != null && !upForm.getName().isEmpty()) {
		            existingEntity.setName(upForm.getName());
		        }

		        if (upForm.getBranch() != null && !upForm.getBranch().isEmpty()) {
		            existingEntity.setBranch(upForm.getBranch());
		        }

		        if (upForm.getCity() != null && !upForm.getCity().isEmpty()) {
		            existingEntity.setCity(upForm.getCity());
		        }

		        if (upForm.getAge() != 0) {  // Since age is a number, we check if it's not null
		            existingEntity.setAge(upForm.getAge());
		        }

		        if (upForm.getRollno() != null && !upForm.getRollno().isEmpty()) {
		            existingEntity.setRollno(upForm.getRollno());
		        }

		        if (upForm.getCourse() != null && !upForm.getCourse().isEmpty()) {
		            existingEntity.setCourse(upForm.getCourse());
		        }
		        
		        srepo.save(existingEntity);
		        
		        model.addAttribute("message", "Student details updated successfully!");
		}
		else {
			model.addAttribute("message", "Student with ID " + upForm.getId() + " does not exist.");
		}
		
		return "updateStatus";
	}
	
	@RequestMapping(value = "/delete")
	public String delete(Model model) {
		StuMgmtEntity ent4 = new StuMgmtEntity();
		model.addAttribute("idObj", ent4);
		
		return "delete";
	}
	
	@RequestMapping(value = "/deleteStatus")
	public String deleteStatus(@ModelAttribute ("idObj") StuMgmtEntity idObj, Model model) {
		
		Optional<StuMgmtEntity> studentOpt = srepo.findById(idObj.getId());
	    
	    if (studentOpt.isPresent()) {
	        
	    	srepo.deleteById(idObj.getId());
	    		model.addAttribute("message", "Student with ID " + idObj.getId() + " has been successfully deleted.");
	    } 
	    else {
	        
	        model.addAttribute("message", "Student with ID " + idObj.getId() + " does not exist.");
	    }
		
		return "deleteStatus";
	}
	
	@RequestMapping(value = "/view")
	public String view(Model model) {
		
		List<StuMgmtEntity> viewData = (List<StuMgmtEntity>) srepo.findAll();
		model.addAttribute("stuView", viewData);
		
		return "view";
	}
	
	
	@RequestMapping(value = "/search")
	public String search(Model model) {
		
		return "search";
	}
	
	
	@PostMapping("/searchResults")
	public String searchResults(@RequestParam("field1") String field1, @RequestParam("fieldValue1") String fieldValue1, 
	 							 @RequestParam("field2") String field2, @RequestParam("fieldValue2") String fieldValue2,
	 							 @RequestParam("field3") String field3, @RequestParam("fieldValue3") String fieldValue3, 
	 							 Model model) {
			
		List<StuMgmtEntity> results = (List<StuMgmtEntity>) srepo.findAll();
		results = filterByField(results, field1, fieldValue1);
				
		if (!field2.equals("none") && fieldValue2 != null && !fieldValue2.isEmpty()) {
			results = filterByField(results, field2, fieldValue2);
		}

			    
		if (!field3.equals("none") && fieldValue3 != null && !fieldValue3.isEmpty()) {
			results = filterByField(results, field3, fieldValue3);
		}

			    // Add results to the model
		model.addAttribute("searchResults", results);
		return "searchResults";		
	 }

	private List<StuMgmtEntity> filterByField(List<StuMgmtEntity> students, String field, String value) {
		
		 switch (field) {
	        case "name":
	            return students.stream()
	                    .filter(student -> student.getName().equalsIgnoreCase(value))
	                    .collect(Collectors.toList());
	        case "city":
	            return students.stream()
	                    .filter(student -> student.getCity().equalsIgnoreCase(value))
	                    .collect(Collectors.toList());
	        case "branch":
	            return students.stream()
	                    .filter(student -> student.getBranch().equalsIgnoreCase(value))
	                    .collect(Collectors.toList());
	        case "age":
	            return students.stream()
	                    .filter(student -> student.getAge() == Integer.parseInt(value))
	                    .collect(Collectors.toList());
	        case "course":
	            return students.stream()
	                    .filter(student -> student.getCourse().equalsIgnoreCase(value))
	                    .collect(Collectors.toList());
	        default:
	            return students;
	    }
	}


}