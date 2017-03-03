import java.util.*;
import java.io.*;

public class Maze{

    private char[][]maze;
    private boolean animate;


    /*Constructor loads a maze text file, and sets animate to false by default.
      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - locations that cannot be moved onto
      ' ' - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)

      'S' - the location of the start(exactly 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!
      3. When the file is not found OR there is no E or S then: print an error and exit the program.

    */

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
	    System.out.println(rownum + "," + colnum + "\n" + temp);

     	}catch(FileNotFoundException e){
    	    System.out.println("File not found");
    	    System.exit(1);
	}

        if (checkSE(temp)==false) {return;}
	maze = new char[rownum][colnum];
	System.out.println(maze.length + "___" + maze[0].length);

	while (temp.length() > 0){
	    for (int i = 0; i < maze.length; i++){
		for (int j = 0; j < maze[0].length; j++){
		    maze[i][j]= temp.charAt(0);
		    temp = temp.substring(1);
		}
	    }
	}
	System.out.println(maze[1][1]);
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



    /*Wrapper Solve Function
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
    */
    public boolean solve(){
            int startr=-1,startc=-1;

            //Initialize starting row and startint col with the location of the S. 

            maze[startr][startc] = ' ';//erase the S, and start solving!
            return solve(startr,startc);
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
    private boolean solve(int row, int col){
        if(animate){
            System.out.println("\033[2J\033[1;1H"+this);

            wait(20);
        }

        //COMPLETE SOLVE

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
	System.out.println(m.rawString());
    }
}
