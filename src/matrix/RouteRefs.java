package matrix;

import java.util.*;

/**
 * Created by f on 22.05.16.
 *
 */
public class RouteRefs {
    private Pair p;
    private List<String> strList;
    private Deque<Reference> refs= new LinkedList<>();

    public RouteRefs(Pair p, String str) {
        this.p = p;

        if (str == null || str.isEmpty()) return;
        strList = new ArrayList<>(Arrays.asList(str.split("\\s+")));
        getRefs(strList);
    }

    /**
     * search references
     *
     * @param strList splitted input string
     */
    private void getRefs(List<String> strList) {

        for (int n = 0; n < strList.size(); n++) {
            String str = strList.get(n);
            char ch = strList.get(n).charAt(0);
            if (Character.isLetter(ch)) {       // Reference discovered
                ch = Character.toLowerCase(ch);
                int i = ch - 'a', j;
                try {
                    j = Integer.parseInt(str.substring(1)) - 1;
                } catch (NumberFormatException e) {
                    System.out.println("NumberFormatException " + str);
                    continue;
                }
//!                System.out.println("n "+n+" r "+ String.format("%c", 'A' + i) + (j + 1));
                refs.add(new Reference(n, new Pair(i, j)));
            }
        }
    }

    public Pair getP() {
        return p;
    }

    public List<String> getStrList() {
        return strList;
    }

    public Deque<Reference> getRefs() {
        return refs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RouteRefs routeRefs = (RouteRefs) o;

        return p.equals(routeRefs.p);
    }

    @Override
    public int hashCode() {
        return p.hashCode();
    }
}
