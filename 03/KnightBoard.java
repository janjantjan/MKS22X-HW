public class KnightBoard {
    private int[][] board;
   
    private int[] nexRow;
    private int[] nexCol;

    public KnightBoard(int startingRows,int startingCols) {
	nexRow = new int[8];
	nexRow[0] = 2;
	nexRow[1] = 2;
	nexRow[2] = 1;
	nexRow[3] = 1;
	nexRow[4] = -2;
	nexRow[5] = -2;
	nexRow[6] = -1;
	nexRow[7] = -1;
	nexCol = new int[8];
	nexCol[0] = 1;
	nexCol[1] = -1;
	nexCol[2] = 2;
	nexCol[3] = -2;
	nexCol[4] = 1;
	nexCol[5] = -1;
	nexCol[6] = 2;
	nexCol[7] = -2;
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



    private void removeKnight (int row, int col){
	board[row][col]= 0;
    }
	    
	
    private boolean solveH(int row ,int col, int level) {
	//base case:
	if((board.length * board.length)<=level){
	    return true;}


	if (board[row][col]==0){
	    board[row][col] = level;

	     if ((row < 2) && (col > (board.length-2))) {
		for (int a = 3; a > 0; a-=2){
		    int y = nexRow[a];
		    int x = nexCol[a];	    
		    if (solveH(row+y, col+x, level+1)){
			return true;}
		}
	    }

	    else if ((row > (board.length-2))&&(col >(board.length-2))){
		for (int c = 7; c > 4; c-=2){
		    int y = nexRow[c];
		    int x = nexCol[c];	    
		    if (solveH(row+y, col+x, level+1)){
			return true;}
		}
	    }

	    else if (row > (board.length-2)){
		for (int b = 7; b >= 1; b=2){
		    int y = nexRow[b];
		    int x = nexCol[b];	    
		    if (solveH(row+y, col+x, level+1)){
			return true;}
		}
	    }

	    else if ((row < 2)&&(col < 2)){
		for (int g = 2; g >= 0; g-=2){
		    int y = nexRow[g];
		    int x = nexCol[g];	    
		    if (solveH(row+y, col+x, level+1)){
			return true;}
		}
	    }

	    
	    else if (col < 2){
		for (int h = 3; h >= 0; h--){
		    int y = nexRow[h];
		    int x = nexCol[h];	    
		    if (solveH(row+y, col+x, level+1)){
			return true;}
		}
	    }

	    else if ((row > board.length-2)&&(col < 2)){
		for (int e = 6; e >=1 ; e-=5){
		    int y = nexRow[e];
		    int x = nexCol[e];	    
		    if (solveH(row+y, col+x, level+1)){
			return true;}
		}
	    }

	    
	    else if (row > board.length- 2){
		for (int f = 6; f >= 0; f-=2){
		    int y = nexRow[f];
		    int x = nexCol[f];	    
		    if (solveH(row+y, col+x, level+1)){
			return true;}
		}
	    }

	    else if ((row < 2)&&(col < 2)){
		for (int g = 2; g < 0; g-=2){
		    int y = nexRow[g];
		    int x = nexCol[g];	    
		    if (solveH(row+y, col+x, level+1)){
			return true;}
		}
	    }
	    

	    else if ((row < 2)&&(col < 2)){
		for (int d = 7; d >= 4; d--){
		    int y = nexRow[d];
		    int x = nexCol[d];	    
		    if (solveH(row+y, col+x, level+1)){
			return true;}
		}
	    }
	   
	   
	    else for (int i = 0; i < nexRow.length; i++){
		int y = nexRow[i];
		int x = nexCol[i];	    
		if (solveH(row+y, col+x, level+1)){
		    return true;}
	    }
	}
	return false;}

   
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

	
