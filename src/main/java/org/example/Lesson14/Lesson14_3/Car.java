package org.example.Lesson14.Lesson14_3;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Car {

    private String carBody;
    private String carColor;
    private String carEngine;
    private String carAC;

    void speedBoost() {
        System.out.println("Газ в пол!");
    }

    ;

    void braking() {
        System.out.println("По тормозам!");
    }

    ;

    public Car(String carBody, String carColor, String carEngine) {
        this.carBody = carBody;
        this.carColor = carColor;
        this.carEngine = carEngine;
    }

    protected Car(String carBody, String carColor, String carEngine, String carAC) {
        this.carBody = carBody;
        this.carColor = carColor;
        this.carEngine = carEngine;
        this.carAC = carAC;
    }

    public static void scanObject(Object obj) {
        if (obj == null) {
            System.out.println("Объект равен нулю");
            return;
        }

        Class<?> clazz = obj.getClass();

        System.out.println("Поля: ");
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                System.out.println(field.getName() + " = " + field.get(obj));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("Методы: ");
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }

        System.out.println("Конструкторы: ");
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        for (Constructor<?> c : constructors) {
            System.out.println(c.getName() + " с количеством параметров: " + c.getParameterCount());
        }
    }

    public static void main(String[] args) {

        Car myCar = new Car("Седан", "Черный", "V8", "Кондей");
        Car myCar2 = new Car("Купе", "Красный", "V12", "Климат контроль");
        Car myCar3 = new Car("SUV", "Коричневый", "V6", "Печка");
        scanObject(myCar);
        System.out.println(" ");
        scanObject(myCar2);
        System.out.println(" ");
        scanObject(myCar3);
    }
}
