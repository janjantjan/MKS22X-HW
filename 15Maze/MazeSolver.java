import java.lang.*;

public class MazeSolver{

    private Maze board;
    private boolean animate;
    private Frontier front;

    public MazeSolver(String filename) {
	this(filename,false);
	} 
    
    public MazeSolver(String filename, boolean a) {
	board = new Maze(filename);
	animate = a;
    }

    public void solve(int style){
	Location start = board.getStart();
	Location end = board.getEnd();
	int startR = start.getRow();
	int startC = start.getCol();
	//System.out.println("startR: " + startR + " startC: " + startC);
	int endR = end.getRow();
	int endC = end.getCol();
	int toGoal = (int) Math.abs(startR - endR) + Math.abs(startC - endC);
	//System.out.println("A");
	//Frontier front;
	
	if (style == 0){
	    front = new FrontierStack();
	    front.add(start);
	}
	if (style == 1){
	    front = new FrontierQueue();
	    front.add(start);
	    //System.out.println("C");
	}
	if (style == 2){
	    front = new FrontierPriorityQueue();
	    front.add(start);
	}
	// if (style == 3){
	// } ???
	
	//System.out.println("B");
	 
	while( front.size() > 0){
	    Location current = front.next();
	    int currentR = current.getRow();
	    int currentC = current.getCol();
	    //System.out.println("D");
	    if ((currentR == endR) && (currentC == endC)){
		//set(currentR, currentC, '@');
		while(front.size() > 0){
		    Location next = front.next();
		    int nextR = next.getRow();
		    int nextC = next.getCol();
		    board.set(nextR, nextC, '@');
		    if (animate) {
			System.out.println(toString());}
		}
	    }
	    //System.out.println("E");
	    int[] neighbors = neigh(current);
	    //System.out.println(emptyary(neighbors));
	    if (neighbors[0]==1){//row, col-1)
		board.set(currentR, currentC-1, '.');
		if (animate) {System.out.println(toString());}
		int toGo1 = (int) Math.abs(currentR - endR) + Math.abs(currentC - endC -1);
		Location left = new Location (currentR, currentC-1, current, 0,toGo1, false);
		
		front.add(left);
	    }
	    if (neighbors[1]==1){//row, col+1
		board.set(currentR, currentC+1, '.');
		if (animate) {System.out.println(toString());}
		int toGo2 = (int) Math.abs(currentR - endR) + Math.abs(currentC - endC +1);
		Location right = new Location (currentR, currentC+1, current,0, toGo2, false);
		front.add(right);
	    }
	    if (neighbors[2]==1){//row-1, col
		board.set(currentR-1, currentC, '.');
		if (animate) {System.out.println(toString());}
		int toGo3 = (int) Math.abs(currentR - endR -1) + Math.abs(currentC - endC);
		Location up = new Location (currentR-1, currentC, current,0, toGo3, false);
		front.add(up);
	    }
	    if (neighbors[3]==1){//row+1, col
		board.set(currentR+1, currentC, '.');
		if (animate) {System.out.println(toString());}
		int toGo4 = (int) Math.abs(currentR - endR +1) + Math.abs(currentC - endC);
		Location down = new Location (currentR+1, currentC, current,0, toGo4, false);
		front.add(down);
	    }
	}
    }
	


    public void solve(){
	solve(1);
    }    

    private int[] neigh(Location x){
	int row = x.getRow();
	int col = x.getCol();
	//System.out.println("row: " + row + " col: " + col);
	int[] fin = new int[4]; // ( L, R, U, D)
	if (col > 0){
	    //System.out.println("w");
	    if (board.get(row, col-1) == ' '){
		fin[0] = 1;
	    }
	    else{fin[0] = 0;}}
	if (col < board.getmaxC()){
	    //System.out.println("x");
	    if (board.get(row, col+1) == ' ' ){
		fin[1] = 1;
	    }
	    else{fin[1] = 0;}}
	if (row > 0 ){
	    //System.out.println("y");
	    if (board.get(row-1, col) == ' ' ){
		fin[2] = 1;
	    }
	    else{fin[2] = 0;}}
	if (row < board.getmaxR()){
	    //System.out.println("z");
	    if (board.get(row+1, col) == ' ' ){
		fin[3] = 1;
	    }
	    else{fin[3] = 0;}}
	
	
	return fin;
    }

    private boolean emptyary(int[] ary){
	for (int i = 0 ; i < ary.length; i++){
	    if (ary[i] == 1){ return false;}}
	    return true;
    }
	  
    public String toString(){
	if(animate){return board.toString(50);}
	else{        return board.toString();}
    }
			    
    public static void main (String[]args){

	MazeSolver a = new  MazeSolver("maze.txt", true);
	System.out.println(a.toString());
	a.solve(1);
	System.out.println(a.toString());
    }






}
