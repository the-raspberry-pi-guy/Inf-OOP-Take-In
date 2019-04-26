import java.util.Objects;
import java.util.List;
import java.util.Map;
import java.util.Hashtable;

public class CarSalesAnalysis {
	
    protected static Map<String, Integer> countByBrand(List<CarItem> soldCars) {
    	Map<String, Integer> brandCount = new Hashtable<>();
    	
    	if (soldCars.size() == 0) { return brandCount; }
    	
        for (int i = 0; i < soldCars.size(); i++) {
        	CarItem reference = soldCars.get(i);
        	String brand = reference.getBrand();
        	if (brandCount.containsKey(brand)) {
        		Integer number = brandCount.get(brand);
        		brandCount.put(brand, number+1);
        	}
        	else {
        		brandCount.put(brand, 1);
        	}
        }
        
        return brandCount;
    }

    public static void main(String[] args) {
        
        System.out.println("\nParsing expense items ...");
        List<CarItem> carData = CarSalesUtils.readDataFromFile(args[0]);
        System.out.println(carData.size() + " entries found in ");
        CarSalesUtils.printCarItemList(carData);
        System.out.println("\nCounting car sales for each car brand...");
        Map<String, Integer> carCounts = countByBrand(carData);
            if (!Objects.isNull(carCounts)) {
                    System.out.println("Car Counts per Brand:\n");
            CarSalesUtils.printCarMappings(carCounts);
} }
}