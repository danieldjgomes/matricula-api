package br.com.gomes.daniel.ufabc.alertadematricula.matriculaapi.framework.configuracao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "disciplinaEntityManagerFactory", transactionManagerRef = "disciplinaTransactionManager", basePackages = {
        "br.com.gomes.daniel.ufabc.alertadematricula.matriculaapi.framework.repositorios.disciplina"})
public class ConfiguracaoDisciplinaDB {

    @Bean(name = "disciplinaDataSource")
    @ConfigurationProperties(prefix = "spring.disciplina.datasource")
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(System.getProperty("dbUrlDisciplina"));
        return dataSource;
    }

    @Bean(name = "disciplinaEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean disciplinaEntityManagerFactory(EntityManagerFactoryBuilder builder,
                                                                             @Qualifier("disciplinaDataSource") DataSource dataSource) {
        HashMap<String, Object> properties = new HashMap<>();
        return builder.dataSource(dataSource).properties(properties)
                .packages("br.com.gomes.daniel.ufabc.alertadematricula.matriculaapi.framework.dominio.DAO.DisciplinaDAO").build();
    }

    @Bean(name = "disciplinaTransactionManager")
    public PlatformTransactionManager disciplinaTransactionManager(
            @Qualifier("disciplinaEntityManagerFactory") EntityManagerFactory disciplinaEntityManagerFactory) {
        return new JpaTransactionManager(disciplinaEntityManagerFactory);
    }


}
