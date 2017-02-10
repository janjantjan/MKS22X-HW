public class QueenBoard{

    private int[][]board;
    private int solutionCount;

    public QueenBoard(int size){
	board = new int[size][size];
    }

    public boolean solve()
    {   for (int i = 0; i < board.length; i++){
	    for (int j = 0; j< board[0].length, j++){
		board[i][j]=0;
	    }
	}
	return solveH(0);
    }

    private boolean solveH(int col){
	if (issolved()){return true;}
	if (col > board.length){ return false;}
	if (addqueen(col)){
	    addqueen(col);
	    return solveH(col+1);}
	if solve(solveH(s+1)){return true;}



