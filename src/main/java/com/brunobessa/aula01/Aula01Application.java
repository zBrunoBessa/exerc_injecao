package com.brunobessa.aula01;

import com.brunobessa.aula01.entities.Order;
import com.brunobessa.aula01.services.OrderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class Aula01Application implements CommandLineRunner {


	private OrderService orderService;

	public Aula01Application(OrderService orderService) {
		this.orderService = orderService;
	}

	public static void main(String[] args) {
		SpringApplication.run(Aula01Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Integer code = sc.nextInt();
		Double basicValue = sc.nextDouble();
		Double discount = sc.nextDouble();
		Order order = new Order(code, basicValue, discount);

		System.out.println("Pedido código " + order.getCode());
		System.out.printf("Valor total: R$%.2f", orderService.total(order));
		sc.close();
	}


}
