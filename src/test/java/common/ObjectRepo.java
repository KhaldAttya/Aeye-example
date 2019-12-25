package common;

import org.openqa.selenium.By;

public class ObjectRepo {

    // Elements

    public static By element;

    static String build;

    public static void objectRepo(String platform, String build) {
        ObjectRepo.build = build;
        switch (platform) {
            case "native-android": {
                nativeAndroid();
            }
            break;
            case "native-ios": {
                nativeIOS();
            }
            break;
            case "react-android": {
                reactAndroid();
            }
            break;
            case "react-ios": {
                reactIOS();
            }
            break;
        }

    }

    private static void reactIOS() {
        element = By.id("");
    }

    private static void reactAndroid() {
        element = By.id("");
    }

    private static void nativeIOS() {
        element = By.id("");
    }

    private static void nativeAndroid() {
        element = By.id("");
    }
}