package hello;
import javax.annotation.Resource;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class PersistenceConfiguration {

	@Resource
	private Environment environment;

	@Bean
	@Primary
	public javax.sql.DataSource dataSource() {
		DataSource dataSource = new DataSource();
		dataSource.setDriverClassName(environment.getProperty("commons.datasource.driver-class-name"));
		dataSource.setUrl(environment.getProperty("commons.datasource.url"));
		dataSource.setUsername(environment.getProperty("commons.datasource.username"));
		dataSource.setPassword(environment.getProperty("commons.datasource.password"));

		dataSource.setInitialSize(Integer.valueOf(environment.getProperty("commons.datasource.initial_size")));
		dataSource.setMaxActive(Integer.valueOf(environment.getProperty("commons.datasource.max_active")));
		dataSource.setMaxIdle(Integer.valueOf(environment.getProperty("commons.datasource.max_idle")));
		dataSource.setMinIdle(Integer.valueOf(environment.getProperty("commons.datasource.min_idle")));
		dataSource.setTestOnReturn(Boolean.parseBoolean(environment.getProperty("commons.datasource.test_on_return")));
		dataSource.setTestWhileIdle(Boolean.parseBoolean(environment.getProperty("commons.datasource.test_while_idle")));
		dataSource.setValidationQuery(environment.getProperty("commons.datasource.validation_query"));

		return dataSource;
	}

}