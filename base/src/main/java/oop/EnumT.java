package oop;

enum Weekday {
    SUN(0, "星期天"), MON(1, "星期一"), TUE(2, "星期二"), WED(3, "星期三"), THU(4, "星期四"), FRI(5, "星期五"), SAT(6, "星期六");
    public final  int    dayValue;
    private final String chinese;

    private Weekday(int dayValue, String zh) {
        this.dayValue = dayValue;
        this.chinese = zh;
    }

    @Override
    public String toString() {
        return this.chinese;
    }
}

public class EnumT {
    public static void main(String[] args) {
        Weekday day = Weekday.SUN;
        /*if (day == Weekday.SAT || day == Weekday.SUN) {
            System.out.println("Work at home!");
        }
        else {
            System.out.println("Work at office!");
        }*/

        if (day.dayValue == 6 || day.dayValue == 0) {
            System.out.println("Today is " + day + ". Work at home!");
        } else {
            System.out.println("Today is " + day + ". Work at office!");
        }
    }
}
