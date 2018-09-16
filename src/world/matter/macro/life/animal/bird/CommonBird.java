package world.matter.macro.life.animal.bird;

public class CommonBird extends Bird {
	public static CommonBird EMPTY = new CommonBird();
	
	@Override
	public void Fly() {
		System.out.println("bird is flying");
	}
}
