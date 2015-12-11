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

  /**
   * return a employee by its name
   * 
   * @param nom
   * @return employee
   */
  public Salarie findSalarieByName(String nom) {
    Salarie salarie = daoS.findByName(nom);
    return salarie;
  }

  /**
   * return a list of all employees
   * 
   * @return list of employees
   */
  public List<Salarie> findSalaries() {
    List<Salarie> salaries = daoS.findAll();
    return salaries;
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
   * creation of a new employee and apply managements rules
   * 
   * @param nom
   * @param prenom
   * @param poste
   */
  public void createSalarie(String nom, String prenom, String poste) {
    // check if the employee already exist
    if (daoS.findByNameSurnameAndPoste(nom, prenom, daoP.findByName(poste)) == null) {
      Salarie s = new Salarie(nom, prenom, daoP.findByName(poste));
      // check if the name and surname are empty
      if (!nom.isEmpty() && !prenom.isEmpty()) {
        daoS.save(s);
      }
    }
  }
}