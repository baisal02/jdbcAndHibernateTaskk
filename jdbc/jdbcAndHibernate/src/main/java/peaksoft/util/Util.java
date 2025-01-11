package peaksoft.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import peaksoft.model.User;

import java.util.Properties;

public class Util {
    // реализуйте настройку соеденения с БД
   public static SessionFactory getSessionFactory() {
       Properties properties = new Properties();
       properties.put("hibernate.connection.driver_class", "org.postgresql.Driver");
       properties.put("hibernate.connection.url", "jdbc:postgresql://localhost:5432/postgres");
       properties.put("hibernate.connection.username", "postgres");
       properties.put("hibernate.connection.password", "1234");
       properties.put("hibernate.show_sql", "true");
       properties.put("hibernate.format_sql", "true");
       properties.put("hibernate.hbm2ddl.auto", "update");
       properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");

       Configuration cfg = new Configuration();
       cfg.setProperties(properties);
       cfg.addAnnotatedClass(User.class);
       SessionFactory sf = cfg.buildSessionFactory();
       return sf;
   }
}
