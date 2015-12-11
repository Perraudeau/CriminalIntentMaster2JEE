package project.service.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import project.entity.IntentionCriminelle;
import project.entity.Salarie;

@Component
@Transactional(propagation = Propagation.MANDATORY)
public class IntentionCriminelleDao {
  @PersistenceContext
  private EntityManager em;

  /*
   * Return a intent from a list of one intent. This method is needed for
   * findByNumber and findByName
   */
  private IntentionCriminelle getSingle(List<IntentionCriminelle> intentionCriminelle) {
    if (intentionCriminelle.isEmpty()) {
      return null;
    }
    if (intentionCriminelle.size() > 1) {
      throw new IllegalStateException("Error : several ic with same name");
    }
    return intentionCriminelle.get(0);
  }

  // return one criminal intent
  public IntentionCriminelle getOne(Long id) {
    return em.find(IntentionCriminelle.class, id);
  }

  // return a list of all criminal intents
  public List<IntentionCriminelle> findAll() {
    return em.createQuery("from IntentionCriminelle ic").getResultList();
  }

  // return a criminal intent found by its name
  public IntentionCriminelle findByLibelle(String libelle) {
    Query query = em.createQuery("from IntentionCriminelle ic where ic.libelle = :libelle");
    query.setParameter("libelle", libelle);
    List<IntentionCriminelle> intentionCriminelle = query.getResultList();
    return getSingle(intentionCriminelle);
  }

  // return a criminal intent found by its employee
  public Object findBySalarie(Salarie salarie) {
    Query query = em.createQuery("from IntentionCriminelle ic where ic.salarie = :salarie");
    query.setParameter("salarie", salarie);
    List<IntentionCriminelle> intentionCriminelle = query.getResultList();
    return getSingle(intentionCriminelle);
  }

  // return a criminal intent found by its name and employee
  public Object findByLibelleAndSalarie(String libelle, Salarie salarie) {
    Query query = em.createQuery("from IntentionCriminelle ic where ic.libelle = :libelle and ic.salarie = :salarie");
    query.setParameter("libelle", libelle);
    query.setParameter("salarie", salarie);
    List<IntentionCriminelle> intentionCriminelle = query.getResultList();
    return getSingle(intentionCriminelle);
  }

  // save the criminal intent into database
  public void save(IntentionCriminelle ic) {
    em.persist(ic);
  }
}