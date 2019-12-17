package project;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Input {

	private static Random rd = new Random();

	public int[] inputByRandom(int n) {
		int[] numbers = new int[n];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = rd.nextInt(101);
		}
		return numbers;
	}

	public static String ArrayToString(int[] array) {
		String str = "";
		for (int number : array) {
			str += (number + " ");
		}
		return str;
	}

	public int[] StringToArray(String array) {
		List<Integer> numbersList = new ArrayList<>();
		String[] string = array.split(" ");
		for (String s : string) {
			numbersList.add(Integer.parseInt(s));
		}
		int[] numbers = new int[numbersList.size()];
		int i = 0;
		for (int number : numbersList) {
			numbers[i] = number;
			i++;
		}
		return numbers;
	}

}
