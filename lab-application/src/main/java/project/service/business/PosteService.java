package project.service.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import project.entity.Poste;
import project.entity.Service;
import project.service.data.PosteDao;

@Component
@Transactional(propagation = Propagation.REQUIRED)
public class PosteService {
	private final PosteDao dao;

	@Autowired
	public PosteService(PosteDao dao) {
		this.dao = dao;
	}

	public Poste findStudent(Long id) {
		Poste poste = dao.getOne(id);
		return poste;
	}

	public Poste findStudentByName(String nom) {
		Poste poste = dao.findByName(nom);
		return poste;
	}

	public List<Poste> findPostes() {
		List<Poste> postes = dao.findAll();
		return postes;
	}

	public void createPoste(String libelle, Service service) {

		Poste emp = new Poste();
		emp.setLibelle(libelle);
		emp.setService(service);

		dao.save(emp);
	}

}