package project.communication;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import project.entity.IntentionCriminelle;
import project.service.business.IntentionCriminelleService;

@Controller
@RequestMapping("/intentionCriminelles")
public class IntentionCriminelleController {
  private final IntentionCriminelleService service;

  @Autowired
  public IntentionCriminelleController(IntentionCriminelleService service) {
    this.service = service;
  }

  @RequestMapping(method = RequestMethod.GET)
  public String findIntentionCriminelles(Map<String, Object> model) {
    List<IntentionCriminelle> intentionCriminelles = service.findIntentionCriminelles();
    model.put("intentionCriminelles", intentionCriminelles);
    return "intentionCriminelle/list";
  }

  @RequestMapping(value = "/create", method = RequestMethod.GET, params = "new")
  public String showStudentForm() {
    return "intentionCriminelle/edit";
  }

  @RequestMapping(value = "/create", method = RequestMethod.POST)
  public String createIntentionCriminelle(@RequestParam Map<String, String> champs) {
    service.createIntentionCriminelle(champs.get("libelle"), champs.get("salarie"));
    return "redirect:/intentionCriminelles";
  }
}