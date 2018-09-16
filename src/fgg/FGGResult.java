package fgg;

enum FGGResult {
	SUCCESS(1, "success"),
	FAILURE(2, "failure"),
	DRAW(3, "draw");
	
	private final int id;
	private final String result;
	public static FGGResult[] lookForId = new FGGResult[2];
	
	private FGGResult(int id, String result) {
		this.id = id;
		this.result = result;
	}
	
	public String getResult() {
		return this.result;
	}
	
	public int getId() {
		return this.id;
	}
	
	public static FGGResult getFGGResultForId(int id) {
		if(id <= FGGResult.lookForId.length) {
			return FGGResult.lookForId[id - 1];
		}
		
		return FGGResult.DRAW;
	}
	
	public static FGGResult determineSOF(FGGType type1, FGGType type2) {
		if(type1 != FGGType.EMPTY && type2 != FGGType.EMPTY && type1 != type2) {
			int value = type1.getId() - type2.getId();//-1&2 s, 1&-2 f
			if(value == 2) {
				value = -1;
			} else if(value == -2) {
				value = 1;
			}
			
			return FGGResult.getFGGResultForId((5 * value + 15) / 10);
		}
		
		return DRAW;
		
		/*if(type1 != FGGType.EMPTY && type2 != FGGType.EMPTY) {
			if(type1 == type2) {
				return DRAW;
			} else if((type1 == FGGType.STONE && type2 == FGGType.SHEAR) || (type1 == FGGType.SHEAR && type2 == FGGType.CLOTH) || (type1 == FGGType.CLOTH && type2 == FGGType.STONE)) {
				return SUCCESS;
			} else if((type1 == FGGType.SHEAR && type2 == FGGType.STONE) || (type1 == FGGType.CLOTH && type2 == FGGType.SHEAR) || (type1 == FGGType.STONE && type2 == FGGType.CLOTH)) {
				return FAILURE;
			}
		}
		return DRAW;*/
	}
	
	public static String resultToCN(FGGResult result) {
		if(result == SUCCESS) {
			return "Ê¤Àû";
		} else if(result == FAILURE) {
			return "Ê§°Ü";
		} else if(result == DRAW) {
			return "Æ½¾Ö";
		} else {
			return "´íÎó";
		}
	}
	
	static {
		for(FGGResult id : FGGResult.values()) {
			FGGResult.lookForId[id.getId() - 1] = id;
		}
	}
}
