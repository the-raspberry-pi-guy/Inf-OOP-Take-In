import org.junit.Test;

@SuppressWarnings("unused")
public class ScalableCarItemTest {

	@Test
    public void testConstructor() {
        ScalableCarItem item = new ScalableCarItem("VW", "Polo", 3000.43);
    }

    @Test
	public void testUpdateSales() {
        ScalableCarItem item = new ScalableCarItem("VW", "Polo", 3000.43);

        item.updateSales(10);
	}

    @Test
	public void testGetPrice() {
	    ScalableCarItem item = new ScalableCarItem("VW", "Polo", 3000.43);

        double result = item.getPrice();
    }

    @Test
	public void testToString() {
        ScalableCarItem item = new ScalableCarItem("VW", "Polo", 3000.43);

        String output = item.toString();
	}

}