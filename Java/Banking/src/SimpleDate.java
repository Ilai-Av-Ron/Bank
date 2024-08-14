package src;

import java.time.LocalDate;
import java.util.Map;
import java.util.HashMap;

public class SimpleDate {
    private final int year;
    private final int month;
    private final int day;

    final int[] shortMonths = {4, 6, 9, 11};
    final static Map<Integer, String> monthNames = new HashMap<>();
    static {
        monthNames.put(1, "January");
        monthNames.put(2, "February");
        monthNames.put(3, "March");
        monthNames.put(4, "April");
        monthNames.put(5, "May");
        monthNames.put(6, "June");
        monthNames.put(7, "July");
        monthNames.put(8, "August");
        monthNames.put(9, "September");
        monthNames.put(10, "October");
        monthNames.put(11, "November");
        monthNames.put(12, "December");
    }

    public SimpleDate(int year, int month, int day){
        assert validateDate(year, month, day);
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public SimpleDate fromString(String date){
        String regex = "^\\d{4}-\\d{2}-\\d{2}$";
        assert date.matches(regex) : "String not in format YYYY-MM-DD";
        String[] parts = date.split("-");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);
        return new SimpleDate(year, month, day);
    }

    public static SimpleDate today(){
        LocalDate today = LocalDate.now();
        int year = today.getYear();
        int month = today.getMonthValue();
        int day = today.getDayOfMonth();
        return new SimpleDate(year, month, day);
    }

    private boolean validateDate(int year, int month, int day){
        assert year >= 0 : "Year can't be nagative.";
        assert month <= 12 && month >= 1 : "Month must be between 1 and 12";
        assert day >= 1 && day <= 31 : "Day must be between 1 and 31";
        for (int m : shortMonths){
            assert m != month || day <= 30 : String.format("%s only has 30 days", monthNames.get(month));
        }
        if (month == 2){
            if (year % 4 == 0) {
                assert day <= 29 : "February of " + year + " only has 29 days";
            }
            else {
                assert day <= 28 : "February of " + year + " only has 28 days";
            }
        }
        return true;
    }

    public boolean before(SimpleDate other){
        if (this.year > other.year){
            return false;
        }
        if (this.year < other.year){
            return true;
        }
        if (this.month > other.month){
            return false;
        }
        if (this.month < other.month){
            return true;
        }
        return this.day <= other.day;
    }
}
