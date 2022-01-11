import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double d = scanner.nextDouble();
        System.out.println(Test.typeConversion(d));
    }
    public static int typeConversion(double d){

        //write your code here......
        String s = String.valueOf(d);
        String[] split = s.split("\\.");
        return Integer.parseInt(split[0]);


    }
}
