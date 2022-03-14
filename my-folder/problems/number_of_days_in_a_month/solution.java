class Solution {
    private static final int[] DAYS_IN_MONTH = {0, 31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public int numberOfDays(int year, int month) {
        if (month != 2)
            return DAYS_IN_MONTH[month];
        return isLeapYear(year) ? 29 : 28;
    }

    private boolean isLeapYear(int year) {
        if (year % 100 == 0)
            return year % 400 == 0;
        return year % 4 == 0;
    }
}