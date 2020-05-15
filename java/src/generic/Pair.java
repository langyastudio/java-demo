package generic;

public class Pair<T> {
    private T first;
    private T last;

    public static void main(String[] args) {
        Pair<String> pair = new Pair<>("1", "2");
        System.out.println(pair.getLast());

        //可以声明带泛型的数组，但不能直接创建带泛型的数组，必须强制转型。
        @SuppressWarnings("unchecked")
        Pair<String>[] pairs = (Pair<String>[]) (new Pair[2]);
    }

    public Pair() {

    }

    public Pair(T first, T last) {
        this.first = first;
        this.last = last;
    }

    /**
     * 静态方法
     */
    public static <K> Pair<K> create(K first, K last) {
        return new Pair<K>(first, last);
    }

    public void init(Class<T> cls) throws ReflectiveOperationException {
        this.first = cls.getDeclaredConstructor().newInstance();
        this.last = cls.getDeclaredConstructor().newInstance();
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getLast() {
        return last;
    }

    public void setLast(T last) {
        this.last = last;
    }
}
