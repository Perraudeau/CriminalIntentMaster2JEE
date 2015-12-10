package project.service.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import project.entity.Poste;
import project.entity.Salarie;
import project.service.data.PosteDao;
import project.service.data.SalarieDao;

@Component
@Transactional(propagation = Propagation.REQUIRED)
public class SalarieService {
  private final SalarieDao daoS;
  private final PosteDao daoP;

  @Autowired
  public SalarieService(SalarieDao dao, PosteDao daoP) {
    this.daoS = dao;
    this.daoP = daoP;
  }

  public Salarie findStudent(Long id) {
    Salarie salarie = daoS.getOne(id);
    return salarie;
  }

  public Salarie findSalarieByName(String nom) {
    Salarie salarie = daoS.findByName(nom);
    return salarie;
  }

  public List<Salarie> findSalaries() {
    List<Salarie> salaries = daoS.findAll();
    return salaries;
  }

  public List<Poste> findPostes() {
    List<Poste> postes = daoP.findAll();
    return postes;
  }

  public void createSalarie(String nom, String prenom, String poste) {
    if (daoS.findByNameSurnameAndPoste(nom, prenom, daoP.findByName(poste)) == null) {
      Salarie s = new Salarie(nom, prenom, daoP.findByName(poste));
      if (!nom.isEmpty() && !prenom.isEmpty()) {
        daoS.save(s);
      }
    }
  }
}