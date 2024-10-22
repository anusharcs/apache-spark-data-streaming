package com.deliveryStream;

import java.util.Random;
import java.util.UUID;

public class GenrateOrderInfo {

	public static void main(String[] args) {
		for (int i = 1; i <= 5; i++) {

			System.out.println("order number:" + generateRandomOrderNumber(1,99999));

			System.out.println("Price:" + generateRandomNumber(99,90000));

			System.out.println("Category:" + generateRandomCategory());

			System.out.println("UUID:" + generateUUID());

			System.out.println("City:" + generateRandomCity());

			System.out.println("Payment mode :" + generateRandomPayment());
			
			System.out.println("Seller :" + generateRandomSeller());
			
			System.out.println("Delivery Partner  :" + generateRandomDeliveryPartner());

			System.out.println("----------------------------");

		}
	}


	public static String generateUUID() {
		return UUID.randomUUID().toString();
	}

	public static String generateRandomDeliveryPartner() {
		String[] PartnerArray = { "e-kart logistics", "BHL", "FastDelivery service", "Wheelcart", "Your delivery service" };
		return PartnerArray[new Random().nextInt(PartnerArray.length)];
	}
	
	public static String generateRandomSeller() {
		String[] SellerArray = { "Seller_A", "Seller_B", "Seller_C", "Seller_D", "Seller_E","Seller_F","Seller_G", "Seller_H" };
		return SellerArray[new Random().nextInt(SellerArray.length)];
	}
	
	public static String generateRandomPayment() {
		String[] PaymentArray = { "Cash", "Card", "UPI", "Net-Banking" };
		return PaymentArray[new Random().nextInt(PaymentArray.length)];
	}

	public static String generateRandomCity() {
		String[] CityArray = { "Chennai", "Tirunelveli", "Puthukottai", "Madurai", "Alankulam","Salem", "Sattur","Thenkaasi","Virudhunagar" };
		return CityArray[new Random().nextInt(CityArray.length)];
	}
	
	public static String generateRandomCategory() {
		String[] CategoryArray = { "Mobile", "Fashion", "Electronics", "Home", "Kitchen","Decor","Toys","Computers","Health","PersonalCare" };
		return CategoryArray[new Random().nextInt(CategoryArray.length)];
	}
	
	public static int generateRandomNumber(int min, int max) {
		return (int) (Math.random() * (max - min) + min);
	}
	
	public static String generateRandomOrderNumber(int min, int max) {
		return  "#" + String.valueOf((int)(Math.random() * (max - min) + min));
	}
	

}