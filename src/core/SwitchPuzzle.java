package core;

public class SwitchPuzzle {
	boolean[] configuration;
	
	public SwitchPuzzle(boolean[] configuration) {
		this.configuration = configuration;
	}
	
	public SwitchPuzzle pressPedestal(int index) {
		int max = configuration.length;
		boolean[] puzzle = new boolean[max];
		for (int i = 0; i<max; i++) {
			if (this.configuration[i]) {
				puzzle[i] = true;
			} else {
				puzzle[i] = false;
			}		
		}

		puzzle[this.modulo(index - 1, max)] = !puzzle[this.modulo(index - 1, max)];
		puzzle[this.modulo(index, max)] = !puzzle[this.modulo(index, max)];
		puzzle[this.modulo(index + 1, max)] = !puzzle[this.modulo(index + 1, max)];
		return new SwitchPuzzle(puzzle);	
	}
	
	public boolean isGoal() {
		for (boolean b : configuration) {
			if (!b) {
				return false;
			}
		}
		return true;
	}
	
	public void setConfiguration(boolean[] configuration) {
		this.configuration = configuration;
	}
	public int size() {
		return this.configuration.length;
	}
	private int modulo(int a, int b) {
		if ((a % b)<0) {
			return a+b;
		}
		return a%b;
	}
	@Override
	public String toString(){
		StringBuffer ret = new StringBuffer();
		for (boolean b : this.configuration) {
			if (b) {
				ret.append("X");
			} else {
				ret.append("O");
			}
			
		}
		return ret.toString();
	}

}
		
