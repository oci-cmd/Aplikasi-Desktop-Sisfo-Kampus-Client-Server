/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author Rosidin
 */
public class Koneksi {
    private static ApplicationContext context = null;
    
    public static JdbcTemplate getJdbcTemplate() {
        initContext();
        DriverManagerDataSource dataSource = (DriverManagerDataSource)context.getBean("dataSource");
        JdbcTemplate template = new JdbcTemplate(dataSource);
        return template;
    }

    public static ApplicationContext getContext() {
        initContext();
        return context;
    }
    
    public static ApplicationContext getContext(String configFilename) {
        return new ClassPathXmlApplicationContext(configFilename);
    }

    private static void initContext() {
        if (context == null){
            context = new ClassPathXmlApplicationContext("db/Database.xml");
        }
    }
    
}
