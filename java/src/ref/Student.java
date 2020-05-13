package ref;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Student extends Person {
    public int score;
    private int grade;
    private int[] iArr;

    public Student(int score, int grade)
    {
        this.score = score;
        this.grade = grade;
    }

    public void setScore(int score)
    {
        this.score = score;
    }

    public void setGrade(int grade)
    {
        this.grade = grade;
    }

    public static void main(String[] args) {
        try
        {
            Class stdCls = Student.class;

            //【1】get Field
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


            //【2】get method
            //获取public方法setScore，参数为int
            Method setScore = stdCls.getMethod("setScore", int.class);

            //method info
            System.out.println(setScore.getName());
            System.out.println(setScore.getReturnType());
            System.out.println(Arrays.toString(setScore.getParameterTypes()));

            //invoke
            setScore.invoke(stuInstans, 80);
            System.out.println(stuInstans.score);

            //【3】constructor
            Constructor cons1 = stdCls.getConstructor(int.class, int.class);
            Student cons1Instanst = (Student) cons1.newInstance(20, 12);
            System.out.println(cons1Instanst.score);

            //【4】继承关系
            Class i = stdCls.getSuperclass();
            System.out.println(i);

            //只返回当前类直接实现的接口类型，并不包括其父类实现的接口类型
            Class[] is = Integer.class.getInterfaces();
            for (Class ix:is)
            {
                System.out.println(ix);
            }
        }
        catch (RuntimeException e )
        {
            e.printStackTrace();
        }
        catch (ReflectiveOperationException  e)
        {
            e.printStackTrace();
        }
    }
}
