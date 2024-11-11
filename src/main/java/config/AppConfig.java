package config;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableAspectJAutoProxy
@EnableJpaRepositories
@ComponentScan(basePackages = {"services","rest","dao","aspects","exception"})
@EntityScan(basePackages = {"entity"})
public class AppConfig {
}
