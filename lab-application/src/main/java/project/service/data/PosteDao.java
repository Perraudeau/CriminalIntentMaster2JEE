package project.service.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import project.entity.Poste;
import project.entity.Service;

@Component
@Transactional(propagation = Propagation.MANDATORY)
public class PosteDao {

  @PersistenceContext
  private EntityManager em;

  /*
   * Return a position from a list of one position. This method is needed for
   * findByNumber and findByName
   */
  private Poste getSingle(List<Poste> postes) {
    if (postes.isEmpty()) {
      return null;
    }
    if (postes.size() > 1) {
      throw new IllegalStateException("Error : several postes with same name");
    }
    return postes.get(0);
  }

  // Return a position by its Id.
  public Poste getOne(Long id) {
    return em.find(Poste.class, id);
  }

  // Return a list of all positions
  public List<Poste> findAll() {
    return em.createQuery("from Poste p").getResultList();
  }

  // Return a position from its name
  public Poste findByName(String libelle) {
    Query query = em.createQuery("from Poste p where p.libelle = :libelle");
    query.setParameter("libelle", libelle);
    List<Poste> postes = query.getResultList();
    return getSingle(postes);
  }

  // Return a position by its service
  public Poste findByService(Service service) {
    Query query = em.createQuery("from Poste p where p.service = :service");
    query.setParameter("service", service);
    List<Poste> postes = query.getResultList();
    return getSingle(postes);
  }

  // Return a position by its service and name
  public Poste findByNameAndService(String libelle, Service service) {
    Query query = em.createQuery("from Poste p where p.service = :service and p.libelle = :libelle");
    query.setParameter("service", service);
    query.setParameter("libelle", libelle);
    List<Poste> postes = query.getResultList();
    return getSingle(postes);
  }

  // save the position in the DB
  public void save(Poste p) {
    em.persist(p);
  }
}
