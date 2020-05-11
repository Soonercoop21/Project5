/**
 * Subject to Boundary Conditions, enforces circular boundary type on neighbor searching method.
 * @author randle pool
 * @version 1.0
 */
public class CircularBoundaryConditions implements BoundaryConditions{

		public CircularBoundaryConditions() {
			
		}
		
		public Cell getNeighbor(int cellIdx, int offset, Generation gen) {
			int length = gen.size();
			int difference = cellIdx + offset;
			int ret = difference;
			if (difference < 0) {
				while (ret < 0) {
					ret = length + ret;
				}
			}
			else if (difference > (length-1)) {
				while (ret > (length-1)) {
					ret = ret - length;
				}
			}
			return gen.getCell(ret);
		}
		
}
