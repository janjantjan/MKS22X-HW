import java.util.*;

public class Calc{

    public static boolean isOp (String s){
	if (s.equals("*") || s.equals("/") || s.equals("+") || s.equals("-") || s.equals("%")){
	    return true;}
	else {return false;}
    }

    public static Double apply(Double a, Double b, String op){
	double x = a.doubleValue();
	double y = b.doubleValue();
	if (op.equals("*")){ 
	    double product = (x * y);
	    return a.valueOf(product);}
	else if (op.equals("/")){
	    double quo = y / x;
	    return a.valueOf(quo);}
	else if (op.equals("+")){
	    double sum = (x + y);
	    return a.valueOf(sum);}
	else if (op.equals("-")){
	    double dif = y - x;
	    return a.valueOf(dif);}
	else {
	    double mod = y % x;
	    return a.valueOf(mod);}
    }



    public static double eval (String  s){
	Stack<Double> t = new Stack <Double>();
	String[]str = s.split(" ");
	for (int i = 0; i < str.length; i++){
	    String temp = str[i] ;
	    if (isOp(temp)){
		Double a = t.pop();
		Double b = t.pop();
		Double y = apply(a,b,temp);
		System.out.println(y.toString());
		t.push(y);
	    }
	    else{
		Double x = Double.parseDouble(temp);
		t.push(x);}
	}
	double ans = t.pop();
	return ans;
    }

    public static void main (String[]argg){
	String s =  "2 3 + 5 * 3 / 2 + 4 -";
	System.out.println("Output: " + eval(s));
    }
}
