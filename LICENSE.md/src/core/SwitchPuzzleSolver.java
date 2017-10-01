package core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class SwitchPuzzleSolver {
	SwitchPuzzle destination;
	SwitchPuzzle startConfiguration;

	public SwitchPuzzleSolver(SwitchPuzzle startConfiguration) {
		this.startConfiguration = startConfiguration;

	}
	
	public List<Integer> solve() {
		HashSet<PuzzlePath> closed = new HashSet<PuzzlePath>();
		HashSet<PuzzlePath> open = new HashSet<PuzzlePath>();
		HashMap<PuzzlePath, Integer> cameFrom = new HashMap<PuzzlePath, Integer>();
		open.add(new PuzzlePath(startConfiguration, 0, 0, null));
		while (!open.isEmpty()) {
			PuzzlePath current = this.getLowestScore(open);
			if (current.isGoal()) {
				closed.clear();
				open.clear();
				return reconstruct_path(cameFrom, current, current.pedestal);
			}
			open.remove(current);
			closed.add(current);
			for (PuzzlePath p : this.createPaths(current)) {
				if (this.isInSet(p, closed)) {
					continue;
				}
				if (!this.isInSet(p, open)) {
					open.add(p);
				}
				cameFrom.put(current, p.pedestal);
			}
			
		}
		return null;
	}
	
	private boolean isInSet(PuzzlePath p, HashSet<PuzzlePath> set) {
		for (PuzzlePath x : set) {
			if (x.toString().equals(p.toString())){
				return true;
			}
		}
		return false;
	}
	private List<Integer> reconstruct_path(HashMap<PuzzlePath, Integer> cameFrom, PuzzlePath current, int pedestal) {
		List<Integer> totalPath = new ArrayList<Integer>();
		while(!(current.pedestal == 0)) {
			totalPath.add(current.pedestal);
			current = current.neighbor;
		}
		cameFrom.clear();
		return totalPath;
	}
	
	private PuzzlePath getLowestScore(HashSet<PuzzlePath> set) {
		PuzzlePath lowest = null;
		for (PuzzlePath s : set) {
			if (lowest == null) {
				lowest = s;
				continue;
			}
			if (s.gScore() < lowest.gScore()) {
				lowest = s;
			}			
		}
		return lowest;
	}
	
	private HashSet<PuzzlePath> createPaths(PuzzlePath path){
		HashSet<PuzzlePath> ret = new HashSet<PuzzlePath>();

		for (int i = 0; i < path.size(); i++) {
			PuzzlePath p = new PuzzlePath(path.configuration.pressPedestal(i), path.gScore() + 1, i + 1, path);
			ret.add(p);
		}
		return ret;
		
	}
}
