package org.jesperancinha.jtd;

import java.io.IOException;
import java.io.InputStream;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.invoke.MethodHandles.Lookup.ClassOption;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Hidden {

    public static void main(String[] args) throws IllegalAccessException, IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        final ClassOption classOption = ClassOption.NESTMATE;

        final InputStream stream = Hidden.class.getClassLoader().getResourceAsStream("./org/jesperancinha/jtd/Mouse.class");

        assert stream != null;

        final Lookup lookup = MethodHandles.lookup().defineHiddenClass(stream.readAllBytes(), false, classOption);
        final Class<?> aClass = lookup.findClass("org.jesperancinha.jtd.Mouse");

        Object newInstance = aClass.newInstance();
        Method method = aClass.getMethod("getCatch", Integer.class);
        Object invokeResult = method.invoke(newInstance, 10);
        
        System.out.println(invokeResult);
        System.out.println(aClass);

    }
}
