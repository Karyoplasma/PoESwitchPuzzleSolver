package core;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class SwitchPuzzleSolverGUI implements ActionListener {

	private JFrame frmFloorPuzzleSolver;
	private JCheckBox checkBox_p1;
	private JCheckBox checkBox_p2;
	private JCheckBox checkBox_p3;
	private JCheckBox checkBox_p8;
	private JCheckBox checkBox_p7;
	private JCheckBox checkBox_p6;
	private JCheckBox checkBox_p4;
	private JCheckBox checkBox_p5;
	private JButton btnSolve;
	private boolean testMode;
	private final List<JCheckBox> pedestals = new ArrayList<JCheckBox>();
	private JTextField textField_solution;
	private JButton btnTestMode;
	private final SwitchPuzzle puzzle = new SwitchPuzzle(new boolean[] {false, false, false, false, false, false, false, false});
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwitchPuzzleSolverGUI window = new SwitchPuzzleSolverGUI();
					window.frmFloorPuzzleSolver.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SwitchPuzzleSolverGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFloorPuzzleSolver = new JFrame();
		frmFloorPuzzleSolver.setResizable(false);
		frmFloorPuzzleSolver.setTitle("Switch Puzzle Solver");
		frmFloorPuzzleSolver.setBounds(100, 100, 265, 297);
		frmFloorPuzzleSolver.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFloorPuzzleSolver.getContentPane().setLayout(null);
		
		checkBox_p1 = new JCheckBox("1");
		checkBox_p1.addActionListener(this);
		checkBox_p1.setBounds(50, 30, 40, 25);
		frmFloorPuzzleSolver.getContentPane().add(checkBox_p1);
		
		checkBox_p2 = new JCheckBox("2");
		checkBox_p2.addActionListener(this);
		checkBox_p2.setBounds(110, 30, 40, 25);
		frmFloorPuzzleSolver.getContentPane().add(checkBox_p2);
		
		checkBox_p3 = new JCheckBox("3");
		checkBox_p3.addActionListener(this);
		checkBox_p3.setBounds(170, 30, 40, 25);
		frmFloorPuzzleSolver.getContentPane().add(checkBox_p3);
		
		checkBox_p8 = new JCheckBox("8");
		checkBox_p8.addActionListener(this);
		checkBox_p8.setBounds(50, 90, 40, 25);
		frmFloorPuzzleSolver.getContentPane().add(checkBox_p8);
		
		checkBox_p7 = new JCheckBox("7");
		checkBox_p7.addActionListener(this);
		checkBox_p7.setBounds(50, 150, 40, 25);
		frmFloorPuzzleSolver.getContentPane().add(checkBox_p7);
		
		checkBox_p6 = new JCheckBox("6");
		checkBox_p6.addActionListener(this);
		checkBox_p6.setBounds(110, 150, 40, 25);
		frmFloorPuzzleSolver.getContentPane().add(checkBox_p6);
		
		checkBox_p4 = new JCheckBox("4");
		checkBox_p4.addActionListener(this);
		checkBox_p4.setBounds(170, 90, 40, 25);
		frmFloorPuzzleSolver.getContentPane().add(checkBox_p4);
		
		checkBox_p5 = new JCheckBox("5");
		checkBox_p5.addActionListener(this);
		checkBox_p5.setBounds(170, 150, 40, 25);
		frmFloorPuzzleSolver.getContentPane().add(checkBox_p5);
		
		btnSolve = new JButton("Solve");
		btnSolve.setBounds(160, 235, 90, 23);
		btnSolve.addActionListener(this);
		frmFloorPuzzleSolver.getContentPane().add(btnSolve);
		
		btnTestMode = new JButton("Test");
		btnTestMode.setBounds(10, 235, 90, 23);
		btnTestMode.addActionListener(this);
		frmFloorPuzzleSolver.getContentPane().add(btnTestMode);
		
		testMode = false;
		pedestals.add(checkBox_p1);
		pedestals.add(checkBox_p2);
		pedestals.add(checkBox_p3);
		pedestals.add(checkBox_p4);
		pedestals.add(checkBox_p5);
		pedestals.add(checkBox_p6);
		pedestals.add(checkBox_p7);
		pedestals.add(checkBox_p8);
		
		textField_solution = new JTextField();
		textField_solution.setEditable(false);
		textField_solution.setHorizontalAlignment(SwingConstants.CENTER);
		textField_solution.setBounds(10, 201, 240, 20);
		frmFloorPuzzleSolver.getContentPane().add(textField_solution);
		textField_solution.setColumns(10);
	}
	
	private void getFloorPuzzleFromGUI() {
		boolean[] configuration = new boolean[pedestals.size()];
		for (int i = 0; i < pedestals.size(); i++) {
			configuration[i] = pedestals.get(i).isSelected();
		}
		puzzle.setConfiguration(configuration);
	}
	
	private void visualizeFloorPuzzle(SwitchPuzzle puzzle) {
		for (int i = 0; i < puzzle.size(); i++) {
			pedestals.get(i).setSelected(puzzle.configuration[i]);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == checkBox_p1) {
			if (!testMode) {
				return;
			}
			getFloorPuzzleFromGUI();
			puzzle.configuration[0] = !puzzle.configuration[0];
			visualizeFloorPuzzle(puzzle.pressPedestal(0));
			return;
		}
		if (e.getSource() == checkBox_p2) {
			if (!testMode) {
				return;
			}
			getFloorPuzzleFromGUI();
			puzzle.configuration[1] = !puzzle.configuration[1];
			visualizeFloorPuzzle(puzzle.pressPedestal(1));
			return;
		}
		if (e.getSource() == checkBox_p3) {
			if (!testMode) {
				return;
			}
			getFloorPuzzleFromGUI();
			puzzle.configuration[2] = !puzzle.configuration[2];
			visualizeFloorPuzzle(puzzle.pressPedestal(2));
			return;
		}
		if (e.getSource() == checkBox_p4) {
			if (!testMode) {
				return;
			}
			getFloorPuzzleFromGUI();
			puzzle.configuration[3] = !puzzle.configuration[3];
			visualizeFloorPuzzle(puzzle.pressPedestal(3));
			return;
		}
		if (e.getSource() == checkBox_p5) {
			if (!testMode) {
				return;
			}
			getFloorPuzzleFromGUI();
			puzzle.configuration[4] = !puzzle.configuration[4];
			visualizeFloorPuzzle(puzzle.pressPedestal(4));
			return;
		}
		if (e.getSource() == checkBox_p6) {
			if (!testMode) {
				return;
			}
			getFloorPuzzleFromGUI();
			puzzle.configuration[5] = !puzzle.configuration[5];
			visualizeFloorPuzzle(puzzle.pressPedestal(5));
			return;
		}
		if (e.getSource() == checkBox_p7) {
			if (!testMode) {
				return;
			}
			getFloorPuzzleFromGUI();
			puzzle.configuration[6] = !puzzle.configuration[6];
			visualizeFloorPuzzle(puzzle.pressPedestal(6));
			return;
		}
		if (e.getSource() == checkBox_p8) {
			if (!testMode) {
				return;
			}
			getFloorPuzzleFromGUI();
			puzzle.configuration[7] = !puzzle.configuration[7];
			visualizeFloorPuzzle(puzzle.pressPedestal(7));
			return;
		}
		if (e.getSource() == btnSolve) {
			getFloorPuzzleFromGUI();
			SwitchPuzzleSolver solver = new SwitchPuzzleSolver(puzzle);
			List<Integer> result = solver.solve();
			StringBuffer buffer = new StringBuffer();
			for (Integer i : result) {
				buffer.append(i).append(", ");
			}
			if (buffer.length() == 0) {
				textField_solution.setText("Already solved!");
				return;
			}
			buffer.setLength(buffer.length() - 2);
			textField_solution.setText(buffer.toString());
			return;
		}
		if (e.getSource() == btnTestMode) {
			testMode = !testMode;
			if (testMode) {
				btnTestMode.setText("Exit Test");
				btnSolve.setEnabled(false);
			} else {
				btnTestMode.setText("Test");
				btnSolve.setEnabled(true);
			}
		}
		
	}
}
