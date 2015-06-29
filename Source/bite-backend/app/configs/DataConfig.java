package configs;

import com.google.common.collect.Maps;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import play.Play;

import java.util.Map;

@Configuration
@EnableTransactionManagement
public class DataConfig {

    @Autowired
    Environment environment;

    @Bean
    @org.springframework.beans.factory.annotation.Autowired(required=true)
    public EntityManagerFactory entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean emf=new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource());
        emf.setPersistenceProvider(new org.hibernate.ejb.HibernatePersistence());
        emf.setPackagesToScan("entities");
        Map<String,String> properties= Maps.newHashMap();
        String dialect=environment.getProperty("hibernate.dialect");
        if (dialect != null) {
            properties.put("hibernate.dialect",dialect);
        }
        emf.setJpaPropertyMap(properties);
        emf.afterPropertiesSet();
        return emf.getObject();
    }

    @Bean
    @org.springframework.beans.factory.annotation.Autowired(required=true)
    public PlatformTransactionManager transactionManager() {
        try {
            JpaTransactionManager transactionManager = new JpaTransactionManager(entityManagerFactory());
            return transactionManager;
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return  null;
    }

    @Bean
    @org.springframework.beans.factory.annotation.Autowired(required=true)
    public DataSource dataSource() {
        final MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUrl(Play.application().configuration().getString("db.default.url"));
        dataSource.setUser(Play.application().configuration().getString("db.default.user"));
        dataSource.setPassword(Play.application().configuration().getString("db.default.password"));
        return dataSource;
    }

}