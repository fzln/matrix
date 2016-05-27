package matrix;

import java.util.*;

/**
 * Created by f on 19.05.16.
 * Calculating Array
 */
public class CalculateArray {

    private String[][] arrStr;

    CalculateArray(String[][] arrStr) {
        this.arrStr = arrStr;
    }

    public void calculate() {

        for (int i = 0; i < arrStr.length; i++)
            for (int j = 0; j < arrStr[i].length; j++) {
                calculateCell(new Pair(i, j));
            }
    }

    private void calculateCell(Pair p) {
        Deque<RouteRefs> routes = new LinkedList<>();       // using as stack, LIFO.
        RouteRefs route = new RouteRefs(p, arrStr[p.getFirst()][p.getSecond()]);
        String str;                 // Parsed string
        Pair priorCell = p;         // dummy initialization to avoid the error

        while (true) {
            boolean doUp = false;

            if (route.getRefs().isEmpty()) {
                str = StringParser.parse(route.getStrList());
                arrStr[route.getP().getFirst()][route.getP().getSecond()] = str;

                if (routes.isEmpty()) return;

                RouteRefs routeDown = routes.peek();
                Queue<Reference> downRefs = routeDown.getRefs();
                routeDown.getStrList().set(downRefs.remove().getI(), str);

                if (downRefs.isEmpty()) route = routes.pop();       // Go to down
                else {
                    // Go to down and next up
                    p = downRefs.element().getP();

                    priorCell = routeDown.getP();
                    doUp = true;
                }
            } else {
                // Go to up
                routes.push(route);
                p = route.getRefs().element().getP();

                priorCell = route.getP();
                doUp = true;
            }

            if (doUp) {
                if (p.getFirst() > arrStr.length || p.getSecond() > arrStr[0].length) {
                    System.out.println("Incorrect reference " +
                            String.format("%c", 'A' + priorCell.getFirst()) + (priorCell.getSecond() + 1)
                            + " -> " + String.format("%c", 'A' + p.getFirst()) + (p.getSecond() + 1));
                    System.exit(0);
                }

                route = new RouteRefs(p, arrStr[p.getFirst()][p.getSecond()]);

                if (routes.contains(route)) {
                    System.out.println("Loop detected " +
                            String.format("%c", 'A' + priorCell.getFirst()) + (priorCell.getSecond() + 1)
                            + " -> " + String.format("%c", 'A' + p.getFirst()) + (p.getSecond() + 1));
                    System.exit(0);
                }
            }
        }
    }
}
