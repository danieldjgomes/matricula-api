package br.com.gomes.daniel.ufabc.alertadematricula.matriculaapi.framework.configuracao;


import br.com.gomes.daniel.ufabc.alertadematricula.matriculaapi.framework.seguranca.oauth.OAuth2SucessHandler;
import br.com.gomes.daniel.ufabc.alertadematricula.matriculaapi.framework.seguranca.oauth.UsuarioOAuth2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class ConfiguracaoOAuth2 extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UsuarioOAuth2Service oAuth2UserService;

    @Autowired
    private OAuth2SucessHandler oAuth2SucessHandler;

    public ConfiguracaoOAuth2() {
    }

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder authBuilder) throws Exception {

        authBuilder
                .jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(new BCryptPasswordEncoder())
                .usersByUsernameQuery("select email, senha, situacao from aluno where email =?")
                .authoritiesByUsernameQuery("select email,situacao from aluno where email=?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                .antMatchers("/oauth2/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .usernameParameter("email")
                .permitAll()
                .defaultSuccessUrl("/")
                .and()
                .oauth2Login()
                .loginPage("/login")
                .userInfoEndpoint().userService(oAuth2UserService)
                .and()
                .successHandler(oAuth2SucessHandler)
                .and()
                .logout()
                .logoutSuccessUrl("/ok")
                .permitAll();
    }


}
