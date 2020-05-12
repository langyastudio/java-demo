package exception;

public class ExceptionT {
    public static void main(String[] args) {
        try {
            //jvm need -ea
            assert 1<0;
            int a = Integer.parseInt("abc");

        } catch (NumberFormatException e) {
            throw new RuntimeException(e);

        } finally {
            System.out.println("end");

        }
    }
}
