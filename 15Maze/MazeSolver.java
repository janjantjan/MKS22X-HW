public class MazeSolver{

    private Maze board;

    public void solve(int x){
    }

    public void solve(){

    }

    private int[] neigh(int row, int col){
	int[] fin = new int[4]; // ( L, R, U, D)
	if (board.get(row, col-1) == ' '){
	    fin[0] = 1;
	}
	else{fin[0] = 0;}
	if (board.get(row, col+1) == ' ' ){
	    fin[1] = 1;
	}
	else{fin[1] = 0;}
	if (board.get(row-1, col) == ' ' ){
	    fin[2] = 1;
	}
	else{fin[2] = 0;}
	if (board.get(row+1, col) == ' ' ){
	    fin[3] = 1;
	}
	else{fin[3] = 0;}
	return fin;
    }

	
	  








}
