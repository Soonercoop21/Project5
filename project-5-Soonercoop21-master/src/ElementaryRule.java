/**
 * Cell manipulation class following elementary automata method. Defines cell neighbors according to 
 * generation and boundary condition inputs and produces cell evolution.
 * @author randle pool
 * @version 1.0
 */
public class ElementaryRule extends Rule{
	private int ruleNum;
	public int num = 0;
	public ElementaryRule(int ruleNum) throws InvalidRuleNumException {
		super(ruleNum);
		String bin = Integer.toBinaryString(ruleNum);
		bin = ("00000000" + bin).substring(bin.length());
		int length = bin.length();
		if ((ruleNum > 255) || (ruleNum < 0)) {
			throw new InvalidRuleNumException();
		}
		this.ruleNum = ruleNum;
	}
	
	public int getNumSubrules() {
		return num;
	}
	
	public Cell[] getNeighborhood(int cellIdx, Generation gen, BoundaryConditions bc) {
		Cell[] ret = new Cell[3];
		ret[0] = bc.getNeighbor(cellIdx, -1, gen);
		ret[1] = bc.getNeighbor(cellIdx, 0, gen);
		ret[2] = bc.getNeighbor(cellIdx, 1, gen);
		return ret;
	}
	
	public EvolvedCell evolve(Cell[] neighborhood) {
		CellState left = neighborhood[0].getState();
		CellState middle = neighborhood[1].getState();
		CellState right = neighborhood[2].getState();
		String bin = Integer.toBinaryString(ruleNum);
		bin = ("00000000" + bin).substring(bin.length());
		EvolvedCell ret = new EvolvedCell(CellState.OFF, 0);
		CellState eight = CellState.OFF;
		CellState seven = CellState.OFF;
		CellState six = CellState.OFF;
		CellState five = CellState.OFF;
		CellState four = CellState.OFF;
		CellState three = CellState.OFF;
		CellState two = CellState.OFF;
		CellState one = CellState.OFF;
		
		if(bin.charAt(0) == '1') {
			eight = CellState.ON;
		}
		if(bin.charAt(1) == '1') {
			seven = CellState.ON;
		}
		if(bin.charAt(2) == '1') {
			six = CellState.ON;
		}
		if(bin.charAt(3) == '1') {
			five = CellState.ON;
		}
		if(bin.charAt(4) == '1') {
			four = CellState.ON;
		}
		if(bin.charAt(5) == '1') {
			three = CellState.ON;
		}
		if(bin.charAt(6) == '1') {
			two = CellState.ON;
		}
		if(bin.charAt(7) == '1') {
			one = CellState.ON;
		}
		if ((left == CellState.ON) && (middle == CellState.ON) && (right == CellState.ON)) {
			EvolvedCell evol = new EvolvedCell(eight, 7);
			ret = evol;
			num = 7;
		}
		if ((left == CellState.ON) && (middle == CellState.ON) && (right == CellState.OFF)) {
			EvolvedCell evol = new EvolvedCell(seven, 6);
			ret = evol;
			num = 6;
		}
		if ((left == CellState.ON) && (middle == CellState.OFF) && (right == CellState.ON)) {
			EvolvedCell evol = new EvolvedCell(six, 5);
			ret = evol;
			num = 5;
		}
		if ((left == CellState.ON) && (middle == CellState.OFF) && (right == CellState.OFF)) {
			EvolvedCell evol = new EvolvedCell(five, 4);
			ret = evol;
			num = 4;
		}
		if ((left == CellState.OFF) && (middle == CellState.ON) && (right == CellState.ON)) {
			EvolvedCell evol = new EvolvedCell(four, 3);
			ret = evol;
			num = 3;
		}
		if ((left == CellState.OFF) && (middle == CellState.ON) && (right == CellState.OFF)) {
			EvolvedCell evol = new EvolvedCell(three, 2);
			ret = evol;
			num = 2;
		}
		if ((left == CellState.OFF) && (middle == CellState.OFF) && (right == CellState.ON)) {
			EvolvedCell evol = new EvolvedCell(two, 1);
			ret = evol;
			num = 1;
		}
		if ((left == CellState.OFF) && (middle == CellState.OFF) && (right == CellState.OFF)) {
			EvolvedCell evol = new EvolvedCell(one, 0);
			ret = evol;
			num = 0;
		}
		return ret;
		
	}
	
	public String toString() {
		String strone = "OOO OO. O.O O.. .OO .O. ..O ...";
		CellState eight = CellState.OFF;
		CellState seven = CellState.OFF;
		CellState six = CellState.OFF;
		CellState five = CellState.OFF;
		CellState four = CellState.OFF;
		CellState three = CellState.OFF;
		CellState two = CellState.OFF;
		CellState one = CellState.OFF;
		String bin = Integer.toBinaryString(ruleNum);
		bin = ("00000000" + bin).substring(bin.length());
		if(bin.charAt(0) == '1') {
			eight = CellState.ON;
		}
		if(bin.charAt(1) == '1') {
			seven = CellState.ON;
		}
		if(bin.charAt(2) == '1') {
			six = CellState.ON;
		}
		if(bin.charAt(3) == '1') {
			five = CellState.ON;
		}
		if(bin.charAt(4) == '1') {
			four = CellState.ON;
		}
		if(bin.charAt(5) == '1') {
			three = CellState.ON;
		}
		if(bin.charAt(6) == '1') {
			two = CellState.ON;
		}
		if(bin.charAt(7) == '1') {
			one = CellState.ON;
		}
		String on = eight.toString();
		String tw = seven.toString();
		String th = six.toString();
		String fo = five.toString();
		String fi = four.toString();
		String si = three.toString();
		String se = two.toString();
		String ei = one.toString();
		String strtwo = " " + on + "   " + tw + "   " + th + "   " + fo + "   " + fi + "   " + si + "   " + se + "   " + ei + " ";
		String fin = strone + "\n" + strtwo;
		//String fin = String.join(System.getProperty("line.separator"), strone, strtwo); 
		return fin;
	}
}
