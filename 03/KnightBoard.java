public class KnightBoard {
    private int[][] board;
   
    private int[] nexRow;
    private int[] nexCol;

    public KnightBoard(int startingRows,int startingCols) {

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
	    
	
    private boolean solveH(int row , int col , int level){
         
	if((board.length * board.length)<=level){
	    return true;}
       
	if (board[row][col]==0){
	    
	    board[row][col] = level;
	    
	    if(row > 1 && col > 0){
                if(solveH(row-2,col-1,level+1)){
		    return true;}        
	    }
       
	    else if(row > 1 && col < board.length -1){
               	if(solveH(row-2,col+1,level+1)){
		    return true;}
	    }
       
	    else if(row <  board.length -2 && col <  board.length -1){
               	if(solveH(row+2,col+1,level+1)){
		    return true;}
	    }
        
	    else if(row <  board.length -2 && col > 0){
                 if(solveH(row+2,col-1,level+1)){
		    return true;}
	    }
        
	    else if(row > 1 && col > 0){
                 if(solveH(row-1,col-2, level+1))
		    {return true;}
	    }
        
	    else if(row > 1 && col <  board.length -1){
               	if(solveH(row+1,col-2,level+1)){
		    return true;}
	    }
        
	    else if(row <  board.length -2 && col > 0){
                if(solveH(row-1,col+2,level+1)){
		    return true;}
	    }
        
	    else if(row <  board.length -2 && col <  board.length -1){
                if(solveH(row+1,col+2,level+1)){
		    return true;}
	    }
	}return false;
    }


   
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

	
