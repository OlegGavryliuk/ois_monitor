package Abstract;

import org.testng.Assert;


public class Assertions {

    public static void beEqual(Object actual, Object expected, String message) {
        Assert.assertEquals(actual, expected, "\n" + message + "\n");
    }

    public static void beNotEqual(Object actual, Object expected, String message) {
        Assert.assertNotEquals(actual, expected, "\n" + message + "\n");
    }

    public static void beTrue(boolean condition, String message) {
        Assert.assertTrue(condition, "\n" + message + "\n");
    }

    public static void beFalse(boolean condition, String message) {
        Assert.assertFalse(condition, "\n" + message + "\n");
    }





}
