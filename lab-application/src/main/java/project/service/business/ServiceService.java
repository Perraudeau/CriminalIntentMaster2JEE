package project.service.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import project.entity.Service;
import project.service.data.ServiceDao;

@Component
@Transactional(propagation = Propagation.REQUIRED)
public class ServiceService {
	private final ServiceDao dao;

	@Autowired
	public ServiceService(ServiceDao dao) {
		this.dao = dao;
	}

	public Service findService(Long id) {
		Service service = dao.getOne(id);
		return service;
	}

	public Service findServiceByLibelle(String libelle) {
		Service service = dao.findByLibelle(libelle);
		return service;
	}

	public List<Service> findService() {
		List<Service> services = dao.findAll();
		return services;
	}

	public void createService(String libelle) {
		Service s = null;

		// This part avoid to recreate clone of services
		if (dao.findByLibelle(libelle) != null) {
			s = dao.findByLibelle(libelle);
		} else {
			s = new Service(libelle);
		}
		if (!libelle.isEmpty()) {
			dao.save(s);
		}
	}

}