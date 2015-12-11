package project.service.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import project.entity.Service;
import project.service.data.ServiceDao;

@Component
@Transactional(propagation = Propagation.REQUIRED)
public class ServiceService {
  private final ServiceDao dao;

  @Autowired
  public ServiceService(ServiceDao dao) {
    this.dao = dao;
  }

  /**
   * return a service by its name
   * 
   * @param libelle
   * @return service
   */
  public Service findServiceByLibelle(String libelle) {
    Service service = dao.findByLibelle(libelle);
    return service;
  }

  /**
   * return a list of all services
   * 
   * @return list of service
   */
  public List<Service> findService() {
    List<Service> services = dao.findAll();
    return services;
  }

  /**
   * creation of a new service and apply managements rules
   * 
   * @param nom
   * @param prenom
   * @param poste
   */
  public void createService(String libelle) {
    Service s = null;

    // check if the service already exist
    if (dao.findByLibelle(libelle) != null) {
      s = dao.findByLibelle(libelle);
    } else {
      s = new Service(libelle);

      // check if the name of the service already exist
      if (!libelle.isEmpty()) {
        dao.save(s);
      }
    }

  }

}