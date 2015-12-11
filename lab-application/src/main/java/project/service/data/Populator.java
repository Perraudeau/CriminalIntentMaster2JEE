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

      posteDao.save(new Poste("Directeur", serviceDao.findByLibelle("Direction")));
      posteDao.save(new Poste("Commercial", serviceDao.findByLibelle("Service commercial")));
      posteDao.save(new Poste("Responsable RH", serviceDao.findByLibelle("Ressources humaines")));

      salarieDao.save(new Salarie("PERRAUDEAU", "Victor", posteDao.findByName("Directeur")));
      salarieDao.save(new Salarie("LEROUX", "Alexis", posteDao.findByName("Commercial")));
      salarieDao.save(new Salarie("BOMBEUR", "Jean", posteDao.findByName("Responsable RH")));

      intentionCriminelleDao.save(new IntentionCriminelle("Laisse l'evier salle", salarieDao.findByName("LEROUX")));
      intentionCriminelleDao.save(new IntentionCriminelle("Ne récupère pas ses impressions de la photocopieuse",
          salarieDao.findByName("LEROUX")));
      intentionCriminelleDao.save(
          new IntentionCriminelle("Se gare sur la place réservé aux handicapés", salarieDao.findByName("BOMBEUR")));

      done = true;
    }
  }
}
