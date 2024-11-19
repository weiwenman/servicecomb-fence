package org.apache.servicecomb.fence.resource.config;

import org.apache.servicecomb.fence.resource.entity.Events;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class HibernateSessionConfig {

    @Bean("sessionFactory")
    public SessionFactory getSessionFactory() {
        System.out.println("init sessionFactory..................");
        StandardServiceRegistry builder = new StandardServiceRegistryBuilder()
                .loadProperties("hibernate.properties")
                .build();
        return new MetadataSources(builder)
                .addAnnotatedClass(Events.class)
                .buildMetadata()
                .buildSessionFactory();
    }
}
