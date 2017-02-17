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
	solveH(0,0,1);
	
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
	if (row*col <= level){ return false;}
	
	if (board[row][col]==0){
	    board[row][col] = level;
	    nextMove(row,col);
	    if (solveH(row+nexRow,col+nexCol, level+1)){
		return true;}
	    else{ removeKnight(row, col);
		solveH(row, col, level+1);}
	}
        return false;}

	

   
   
    public String toString(){
	String fin = "";
	for (int i = 0; i < board.length ; i++) {
	    for (int j=0; j < board[i].length; j++) {
		fin += "" + board [i][j] + "  ";
	    }
	    fin += "\n";
	        
		    	
	}
	
	return fin;
    }


}


	//blank if you never called solve or when there is no solution

	
