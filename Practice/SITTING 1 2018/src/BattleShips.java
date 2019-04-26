import java.util.Map;
import java.util.List;
import java.util.Hashtable;
import java.util.ArrayList;

class BattleShips {

    public static char fireShot(char[][] grid, Position shot) {
        int x = shot.getX();
        int y = shot.getY();
        
        char result = grid[y][x];

        if ((x > grid.length) || (y > grid.length)) {
        	System.out.println(shot.toString() + ": Out of Bounds");
        	return '#';
        }
        else if (result == '#') {
        	System.out.println(shot.toString() + ": Miss");
        	return result;
        }
        else {
        	System.out.println(shot.toString() + ": Hit " + result);
        	return result;
        }
    }

    public static Map<Character, Integer> findShips(char[][] grid) {
    	Map<Character, Integer> shipMap = new Hashtable<>();
    	
        for (int y=0; y < grid.length; y++) {
        	for (int x=0; x < grid.length; x++) {
        		char current = grid[y][x];
        		if (current == '#') { continue; }
        		if (shipMap.containsKey(current)) {
        			Integer number = shipMap.get(current);
        			shipMap.put(current, number+1);
        		}
        		else {
        			shipMap.put(current, 1);
        		}
        	}
        }
        return shipMap;
    }

    public static List<Character> fireShots(char[][] grid, List<Position> shots) {
        ArrayList<Character> results = new ArrayList<Character>();
        Map<Character, Integer> shipMap = findShips(grid);
        
        for (int i = 0; i<shots.size(); i++) {
        	char outcome = fireShot(grid, shots.get(i));
        	if (outcome == '#') { continue; }
        	int shipLength = shipMap.get(outcome);
        	shipMap.put(outcome, shipLength-1);
        	if (shipLength-1 == 0) {
        		results.add(outcome);
        	}
        }
        System.out.println(results.toString());
        return results;
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please execute this program by"
                    + " providing the path to a game file,"
                    + " e.g. java BattleShips ./game01.txt");
            System.exit(1);
        }

        char[][] grid = BattleShipsUtils.parseGrid(args[0]);

        System.out.println("Playing with grid: ");
        BattleShipsUtils.printGrid(grid);

        Position centreShot = new Position(grid.length / 2,
                                           grid.length / 2);
        System.out.println("\nFiring Shot at centre " +
                            centreShot.toString() + " ...");
        fireShot(grid, centreShot);

        System.out.println("\nGenerating shots ...");
        List<Position> shots = BattleShipsUtils.generateShots(grid.length,
                                    grid.length * 2);
        System.out.println("Shots: " + shots);

        System.out.println("\nFinding Ships ...");
        Map<Character, Integer> ships = findShips(grid);
    	if(ships != null) {
           for (Character ship : ships.keySet())
             System.out.println(ship + " has size " + ships.get(ship));
    	}

        System.out.println("\nFiring shots ...");
    	if(shots != null) {
            List<Character> destroyedShips = fireShots(grid, shots);
    	    if (destroyedShips != null && !destroyedShips.isEmpty()) {
    	        System.out.println("Destroyed ships: ");
    	        for(char ship : destroyedShips)
    	            System.out.println(ship);
    	    }
    	}
    }
}