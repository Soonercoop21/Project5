import java.util.HashMap;
import java.util.Map;
/**
 * Class which defines cell state values and maps their symbols.
 * @author randle pool
 * @version 1.0
 */
public enum CellState {
	OFF,
	ON;
	
	private char symbol;
	private static Map<Character, CellState> SYMBOL_TO_STATE = initializeMap();
	
	private static Map<Character, CellState> initializeMap() {
		Map<Character, CellState> map = new HashMap<>();
		map.put('.', OFF);
		map.put('O', ON);
		return map;
	}
	
	private CellState(char symbol) {
		this.symbol = symbol;
	}
	
	CellState() {
		// TODO Auto-generated constructor stub
	}

	public static CellState getState(char symbol) {
		return SYMBOL_TO_STATE.get(symbol);
	}
	
	public String toString() {
		String name = name();
		String ret = ".";
		switch(name) {
		case "OFF":
			ret = ".";
		break;
		case "ON":
			ret = "O";
		break;
		}
		return ret;
	}
	
}
