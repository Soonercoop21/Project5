/**
 * Class defining special cell type which contains additional information.
 * @author randle pool
 * @version 1.0
 */
public class EvolvedCell extends Cell{
	private int subruleNum;
	private CellState state;
	
	public EvolvedCell(CellState state, int subruleNum) {
		this.subruleNum = subruleNum;
		this.state = state;
	}
	
	public int getSubruleNum() {
		return subruleNum;
	}
	
	public CellState getState() {
		return state;
	}
	
	public String toString() {
		CellState state = getState();
		String ret = "";
		if (state == CellState.ON) {
			ret = "O";
		}
		if (state == CellState.OFF) {
			ret = ".";
		}
		
		return ret;
	}
}
