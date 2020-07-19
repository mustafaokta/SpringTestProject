package gov.btk.spring.lab08.webmvc;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebMvcController {

	@Autowired
	CustomerRepository customerRepository;
	
	@RequestMapping("/hello")
	public ModelAndView sayHello() {
		Map<String, Object> model = new LinkedHashMap<>();
		model.put("name", "Foo");
		
		model.put("customers", customerRepository.findAll());
		
		return new ModelAndView("hello", model);
		
	}
}
