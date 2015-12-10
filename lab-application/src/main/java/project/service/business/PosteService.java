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

  public Poste findPoste(Long id) {
    Poste poste = daoP.getOne(id);
    return poste;
  }

  public Poste findStudentByName(String nom) {
    Poste poste = daoP.findByName(nom);
    return poste;
  }

  public List<Poste> findPostes() {
    List<Poste> postes = daoP.findAll();
    return postes;
  }

  public List<Service> findServices() {
    List<Service> services = daoS.findAll();
    return services;
  }

  public void createPoste(String libelle, String service) {
    if (daoP.findByNameAndService(libelle, daoS.findByLibelle(service)) == null) {
      Poste p = new Poste(libelle, daoS.findByLibelle(service));
      if (!libelle.isEmpty()) {
        daoP.save(p);
      }
    }
  }
}