package hu.meiit.haladojava.calculator;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String method = input();
        String[] methodArray = new String[3];

        methodArray = splitCheck(method);

        String operator = methodArray[1];
        Integer a = getInt(methodArray[0]);
        Integer b = getInt(methodArray[2]);

        if (a != null && b != null){
            if ((a == 0 || b == 0) && operator.equals("/")) {
                System.out.println("-");
            } else {printResult(calculate(a, b, operator));}
        }

    }

    private static void printResult(double result) {
        System.out.println(result);
    }

    private static String[] splitCheck(String method){
        String[] methodArray = new String[3];

        if(method.contains(" ")) {
            methodArray = method.split(" ", 3);
        }
        else {
            methodArray = method.split("", 3);
        }
        return methodArray;
    }

    private static double calculate(int a, int b, String operator) {
        double result = 0;

        switch(operator) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "/":
                result = a / b;
                break;
            case "*":
                result = a * b;
                break;
        }

        return result;
    }

    private static String input() {

        Scanner sc = new Scanner(System.in);

        //System.out.println("Mit szeretne kiszamolni: ");
        String method = sc.nextLine();

        return method;
    }
    private static Integer getInt(String str) {
        Integer rv = null;

        try {
            rv = Integer.valueOf(str);
        }catch(NumberFormatException e) {
            System.err.println("-");
            System.exit(0);
        }

        return rv;
    }
}
