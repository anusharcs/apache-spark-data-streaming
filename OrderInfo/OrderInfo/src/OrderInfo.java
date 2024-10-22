import com.google.gson.Gson;

public class OrderInfo {

	private String OrderNumber;
	private int Price ;
	private String Category ;
	private String UniqueId;
	private String City;
	private String PaymentMode;
	private String Seller;
	private String DeliveryPartnerName;

	public OrderInfo() {

	}

	public OrderInfo(String orderNumber, int price, String category, String uniqueId, String city, String paymentMode,
			String seller, String deliveryPartnerName) {
		super();
		this.OrderNumber = orderNumber;
		this.Price = price;
		this.Category = category;
		this.UniqueId = uniqueId;
		this.City = city;
		this.PaymentMode = paymentMode;
		this.Seller = seller;
		this.DeliveryPartnerName = deliveryPartnerName;
	}

	public String getOrderNumber() {
		return OrderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		OrderNumber = orderNumber;
	}

	public int getPrice() {
		return Price;
	}

	public void setPrice(int price) {
		Price = price;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public String getUniqueId() {
		return UniqueId;
	}

	public void setUniqueId(String uniqueId) {
		UniqueId = uniqueId;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getPaymentMode() {
		return PaymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		PaymentMode = paymentMode;
	}

	public String getSeller() {
		return Seller;
	}

	public void setSeller(String seller) {
		Seller = seller;
	}

	public String getDeliveryPartnerName() {
		return DeliveryPartnerName;
	}

	public void setDeliveryPartnerName(String deliveryPartnerName) {
		DeliveryPartnerName = deliveryPartnerName;
	}
	
	@Override
	public String toString() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}
	
}