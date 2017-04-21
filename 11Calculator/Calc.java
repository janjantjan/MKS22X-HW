import java.util.*;

public class Calc{

    public static boolean isOp (String s){
	if (s.equals("*") || s.equals("/") || s.equals("+") || s.equals("-") || s.equals("%")){
	    return true;}
	else {return false;}
    }

    public static double apply(String a, String b, String op){
	int x = Integer.parseInt(a);
	int y = Integer.parseInt(b);
	if (op.equals("*")){ 
	    int product = (x * y);
	    return (double)(product);}
	if (op.equals("/")){
	    double quo = (double)x / y;
	    return quo;}
	if (op.equals("+")){
	    double sum = (x + y);
	    return (double)(sum);}
	if (op.equals("-")){
	    int dif = x - y;
	    return (double)(dif);}
	if (op.equals("%")){
	    int mod = x % y;
	    return (double)(mod);}
    }



    public static double eval (String  s){
	Stack t = new Stack();
	String[]str = s.split(" ");
	for (int i = 0; i < str.length; i++){
	    String temp = str.get(0) + "";
	    if (isOp(temp)){
		int a = t.pop();
		int b = t.pop();
		eval(a,b,temp);
	    }
	    else{ t.push(temp);}
	}
	double ans = t.pop();
	return ans;
    }

    public static void main (String[]argg){
	String s =  "2 3 + 5 * 3 / 2 + 4 %";
	System.out.println("Output: " + eval(s));
    }
}
