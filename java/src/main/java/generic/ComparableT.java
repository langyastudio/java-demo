package generic;

import java.util.Arrays;

public class ComparableT implements Comparable<ComparableT> {
    private int    score;
    private String name;

    public static void main(String[] args) {
        ComparableT [] cArr = new ComparableT[]{
                new ComparableT(30, "thirty"),
                new ComparableT(90, "ninety"),
                new ComparableT(60, "sixty"),
        };

        //mutually comparable</i>
        Arrays.sort(cArr);

        System.out.println(Arrays.toString(cArr));
    }

    public ComparableT(int score, String name)
    {
        this.score = score;
        this.name  = name;
    }

    @Override
    public int compareTo(ComparableT o)
    {
        if(this.score > o.score)
        {
            return 1;
        }
        else if (this.score < o.score)
        {
            return -1;
        }

        return 0;
    }

    @Override
    public String toString() {
        return this.name + " " + this.score;
    }
}
