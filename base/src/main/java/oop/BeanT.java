package oop;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

public class BeanT {
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        try
        {
            BeanInfo beanInfo = Introspector.getBeanInfo(BeanT.class);
            for (PropertyDescriptor property : beanInfo.getPropertyDescriptors())
            {
                System.out.println(property.getName());
                System.out.println(property.getReadMethod());
                System.out.println(property.getWriteMethod());
                System.out.println(property.getPropertyType());
            }
        }
        catch (Exception e)
        {

        }
    }
}

