import java.util.Scanner;

public class program {
    /**
     * 入口函数
     * @param args 参数
     */
    public static void main(String[] args) {
        //通过Scanner就可以简化后续的代码
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input your name:");
        String strName = scanner.nextLine();

        System.out.println("Input your age:");
        int age = scanner.nextInt();

        System.out.printf("Hi your name is %s, and your age is %2d", strName, age);
    }
}