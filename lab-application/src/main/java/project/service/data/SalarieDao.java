package project.service.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import project.entity.Poste;
import project.entity.Salarie;

@Component
@Transactional(propagation = Propagation.MANDATORY)
public class SalarieDao {
  @PersistenceContext
  private EntityManager em;

  /*
   * Return a employee from a list of one employee. This method is needed for
   * findByNumber and findByName
   */
  private Salarie getSingle(List<Salarie> salaries) {
    if (salaries.isEmpty()) {
      return null;
    }
    if (salaries.size() > 1) {
      throw new IllegalStateException("Error : several salaries with same name");
    }
    return salaries.get(0);
  }

  // Return a employee by his Id.
  public Salarie getOne(Long id) {
    return em.find(Salarie.class, id);
  }

  public List<Salarie> findAll() {
    return em.createQuery("from Salarie s").getResultList();
  }

  // return an employee by his surname
  public Salarie findByName(String nom) {
    Query query = em.createQuery("from Salarie s where s.nom = :nom");
    query.setParameter("nom", nom);
    List<Salarie> salaries = query.getResultList();
    return getSingle(salaries);
  }

  // return a employee by his name
  public Object findByFirstName(String prenom) {
    Query query = em.createQuery("from Salarie s where s.prenom = :prenom");
    query.setParameter("prenom", prenom);
    List<Salarie> salaries = query.getResultList();
    return getSingle(salaries);
  }

  // return a employee by his position
  public Object findByPoste(Poste poste) {
    Query query = em.createQuery("from Salarie s where s.poste = :poste");
    query.setParameter("poste", poste);
    List<Salarie> salaries = query.getResultList();
    return getSingle(salaries);
  }

  // return a employee by his name,surname and position
  public Object findByNameSurnameAndPoste(String nom, String prenom, Poste poste) {
    Query query = em.createQuery("from Salarie s where s.nom = :nom and s.prenom = :prenom and s.poste = :poste");
    query.setParameter("nom", nom);
    query.setParameter("prenom", prenom);
    query.setParameter("poste", poste);
    List<Salarie> salaries = query.getResultList();
    return getSingle(salaries);
  }

  // save the employee into database
  public void save(Salarie sal) {
    em.persist(sal);
  }
}
