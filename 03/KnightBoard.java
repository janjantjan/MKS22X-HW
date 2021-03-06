public class KnightBoard {
    private int[][] board;
   
  

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



   
	    
	
    private boolean solveH(int row , int col , int level){
         
	if((board.length * board[0].length)<level){
	    return true;}

	 if (row<0 || row >= board.length || col<0 || col>= board[0].length){return false;}
	    
       
	if (board[row][col]==0){

	    board[row][col] = level;
	    
	    
	    if(row > 1 && col > 0){
                if(solveH(row-2,col-1,level+1)){
		    return true;}
		
	    }
       
	    if(row > 1 && col < board[0].length ){
               	if(solveH(row-2,col+1,level+1)){

		    return true;}
	    }
       
	    if(row <  board.length -2 && col <  board[0].length){
               	if(solveH(row+2,col+1,level+1)){
		    return true;}
	    }
        
	    if(row <  board.length -2 && col > 0){
		if(solveH(row+2,col-1,level+1)){

		    return true;}
	    }
        
	    if(col > 1 && row > 0){
		if(solveH(row-1,col-2, level+1)){
		    return true;}
	    }
	
            
	    if(col > 1 && row <  board.length -1){
		if(solveH(row+1,col-2,level+1)){
		    return true;}
	    }
        
	    if(col <  board[0].length -2 && row > 0){
		if(solveH(row-1,col+2,level+1)){
		    return true;}
	    }
        
	    if(col <  board[0].length -2 && row <  board.length -1){
		if(solveH(row+1,col+2,level+1)){
		    return true;}
	    }

	    board[row][col]=0;       
	}
	 
   
	return false;
    }


   
    public String toString(){
	String fin = "";
	for (int i = 0; i < board.length ; i++) {
	    for (int j=0; j < board[i].length; j++) {
		if (board[i][j]> 99){	    
		    fin += "" + board[i][j]+ "";}
		if (board[i][j]>9){
		    fin += " " + board[i][j] + " ";}
		else{ fin += "  " + board[i][j] + " ";}
	    }
	    fin += "\n" + "\n"; 	    	
	}	
	return fin;
    }

    
  
}



