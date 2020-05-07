package cls;

public class Student extends Person
{
    protected int score;

    public Student()
    {
        this(0, "unknown", 0);
    }

    public Student(int age, String name, int score)
    {
        super(age, name);

        this.score = score;
    }


    @Override
    public void run()
    {
        System.out.println("student run");
    }

    /**
     * 入口函数
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        try {
            Student studentIns = new Student(12, "张三", 100);
            studentIns.setNames("wang", "lai", "xxx");
            studentIns.setNames();

            studentIns.run();

            // 返回 Class 实例
            //Object outerCls = studentIns.getClass();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }
}
