package core;

public class PuzzlePath implements Comparable<PuzzlePath>{
	private int gscore;
	private SwitchPuzzle configuration;
	private PuzzlePath neighbor;
	private int pedestal;

	public PuzzlePath(SwitchPuzzle configuration, int gscore, int pedestal, PuzzlePath neighbor) {
		this.neighbor = neighbor;
		this.gscore = gscore;
		this.configuration = configuration;
		this.pedestal = pedestal;
	}
	
	public int size() {
		return this.configuration.size();
	}
	
	public boolean isGoal() {
		return configuration.isGoal();
	}
	
	public int getGscore() {
		return this.gscore;
	}

	public SwitchPuzzle getConfiguration() {
		return this.configuration;
	}

	public PuzzlePath getNeighbor() {
		return this.neighbor;
	}

	public int getPedestal() {
		return this.pedestal;
	}

	public void setNeighbor(PuzzlePath neighbor) {
		this.neighbor = neighbor;
	}
	
	@Override
	public String toString() {
		StringBuffer ret = new StringBuffer();
		ret.append("(").append(configuration.toString()).append(", ").append(this.gscore);
		ret.append(")");
		return ret.toString();
	}
	
	@Override
	public boolean equals(Object p) {
		if (p instanceof PuzzlePath) {
			return this.toString().equals(p.toString());
		}
		return false;
		
	}

	@Override
	public int compareTo(PuzzlePath o) {
		if (this.getGscore() == o.getGscore()) {
			return 0;
		} else {
			if (this.getGscore() > o.getGscore()) {
				return 1;
			} else {
				return -1;
			}
		}
	}
}
