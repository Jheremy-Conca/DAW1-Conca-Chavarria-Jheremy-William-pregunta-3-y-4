package pe.edu.i202222124.cl1_jpa_data_conca_chavarria_jheremy.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConexionesConfig {

    @Value("${DB_WORLD_URL}")
    private String dbWorldUrl;
    @Value("${DB_WORLD_USER}")
    private String dbWorldUser;
    @Value("${DB_WORLD_PASS}")
    private String dbWorldPass;
    @Value("${DB_WORLD_DRIVER}")
    private String dbWorldDriver;

    @Bean
    public HikariDataSource hikariDataSource() {

        HikariConfig config = new HikariConfig();

        config.setJdbcUrl(dbWorldUrl);
        config.setUsername(dbWorldUser);
        config.setPassword(dbWorldPass);
        config.setDriverClassName(dbWorldDriver);

        config.setMaximumPoolSize(30);  // 30 conexiones
        config.setMinimumIdle(4);       // 4 conexiones inactivas
        config.setIdleTimeout(240000);  // 4 minutos
        config.setConnectionTimeout(45000);  // 45 segundos

        System.out.println("###### HikariCP initialized ######");
        return new HikariDataSource(config);
    }
}
