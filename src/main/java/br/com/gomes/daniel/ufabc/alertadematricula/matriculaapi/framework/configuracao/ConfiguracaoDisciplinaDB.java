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
@EnableJpaRepositories(entityManagerFactoryRef = "disciplinaEntityManager",
    basePackageClasses = DisciplinaRepository.class)

//@EnableTransactionManagement
//@EnableJpaRepositories(entityManagerFactoryRef = "disciplinaEntityManagerFactory", transactionManagerRef = "disciplinaTransactionManager", basePackages = {
//        "br.com.gomes.daniel.ufabc.alertadematricula.matriculaapi.framework.repositorios.disciplina"})
public class ConfiguracaoDisciplinaDB {

//    @Bean(name = "disciplinaDataSource")
//    @ConfigurationProperties(prefix = "spring.disciplina.datasource")
//    public DataSource dataSource() {
////        DriverManagerDataSource dataSource = new DriverManagerDataSource();
////        dataSource.setUrl(System.getProperty("dbUrlDisciplina"));
////        return dataSource;
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "disciplinaEntityManagerFactory")
//    public LocalContainerEntityManagerFactoryBean disciplinaEntityManagerFactory(EntityManagerFactoryBuilder builder,
//                                                                             @Qualifier("disciplinaDataSource") DataSource dataSource) {
//        HashMap<String, Object> properties = new HashMap<>();
//        return builder.dataSource(dataSource).properties(properties)
//                .packages("br.com.gomes.daniel.ufabc.alertadematricula.matriculaapi.framework.dominio.DAO.disciplina.DisciplinaDAO").build();
//    }
//
//    @Bean(name = "disciplinaTransactionManager")
//    public PlatformTransactionManager disciplinaTransactionManager(
//            @Qualifier("disciplinaEntityManagerFactory") EntityManagerFactory disciplinaEntityManagerFactory) {
//        return new JpaTransactionManager(disciplinaEntityManagerFactory);
//    }


    @Bean
    @ConfigurationProperties(prefix = "disciplina.datasource")
    public DataSource disciplinaDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean
    public  LocalContainerEntityManagerFactoryBean disciplinaEntityManager(
            EntityManagerFactoryBuilder builder,
            @Qualifier("disciplinaDataSource") DataSource dataSource)
    {
        return builder
                .dataSource(dataSource)
                .packages("br.com.gomes.daniel.ufabc.alertadematricula.matriculaapi.framework.dominio.DAO.disciplina")
                .build();
    }




}
