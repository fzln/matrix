package matrix;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Created by f on 19.05.16.
 *
 */
public class StreamParser {

    /**
     * Fill string array from input stream by primary values
     *
     * @param is InputStream
     * @return filled array
     */
    public static String[][] parse(InputStream is) {
        Scanner sc = new Scanner(is);
        String str = "";

        if (sc.hasNextLine()) {
            str = sc.nextLine();
        } else {
            System.out.println("Can't read dimension");
            System.exit(0);
        }

        String[] stringDimensions = str.split("\\s+");
        if (stringDimensions.length != 2) {
            System.out.println("Incorrect dimension parameters");
            System.exit(0);
        }

        // Get dimensions
        int d0 = Integer.parseInt(stringDimensions[0]);
        int d1 = Integer.parseInt(stringDimensions[1]);

        if (d0 > 26) {
            System.out.println("The dimension 1 should be less than or equal to 26");
            System.exit(0);
        }

        String[][] arrStr = new String[d0][d1];
        int i = 0;
        while (sc.hasNextLine()) {

            if (i >= d0) {
                System.out.println("The size of input stream exceeds declared value");
                System.exit(0);
            }
            str = sc.nextLine();

            String[] strLine = str.split(";");
            int j = 0;
            for (String s : strLine) {
                if (j == d1) {
                    System.out.println("The size of input stream exceeds declared value. on line " + (i + 1));
                    System.exit(0);
                }
                arrStr[i][j] = s.trim();
                ++j;
            }
            if (j != d1) {
                System.out.println("The size of input stream less declared value. on line " + (i + 1));
                System.exit(0);
            }
            i++;
        }

        if (i != d0) {
            System.out.println("The size of input stream less declared value.");
            System.exit(0);
        }

        sc.close();

        return arrStr;
    }
}
