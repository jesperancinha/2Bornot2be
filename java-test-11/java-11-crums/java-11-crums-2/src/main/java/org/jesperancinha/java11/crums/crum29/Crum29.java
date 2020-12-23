package org.jesperancinha.java11.crums.crum29;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericTitleLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printOrangeGenericLn;

public class Crum29 {
    public static class Wall {
        public void methodA() {

        }

        public static void methodB() {
            printOrangeGenericLn("MethodB from Wall");
        }

    }

    public static class WaillingWall extends Wall {


        public static void methodB() {
            printOrangeGenericLn("MethodB from WaillingWall");
        }


        // Static method 'methodA()' in 'org.jesperancinha.java11.crums.crum29.Crum29.WaillingWall'
        // cannot override instance method 'methodA()' in
        // 'org.jesperancinha.java11.crums.crum29.Crum29.Wall'
        // public static void methodA() {
        // }

        // Instance method 'methodB()' in 'org.jesperancinha.java11.crums.crum29.Crum29.WaillingWall'
        // cannot override static method 'methodB()' in
        // 'org.jesperancinha.java11.crums.crum29.Crum29.Wall'
        // public void methodB() {
        // }

    }

    public static void main(String[] args) {
        printBlueGenericTitleLn("Crum 29 - Overriding (NOT) static methods with instance methods and vice-versa");
        Wall.methodB();
        WaillingWall.methodB();

        final Wall wall =null;
        wall.methodB();
        final WaillingWall waillingWall = null;
        waillingWall.methodB();
        ((Wall)waillingWall).methodB();
        printGreenGenericLn("Note that inner classes have to be static in order to have static methods");
        printGreenGenericLn("There is no overriding static methods and they are accessible via the right casting");
        printGreenGenericLn("Instance references can be used to access static methods even if they have null value");
    }
}
