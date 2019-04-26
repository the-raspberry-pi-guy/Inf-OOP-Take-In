
public class Boss extends Monster {

	private int stage;
	private final int initialHealth;
	
	public Boss(int health, int power) {
		super(health, power);
		this.initialHealth = health;
		this.stage = 1;
	}
	
	@Override
	public String toString() {
		System.out.println(super.toString() + "\nStage: " + this.stage);
		return super.toString() + "\nStage: " + this.stage;
	}
	
	@Override
    public void takeDamage(int damage) {		
		super.takeDamage(damage);
		
		if ((super.isDefeated() == false) && ((super.health < initialHealth/2) && (this.stage == 1))
				|| (super.health < initialHealth/5) && (this.stage == 2)) {
			stage ++;
			super.power = super.power * 2;
		}
	}
	
	public static void main(String[] args) {
		Boss test = new Boss(600, 20);
		test.toString();
		test.takeDamage(190);
		test.toString();
		test.takeDamage(130);
		test.toString();
		test.takeDamage(80);
		test.toString();
	}
}
