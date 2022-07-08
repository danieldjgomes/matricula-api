package br.com.gomes.daniel.ufabc.alertadematricula.matriculaapi.framework.configuracao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactory", basePackages = {
        "br.com.gomes.daniel.ufabc.alertadematricula.matriculaapi.framework.framework.repositorios" })
public class ConfiguracaoAlertaDB{

    @Value("${general.connections.jdbc}")
    private String URL_BANCO;

//    @Primary
    @Bean(name = "dataSource")
//    @ConfigurationProperties(prefix = "spring.alerta.datasource")
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(URL_BANCO);
        return dataSource;
    }

//    @Primary
    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
                                                                             DataSource dataSource) {

        HashMap<String, Object> properties = new HashMap<>();
        return builder.dataSource(dataSource).properties(properties)
                .packages("br.com.gomes.daniel.ufabc.alertadematricula.matriculaapi.framework.dominio.DAO").build();
    }

//    @Primary
    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager(
            EntityManagerFactory entityManagerFactory) {

        return new JpaTransactionManager(entityManagerFactory);
    }

}
