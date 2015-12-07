package project.entity;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Salarie {
  @Id
  @GeneratedValue
  private Long idSalarie;
  @Basic
  private String nom;
  @Basic
  private String prenom;
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(unique = true)
  private Poste poste;

  public Salarie() {
  }

  public Salarie(String nom, String prenom, Poste poste) {
    this.nom = nom;
    this.prenom = prenom;
    this.poste = poste;
  }

  public Long getIdSalarie() {
    return idSalarie;
  }

  public void setIdSalarie(Long idSalarie) {
    this.idSalarie = idSalarie;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  public Poste getPoste() {
    return poste;
  }

  public void setPoste(Poste poste) {
    this.poste = poste;
  }

}
