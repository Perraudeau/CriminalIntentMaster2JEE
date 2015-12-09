package project.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
// @EnableAspectJAutoProxy
@ComponentScan("project.service")
public class RootConfig {
  public static final String DRIVER = "org.h2.Driver";
  public static final String URL = "jdbc:h2:tcp://localhost/~/h2db/finalProjectLerouxPerraudeau";
  public static final String USERNAME = "finalProject";
  public static final String PASSWORD = "finalProject";

  @Bean
  public DataSource dataSource() {
    DriverManagerDataSource bean = new DriverManagerDataSource();
    bean.setDriverClassName(DRIVER);
    bean.setUrl(URL);
    bean.setUsername(USERNAME);
    bean.setPassword(PASSWORD);
    return bean;
  }

  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
    LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
    em.setDataSource(dataSource);
    em.setPackagesToScan("project.entity");
    em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

    Properties properties = new Properties();
    properties.setProperty("hibernate.hbm2ddl.auto", "create");
    properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
    properties.setProperty("hibernate.connection.useUnicode", "true");
    properties.setProperty("hibernate.connection.characterEncoding", "utf-8");

    em.setJpaProperties(properties);
    return em;
  }

  @Bean
  public PersistenceAnnotationBeanPostProcessor paPostProcessor() {
    return new PersistenceAnnotationBeanPostProcessor();
  }

  @Bean
  public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(emf);
    return transactionManager;
  }
}