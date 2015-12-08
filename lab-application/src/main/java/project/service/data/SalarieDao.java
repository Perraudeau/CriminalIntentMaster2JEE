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

	private Salarie getSingle(List<Salarie> salaries) {
		if (salaries.isEmpty()) {
			return null;
		}
		if (salaries.size() > 1) {
			throw new IllegalStateException("Plusieurs salariés avec le même nom?");
		}
		return salaries.get(0);
	}

	public Salarie getOne(Long id) {
		return em.find(Salarie.class, id);
	}

	public List<Salarie> findAll() {
		return em.createQuery("from Salarie s").getResultList();
	}

	public Salarie findByName(String nom) {
		Query query = em.createQuery("from Salarie s where s.nom = :nom");
		query.setParameter("nom", nom);
		List<Salarie> salaries = query.getResultList();
		return getSingle(salaries);
	}

	public Object findByFirstName(String prenom) {
		Query query = em.createQuery("from Salarie s where s.prenom = :prenom");
		query.setParameter("prenom", prenom);
		List<Salarie> salaries = query.getResultList();
		return getSingle(salaries);
	}

	public Object findByPoste(Poste poste) {
		Query query = em.createQuery("from Salarie s where s.poste = :poste");
		query.setParameter("poste", poste);
		List<Salarie> salaries = query.getResultList();
		return getSingle(salaries);
	}

	public void save(Salarie stu) {
		em.persist(stu);
	}
}
