package com.example.StackMarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableScheduling
public class StackMarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(StackMarketApplication.class, args);
	}

	/*public ApplicationRunner init(StackRepository repository){
		return args -> {
			StackBean stackBean1 = new StackBean();stackBean1.setName("MAHINDRA"); stackBean1.setCost(1555);
			StackBean stackBean2 = new StackBean();stackBean2.setName("TATA"); stackBean2.setCost(1700);
			StackBean stackBean3 = new StackBean();stackBean3.setName("MARUTI"); stackBean3.setCost(1200);
			StackBean stackBean4 = new StackBean();stackBean4.setName("BMD"); stackBean4.setCost(2300);
			StackBean stackBean5 = new StackBean();stackBean5.setName("HIRO HONDA"); stackBean5.setCost(1000);
			List<StackBean> stacks = Arrays.asList(stackBean1,stackBean2,stackBean3,stackBean4,stackBean4,stackBean5);
			stacks.stream().forEach(stack -> {
				if(repository.findStackByName(stack.getName()) == null)
					repository.save(stack);
			});
			repository.findAll().stream().forEach(System.out::println);
		};
	}*/
}
