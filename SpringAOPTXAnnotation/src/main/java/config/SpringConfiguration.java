package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@Configuration
@ComponentScan("dyliang")
@Import({JdbcConfig.class, TransactionManager.class})
@EnableTransactionManagement
@PropertySource("jdbcConfig.properties")
public class SpringConfiguration {
}
