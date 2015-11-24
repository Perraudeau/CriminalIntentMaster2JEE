package project.communication;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HomeController {

	@RequestMapping(method = RequestMethod.GET)
	public String allUseCases(Map<String, Object> model) {
		List<String> uc = new ArrayList<>();
		uc.add("List all salarié (GET '/salarie')");
		uc.add("Create a student (GET '/salaries/create?new' && POST '/salaries/create')");

		model.put("useCases", uc);

		return "home";
	}
}
