package br.com.gomes.daniel.ufabc.alertadematricula.matriculaapi.framework.configuracao;

import br.com.gomes.daniel.ufabc.alertadematricula.matriculaapi.framework.framework.repositorios.DAO.alerta.AlertaRepository;
import br.com.gomes.daniel.ufabc.alertadematricula.matriculaapi.framework.framework.repositorios.DAO.disciplina.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "alertaEntityManager",
        basePackageClasses = AlertaRepository.class)
//@EnableTransactionManagement
//@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactory", transactionManagerRef = "transactionManager", basePackages = {
//        "br.com.gomes.daniel.ufabc.alertadematricula.matriculaapi.framework.repositorios.alerta" })
public class ConfiguracaoAlertaDB{

//    @Primary
//    @Bean(name = "dataSource")
//    @ConfigurationProperties(prefix = "spring.datasource")
//    public DataSource dataSource() {
////        DriverManagerDataSource dataSource = new DriverManagerDataSource();
////        dataSource.setUrl(System.getProperty("dbUrlAlerta"));
////        return dataSource;
//        return DataSourceBuilder.create().build();
//    }
//
//    @Primary
//    @Bean(name = "entityManagerFactory")
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
//                                                                             @Qualifier("dataSource") DataSource dataSource) {
//
//        HashMap<String, Object> properties = new HashMap<>();
//        return builder.dataSource(dataSource)
//                .packages("br.com.gomes.daniel.ufabc.alertadematricula.matriculaapi.framework.dominio.DAO")
//                .persistenceUnit("AlertaDAO")
//                .build();
//    }
//
//    @Primary
//    @Bean(name = "transactionManager")
//    public PlatformTransactionManager transactionManager(
//            @Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory) {
//
//        return new JpaTransactionManager(entityManagerFactory);
//    }


    @Bean
    @Primary
    @ConfigurationProperties(prefix = "alerta.datasource")
    public DataSource alertaDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    public  LocalContainerEntityManagerFactoryBean alertaEntityManager(
            EntityManagerFactoryBuilder builder,
            @Qualifier("alertaDataSource") DataSource dataSource)
    {
        return builder
                .dataSource(dataSource)
                .packages("br.com.gomes.daniel.ufabc.alertadematricula.matriculaapi.framework.dominio.DAO.alerta")
                .build();
    }





}
