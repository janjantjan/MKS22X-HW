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


    public void solve() {
	solveH(0,0,1);
	
    }


    private boolean nextMove(int row,int col,int level,int choice){
		
	int[row-2][col+1]= level+1;
	int[row+2][col+1]= level+1;
	int[row-2][col-1]= level+1;
	int[row+2][col-1]= level+1;
	int[row-1][col+2]= level+1;
	int[row+1][col+2]= level+1;
	int[row-1][col-2]= level+1;
	int[row+1][col-2]= level+1;

    }//just an idea...
	
	    
	
    private boolean solveH(int row ,int col, int level) {
	//base case:
	if (row*col <= level){ return false;}
	
	if (board[row][col]==0){
	    board[row][col] = level;
	    
	    if (solveH(row+nexRow,col+nexCol, level+1)){
		return true;}

	    else{ removeKnight(row, col);}
	}
        return false;}
	  

	

   
   
    public String toString(){
		String fin = "";
	for (int i = 0; i < data.length ; i++) {
	    for (int j=0; j < data[i].length; j++) {
		fin += "" + data [i][j] + "  ";
	    }
	    fin += "\n";
	        
		    	
	}
	
	return fin;
    }





	//blank if you never called solve or when there is no solution

	
