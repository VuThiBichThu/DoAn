package project;


public class Sort {

	public int[] selectionSort(int[] numbers, Order o) {
		int[] sortedNumbers = numbers.clone();
		for (int i = 0; i < sortedNumbers.length - 1; i++) {
			int index = i;
			for (int j = i + 1; j < sortedNumbers.length; j++)
				if (o.compare(sortedNumbers[j], sortedNumbers[index]))
					index = j;
			int temp = sortedNumbers[index];
			sortedNumbers[index] = sortedNumbers[i];
			sortedNumbers[i] = temp;
		}
		return sortedNumbers;
	}

	public int[] bubbleSort(int[] numbers, Order o) {
		int[] sortedNumbers = numbers.clone();
		int i, j, temp;
		boolean swapped;
		for (i = 0; i < sortedNumbers.length - 1; i++) {
			swapped = false;
			for (j = 0; j < sortedNumbers.length - i - 1; j++) {
				if (o.compare(sortedNumbers[j], sortedNumbers[j + 1])) {
					temp = sortedNumbers[j];
					sortedNumbers[j] = sortedNumbers[j + 1];
					sortedNumbers[j + 1] = temp;
					swapped = true;
				}
			}
			if (swapped == false)
				break;
		}
		return sortedNumbers;
	}

	public int[] mergeSortMethod(int[] numbers, Order o) {
		int[] sortedNumbers = numbers.clone();
		int l = 0;
		int r = sortedNumbers.length - 1;
		mergeSort(sortedNumbers, l, r, o);
		return sortedNumbers;
	}

	private void mergeSort(int[] numbers, int l, int r, Order o) {
		if (l < r) {
			int m = (l + r) / 2;
			mergeSort(numbers, l, m, o);
			mergeSort(numbers, m + 1, r, o);
			merge(numbers, l, m, r, o);
		}
	}

	private void merge(int numbers[], int left, int mid, int right, Order o) {
		int n1 = mid - left + 1;
		int n2 = right - mid;

		int leftNumbers[] = new int[n1];
		int rightNumbers[] = new int[n2];

		for (int i = 0; i < n1; ++i)
			leftNumbers[i] = numbers[left + i];
		for (int j = 0; j < n2; ++j)
			rightNumbers[j] = numbers[mid + 1 + j];

		int i = 0, j = 0;

		int k = left;

		while (i < n1 && j < n2) {
			if (o.compare(leftNumbers[i], rightNumbers[j])) {
				numbers[k] = leftNumbers[i];
				i++;
			} else {
				numbers[k] = rightNumbers[j];
				j++;
			}
			k++;
		}

		while (i < n1) {
			numbers[k] = leftNumbers[i];
			i++;
			k++;
		}

		while (j < n2) {
			numbers[k] = rightNumbers[j];
			j++;
			k++;
		}
	}

	public int[] quickSortMethod(int[] numbers, Order o) {
		int[] sortedNumbers = numbers.clone();
		int left = 0;
		int right = sortedNumbers.length - 1;
		quickSort(sortedNumbers, left, right, o);
		return sortedNumbers;
	}

	private void quickSort(int[] numbers, int left, int right, Order o) {

		if (left < right) {
			int pi = partition(numbers, left, right, o);
			quickSort(numbers, left, pi - 1, o);
			quickSort(numbers, pi + 1, right, o);
		}
	}

	private int partition(int numbers[], int left, int right, Order o) {
		int pivot = numbers[right];
		int i = (left - 1);
		for (int j = left; j < right; j++) {
			if (o.compare(numbers[j], pivot)) {
				i++;
				int temp = numbers[i];
				numbers[i] = numbers[j];
				numbers[j] = temp;
			}
		}

		int temp = numbers[i + 1];
		numbers[i + 1] = numbers[right];
		numbers[right] = temp;

		return i + 1;
	}
}
