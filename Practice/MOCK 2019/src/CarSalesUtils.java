import java.nio.file.Paths;
import java.nio.file.Path;
import static java.nio.file.Files.*;
import java.util.Scanner;
import static java.util.Objects.*;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.io.UncheckedIOException;
import java.io.IOException;


/**
 * Utility functions for the car sales system.
 */
public class CarSalesUtils {

    /**
     * Prints the given list of car items using one line
     * per item in list.
     *
     * @data list of car items
     */
    public static void printCarItemList(List<CarItem> data) {
        if (isNull(data))  
            System.out.println(data);
        else {
            for (CarItem item : data) 
                System.out.println(item);
        }
    }

    /**
     * Prints the given mappings of car entries using one line
     * per entry.
     *
     * @data count mapping of car entries
     */
    public static void printCarMappings(Map<String, Integer> data) {
        if (isNull(data))  
            System.out.println(data);
        else {
            for (String make : data.keySet())
                System.out.println(make + ":" + data.get(make));
        }
    }


   /**
    * This method reads the output from a text data file 
    * of car sale items specified by the given path and 
    * returns a list of CarItem instances.
    *
    * Each line in the given data file is expected to stand for 
    * a single CarItem with the following format:
    * <Brand> <Model> <Price>
    * For example
    * VW Polo 13435
    * 
    * @param data the path to a text data file
    * @return a list of CarItem instances as specified in the data file 
    * @exception IllegalArgumentException if the data is null, the file 
    * does not exist or is an invalid file.
    * @see IllegalArgumentException
    */
    public static List<CarItem> readDataFromFile(String path) {
        Path dataPath = Paths.get(path);
        if(isNull(dataPath))
            throw new IllegalArgumentException(
			"The given data file path must not be null!");
//        if(!exists(dataPath))
//            throw new IllegalArgumentException(
//			"The given data file path does not exist! " + dataPath);
        if(!isRegularFile(dataPath))
            throw new IllegalArgumentException(
			"The given data file path is not a valid file! " + dataPath);

        Scanner in;
        try {
            in = new Scanner(dataPath);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

		List<CarItem> data = new ArrayList<CarItem>();
		while (in.hasNext()) {
            CarItem car = new CarItem(
                    in.next(),
                    in.next(),
                    in.nextDouble());
			data.add(car);
		}
        in.close();

        return data;
    }
}