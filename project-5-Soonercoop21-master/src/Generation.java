/**
 * Defines cell arrays within an itemized class.
 * @author randle pool
 * @version 1.0
 */
public class Generation {
	private Cell[] cells;
	
	public Generation(CellState[] states) {
		Cell[] tempcell = new Cell[states.length];
		for (int i = 0; i < states.length; i++) {
			Cell cell1 = new Cell(states[i]);
			tempcell[i] = cell1;
		}
		this.cells = tempcell.clone();
	}
	
	public Generation(String states) {
		char[] charStates = states.toCharArray();
		Cell[] tempcell = new Cell[charStates.length];
		CellState[] tempcellState = new CellState[charStates.length];
		for (int i = 0; i < charStates.length; i++) {
			if ((charStates[i] != 'O') && (charStates[i] != '.')) {
				throw new IllegalArgumentException();
			}
			tempcellState[i] = CellState.getState(charStates[i]);
			Cell cell1 = new Cell(tempcellState[i]);
			tempcell[i] = cell1;
		}
		this.cells = tempcell.clone();
	}
	
	public Generation(Cell[] cells) {
		this.cells = cells.clone();
	}
	
	public int size() {
		return cells.length;
	}
	
	public Cell getCell(int idx) {
		return cells[idx];
	}
	
	public String toString() {
		String ret = "";
		for (int i = 0; i < cells.length; i++) {
			ret = ret + cells[i].toString();
		}
		return ret;
	}
}
