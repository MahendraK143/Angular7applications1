package com.example.StockMartketApplicaiton;

import com.st.bean.StackBean;
import com.st.repository.StackRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.List;
@ComponentScan({"com.st.controller","com.st.repository","com.st.service"})
@EntityScan("com.st.bean")
@SpringBootApplication
//@EnableJpaRepositories("com.st.repository")
@EnableJpaAuditing
public class StockMartketApplicaitonApplication {
	/*@Autowired
	private StackRepository stackRepository;
*/
	public static void main(String[] args) {
		SpringApplication.run(StockMartketApplicaitonApplication.class, args);
	}
	@RequestMapping("get")
	public String get(){
		return "Mahendra";
	}
/*
	@RequestMapping(name = "stock-list")
	public List<StackBean> stackList(){
		System.out.println("Good");
		StackBean stackBean1 = new StackBean();stackBean1.setName("MAHINDRA"); stackBean1.setCost(1555);
		StackBean stackBean2 = new StackBean();stackBean2.setName("TATA"); stackBean2.setCost(1700);
		StackBean stackBean3 = new StackBean();stackBean3.setName("MARUTI"); stackBean3.setCost(1200);
		StackBean stackBean4 = new StackBean();stackBean4.setName("BMD"); stackBean4.setCost(2300);
		StackBean stackBean5 = new StackBean();stackBean5.setName("HIRO HONDA"); stackBean5.setCost(1000);
		List<StackBean> stacks = Arrays.asList(stackBean1,stackBean2,stackBean3,stackBean4,stackBean4,stackBean5);

		return stacks;
	}
*/
/*	@Bean
	public ApplicationRunner init(@Autowired StackRepository repository) {
		System.out.println("asdffasdfasfasdfadf");
		return args -> {
			StackBean stackBean1 = new StackBean();
			stackBean1.setName("MAHINDRA");
			stackBean1.setCost(1555);
			StackBean stackBean2 = new StackBean();
			stackBean2.setName("TATA");
			stackBean2.setCost(1700);
			StackBean stackBean3 = new StackBean();
			stackBean3.setName("MARUTI");
			stackBean3.setCost(1200);
			StackBean stackBean4 = new StackBean();
			stackBean4.setName("BMD");
			stackBean4.setCost(2300);
			StackBean stackBean5 = new StackBean();
			stackBean5.setName("HIRO HONDA");
			stackBean5.setCost(1000);
			List<StackBean> stacks = Arrays.asList(stackBean1, stackBean2, stackBean3, stackBean4, stackBean4, stackBean5);
			stacks.stream().forEach(stack -> {
				//if (repository.findStackByName(stack.getName()) == null)
					repository.save(stack);
			});
			repository.findAll().stream().forEach(System.out::println);
		};
	}*/


	@Value("${spring.datasource.driver-class-name}") String driverClassName;
	@Value("${spring.datasource.url}") String url;
	@Value("${spring.datasource.username}") String username;
	@Value("${spring.datasource.password}") String password;
	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		DataSource dataSource = DataSourceBuilder
				.create()
				.username(username)
				.password(password)
				.url(url)
				.driverClassName(driverClassName)
				.build();
		return dataSource;
	}
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.scanPackages("com.st.bean");
		return sessionBuilder.buildSessionFactory();
	}
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(
			SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(
				sessionFactory);
		return transactionManager;
	}
	@Bean
	public DataSourceInitializer dataSourceInitializer(final DataSource dataSource) {
		final DataSourceInitializer initializer = new DataSourceInitializer();
		initializer.setDataSource(dataSource);
		return initializer;
	}
}

