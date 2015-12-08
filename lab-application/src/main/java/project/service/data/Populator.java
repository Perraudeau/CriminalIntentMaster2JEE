package project.service.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import project.entity.IntentionCriminelle;
import project.entity.Poste;
import project.entity.Salarie;
import project.entity.Service;

@Component
public class Populator implements ApplicationListener<ContextRefreshedEvent> {
  @Autowired
  ServiceDao serviceDao;
  @Autowired
  PosteDao posteDao;
  @Autowired
  SalarieDao salarieDao;
  @Autowired
  IntentionCriminelleDao intentionCriminelleDao;

  boolean done = false;

  @Override
  @Transactional
  public void onApplicationEvent(ContextRefreshedEvent event) {
    if (!done) {

      serviceDao.save(new Service("Ressources humaines"));
      serviceDao.save(new Service("Service commercial"));
      serviceDao.save(new Service("Direction"));

      posteDao.save(new Poste("Directeur", serviceDao.findByName("Direction")));
      posteDao.save(new Poste("Commercial", serviceDao.findByName("Service commercial")));
      posteDao.save(new Poste("Responsable RH", serviceDao.findByName("Ressources humaines")));

      salarieDao.save(new Salarie("PERRAUDEAU", "Victor", posteDao.findByName("Directeur")));
      salarieDao.save(new Salarie("LEROUX", "Alexis", posteDao.findByName("Commercial")));
      salarieDao.save(new Salarie("BOMBEUR", "Jean", posteDao.findByName("Responsable RH")));

      intentionCriminelleDao.save(new IntentionCriminelle("Laisse trainer son caca", salarieDao.findByName("LEROUX")));
      intentionCriminelleDao
          .save(new IntentionCriminelle("Mange la bouche ouverte", salarieDao.findByName("PERRAUDEAU")));
      intentionCriminelleDao.save(new IntentionCriminelle("Fait caca sur les murs", salarieDao.findByName("BOMBEUR")));

      done = true;
    }
  }
}
