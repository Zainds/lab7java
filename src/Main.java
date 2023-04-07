import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        try(FileReader fin = new FileReader("test.txt"))
        {
            Scanner Reader = new Scanner(fin);
            ArrayList<String> check = new ArrayList<String>();
            while (Reader.hasNextLine()) {
                String data = Reader.nextLine();
                check.add(data);
            }

            String line = check.get(0);
            System.out.println(line);

            String lWord = "";
            StringBuilder bufword = new StringBuilder();
            int wordLen = 0;
            int k = 0;
            int duplicates = 0;
            for (int i = 0; i < line.length(); i++)
            {
                if (line.charAt(i) != ' ') {
                    bufword.append(line.charAt(i));
                    k += 1;
                }
                else {
                    if (k > wordLen) {
                        wordLen = k;
                        lWord = bufword.toString();

                    }
                    bufword = new StringBuilder();
                    k = 0;
                }
            }
            bufword = new StringBuilder();
            for (int i = 0; i < line.length(); i++)
            {
                if (line.charAt(i) != ' ') {
                    bufword.append(line.charAt(i));
                }
                else {

                    if (bufword.toString().equals(lWord)) {
                        duplicates += 1;
                    }

                    bufword = new StringBuilder();
                    k = 0;
                }
            }
            if (bufword.toString().equals(lWord)) duplicates += 1;
            System.out.print(lWord + " " + duplicates);
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}