package project.communication;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import project.entity.IntentionCriminelle;
import project.entity.Salarie;
import project.service.business.IntentionCriminelleService;

@Controller
@RequestMapping("/intentionCriminelles")
public class IntentionCriminelleController {
  private final IntentionCriminelleService service;

  @Autowired
  public IntentionCriminelleController(IntentionCriminelleService service) {
    this.service = service;
  }

  /**
   * List all criminal intents
   * 
   * @param model
   * @return list page
   */
  @RequestMapping(method = RequestMethod.GET)
  public String findIntentionCriminelles(Map<String, Object> model) {
    List<IntentionCriminelle> intentionCriminelles = service.findIntentionCriminelles();
    model.put("intentionCriminelles", intentionCriminelles);
    return "intentionCriminelle/list";
  }

  /**
   * Show the page for create a criminal intent
   * 
   * @param model
   * @return edit page
   */
  @RequestMapping(value = "/create", method = RequestMethod.GET, params = "new")
  public String showIntentionForm(Map<String, Object> model) {
    List<Salarie> salaries = service.findSalaries();
    model.put("salaries", salaries);
    return "intentionCriminelle/edit";
  }

  /**
   * handle POST of creation of a new criminal intent
   * 
   * @param champs
   * @return redirect to the list of criminal intents
   */
  @RequestMapping(value = "/create", method = RequestMethod.POST)
  public String createIntentionCriminelle(@RequestParam Map<String, String> champs) {
    service.createIntentionCriminelle(champs.get("libelle"), champs.get("salarie"));
    return "redirect:/intentionCriminelles";
  }
}