import java.util.*;
import java.io.*;

public class USACO{

    private int[][] lake;
    private int elevation;
    private int[][] directions;


    public USACO(){
	

    }
    //BRONZE PROBLEM ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    private  void fillDataBronze (String filename){
	try {
	    Scanner s = new Scanner (new File(filename));
	    String temp = "";
	    int row = s.nextInt();
	    int col = s.nextInt();
	    elevation = s.nextInt();
	    int num = s.nextInt();
	    
	    lake = new int [row][col];
	    for (int i = 0; i < row; i++){
		for (int j = 0; j <col; j++){
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

    private String makeString(int[][] x){
	String fin = "";
	for (int i = 0; i < x.length ; i++) {
	    for (int j=0; j < x[0].length; j++) {
		
		fin += x[i][j] + " " ;
	    }
	
	    fin += "\n";}
	return fin;
    }

    private int isHigher (int r, int c, int highest){
	if (r < 0 || c < 0) { return highest;}
	if ( lake[r][c]< 0 ) { return highest;}
	if (lake[r][c] > highest) {return lake[r][c];}
	else { return highest;}
    }

    private void replace (int r, int c, int high){
	if (r < 0 || c < 0){return;}
	if (lake[r][c] > high){
	    lake[r][c] = high;}
	
    }

    private void getStompy (int row, int col, int stomp){
	
	int highest = 0;
	highest = isHigher(row-1, col-1, lake[row-1][col]);
	
	highest = isHigher(row-1, col+1, highest);
	highest = isHigher(row, col-1, highest);
	highest = isHigher(row, col, highest);
	highest = isHigher(row, col+1, highest);
	highest = isHigher(row+1, col-1, highest);
	highest = isHigher(row+1, col-1, highest);
	highest = isHigher(row+1, col+1, highest);
	
	int high = highest - stomp;
	
	replace(row-1, col-1, high);
	replace(row-1, col, high);
	replace(row-1, col+1, high);
	replace(row, col, high);
	replace(row, col+1, high);
	replace(row, col-1, high);
	replace(row+1, col-1, high);
	replace(row+1, col, high);
	replace(row+1, col+1, high);
	 

	  
       
    }

    private void drownCows(){
	for (int i = 0; i < lake.length; i++){
	    for (int j = 0; j < lake[0].length; j++){
		lake[i][j] -= elevation;}
	}

	for (int i = 0; i < lake.length; i++){
	    for (int j = 0; j < lake[0].length; j++){
		if (lake[i][j]<0){
		    lake[i][j] = lake[i][j] * -1;}
		else { lake[i][j] = 0;}
	    }
	}
	
    }

    private int findVol(){
	int clumpyDepth = 0;
	for (int i = 0; i < lake.length; i++){
	    for (int j = 0; j < lake[0].length; j++){
		clumpyDepth += lake[i][j];}}

	return clumpyDepth * 72 * 72;
	
    }
	
	

    public int  bronze (String filename){
   	fillDataBronze(filename);
	for (int i = 0; i < directions.length; i++){
	    getStompy(directions[i][0], directions[i][1], directions[i][2]);
	}
	drownCows();
	return findVol();
    }
	
    
	



    
    
    //SILVER PROBLEM :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

    //MAIN :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    public static void main (String[]args){
	USACO u = new USACO();
	System.out.println(u.bronze("makelake.in"));
    }

}  
	    




	    
	    

