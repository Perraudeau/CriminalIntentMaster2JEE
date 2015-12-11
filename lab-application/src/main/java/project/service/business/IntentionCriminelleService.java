package project.service.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import project.entity.IntentionCriminelle;
import project.entity.Salarie;
import project.service.data.IntentionCriminelleDao;
import project.service.data.SalarieDao;

@Component
@Transactional(propagation = Propagation.REQUIRED)
public class IntentionCriminelleService {
  private final IntentionCriminelleDao daoIc;
  private final SalarieDao daoS;

  @Autowired
  public IntentionCriminelleService(IntentionCriminelleDao dao, SalarieDao daoS) {
    this.daoIc = dao;
    this.daoS = daoS;
  }

  /**
   * return a criminal intent by its name
   * 
   * @param libelle
   * @return position
   */
  public IntentionCriminelle findIntentionCriminelleByLibelle(String libelle) {
    IntentionCriminelle ic = daoIc.findByLibelle(libelle);
    return ic;
  }

  /**
   * Find all criminal intents
   * 
   * @return list of criminal intents
   */
  public List<IntentionCriminelle> findIntentionCriminelles() {
    List<IntentionCriminelle> ics = daoIc.findAll();
    return ics;
  }

  /**
   * Find all employees
   * 
   * @return list of employees
   */
  public List<Salarie> findSalaries() {
    List<Salarie> salaries = daoS.findAll();
    return salaries;
  }

  /**
   * creation of a new criminal intention and apply managements rules
   * 
   * @param libelle
   * @param salarie
   * @return save the criminal intention in database
   */
  public void createIntentionCriminelle(String libelle, String salarie) {
    // check if the criminal intent already exist
    if (daoIc.findByLibelleAndSalarie(libelle, daoS.findByName(salarie)) == null) {
      IntentionCriminelle ic = new IntentionCriminelle(libelle, daoS.findByName(salarie));
      // check if the name is empty
      if (!libelle.isEmpty()) {
        daoIc.save(ic);
      }
    }
  }
}