
/*
 * this 表示调用子类中相应的属性和方法
 * super 表示调用父类中相应的属性和方法
 */
public class ClassT {
    enum PeopleEnum{
        //男士
        MAIL,
        //女士
        WOMEN
    };

    /**
     * 入口函数
     * @param args 参数
     */
    public static void main(String[] args) {
        //【4】内部类
        try{
            ClassT   outer = new ClassT();
            InterCls inter = outer.new InterCls();
            inter.print("Outer.new");

            inter = outer.getInner();
            inter.print("Outer.get");

            // 返回 Class 实例
            Object outerCls = outer.getClass();

            // Exception
            int ex = 12 / 0;

        }catch (Exception e){
            e.printStackTrace();
        }finally {

        }

        //【5】集合类


    }

    //推荐使用getxxx()来获取成员内部类，尤其是该内部类的构造函数无参数时
    private InterCls getInner() {
        return new InterCls();
    }

    /**
     * 方法内部类
     */
    public class InterCls {
        public void print(String str) throws Exception {
            System.out.println(str);
        }
    }
}