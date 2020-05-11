/**
 * Evolves generations following cell-wise evolution of counterpart Rule classes.
 * @author randle pool
 * @version 1.0
 */
public abstract class Rule {
	private int ruleNum;
	private int totalistic = 0;
	private int elementary = 0;
	public String subrules = "";
	protected Rule(int ruleNum) {
		int num = getNumSubrules();
		if (num == 8) {
			elementary = 1;
			String bin = Integer.toBinaryString(ruleNum);
			bin = ("00000000" + bin).substring(bin.length());
		}
		else if (num == 6) {
			totalistic = 1;
			String bin = Integer.toBinaryString(ruleNum);
			bin = ("000000" + bin).substring(bin.length());
		}
		this.ruleNum = ruleNum;
	}
	
	public int getRuleNum() {
		return ruleNum;
	}
	
	public Generation evolve(Generation gen, BoundaryConditions bc) {
		subrules = "";
		int length = gen.size();
		EvolvedCell[] ret = new EvolvedCell[length];
		for (int i = 0; i < length; i++) {
			Cell[] neighborhood = getNeighborhood(i, gen, bc);
			ret[i] = evolve(neighborhood);
			subrules = subrules + getNumSubrules();
		}
		Generation retu = new Generation(ret);
		return retu;
		
	}
	
	public String subrules() {
		return subrules;
	}
	
	public abstract int getNumSubrules();
	
	public abstract Cell[] getNeighborhood(int cellIdx, Generation gen, BoundaryConditions bc);
	
	public abstract EvolvedCell evolve(Cell[] neighborhood);
	
	public abstract String toString();
}
