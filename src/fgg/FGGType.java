package fgg;

enum FGGType {
	STONE(0, "stone"),
	SHEAR(1, "shear"),
	CLOTH(2, "cloth"),
	EMPTY(3, "empty");
	
	private final String name;
	private final int id;
	
	private FGGType(int id, String name) {
		this.name = name;
		this.id = id;
	}
	
	public static FGGType getTypeFromId(int id) {
		for(FGGType type : values()) {
			if(type.getId() == id) {
				return type;
			}
		}
		return EMPTY;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String toString() {
		return this.getName();
	}
}
