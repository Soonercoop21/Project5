/**
 * Cell manipulation class following totalistic automata method. Defines cell neighbors according to 
 * generation and boundary condition inputs and produces cell evolution.
 * @author randle pool
 * @version 1.0
 */
public class TotalisticRule extends Rule{
	private int ruleNum;
	
	public TotalisticRule(int ruleNum) throws InvalidRuleNumException {
		super (ruleNum);
		String bin = Integer.toBinaryString(ruleNum);
		bin = ("000000" + bin).substring(bin.length());
		int length = bin.length();
		if ((ruleNum > 63) || (ruleNum < 0)) {
			throw new InvalidRuleNumException();
		}
		this.ruleNum = ruleNum;
	}
	
	public int getNumSubrules() {
		return 6;
	}
	
	public Cell[] getNeighborhood(int cellIdx, Generation gen, BoundaryConditions bc) {
		Cell[] ret = new Cell[5];
		ret[0] = bc.getNeighbor(cellIdx, -2, gen);
		ret[1] = bc.getNeighbor(cellIdx, -1, gen);
		ret[2] = bc.getNeighbor(cellIdx, 0, gen);
		ret[3] = bc.getNeighbor(cellIdx, 1, gen);
		ret[4] = bc.getNeighbor(cellIdx, 2, gen);
		return ret;
	}
	
	public EvolvedCell evolve(Cell[] neighborhood) {
		CellState leftleft = neighborhood[0].getState();
		CellState left = neighborhood[1].getState();
		CellState middle = neighborhood[2].getState();
		CellState right = neighborhood[3].getState();
		CellState rightright = neighborhood[4].getState();
		String bin = Integer.toBinaryString(ruleNum);
		bin = ("000000" + bin).substring(bin.length());
		int sum = 0;
		EvolvedCell ret = new EvolvedCell(CellState.OFF, 0);
		CellState six = CellState.OFF;
		CellState five = CellState.OFF;
		CellState four = CellState.OFF;
		CellState three = CellState.OFF;
		CellState two = CellState.OFF;
		CellState one = CellState.OFF;
		if(bin.charAt(0) == '1') {
			six = CellState.ON;
		}
		if(bin.charAt(1) == '1') {
			five = CellState.ON;
		}
		if(bin.charAt(2) == '1') {
			four = CellState.ON;
		}
		if(bin.charAt(3) == '1') {
			three = CellState.ON;
		}
		if(bin.charAt(4) == '1') {
			two = CellState.ON;
		}
		if(bin.charAt(5) == '1') {
			one = CellState.ON;
		}
		if (leftleft == CellState.OFF) {
			
		}
		else {
			sum++;
		}
		if (left == CellState.OFF) {
			
		}
		else {
			sum++;
		}
		if (middle == CellState.OFF) {
			
		}
		else {
			sum++;
		}
		if (right == CellState.OFF) {
			
		}
		else {
			sum++;
		}
		if (rightright == CellState.OFF) {
			
		}
		else {
			sum++;
		}
		if ((sum == 5) && (six == CellState.ON)) {
			EvolvedCell evol = new EvolvedCell(CellState.ON, 5);
			ret = evol;
		}
		else if ((sum == 5) && (six == CellState.OFF)) {
			EvolvedCell evol = new EvolvedCell(CellState.OFF, 5);
			ret = evol;
		}
		else if ((sum == 4) && (five == CellState.ON)) {
			EvolvedCell evol = new EvolvedCell(CellState.ON, 4);
			ret = evol;
		}
		else if ((sum == 4) && (five == CellState.OFF)) {
			EvolvedCell evol = new EvolvedCell(CellState.OFF, 4);
			ret = evol;
		}
		else if ((sum == 3) && (four == CellState.ON)) {
			EvolvedCell evol = new EvolvedCell(CellState.ON, 3);
			ret = evol;
		}
		else if ((sum == 3) && (four == CellState.OFF)) {
			EvolvedCell evol = new EvolvedCell(CellState.OFF, 3);
			ret = evol;
		}
		else if ((sum == 2) && (three == CellState.ON)) {
			EvolvedCell evol = new EvolvedCell(CellState.ON, 2);
			ret = evol;
		}
		else if ((sum == 2) && (three == CellState.OFF)) {
			EvolvedCell evol = new EvolvedCell(CellState.OFF, 2);
			ret = evol;
		}
		else if ((sum == 1) && (two == CellState.ON)) {
			EvolvedCell evol = new EvolvedCell(CellState.ON, 1);
			ret = evol;
		}
		else if ((sum == 1) && (two == CellState.OFF)) {
			EvolvedCell evol = new EvolvedCell(CellState.OFF, 1);
			ret = evol;
		}
		else if ((sum == 0) && (one == CellState.ON)) {
			EvolvedCell evol = new EvolvedCell(CellState.ON, 0);
			ret = evol;
		}
		else if ((sum == 0) && (one == CellState.OFF)) {
			EvolvedCell evol = new EvolvedCell(CellState.OFF, 0);
			ret = evol;
		}
		return ret;
	}
	
	public String toString() {
		String strone = "5 4 3 2 1 0";
		String bin = Integer.toBinaryString(ruleNum);
		bin = ("000000" + bin).substring(bin.length());
		CellState six = CellState.OFF;
		CellState five = CellState.OFF;
		CellState four = CellState.OFF;
		CellState three = CellState.OFF;
		CellState two = CellState.OFF;
		CellState one = CellState.OFF;
		if(bin.charAt(0) == '1') {
			six = CellState.ON;
		}
		if(bin.charAt(1) == '1') {
			five = CellState.ON;
		}
		if(bin.charAt(2) == '1') {
			four = CellState.ON;
		}
		if(bin.charAt(3) == '1') {
			three = CellState.ON;
		}
		if(bin.charAt(4) == '1') {
			two = CellState.ON;
		}
		if(bin.charAt(5) == '1') {
			one = CellState.ON;
		}
		String on = six.toString();
		String tw = five.toString();
		String th = four.toString();
		String fo = three.toString();
		String fi = two.toString();
		String si = one.toString();
		String strtwo = on + " " + tw + " " + th + " " + fo + " " + fi + " " + si;
		String ret = strone + "\n" + strtwo;
		return ret;
	}
}

