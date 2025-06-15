package Practice.Module6.Singleton;

public class Main {
    public static void main(String[] args) {
        // Get the singleton instance from two different places in the code
        AppSettings settings1 = AppSettings.getInstance();
        AppSettings settings2 = AppSettings.getInstance();

        // Check if both variables point to the exact same object
        if (settings1 == settings2) {
            System.out.println("Both settings1 and settings2 are the same instance.");
        }

        // Prove it by changing the theme using one reference
        System.out.println("Initial theme: " + settings1.getTheme());
        settings1.setTheme("Dark");

        // The change is reflected when accessed through the other reference
        System.out.println("Theme after change: " + settings2.getTheme());
    }
}
