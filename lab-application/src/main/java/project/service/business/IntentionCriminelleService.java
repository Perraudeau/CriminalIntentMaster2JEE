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

  public IntentionCriminelle findIntentionCriminelle(Long id) {
    IntentionCriminelle poste = daoIc.getOne(id);
    return poste;
  }

  public IntentionCriminelle findIntentionCriminelleByLibelle(String libelle) {
    IntentionCriminelle ic = daoIc.findByLibelle(libelle);
    return ic;
  }

  public List<IntentionCriminelle> findIntentionCriminelles() {
    List<IntentionCriminelle> ics = daoIc.findAll();
    return ics;
  }

  public List<Salarie> findSalaries() {
    List<Salarie> salaries = daoS.findAll();
    return salaries;
  }

  public void createIntentionCriminelle(String libelle, String salarie) {
    if (daoIc.findByLibelleAndSalarie(libelle, daoS.findByName(salarie)) == null) {
      IntentionCriminelle ic = new IntentionCriminelle(libelle, daoS.findByName(salarie));
      if (!libelle.isEmpty()) {
        daoIc.save(ic);
      }
    }
  }
}