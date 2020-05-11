/**
 * Class containing automaton measurements
 * @author randle pool
 * @version 1.0
 */
public class AutomatonMeasurements {
	public static int hammingDistance(Generation g1, Generation g2) {
		if (g1.size() != g2.size()) {
			throw new IllegalArgumentException();
		}
		int length = g1.size();
		int sum = 0;
		for (int idx = 0;idx < length; idx++) {
			if (g1.getCell(idx).getState() != g2.getCell(idx).getState()) {
				sum++;
			}
		}
		return sum;
	}
	
	public static int hammingDistance(int stepNum, Automaton a) throws InvalidStepNumException {
		int hamm = 0;
		if (stepNum > 0) {
			Generation one = a.getGeneration(stepNum -1);
			Generation two = a.getGeneration(stepNum);
			hamm = hammingDistance(one, two);
		}  
		return hamm;
	}
	
	public static int[] hammingDistances(Automaton a) throws InvalidStepNumException {
		int totsteps = a.getTotalSteps();
		int[] hamm = new int[totsteps];
		for (int idx = 1;idx <= totsteps; idx++) {
			hamm[(idx - 1)] = hammingDistance(idx, a);
		}  
		return hamm;
		
	}
	
	public static int[] subruleCount(int stepNum, Automaton a) throws InvalidStepNumException {
		int[] ne = {0, 0};
		return ne;
			
	}
	
	public static int[][] subruleCounts(Automaton a) {
		int[] ne = {0, 0};
		int[][] nee = {ne, ne};
		return nee;
	}
	
	public String[] subrulescount(Automaton a) {
		String[] str = a.getallsubrules();
		str[0] = "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
		return a.getallsubrules();
	}
}
