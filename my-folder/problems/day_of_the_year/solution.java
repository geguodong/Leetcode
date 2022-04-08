class Solution {
	public int dayOfYear(String date) {
		int[] monthDays = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		String dateArr[] = date.split("-");
		int year = Integer.parseInt(dateArr[0]);
		int month = Integer.parseInt(dateArr[1]);
		int day = Integer.parseInt(dateArr[2]);
		boolean leapYear = false;
		if(((year % 4 == 0) && (year % 100!= 0)) || (year%400 == 0)) {
			leapYear = true;
		}
		for(int i = 1; i < month; i++) {
			day += monthDays[i];
		}
		if(leapYear && month > 2) day++;
		return day;
	}
}