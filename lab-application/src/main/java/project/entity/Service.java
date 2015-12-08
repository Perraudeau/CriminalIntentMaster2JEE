package project.entity;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Service {
  @Id
  @GeneratedValue
  private Long idService;
  @Basic
  private String libelle;

  public Service() {
  }

  public Service(String libelle) {
    this.libelle = libelle;
  }

  public Long getIdService() {
    return idService;
  }

  public void setIdService(Long idService) {
    this.idService = idService;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }
}
