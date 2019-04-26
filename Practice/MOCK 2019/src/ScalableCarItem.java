
public class ScalableCarItem extends CarItem {
	
	private double scaledPrice;
	private int sales;
	
	public ScalableCarItem(String brand, String model, double price) {
		super(brand,model,price);
		this.scaledPrice = super.price;
		this.sales = 0;
	}
	
	@Override
	public double getPrice() { return scaledPrice; }
	
	public void updateSales(int latestSales) {
		if (latestSales < 0) {
			throw new IllegalArgumentException("Latest sales figures cannot be 0.");
		}
		sales += latestSales;
		double number = sales / 100.0;
		double tmp = scaledPrice  * (1 + number);
		scaledPrice = Math.round(tmp * 100) /100.0;
	}
	
	@Override
	public String toString() {
		return (super.toString() + "\nsales: " + sales + "\nscaled price: " + scaledPrice + " GBP");
	}
	
	public static void main(String[] args) {
		ScalableCarItem car = new ScalableCarItem("Ford", "Fiesta", 2000.50);
		
		car.updateSales(25);
		
		System.out.println(car.getPrice());
	}
	
}
