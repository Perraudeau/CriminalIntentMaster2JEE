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
	public String allRegleGestion(Map<String, Object> model) {
		List<String> rg = new ArrayList<>();
		rg.add("Les caractères accentué sont pris en compte.");
		rg.add("Vous ne pouvez pas ajouter de service/poste/salarié/intention criminelle vide ou avec un espace");
		rg.add("Vous ne pouvez pas ajouter un poste à un service inexistant");
		rg.add("Vous ne pouvez pas ajouter un salarié à un poste inexistant");
		rg.add("Vous ne pouvez pas ajouter une intention criminelle à un salarié inexistant");
		model.put("regleGestion", rg);

		return "home";

	}
}
