import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;   
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class Tests {

	public static void main(String[] args) throws InvalidRuleNumException, InvalidStepNumException { 
		
		JFrame frame = new JFrame("Automata Generator");
        
        frame.setSize(400, 300);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        FlowLayout layout = new FlowLayout();
        frame.setLayout(layout);
        
        JButton b1 = new JButton("Generate (Hamming Distance)");
        JButton b2 = new JButton("Generate (Subrules Count)");
        JButton b3 = new JButton("Clear");
        
        String[] ruleNums = new String[256];
        for (int idx = 0; idx <256; idx++) {
        	ruleNums[idx] = Integer.toString(idx);
        }
        final JComboBox<String> ruleNum = new JComboBox<String>(ruleNums);
        ruleNum.setVisible(true);
        
        String[] ruleTypes = {"Elementary", "Totalistic"};
        final JComboBox<String> ruleType = new JComboBox<String>(ruleTypes);
        ruleType.setVisible(true);
        
        String[] boundTypes = {"Circular", "Fixed"};
        final JComboBox<String> boundType = new JComboBox<String>(boundTypes);
        ruleType.setVisible(true);
        
        JLabel instruct = new JLabel("Select a Rule Number:");
        instruct.setVisible(true);
        
        JLabel instruct2 = new JLabel("Select a Rule Type:");
        instruct2.setVisible(true);
        
        JLabel instruct3 = new JLabel("Select Boundary Conditions:");
        instruct3.setVisible(true);
        
        JLabel instruct4 = new JLabel("Input Initial Generation (length 101):");
        instruct4.setVisible(true);
        
        JTextField field = new JTextField(10);
        
        
        frame.add(instruct);
        frame.add(ruleNum);
        frame.add(instruct4);
        frame.add(field);
        frame.add(instruct2);
        frame.add(ruleType);
        frame.add(instruct3);
        frame.add(boundType);
        frame.add(b1);
        frame.add(b2);
        frame.add(b3);
        frame.pack();
        
        String hist = "";
        b1.addActionListener(new ActionListener(){
        	String states = "..................................................O..................................................";
            @Override
            public void actionPerformed(ActionEvent e)
            {
            	if ((field.getText() != null) && (field.getText().length() == 101)) {
            		states = field.getText();
            	}
                Boolean circ = true;
                int ruleNumss = 28;
                ruleNumss = Integer.parseInt(String.valueOf(ruleNum.getSelectedItem()));
                if (String.valueOf(boundType.getSelectedItem()) == "Fixed") {
                	circ = false;
                }
                if (String.valueOf(ruleType.getSelectedItem()) == "Totalistic") {
						try {
							Totalistic(circ, ruleNumss, states);
						} catch (InvalidRuleNumException | InvalidStepNumException | IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
                }
                else if (String.valueOf(ruleType.getSelectedItem()) == "Elementary") {
                	try {
						Elementary(circ, ruleNumss, states);
					} catch (InvalidRuleNumException | InvalidStepNumException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                }
                hammingPlot();
            }
        });
        
        b2.addActionListener(new ActionListener(){
        	String states = "..................................................O..................................................";
            @Override
            public void actionPerformed(ActionEvent e)
            {
            	if ((field.getText() != null) && (field.getText().length() == 101)) {
            		states = field.getText();
            	}
                Boolean circ = true;
                int ruleNumss = 28;
                ruleNumss = Integer.parseInt(String.valueOf(ruleNum.getSelectedItem()));
                if (String.valueOf(boundType.getSelectedItem()) == "Fixed") {
                	circ = false;
                }
                if (String.valueOf(ruleType.getSelectedItem()) == "Totalistic") {
						try {
							Totalistic(circ, ruleNumss, states);
						} catch (InvalidRuleNumException | InvalidStepNumException | IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
                }
                else if (String.valueOf(ruleType.getSelectedItem()) == "Elementary") {
                	try {
						Elementary(circ, ruleNumss, states);
					} catch (InvalidRuleNumException | InvalidStepNumException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                }
                subrulePlot();
            }
        });
        
        b3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });
        
	
	}
	
	public static void Totalistic(Boolean circ, int ruleNum, String states) throws InvalidRuleNumException, InvalidStepNumException, IOException {
		Generation init = new Generation(states);
		CircularBoundaryConditions bc1 = new CircularBoundaryConditions();
		int rule22 = 149;
		TotalisticRule rule1 = new TotalisticRule(rule22);
		Automaton b = new Automaton(rule1, init, bc1);
		if (circ == true) {
			TotalisticRule rule = new TotalisticRule(ruleNum);
			CircularBoundaryConditions bc = new CircularBoundaryConditions();
			Automaton a = new Automaton(rule, init, bc);
			b = a;
		}
		else if (circ == false) {
			TotalisticRule rule = new TotalisticRule(ruleNum);
			FixedBoundaryConditions bc = new FixedBoundaryConditions(CellState.OFF, CellState.OFF);
			Automaton a = new Automaton(rule, init, bc);
			b = a;
		}
		Generate(b);
	}
	
	public static void Elementary(Boolean circ, int ruleNum, String states) throws InvalidRuleNumException, InvalidStepNumException, IOException {
		Generation init = new Generation(states);
		CircularBoundaryConditions bc1 = new CircularBoundaryConditions();
		int rule22 = 149;
		ElementaryRule rule1 = new ElementaryRule(rule22);
		Automaton b = new Automaton(rule1, init, bc1);
		
		if (circ == true) {
			ElementaryRule rule = new ElementaryRule(ruleNum);
			CircularBoundaryConditions bc = new CircularBoundaryConditions();
			Automaton a = new Automaton(rule, init, bc);
			b = a;
		}
		
		else if (circ == false) {
			ElementaryRule rule = new ElementaryRule(ruleNum);
			FixedBoundaryConditions bc = new FixedBoundaryConditions(CellState.OFF, CellState.OFF);
			Automaton a = new Automaton(rule, init, bc);
			b = a;
		}
		Generate(b);
	}
	
	public static void Generate(Automaton b) throws InvalidRuleNumException, InvalidStepNumException, IOException {
		
		b.evolve(100);
		String ee = b.getHistory();
		String stringg = "";
		AutomatonMeasurements bb = new AutomatonMeasurements();
		for (int idx = 0; idx < 101; idx++) {
			stringg = stringg + bb.hammingDistance(idx, b) + "\n";
		    //System.out.println(bb.hammingDistance(idx, b));
		}
		File hamming = new File("hamming.txt");
		FileWriter b1 = new FileWriter("hamming.txt");
		b1.write(stringg);
		b1.close();
		String[] str = bb.subrulescount(b);
		String stringgg = "";
		for (int idx = 0; idx < 101; idx++) {
			int zero = 0;
			int one = 0;
			int two = 0;
			int three = 0;
			int four = 0;
			int five = 0;
			int six = 0;
			int seven = 0;
			for (int idxx = 0; idxx < 101; idxx++) {
				if (str[idx].charAt(idxx) == '0') {
					zero++;
				}
				if (str[idx].charAt(idxx) == '1') {
					one++;
				}
				if (str[idx].charAt(idxx) == '2') {
					two++;
				}
				if (str[idx].charAt(idxx) == '3') {
					three++;
				}
				if (str[idx].charAt(idxx) == '4') {
					four++;
				}
				if (str[idx].charAt(idxx) == '5') {
					five++;
				}
				if (str[idx].charAt(idxx) == '6') {
					six++;
				}
				if (str[idx].charAt(idxx) == '7') {
					seven++;
				}
			}
			stringgg = stringgg + zero + "," + one + "," + two + "," + three + "," + four + "," + five + "," + six + "," + seven + "\n";
			//System.out.println(zero + "," + one + "," + two + "," + three + "," + four + "," + five + "," + six + "," + seven);
		}
		File subrule = new File("subrule.txt");
		FileWriter b2 = new FileWriter("subrule.txt");
		b2.write(stringgg);
		b2.close();
		FileWriter b3 = new FileWriter("history.txt");
		b3.write(ee);
		b3.close();
		JOptionPane.showMessageDialog(null, ee,"Automaton", JOptionPane.DEFAULT_OPTION);
		
	}
	
	public static void subrulePlot() {
		String[] str = {""};
		SubrulesPlot aaa = new SubrulesPlot();
		aaa.main(str);
	}
	
	public static void hammingPlot() {
		String[] str = {""};
		HammingPlot bbb = new HammingPlot();
		bbb.main(str);
	}
}
