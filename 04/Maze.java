import java.util.*;
import java.io.*;

public class Maze{

    private char[][]maze;
    private boolean animate;

    public Maze(String filename){
	int rownum = 0;
	int colnum = 0;
	
	String temp = "";
	try{ 
	    Scanner t = new Scanner(new File(filename));
	    while(t.hasNextLine()){
		String line = t.nextLine();
		temp += line;
		rownum++;
		colnum = line.length();
	    }
	   

     	}catch(FileNotFoundException e){
    	    System.out.println("File not found");
    	    System.exit(1);
	}

        if (checkSE(temp)==false) {
	    System.out.println ("Please indicate Start and End");
	    return;}
	{

	    maze = new char[rownum][colnum];
	    

	    while (temp.length() > 0){
		for (int i = 0; i < maze.length; i++){
		    for (int j = 0; j < maze[0].length; j++){
			maze[i][j]= temp.charAt(0);
			temp = temp.substring(1);
		    }
		}
	    }
	}

	animate=false;
    }

    private boolean checkSE (String maze){
	boolean s = false;
	boolean e = false;
	for (int i = 0; i < maze.length(); i++){
	    if (maze.charAt(i)=='S'){ s=true;}
	    if (maze.charAt(i)=='E'){ e=true;}
	}
	return (s && e );
    }



    

    private void wait(int millis){ //ADDED SORRY!
         try {
             Thread.sleep(millis);
         }
         catch (InterruptedException e) {
         }
     }


    public void setAnimate(boolean b){

        animate = b;

    }


    public void clearTerminal(){

        //erase terminal, go to top left of screen.

        System.out.println("\033[2J\033[1;1H");

    }

 
    public boolean solve(){
            int startr=-1,startc=-1;
	    for (int i =0; i < maze.length;i++){
		for(int j =0; j<maze[0].length; j++){
		    if (maze[i][j]=='S'){
			startr=i;
			startc=j;
		    }
		}
	    }
	    
            maze[startr][startc] = ' ';
            return solveH(startr,startc);
    }

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns true when the maze is solved,
      Returns false when the maze has no solution.


      Postcondition:

        The S is replaced with '@' but the 'E' is not.

        All visited spots that were not part of the solution are changed to '.'
        All visited spots that are part of the solution are changed to '@'
    */
    private boolean solveH(int row, int col){
        if(animate){
	    
            System.out.println("\033[2J\033[1;1H"+this);
            wait(20);
        }


	
	if (maze[row][col]=='E'){
	    return true;}

	
	if (maze[row][col]==' '|| maze[row][col]=='S'){
	    
	    maze[row][col] = '@';

	    if (row < maze.length-1){
		if (maze[row+1][col]!='#'){
		    if (solveH(row+1,col)){
			
			return true;}}}
	    if (col < maze[0].length-1){
		if (maze[row][col+1]!='#'){
		    if (solveH(row,col+1)){return true;}}}
	    if (row >= 1){
		if (maze[row-1][col]!='#'){
		    if (solveH(row-1,col)){return true;}}}
	    if (col >= 1){
		if(maze[row][col-1]!='#'){
		    if (solveH(row,col-1)){return true;}}}
	    
	    maze[row][col] = '.';
     	}

        return false; //so it compiles
    }

    public String rawString(){
	String fin = "";
	for (int i = 0; i < maze.length ; i++) {
	    for (int j=0; j < maze[0].length; j++) {
		fin += maze[i][j] ;
	    }
	
	    fin += "\n";}
	return fin;
    }


    public static void main (String[]args){
	Maze m = new Maze("data3.dat");
	m.solve();
	System.out.println(m.rawString());
    }
}
