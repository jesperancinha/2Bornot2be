package org.jesperancinha.ocp11.primitives;

public class PrimitiveRunner {

    // 1. Cannot resolve symbol var
    // var is a keyword too to declare variables\
    // it is used in local scopes
    // Type inference cannor happen with lamda expressions and also not with parameters and this is why var doesn't work further in those situations.
    // private var x = 10;

    // 3. Static var doesn't exist
    // It is not local scope
    // static var x = 10;

    public static void main(String[] args) {
        // 2. Int x = 10
        final int x = 10;

        // 4. var with a type
        // By defining a type, this defeats the purpose of var, which is type inference.
        // when combining the two, the compiler interprets var as a symbol and again
        // it reports cannot resolve symbol var.
        // var int x = 10;
    }
}
