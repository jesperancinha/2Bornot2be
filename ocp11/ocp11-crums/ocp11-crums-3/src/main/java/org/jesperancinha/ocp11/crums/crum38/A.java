package org.jesperancinha.ocp11.crums.crum38;

interface A {
    int getTheSheeps();

    private boolean theSheepsAreAlright() {
        return true;
    }

    default int countSheeps() {
        return theSheepsAreAlright() ?
            200 :
            100;
    }
}
