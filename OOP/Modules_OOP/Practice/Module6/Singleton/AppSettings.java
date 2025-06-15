package Practice.Module6.Singleton;

public class AppSettings {
    // 1. The single, static instance of the class. It's private so it can't be accessed directly.
    private static AppSettings instance;

    // Class attributes
    private String theme;

    // 2. The constructor is private to prevent instantiation from other classes.
    private AppSettings() {
        // Default settings
        theme = "Light";
    }

    // 3. The public static method that provides the global access point.
    public static AppSettings getInstance() {
        // Lazy initialization: create the instance only if it doesn't exist yet.
        if (instance == null) {
            instance = new AppSettings();
        }
        return instance;
    }

    // Getters and Setters for the settings
    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }
}
