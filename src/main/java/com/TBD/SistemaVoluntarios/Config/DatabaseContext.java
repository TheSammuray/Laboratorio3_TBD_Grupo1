package com.TBD.SistemaVoluntarios.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.sql2o.Sql2o;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.DataSource;

@Configuration
public class DatabaseContext {
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/voluntarios");
        dataSource.setUsername("postgres");
        dataSource.setPassword("1234");
        return dataSource;
    }

    @Bean
    public Sql2o sql2o(DataSource dataSource) {
        return new Sql2o(dataSource);
    }
}