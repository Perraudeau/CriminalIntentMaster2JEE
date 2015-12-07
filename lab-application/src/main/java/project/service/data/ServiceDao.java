package project.service.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import project.entity.Service;

@Component
@Transactional(propagation = Propagation.MANDATORY)
public class ServiceDao {

  @PersistenceContext
  private EntityManager em;

  /*
   * Return a service from a list of one service. This method is needed for
   * findByNumber and findByName
   */
  private Service getSingle(List<Service> services) {
    if (services.isEmpty()) {
      return null;
    }
    if (services.size() > 1) {
      throw new IllegalStateException("Error : several services with same name");
    }
    return services.get(0);
  }

  // Return a service by its Id.
  public Service getOne(Long id) {
    return em.find(Service.class, id);
  }

  // Return a list of all services
  public List<Service> findAll() {
    return em.createQuery("from Service s").getResultList();
  }

  // Return a service from its name
  public Service findByName(String libelle) {
    Query query = em.createQuery("from Service s where s.libelle = :libelle");
    query.setParameter("libelle", libelle);
    List<Service> services = query.getResultList();
    return getSingle(services);
  }

  // save the service in the DB
  public void save(Service stu) {
    em.persist(stu);
  }
}
