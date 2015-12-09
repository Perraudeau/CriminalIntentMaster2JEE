package project.service.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import project.entity.IntentionCriminelle;
import project.service.data.IntentionCriminelleDao;
import project.service.data.SalarieDao;

@Component
@Transactional(propagation = Propagation.REQUIRED)
public class IntentionCriminelleService {
  private final IntentionCriminelleDao dao;
  private final SalarieDao daoS;

  @Autowired
  public IntentionCriminelleService(IntentionCriminelleDao dao, SalarieDao daoS) {
    this.dao = dao;
    this.daoS = daoS;
  }

  public IntentionCriminelle findStudent(Long id) {
    IntentionCriminelle poste = dao.getOne(id);
    return poste;
  }

  public IntentionCriminelle findIntentionCriminelleByLibelle(String libelle) {
    IntentionCriminelle ic = dao.findByLibelle(libelle);
    return ic;
  }

  public List<IntentionCriminelle> findIntentionCriminelles() {
    List<IntentionCriminelle> ics = dao.findAll();
    return ics;
  }

  public void createIntentionCriminelle(String libelle, String salarie) {

    IntentionCriminelle ic = new IntentionCriminelle();
    ic.setLibelle(libelle);
    ic.setSalarie(daoS.findByName(salarie));

    dao.save(ic);
  }

}