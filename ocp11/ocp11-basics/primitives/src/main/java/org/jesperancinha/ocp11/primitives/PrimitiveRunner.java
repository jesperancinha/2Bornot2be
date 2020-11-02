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

        var f1 = 1.0;

        // They can only be doubles
        // float f = 43e1;

        float o = 2349238492389489238454539489234982394f;
        // float s = 23492384923894892384545349239489234982394f;
        //  float p = 234923849238948923849239489234982394;
        // double q = 234923849238948923849239489234982394;
        double r = 234923849238948923849239489234982394d;
        // double t = 2349238492389489238492394892349823234234234294f;
        double u = 2349238492389489238492394892349823234234234294d;


        // Maximum minimum floats
        double d = 43e1;

        var f2 = -1;
        float f3 = f2;

        float f4 = 1;
        var f5 = f4;

        var f6 = 4f;

        var f7 = 4d;

    }
}
