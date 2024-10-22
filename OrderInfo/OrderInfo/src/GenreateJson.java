import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import static com.deliveryStream.GenrateOrderInfo.*;

public class GenreateJson {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		File file = new File("C:/Users/HARISH/Documents/json/" + "Data.json");
		
		while (true) {
			int records = new Random().nextInt(15);
			for (int i = 1; i <= records; i++) {
				OrderInfo order = new OrderInfo();
				order.setOrderNumber(generateRandomOrderNumber(1,99999));
				order.setPrice(generateRandomNumber(99,90000));
				order.setCategory(generateRandomCategory());
				order.setUniqueId(generateUUID());
				order.setCity(generateRandomCity());
				order.setPaymentMode(generateRandomPayment());
				order.setSeller(generateRandomSeller());
				order.setDeliveryPartnerName(generateRandomDeliveryPartner());
				
				// Write the order data into a file
				
				FileWriter fw = new FileWriter(file, true);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.append(order.toString()+"\n");
				bw.flush();
				bw.close();
			}
		   //System.out.println (file.toURI());
		   Thread.sleep(300);
		}
	}
}