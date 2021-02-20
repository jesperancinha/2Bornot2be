package org.jesperancinha.java11.annotations.books;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AnnotationBooksRunner {
    public static void main(String[] args) throws NoSuchMethodException {
        final String mysteryBookAnnotations = Arrays.stream(MysteryBook.class.getAnnotations()).map(Annotation::toString).collect(Collectors.joining(","));
        System.out.printf("This is the collected values for the annotations of the MysteryBook. It should be empty: %s\n", mysteryBookAnnotations);

        final String sdkMysteryBook = Arrays.stream(SdkMysteryBook.class.getAnnotations()).map(Annotation::toString).collect(Collectors.joining(","));
        System.out.printf("This is the collected values for the annotations of the SdkMysteryBook. It should also be empty: %s\n", sdkMysteryBook);

        Method toString = SdkMysteryBook.class.getMethod("toString");
        final String toStringAnnotations = Arrays.stream(toString.getAnnotations()).map(Annotation::toString).collect(Collectors.joining(","));
        System.out.printf("Even the Override on the method should now see no annotations: %s", toStringAnnotations);

        final String sdkRealBook = Arrays.stream(SdkRealBook.class.getAnnotations()).map(Annotation::toString).collect(Collectors.joining(","));
        System.out.printf("This is the collected values for the annotations of the SdkRealBook. It should have two annotations: %s\n", sdkRealBook);

        final String sdkRealBookImpl = Arrays.stream(SdkRealBookImpl.class.getAnnotations()).map(Annotation::toString).collect(Collectors.joining(","));
        System.out.printf("This is the collected values for the annotations of the SdkRealBook. It should also be empty  purely because there are no annotations on a class level: %s\n", sdkRealBookImpl);

        final Method varagSafeMethod = SdkRealBookImpl.class.getMethod("varagSafeMethod", List[].class);
        final String varagSafeMethodAnnotations = Arrays.stream(varagSafeMethod.getAnnotations()).map(Annotation::toString).collect(Collectors.joining(","));
        System.out.printf("The check on the method varagSafeMethod should now on annotation. Do remember that Override is removed: %s", varagSafeMethodAnnotations);
    }
}
