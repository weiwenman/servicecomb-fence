package org.apache.servicecomb.fence.jooqdemo.config;

import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.conf.Settings;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.tools.jdbc.SingleConnectionDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.jooq.impl.DSL.using;

@Component
@ConfigurationProperties(prefix = "servicecomb.jooq")
public class DataSourceConfig {

//    private String url = "jdbc:postgresql://localhost:5432/postgres";
//    private String username = "gaussdb";
//    private String password = "Postgres@123";
//    private String driverClassName = "org.postgresql.Driver";
    private DSLContext ctx;
    private Connection conn;
    private String url;
    private String username;
    private String password;
    private String driverClassName;

    @Bean
    public DSLContext dslContext() throws SQLException {
        if (conn == null || ctx == null) {
            conn = DriverManager.getConnection(url, username, password);
            DataSource jdbc = new SingleConnectionDataSource(conn);
            Configuration configuration = new DefaultConfiguration();
            configuration.set(jdbc).set(SQLDialect.POSTGRES)
                    .set(new Settings().withRenderFormatted(true));
            ctx = using(configuration);
        }
        return ctx;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }
}
