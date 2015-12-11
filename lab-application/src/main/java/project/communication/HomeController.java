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
		uc.add("Ce site à été crée par Alexis LEROUX et Victor PERRAUDEAU.");
		uc.add("Il a pour but de recenser les intentions criminelles des salariés.");
		uc.add("A vos claviers, prêt, taper...");
		model.put("useCases", uc);

		return "home";
	}
}
