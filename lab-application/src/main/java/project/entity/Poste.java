package project.entity;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Poste {
  @Id
  @GeneratedValue
  private Long idPoste;
  @Basic
  private String libelle;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(referencedColumnName = "idService")
  private Service service;

  public Poste() {
  }

  public Poste(String libelle, Service service) {
    this.libelle = libelle;
    this.service = service;
  }

  public Long getIdPoste() {
    return idPoste;
  }

  public void setIdPoste(Long idPoste) {
    this.idPoste = idPoste;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  public Service getService() {
    return service;
  }

  public void setService(Service service) {
    this.service = service;
  }

}
