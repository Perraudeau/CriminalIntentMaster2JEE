package project.entity;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class IntentionCriminelle {
  @Id
  @GeneratedValue
  private Long idIntentionCriminelle;
  @Basic
  private String libelle;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(referencedColumnName = "idSalarie")
  private Salarie salarie;

  public IntentionCriminelle() {
  }

  public IntentionCriminelle(String libelle, Salarie salarie) {
    this.libelle = libelle;
    this.salarie = salarie;
  }

  public Long getIdIntentionCriminelle() {
    return idIntentionCriminelle;
  }

  public void setIdIntentionCriminelle(Long idIntentionCriminelle) {
    this.idIntentionCriminelle = idIntentionCriminelle;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  public Salarie getSalarie() {
    return salarie;
  }

  public void setSalarie(Salarie salarie) {
    this.salarie = salarie;
  }

}