package project.service.business;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class BusinessException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  private String regle;
  @PersistenceContext
  private EntityManager em;

  public BusinessException(String regle, String message) {
    super(message);

    this.regle = regle;
  }

  public String getRegle() {
    return regle;
  }
}
