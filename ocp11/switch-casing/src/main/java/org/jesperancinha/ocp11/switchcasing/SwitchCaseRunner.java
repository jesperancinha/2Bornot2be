package org.jesperancinha.ocp11.switchcasing;

public class SwitchCaseRunner {
    public static void main(String[] args) {

        var film1919 = getGreatestFilmFromYearMethod1(1919);
        var film1919_2 = getGreatestFilmFromYearMethod2((short) 1919);
        var film1919_3 = getGreatestFilmFromYearMethod1(new Integer("1919"));

        System.out.println("We found this film as being the best film of 1919 using different methods");
        System.out.printf("- Switching Integer -> %s\n", film1919);
        System.out.printf("- Switching Short -> %s\n", film1919_2);
        System.out.printf("- Switching Conversion From String to Integer -> %s\n", film1919_3);
    }

    public static String getGreatestFilmFromYearMethod1(Integer year){
        switch (year) {
            case 1919: return "Broken Blossoms";
            case 1929: return "Alibi";
        }
        return "Nothing found!";
    }

    public static String getGreatestFilmFromYearMethod2(Short year){
        switch (year) {
            case 1919: return "Broken Blossoms";
            case 1929: return "Alibi";
        }
        return "Nothing found!";
    }

}
