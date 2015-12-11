package project.service.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import project.entity.Poste;
import project.entity.Service;
import project.service.data.PosteDao;
import project.service.data.ServiceDao;

@Component
@Transactional(propagation = Propagation.REQUIRED)
public class PosteService {
  private final PosteDao daoP;
  private final ServiceDao daoS;

  @Autowired
  public PosteService(PosteDao daoP, ServiceDao daoS) {
    this.daoP = daoP;
    this.daoS = daoS;
  }

  /**
   * return a position by its name
   * 
   * @param nom
   * @return position
   */
  public Poste findStudentByName(String nom) {
    Poste poste = daoP.findByName(nom);
    return poste;
  }

  /**
   * return a list of all positions
   * 
   * @return list of positions
   */
  public List<Poste> findPostes() {
    List<Poste> postes = daoP.findAll();
    return postes;
  }

  /**
   * return a list of all services
   * 
   * @return list of services
   */
  public List<Service> findServices() {
    List<Service> services = daoS.findAll();
    return services;
  }

  /**
   * creation of a new position and apply managements rules
   * 
   * @param libelle
   * @param service
   * @return save the position in database
   */
  public void createPoste(String libelle, String service) {
    // check if the position already exist
    if (daoP.findByNameAndService(libelle, daoS.findByLibelle(service)) == null) {
      Poste p = new Poste(libelle, daoS.findByLibelle(service));
      // check if the name is empty
      if (!libelle.isEmpty()) {
        daoP.save(p);
      }
    }
  }
}