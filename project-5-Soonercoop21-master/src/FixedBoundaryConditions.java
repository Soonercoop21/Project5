/**
 * Subject to Boundary Conditions, enforces fixed boundary type on neighbor searching method.
 * @author randle pool
 * @version 1.0
 */
public class FixedBoundaryConditions implements BoundaryConditions{
	private CellState right;
	private CellState left;
	public FixedBoundaryConditions(CellState left, CellState right) {
		this.left = left;
		this.right = right;
	}
	
	public CellState getLeftState() {
		return left;
	}
	
	public CellState getRightState() {
		return right;
	}
	
	public Cell getNeighbor(int cellIdx, int offset, Generation gen) {
		int length = gen.size();
		int difference = cellIdx + offset;
		Cell retcell;
		if (difference < 0) {
			retcell = new Cell(getLeftState());
		}
		else if (difference > (length - 1)) {
			retcell = new Cell(getRightState());
			
		}
		else {
			retcell = gen.getCell(difference);
		}
		return retcell;
	}
}
