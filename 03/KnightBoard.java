public class KnightBoard {
    private int[][] board;
    boolean solved;
    int nexRow;
    int nexCol;
        

    public KnightBoard(int startingRows,int startingCols) {
	solved = false;
	board = new int[startingRows][startingCols];
	for (int i = 0; i < board.length; i++){
	    for (int j = 0; j< board[0].length; j++){
		board[i][j]=0;
	    }
	}
    }


    public void solve() {
	solveH(3,3,1);
	
    }


    private void nextMove(int row,int col){
	  	
	if (board[row-2][col+1]== 0){
	    nexCol=1;
	    nexRow=-2;}
	else if (board[row+2][col+1]== 0){
	    nexCol=1;
	    nexRow=2;}
	else if(board[row-2][col-1]== 0){
	    nexCol=-1;
	    nexRow=-2;}
	else if(board[row+2][col-1]== 0){
	    nexCol=-1;
	    nexRow=2;}
	else if(board[row-1][col+2]== 0){
	    nexCol=2;
	    nexRow=-1;}
	else if(board[row+1][col+2]== 0){
	    nexCol=2;
	    nexRow=1;}
	else if(board[row-1][col-2]== 0){
	    nexCol=-2;
	    nexRow=-1;}
	else if(board[row+1][col-2]== 0){
	    nexCol=-2;
	    nexRow=1;}

    }

    private void removeKnight (int row, int col){
	board[row][col]= 0;
    }
	    
	
    private boolean solveH(int row ,int col, int level) {
	//base case:
	if((board.length * board.length)<=level){
	    System.out.println("UGHHHH");
	    return true;}
	
	if (board[row][col]==0){
	    board[row][col] = level;
	    nextMove(row,col);
	    System.out.println(nexRow);
	    System.out.println(nexCol);
	    if (solveH(row+nexRow,col+nexCol, level+1)){
		return true;}
	    else{ removeKnight(row, col);
	    }
	}        return false;}
   
    public String toString(){
	String fin = "";
	for (int i = 0; i < board.length ; i++) {
	    for (int j=0; j < board[i].length; j++) {
		if (board[i][j]> 99){	    
		    fin += "" + board[i][j]+ " ";}
		if (board[i][j]>9){
		    fin += " " + board[i][j] + " ";}
		else{ fin += "  " + board[i][j] + " ";}
	    }
	    fin += "\n" + "\n"; 	    	
	}	
	return fin;
    }

    
    public static void main (String[]args){
	KnightBoard k = new KnightBoard(5,5);
	k.solve();
	System.out.println(k.toString());
	
	KnightBoard l = new KnightBoard(7,7);
	l.solve();
	System.out.println(l.toString());
	
	KnightBoard m = new KnightBoard(9,9);
	m.solve();
	System.out.println(m.toString());
	
	
    }
}


	//blank if you never called solve or when there is no solution

	
