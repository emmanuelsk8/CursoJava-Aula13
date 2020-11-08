package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program3 {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String clientName = sc.nextLine();
		System.out.print("E-mail: ");
		String clientEmail = sc.nextLine();
		System.out.print("Birth Date: ");
		Date clientBirthDate = sdf.parse(sc.nextLine());
		
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		String orderStatus = sc.nextLine();
		
		Order order = new Order(new Date(), OrderStatus.valueOf(orderStatus), new Client(clientName, clientEmail, clientBirthDate));
		
		System.out.println("How many items to this order? ");
		int n = sc.nextInt();
		
		for(int i = 1; i <= n; i++) {
			System.out.println("Enter item #"+i+" data: ");
			System.out.print("Product Name: ");
			String productName = sc.next();
			
			System.out.print("Product price: ");
			double productPrice = sc.nextDouble();
			
			System.out.print("Quantity: ");
			int orderQuantity = sc.nextInt();
			
			OrderItem orderItem = new OrderItem(orderQuantity, productPrice, new Product(productName, productPrice));
			order.addItem(orderItem);
		}
		
		System.out.println();
		System.out.println("ORDER SUMMARY:");
		System.out.println(order.toString());
		
		sc.close();

	}

}
