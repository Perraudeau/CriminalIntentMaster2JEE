package project.communication;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.entity.Poste;
import project.service.business.PosteService;

@Controller
@RequestMapping("/postes")
public class PosteController {
  private final PosteService service;

  @Autowired
  public PosteController(PosteService service) {
    this.service = service;
  }

  @RequestMapping(method = RequestMethod.GET)
  public String findPostes(Map<String, Object> model) {
    List<Poste> postes = service.findPostes();
    model.put("postes", postes);
    return "poste/list";
  }

  @RequestMapping(value = "/create", method = RequestMethod.GET, params = "new")
  public String showStudentForm() {
    return "poste/edit";
  }

  @RequestMapping(value = "/create", method = RequestMethod.POST)
  public String createPoste(Poste poste) {
    service.createPoste(poste.getLibelle(), poste.getService());
    return "redirect:/postes";
  }
}