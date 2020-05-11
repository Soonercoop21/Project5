import java.util.ArrayList;
import java.util.List;
/**
 * Class containing automaton features and control methods. Allows creation of automata.
 * @author randle pool
 * @version 1.0
 */
public class Automaton {
	private Rule rule;
	private List<Generation> generations = new ArrayList<Generation>();
	private BoundaryConditions bc;
	private int steps = 0;
	public String[] subrules = new String[120];
	public Automaton(Rule rule, Generation init, BoundaryConditions bc) {
		this.rule = rule;
		generations.add(init);
		this.bc = bc;
	}
	
	public Rule getRule() {
		return rule;
	}
	
	public Generation getGeneration(int stepNum) throws InvalidStepNumException {
		Generation ret;
		int steps = getTotalSteps();
		if (stepNum < 0) {
			throw new InvalidStepNumException();
		}
		else if (stepNum <= steps) {
			ret = generations.get(stepNum);
		}
		else if (stepNum >  steps) {
			int difference = stepNum - steps;
			evolve(difference);
			ret = generations.get(stepNum);
		}
		else {
			ret = generations.get(stepNum);
		}
		return ret;
	}
	
	public BoundaryConditions getBoundaryConditions() {
		return bc;
	}
	
	public void evolve(int numSteps) {
		BoundaryConditions bc = getBoundaryConditions();
		Rule rule = getRule();
		if (numSteps < 1) {
			
		}
		else {
			for (int i = 0; i < numSteps; i++) {
				Generation ret = rule.evolve(generations.get(steps), bc);
				steps++;
				generations.add(ret);
				subrules[getTotalSteps()] = rule.subrules();
			}
		}
	}
	
	public String[] getallsubrules() {
		return subrules;
	}
	
	public int getTotalSteps() {
		return steps;
	}
	
	public String toString() {
		return generations.get(steps).toString();
	}
	
	public String getHistory() {
		String history = "";
		for (int idx = 0; idx < steps; idx++) {
			history = history + generations.get(idx).toString() + "\n";
		}
		history = history + generations.get(steps);
		return history;
	}
}