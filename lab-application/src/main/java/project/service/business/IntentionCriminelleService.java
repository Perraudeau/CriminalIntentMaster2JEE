package project.service.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import project.entity.IntentionCriminelle;
import project.entity.Salarie;
import project.service.data.IntentionCriminelleDao;

@Component
@Transactional(propagation = Propagation.REQUIRED)
public class IntentionCriminelleService {
  private final IntentionCriminelleDao dao;

  @Autowired
  public IntentionCriminelleService(IntentionCriminelleDao dao) {
    this.dao = dao;
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

  public void createIntentionCriminelle(String libelle, Salarie salarie) {

    IntentionCriminelle ic = new IntentionCriminelle();
    ic.setLibelle(libelle);
    ic.setSalarie(salarie);

    dao.save(ic);
  }

}