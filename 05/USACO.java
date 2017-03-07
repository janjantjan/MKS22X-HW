import java.util.*;
import java.io.*;

public class USACO{

    private int[][] lake;
    private int elevation;
    private int[][] directions;


    public USACO(){

    }

    public USACO (String filename){
	try {
	    Scanner s = new Scanner (new File(filename));
	    String temp = "";
	    int row = s.nextInt();
	    int col = s.nextInt();
	    elevation = s.nextInt();
	    int num = s.nextInt();
	    lake = new int [row][col];
	    for (int i = 0; i < row; i++){
		for (int j = 0; j <row; j++){
		    lake[i][j]=s.nextInt();}
	    }
	    directions = new int[num][3];
	    for (int i =0; i< num; i++){
		for (int j = 0; j < 3; j++){
		    directions[i][j]= s.nextInt();
		}}
	   
	}catch(FileNotFoundException e){
    	    System.out.println("File not found");
    	    System.exit(1);
	}
    }

  
    public static void main (String[]args){
	USACO u = new USACO("makelake.in");

    }

}  
	    




	    
	    

