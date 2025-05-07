import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class inMemoryDataSourceConfig {
    @Bean
    public DataSource inMemoryDataSource() {
        return DataSourceBuilder.create()
                .driverClassName("org.h2.Driver")
                .url("jdbc:h2:mem:mydb;DB_CLOSE_DELAY=-1")
                .username("sa")
                .password("")
                .build();
    }
}