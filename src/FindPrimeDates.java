import java.io.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by sOkE on 27/02/2017.
 * Version 1.
 */
public class FindPrimeDates {

    private static File input = new File("C:\\Users\\sOkE\\Desktop\\note.txt");
    private static String output = "C:\\Users\\sOkE\\Desktop\\datesoutput.txt";

    public static void main(String[] args) {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            Scanner scanner = new Scanner(input);
            fw = new FileWriter(output, true);
            bw = new BufferedWriter(fw);
            while (scanner.hasNextLine()) {
                String temp = scanner.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate localDate = LocalDate.parse(temp, formatter);
                DayOfWeek dow = localDate.getDayOfWeek();
                String output = dow.getDisplayName(TextStyle.FULL, Locale.UK);
                String removedSlash = temp.replaceAll("/", " ");
                removedSlash = removedSlash + "  " + output + "\r\n";
                bw.write(removedSlash);
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

}
