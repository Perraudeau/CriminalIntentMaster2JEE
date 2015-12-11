package project.communication;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import project.entity.Poste;
import project.entity.Service;
import project.service.business.PosteService;

@Controller
@RequestMapping("/postes")
public class PosteController {
  private final PosteService PosteService;

  @Autowired
  public PosteController(PosteService service) {
    this.PosteService = service;
  }

  /**
   * List all positions
   * 
   * @param model
   * @return list page
   */
  @RequestMapping(method = RequestMethod.GET)
  public String findPostes(Map<String, Object> model) {
    List<Poste> postes = PosteService.findPostes();
    model.put("postes", postes);
    return "poste/list";
  }

  /**
   * Show the page for create a position
   * 
   * @param model
   * @return edit page
   */
  @RequestMapping(value = "/create", method = RequestMethod.GET, params = "new")
  public String showPosteForm(Map<String, Object> model) {
    List<Service> listServices = PosteService.findServices();
    model.put("services", listServices);
    return "poste/edit";
  }

  /**
   * handle POST of creation of a new position
   * 
   * @param champs
   * @return redirect to the list of criminal intents
   */
  @RequestMapping(value = "/create", method = RequestMethod.POST)
  public String createPoste(@RequestParam Map<String, String> champs) {
    PosteService.createPoste(champs.get("libelle"), champs.get("service"));
    return "redirect:/postes";
  }
}