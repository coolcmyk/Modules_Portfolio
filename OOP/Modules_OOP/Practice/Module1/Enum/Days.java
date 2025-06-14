package Practice.Module1.Enum;

public enum Days {
    SUNDAY("Weekend"),
    MONDAY("Weekday"),
    TUESDAY("Weekday"),
    WEDNESDAY("Weekday"),
    THURSDAY("Weekday"),
    FRIDAY("Weekday"),
    SATURDAY("Weekend");

    private final String dayType;

    Days(String dayType) {
        this.dayType = dayType;
    }

    public void printDayType() {
        System.out.println(this.name() + " is a " + this.dayType);
    }

    public static void main(String[] args) {
        Days today = Days.MONDAY;
        Days weekend = Days.SATURDAY;

        today.printDayType();    
        weekend.printDayType(); 
    }
}