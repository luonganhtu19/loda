package com.example.loda.core.javaReflection;

import java.lang.reflect.Field;

public  class mainTest {
    public static void main(String[] args) throws NoSuchMethodException {
        // Reflection:
        // field
        Girl girl = new Girl("test");

        // lay ra tat ca field cua object.
        for (Field field: girl.getClass().getDeclaredFields()){
         System.out.println("------------- field----------");
         System.out.println("field: "+ field.getName() +" ---Type: "+ field.getType());
         System.out.println("-----------------------------");
        }
        try {
            System.out.println(girl.toString());
            Field field = girl.getClass().getField("name");
            Field field1 = girl.getClass().getDeclaredField("id");
            field1.setAccessible(true);
            field1.set(girl,1);

            System.out.println(field1.getInt(girl));
            System.out.println("000000000");
            System.out.println(field1.toString());
            System.out.println(girl.toString());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        // lay ra Constructor
        Class<Girl> girlClass = Girl.class;
        System.out.println("Class:" + girlClass.getSimpleName());
        System.out.println("Constructor"+ girlClass.getConstructor().toString());
    }
}
