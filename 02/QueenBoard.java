public class QueenBoard{

    private int[][]board;
    private int solutionCount;

    public QueenBoard(int size){
		solutionCount = 0;
	board = new int[size][size];
	for (int i = 0; i < board.length; i++){
	    for (int j = 0; j< board[0].length; j++){
		board[i][j]=0;
		
	    }
	}

    }

    public boolean solve()
    {   
	return solveH(0);
    }

    public boolean issolved(){
	int q = 0;
	for (int i = 0; i < board.length; i++){
	    for (int j = 0; j< board.length; j++){
		if (board[i][j]==-1){q++;}
	    }
	}
	return (q==board.length);
    }

       
    private boolean addQueen(int c, int r){
	// if (r >= board.length){return false;}
	// if (board[r][c]== 0){
	   	   
	for(int x=0;x<board.length;x++){
	    board[x][c]++;
	}
	    
	for(int y=0;y<board.length;y++){
	    board[r][y]++;
	}
	int p = 0;//y
	int q = board.length-1;//x
	if (r+c-board.length >= 0){
	    p = (r+c) - board.length+1;}
	else {q = r+c;}
	while ((p <= board.length-1) && (q>= 0)){
	    board[p][q]++;
	    p++;
	    q--;
	}

	int s = board.length-1;//y
	int t = board.length-1;//x
	if (c>=r){
	    s = board.length + r - c - 1;}
	else {t = board.length - r + c - 1 ;}
	while ((s >= 0) && (t >= 0)){
	    board[s][t]++;
	    s--;
	    t--;
	}
	
	board[r][c]=-1;
	    
	  return true;
	// }
	// return addQueen(c, r+1);
    }				     

         
    private boolean removeQueen(int c){
	for (int r = 0; r < board.length; r++){
	    
	    if (board[r][c]== -1){
		
		for (int y=0; y<board.length;y++){
		    board[y][c]--;
		}
		
		for(int x=0; x<board.length;x++){
		    board[r][x]--; 
		}
		
		int p = 0;//y
		int q = board.length-1;//x
		if (r+c-board.length >= 0){
		    p = (r+c) - board.length+1;}
		else {q = r+c;}
		while ((p <= board.length-1) && (q>= 0)){
		    board[p][q]--;
		    p++;
		    q--;
		}

		int s = board.length-1;//y
		int t = board.length-1;//x
		if (c>=r){
		    s = board.length + r - c - 1;}
		else {t = board.length - r + c - 1 ;}
		while ((s >= 0) && (t >= 0)){
		    board[s][t]--;
		    s--;
		    t--;
		}
		board[r][c]= 0;
		return true;
	    }
	 
	}
	return false;
    }	
	
	
     private boolean solveH(int col){
	if (col >= board.length){
     	    return true;}


	for (int r=0; r < board.length; r++){
	    
	    if (board[r][col]== 0){
		addQueen(col,r);
		
		if (solveH(col+1)){
		    return true;}
		else{
		    removeQueen(col);
		      
		    
		}
	    }
	    
	  
	}

	return  false;
     }
	    

	


    
    public String toString(){
	String fin = "";
	for (int i = 0; i < board.length ; i++) {
	    for (int j=0; j < board.length; j++) {
		if (board[i][j] == -1) {
		    fin += "Q" + " ";
		}
		else {fin += "_" + " ";}
	    }
	    fin += "\n";}
	
	if (solve()){
	    return fin +  "SOLVED!";
	}
	 return fin + "no sol";
    }

    public String rawString(){
	String fin = "";
	for (int i = 0; i < board.length ; i++) {
	    for (int j=0; j < board.length; j++) {
		fin += board[i][j] + " ";
	    }
	
	    fin += "\n";}
	
	if (solve()){
	    return fin +  "SOLVED!";
	}
	 return fin + "no sol";
    }

// public void countSolutions() - look for all solutions, and update the instance variable solutionCount to reflect the number found. 
// public int getSolutionCount() - return the instance variable solutionCount, which should be -1 if the countSolutions was never run.

    public boolean countSolutions(int col){
	if (col >= board.length){
	    solutionCount++;
	    return false;
     	    }


	for (int r=0; r < board.length; r++){
	    
	    if (board[r][col]== 0){
		addQueen(col,r);
		
		if (countSolutions(col+1)){
		    return true;}
		else{
		    removeQueen(col);
		      
		    
		}
	    }
	    
	  
	}

	return  false;
    }
	 
    

	


    public int getSolutionCount(){
	countSolutions(0);
	return solutionCount;
    }	
    
    
    
    public static void main (String[]args){
	QueenBoard q = new QueenBoard(5);
	q.solve();
	System.out.println(q.toString());
	System.out.println(q.rawString());
	QueenBoard r = new QueenBoard(16);
	r.solve();
	System.out.println(r.toString());
	System.out.println(r.rawString());
	QueenBoard s = new QueenBoard(6);
	s.solve();
	System.out.println(s.toString());
	System.out.println(s.rawString());
	QueenBoard t = new QueenBoard(10);
	System.out.println(t.getSolutionCount());
        
	
	
    }
}

