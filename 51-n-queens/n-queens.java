class Solution {
	static int solCtr;

	private static boolean isSafe(int[] qpos, int qno, int pos) {
		int row;
		int col;
		// uld (up left diagonal) - (row - 1, col - 1)
		for (row = qno - 1, col = pos - 1; row >= 0 && col >= 0; row--, col--) {
			if (qpos[row] == col)
				return false;
		}
		// up (row - 1, col)
		for (row = qno - 1, col = pos; row >= 0; row--) {
			if (qpos[row] == col)
				return false;
		}

		// urd (up right diagonal) - (row - 1, col + 1)
		for (row = qno - 1, col = pos + 1; row >= 0 && col < qpos.length; row--, col++) {
			if (qpos[row] == col)
				return false;
		}
		return true;
	}

	private static void solve_n_queen_helper(int[] qpos, int noq, int qno, List<List<String>> res) {
		// enumerate all the choices
		// 0 to noq - 1
		if (noq == qno) {
// 			System.out.printf("Solution # %d\n", ++solCtr);
			printBoard(qpos, res);
			// return;
		}
		int position;
		for (position = 0; position < noq; position++) {
			// validity - SAFETY
			if (isSafe(qpos, qno, position) == true) {
				qpos[qno] = position;
				solve_n_queen_helper(qpos, noq, qno + 1, res);
				qpos[qno] = -1;
			}
		}

	}

	private static void printBoard(int[] qpos, List<List<String>> res) {
		int row;
		int col;
		List<String> li = new ArrayList<>();
		for (row = 0; row < qpos.length; row++) {
		    StringBuilder subString = new StringBuilder();
			for (col = 0; col < qpos.length; col++)
				// System.out.printf("%c ", qpos[row] == col ? 'Q' : '-');
				if(qpos[row] == col)
				    subString.append('Q');
				else
				    subString.append('.');
			String sub = subString.toString();
			li.add(sub);
		}
		res.add(li);
	}
	
	public static List<List<String>> solveNQueens(int noq) {
        List<List<String>> res = new ArrayList<>();
		// arm / validation
        if(noq == 1) {
            List<String> sub = new ArrayList<>();
            sub.add("Q");
            res.add(sub);
            return res;
        }

		// set an environment
		int[] qpos = new int[noq];
		int qpos_ind;
		for (qpos_ind = 0; qpos_ind < noq; qpos_ind++)
			// store -1 in all the positions
			qpos[qpos_ind] = -1;
		solve_n_queen_helper(qpos, noq, 0, res);

		return res;
	}
}
