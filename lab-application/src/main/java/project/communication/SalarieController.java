package project.communication;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.entity.Salarie;
import project.service.business.SalarieService;

@Controller
@RequestMapping("/salaries")
public class SalarieController {
	private final SalarieService service;

	@Autowired
	public SalarieController(SalarieService service) {
		this.service = service;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String findSalaries(Map<String, Object> model) {
		List<Salarie> salaries = service.findSalaries();
		model.put("salaries", salaries);
		return "salarie/list";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET, params = "new")
	public String showStudentForm() {
		return "salarie/edit";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createSalarie(Salarie salarie) {
		service.createSalarie(salarie.getNom(), salarie.getPrenom(), salarie.getPoste());
		return "redirect:/salaries";
	}
}