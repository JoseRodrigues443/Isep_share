package lapr4.red.s3.core.n1150834.persistingImages;

/**
 * The behavior of the image window
 *
 * @author 1150834
 */
public class AutomaticBehavior {

    /**
     * The window behavior
     */
    private static boolean behavior = true;

    /**
     * Creates a new AutomaticBehavior
     */
    public AutomaticBehavior() {
    }

    /**
     * Enables automatic window behavior
     */
    public static void enable() {
        behavior = true;
    }

    /**
     * Disables automatic window behavior
     */
    public static void disable() {
        behavior = false;
    }

    /**
     * Returns the current window behavior
     *
     * @return the current window behavior
     */
    public static boolean currentBehavior() {
        return behavior;
    }

}
