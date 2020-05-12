package ref;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Student extends Person {
    public int score;
    private int grade;
    private int[] iArr;

    public Student(int score, int grade)
    {
        this.score = score;
        this.grade = grade;
    }

    public static void main(String[] args) {
        try
        {
            Class stdCls = Student.class;

            //get Field
            Field name  = stdCls.getField("name");
            Field score = stdCls.getField("score");
            Field grade = stdCls.getDeclaredField("grade");

            System.out.println(name);
            System.out.println(score);
            System.out.println(grade);

            //field info
            System.out.println(score.getName());//name
            System.out.println(score.getType());//类型
            int scoreModifiers = score.getModifiers();
            System.out.println(Modifier.isPrivate(scoreModifiers));//修饰符

            Student stuInstans = new Student(100, 3);

            //set field value
            score.set(stuInstans, 90);

            //get field value
            System.out.println(score.get(stuInstans));

        }
        catch (IllegalArgumentException | IllegalAccessException e)
        {
            e.printStackTrace();
        }
        catch (NoSuchFieldException | SecurityException e)
        {
            e.printStackTrace();
        }

    }
}
