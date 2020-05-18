package org.jesperancinha.jtd;


import java.io.IOException;
import java.io.InputStream;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.invoke.MethodHandles.Lookup.ClassOption;

public class Hidden {

    public static void main(String[] args) throws IllegalAccessException, IOException, ClassNotFoundException {
        ClassOption classOption = ClassOption.NESTMATE;

        String className = Hidden.class.getName();
        String classAsPath = className.replace('.', '/') + ".class";
        InputStream stream = Hidden.class.getClassLoader().getResourceAsStream(classAsPath);

        Lookup lookup = MethodHandles.lookup().defineHiddenClass(stream.readAllBytes(), false, classOption);
        Class<?> aClass = lookup.findClass(className);
        System.out.println(aClass);
    }
}
