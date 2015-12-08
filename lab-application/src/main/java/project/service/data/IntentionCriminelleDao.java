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

  public IntentionCriminelle getOne(Long id) {
    return em.find(IntentionCriminelle.class, id);
  }

  public List<IntentionCriminelle> findAll() {
    return em.createQuery("from IntentionCriminelle ic").getResultList();
  }

  public IntentionCriminelle findByLibelle(String libelle) {
    Query query = em.createQuery("from IntentionCriminelle ic where ic.libelle = :libelle");
    query.setParameter("libelle", libelle);
    List<IntentionCriminelle> intentionCriminelle = query.getResultList();
    return getSingle(intentionCriminelle);
  }

  public Object findBySalarie(Salarie salarie) {
    Query query = em.createQuery("from IntentionCriminelle ic where ic.salarie = :salarie");
    query.setParameter("salarie", salarie);
    List<IntentionCriminelle> intentionCriminelle = query.getResultList();
    return getSingle(intentionCriminelle);
  }

  public void save(IntentionCriminelle ic) {
    em.persist(ic);
  }
}