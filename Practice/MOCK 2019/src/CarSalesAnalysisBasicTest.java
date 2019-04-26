import org.junit.Test;

import java.util.Map;
import java.util.List;
import java.util.Arrays;

@SuppressWarnings("unused")
public class CarSalesAnalysisBasicTest {

	@Test
    public void testCountByBrand() {
        List<CarItem> input = Arrays.asList(new CarItem("VW", "Polo", 2454.45));
        Map<String, Integer> result = CarSalesAnalysis.countByBrand(input);
    }

}