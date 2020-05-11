/**
 * Class which stores a state, known as a cell.
 * @author randle pool
 * @version 1.0
 */
public class Cell {

		private CellState state;
		
		public Cell() {
			state = CellState.OFF;
		}
		
		public Cell(CellState state) {
			this.state = state;
		}
		
		public CellState getState() {
			return state;
		}
		
		public String toString() {
			return state.toString();
		}
		
}
