import java.io.*;
import java.util.Scanner;

/**
 * Created by sOkE on 27/02/2017.
 * Version 1.
 */
public class FinalDates {
    private static File input = new File("C:\\Users\\sOkE\\Desktop\\datesoutput.txt");
    private static String output = "C:\\Users\\sOkE\\Desktop\\finaldatesoutput.txt";

    public static void main(String[] args) {
        FileWriter fw = null;
        BufferedWriter bw = null;
        int date, month, year;
        try {
            Scanner scanner = new Scanner(input);
            while (scanner.hasNextLine()) {
                date = scanner.nextInt();
                month = scanner.nextInt();
                year = scanner.nextInt() - 2000;
/*
                if (isPrime(date + month + year)) {
                    //fw = new FileWriter(output, true);
                    //bw = new BufferedWriter(fw);
                    year += 2000;
                    String result = date + "/" + month + "-" +year +"\r\n";
                    System.out.print(result);
                }
*/
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {

                if (bw != null)
                    bw.close();

                if (fw != null)
                    fw.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }
        }

    }

    //checks whether an int is prime or not.
    private static boolean isPrime(int n) {
        //check if n is a multiple of 2
        if (n % 2 == 0) return false;
        //if not, then just check the odds
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }


}
