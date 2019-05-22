import java.util.Scanner;

public class middleOfTheContest {
	static time add(time t1, time t2) {
		int hours = t1.hours + t2.hours;
		int min = (t1.min + t2.min) % 60;
		if (min != (t1.min + t2.min)) {
			hours++;
		}
		return new time(hours, min);
	}

	static time halve(time t1) {
		int hours, min = 0;
		hours = t1.hours / 2;
		if (t1.hours % 2 == 1) {
			min = 30;
		}
		min += t1.min / 2;
		return new time(hours, min);
	}

	static String format(int time) {
		String t = time + "";
		if (t.length() == 1) {
			return 0 + t;
		}
		return t;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String t[] = sc.next().split(":");
		time t1 = new time(Integer.parseInt(t[0]), Integer.parseInt(t[1]));
		t = sc.next().split(":");
		time t2 = new time(Integer.parseInt(t[0]), Integer.parseInt(t[1]));
		time midTime = halve(add(t1, t2));
		System.out.print(format(midTime.hours) + ":" + format(midTime.min));
	}
}

class time {
	int hours;
	int min;

	time(int h, int m) {
		hours = h;
		min = m;
	}
}
