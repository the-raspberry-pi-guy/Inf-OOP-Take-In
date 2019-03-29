public class QuadraticSolver {
	public static void main(String[] args) {
	 double a = Double.parseDouble(args[0]);
	 double b = Double.parseDouble(args[1]);
	 double c = Double.parseDouble(args[2]);
	 
	 System.out.println(quadsolv('+',a,b,c));
	 System.out.println(quadsolv('-',a,b,c));
	}
	
	public static String quadsolv(char sign, double a, double b, double c) {
		if (sign == '-') {
			return Double.toString((-b - Math.sqrt(b*b-4*a*c))/2*a);
		}
		else {
			return Double.toString((-b + Math.sqrt(b*b-4*a*c))/2*a);
		}
	}
}
