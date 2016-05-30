package matrix;

/**
 * Created by f on 19.05.16.
 */
public class Main {
    public static void main(String[] args) {

        String[][] arrStr;

        if (args.length > 0)
            arrStr = StreamParser.parse(TestInputStream.get());
        else
            arrStr = StreamParser.parse(System.in);

        for (String[] anArrStr : arrStr) {
            for (int j = 0; j < anArrStr.length; j++) {
                System.out.print(anArrStr[j] + ";");
                if (j < anArrStr.length - 1) System.out.print(" ");
            }
            System.out.println();
        }

        new CalculateArray(arrStr).calculate();

        System.out.println();

        for (String[] anArrStr : arrStr) {
            for (int j = 0; j < anArrStr.length; j++) {
                System.out.print(anArrStr[j] + ";");
                if (j < anArrStr.length - 1) System.out.print(" ");
            }
            System.out.println();
        }
    }
}
