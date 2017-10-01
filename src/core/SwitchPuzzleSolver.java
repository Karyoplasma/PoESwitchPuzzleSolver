package core;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class SwitchPuzzleSolver {
	SwitchPuzzle destination;
	SwitchPuzzle startConfiguration;

	public SwitchPuzzleSolver(SwitchPuzzle startConfiguration) {
		this.startConfiguration = startConfiguration;

	}
	
	public List<Integer> solve() {
		PriorityQueue<PuzzlePath> closed = new PriorityQueue<PuzzlePath>();
		PriorityQueue<PuzzlePath> open = new PriorityQueue<PuzzlePath>();
		open.add(new PuzzlePath(startConfiguration, 0, 0, null));
		while (!open.isEmpty()) {
			PuzzlePath current = open.poll();
			if (current.isGoal()) {
				closed.clear();
				open.clear();
				return reconstruct_path(current, current.getPedestal());
			}
			closed.add(current);
			for (PuzzlePath p : this.createPaths(current)) {
				if (closed.contains(p)) {
					continue;
				}
				if (!open.contains(p)) {
					open.add(p);
				}
			}
			
		}
		return null;
	}
	
	private List<Integer> reconstruct_path(PuzzlePath current, int pedestal) {
		List<Integer> totalPath = new ArrayList<Integer>();
		while(!(current.getPedestal() == 0)) {
			totalPath.add(current.getPedestal());
			current = current.getNeighbor();
		}
		return totalPath;
	}
	
	private HashSet<PuzzlePath> createPaths(PuzzlePath path){
		HashSet<PuzzlePath> ret = new HashSet<PuzzlePath>();

		for (int i = 0; i < path.size(); i++) {
			PuzzlePath p = new PuzzlePath(path.getConfiguration().pressPedestal(i), path.getGscore() + 1, i + 1, path);
			ret.add(p);
		}
		return ret;
		
	}
}
