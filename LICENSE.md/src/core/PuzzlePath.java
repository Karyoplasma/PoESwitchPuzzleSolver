package core;

public class PuzzlePath {
	public int gscore;
	public SwitchPuzzle configuration;
	public PuzzlePath neighbor;
	public int pedestal;
	
	public PuzzlePath(SwitchPuzzle configuration, int gscore, int pedestal, PuzzlePath neighbor) {
		this.neighbor = neighbor;
		this.gscore = gscore;
		this.configuration = configuration;
		this.pedestal = pedestal;
	}
	
	public int size() {
		return this.configuration.size();
	}
	
	public int gScore() {
		return this.gscore;
	}
	
	public boolean isGoal() {
		return configuration.isGoal();
	}
	@Override
	public String toString() {
		StringBuffer ret = new StringBuffer();
		ret.append("(").append(configuration.toString()).append(", ").append(this.gscore);
		ret.append(")");
		return ret.toString();
	}

}
