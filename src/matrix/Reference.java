package matrix;

/**
 * Created by f on 22.05.16.
 *
 */
public class Reference {
    private int i;      // index reference in strList
    private Pair p;

    public Reference(int i, Pair p){
        this.i=i;
        this.p=p;
    }

    public int getI() {
        return i;
    }

    public Pair getP() {
        return p;
    }
}
