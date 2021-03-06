package project.communication;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import project.entity.Poste;
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

  /**
   * List all employees
   * 
   * @param model
   * @return list page
   */
  @RequestMapping(method = RequestMethod.GET)
  public String findSalaries(Map<String, Object> model) {
    List<Salarie> salaries = service.findSalaries();
    model.put("salaries", salaries);
    return "salarie/list";
  }

  /**
   * Show the page for create an employee
   * 
   * @param model
   * @return edit page
   */
  @RequestMapping(value = "/create", method = RequestMethod.GET, params = "new")
  public String showSalarieForm(Map<String, Object> model) {
    List<Poste> postes = service.findPostes();
    model.put("postes", postes);
    return "salarie/edit";
  }

  /**
   * handle POST of creation of a new employee
   * 
   * @param champs
   * @return redirect to the list of employees
   */
  @RequestMapping(value = "/create", method = RequestMethod.POST)
  public String createSalarie(@RequestParam Map<String, String> champs) {
    service.createSalarie(champs.get("nom"), champs.get("prenom"), champs.get("poste"));
    return "redirect:/salaries";
  }
}