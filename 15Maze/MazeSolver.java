import java.lang.*;

public class MazeSolver{

    private Maze board;
    private boolean animate;

    public MazeSolver(String filename) {
	this(filename,false); } 
    
    public MazeSolver(String filename, boolean a) {
	board = new Maze(filename);
	animate = a;
    }

    
    public void solve(int style){
	//     - style is 0-4, where 0-DFS, 1-BFS,2-BestFirst, 3-A*
	// - This method will instantiate the Frontier based on which style was chosen. 
	// It will then add the starting location of the maze to the Frontier.
	//Finally it will process each subsequent element of the frontier until the end is found. 
	Location start = board.getStart();
	Location end = board.getEnd();
	int startR = start.getRow();
	int startC = start.getCol();
	int endR = end.getRow();
	int endC = end.getCol();
	int toGoal = (int) Math.sqrt(((startR - endR) * (startR - endR)) + ((startC - endC) * (startC - endC)));

	Location current = new Location (startR, startC, null,0, toGoal, false);
	//will finish

	//breadth V. depth
    }

    public void solve(){
	
	solve(1);


    }

    private boolean hasN(Location x) {
	int[] n = neigh(x);

	for (int i = 0; i < n.length; i++){
	    if (n[i] == 1) { return true;}
	}

	return false;
	
    }
    

    private int[] neigh(Location x){
	int row = x.getRow();
	int col = x.getCol();
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

	
	  
    public String toString(){
	if (animate){
	    return board.toString(3);
	}
	else{
	    return board.toString();}
    }
			    







}
