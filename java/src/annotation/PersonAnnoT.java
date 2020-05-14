package annotation;

import java.lang.reflect.Field;

public class PersonAnnoT {
    @Range(min = 2, max = 4)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        PersonAnnoT p = new PersonAnnoT();
        p.setName("五个字名字");

        try {
            p.check(p);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    //处理注解
    public void check(PersonAnnoT person) throws IllegalArgumentException, ReflectiveOperationException {
        Class   cls    = person.getClass();
        Field[] fields = cls.getDeclaredFields();

        for (Field field : fields) {
            Range range = field.getAnnotation(Range.class);
            if (null != range) {

                if(field.getType() == String.class)
                {
                    String fieldValue = (String)field.get(person);
                    if (fieldValue.length() < range.min() || fieldValue.length() > range.max()) {
                        throw new IllegalArgumentException("field range not ok " + field.getName());
                    }
                }
            }
        }
    }
}