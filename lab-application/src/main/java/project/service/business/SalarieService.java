package project.service.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import project.entity.Salarie;
import project.service.data.PosteDao;
import project.service.data.SalarieDao;

@Component
@Transactional(propagation = Propagation.REQUIRED)
public class SalarieService {
  private final SalarieDao dao;
  private final PosteDao daoP;

  @Autowired
  public SalarieService(SalarieDao dao, PosteDao daoP) {
    this.dao = dao;
    this.daoP = daoP;
  }

  public Salarie findStudent(Long id) {
    Salarie salarie = dao.getOne(id);
    return salarie;
  }

  public Salarie findStudentByName(String nom) {
    Salarie salarie = dao.findByName(nom);
    return salarie;
  }

  public List<Salarie> findSalaries() {
    List<Salarie> salaries = dao.findAll();
    return salaries;
  }

  public void createSalarie(String nom, String prenom, String poste) {

    Salarie s = new Salarie();
    s.setNom(nom);
    s.setPrenom(prenom);
    s.setPoste(daoP.findByName(poste));

    dao.save(s);
  }

}