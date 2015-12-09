package project.communication;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import project.entity.Service;
import project.service.business.ServiceService;

@Controller
@RequestMapping("/services")
public class ServiceController {
  private final ServiceService service;

  @Autowired
  public ServiceController(ServiceService service) {
    this.service = service;
  }

  @RequestMapping(method = RequestMethod.GET)
  public String findSalaries(Map<String, Object> model) {
    List<Service> services = service.findService();
    model.put("services", services);
    return "service/list";
  }

  @RequestMapping(value = "/create", method = RequestMethod.GET, params = "new")
  public String showStudentForm() {
    return "service/edit";
  }

  @RequestMapping(value = "/create", method = RequestMethod.POST)
  public String createService(@RequestParam Map<String, String> champs) {
    service.createService(champs.get("libelle"));
    return "redirect:/services";
  }
}