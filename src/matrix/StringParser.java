package matrix;

import java.util.*;

/**
 * Created by f on 19.05.16.
 *
 */
public class StringParser {
    public static String parse(String str) {

        if (str == null || str.isEmpty()) return "";

        str = str.trim();
        List<String> strList = new ArrayList<>(Arrays.asList(str.split("\\s+")));

//        strList.remove("");      // remove possible leading empty str
        return parse(strList);
    }

    /**
     * Parse string as final cell
     *
     * @param strList splitted input string
     * @return formatted result
     */
    public static String parse(List<String> strList) {

        Deque<Double> stack = new LinkedList<>();

        // Operands for arithmetical expressions
        double dA, dB;

        String str = "";

        for (String s : strList) {
            if ("".equals(s)) continue;

            switch (s) {
                case "+":
                    if (stack.size() < 2) {
                        return "Error(+)";
                    }
                    dB = stack.pop();
                    dA = stack.pop();
                    dA += dB;
                    stack.push(dA);
                    break;
                case "-":
                    if (stack.size() < 2) {
                        return "Error(-)";
                    }
                    dB = stack.pop();
                    dA = stack.pop();
                    dA -= dB;
                    stack.push(dA);
                    break;
                case "*":
                    if (stack.size() < 2) {
                        return "Error(*)";
                    }
                    dB = stack.pop();
                    dA = stack.pop();
                    dA *= dB;
                    stack.push(dA);
                    break;
                case "/":
                    if (stack.size() < 2) {
                        return "Error(/)";
                    }
                    dB = stack.pop();
                    dA = stack.pop();
                    dA /= dB;
                    stack.push(dA);
                    break;
                case "++":
                    if (stack.isEmpty()) {
                        return "Error(++)";
                    }
                    dA = stack.pop();
                    dA++;
                    stack.push(dA);
                    break;
                case "--":
                    if (stack.isEmpty()) {
                        return "Error(--)";
                    }
                    dA = stack.pop();
                    dA--;
                    stack.push(dA);
                    break;
                default:
                    try {
                        s = s.replace(',', '.');
                        dA = Double.valueOf(s);
                    } catch (NumberFormatException e) {
                        str += s+" ";
                        continue;
                    }
                    stack.push(dA);
            }
        }

        if (stack.size() > 1) {
            return "Error(<)";
        }

        Double result;
        if(!stack.isEmpty()) {
            result = stack.pop();
//            str+= String.format("%.5f", result);
            str+= result;
        }
        return str;
    }
}
