package com.grup2.analyzer.config;

import com.grup2.analyzer.model.Page;
import com.grup2.analyzer.model.PageLog;
import com.grup2.analyzer.model.User;
import com.grup2.analyzer.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

import static org.hibernate.cfg.Environment.*;

@PropertySource("classpath:hibernate.properties")
@EnableTransactionManagement
@Configuration
@ComponentScan(basePackages = "com.grup2.analyzer")
public class AppConfig {

    @Autowired
    private Environment env;

    @Bean
    public LocalSessionFactoryBean getSessionFactory() {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();

        Properties props = new Properties();
        // Setting JDBC properties
        props.put(DRIVER, env.getProperty("mysql.driver"));
        props.put(URL, env.getProperty("mysql.url"));
        props.put(USER, env.getProperty("mysql.username"));
        props.put(PASS, env.getProperty("mysql.password"));

        // Setting Hibernate properties
        props.put(SHOW_SQL, env.getProperty("hibernate.show_sql"));
        props.put(FORMAT_SQL, env.getProperty("hibernate.format_sql"));
        props.put(HBM2DDL_AUTO, env.getProperty("hibernate.hbm2ddl.auto"));
        props.put(DIALECT, env.getProperty("hibernate.dialect"));

        // Setting C3P0 properties
        props.put(C3P0_MIN_SIZE, env.getProperty("hibernate.c3p0.min_size"));
        props.put(C3P0_MAX_SIZE, env.getProperty("hibernate.c3p0.max_size"));
        props.put(C3P0_ACQUIRE_INCREMENT, env.getProperty("hibernate.c3p0.acquire_increment"));
        props.put(C3P0_TIMEOUT, env.getProperty("hibernate.c3p0.timeout")); // seconds
        props.put(C3P0_MAX_STATEMENTS, env.getProperty("hibernate.c3p0.max_statements"));
        props.put(C3P0_CONFIG_PREFIX + ".initialPoolSize", env.getProperty("hibernate.c3p0.initialPoolSize"));
        props.put(C3P0_IDLE_TEST_PERIOD, env.getProperty("hibernate.c3p0.idle_test_period")); // seconds
        props.put(C3P0_CONFIG_PREFIX + ".acquireRetryAttempts", env.getProperty("hibernate.c3p0.acquireRetryAttempts"));
        props.put(C3P0_CONFIG_PREFIX + ".acquireRetryDelay", env.getProperty("hibernate.c3p0.acquireRetryDelay")); // milliseconds

        factoryBean.setHibernateProperties(props);
        factoryBean.setAnnotatedClasses(Page.class, PageLog.class, User.class, UserRole.class);
        return factoryBean;
    }

    @Bean
    public HibernateTransactionManager getTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(getSessionFactory().getObject());
        return transactionManager;
    }

}
