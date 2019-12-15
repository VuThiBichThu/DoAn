package project;

//Tạo package sorting => code các thuật toán sắp xếp, mỗi thuật toán một hàm.
//1. Sắp xếp Nổi b�?t – Bubble Sort
//2. Săp xếp Kiểu ch�?n – Selection Sort
//3. Merge Sort (Tìm hiểu thuật toán chia để trị)
//4. QuickSort (Tìm hiểu thuật toán phân hoạch)
public class Sort {

	public int[] bubbleSort(int[] numbers) {
		int[] newNumbers = numbers.clone();
		int i, j, temp;
		boolean swapped;
		for (i = 0; i < newNumbers.length - 1; i++) {
			swapped = false;
			for (j = 0; j < newNumbers.length - i - 1; j++) {
				if (newNumbers[j] > newNumbers[j + 1]) {
					temp = newNumbers[j];
					newNumbers[j] = newNumbers[j + 1];
					newNumbers[j + 1] = temp;
					swapped = true;
				}
			}
			if (swapped == false)
				break;
		}
		return newNumbers;
	}

	public int[] selectionSort(int[] numbers) {
		int[] newNumbers = numbers.clone();
		for (int i = 0; i < newNumbers.length - 1; i++) {
			int min_idx = i;
			for (int j = i + 1; j < newNumbers.length; j++)
				if (newNumbers[j] < newNumbers[min_idx])
					min_idx = j;
			int temp = newNumbers[min_idx];
			newNumbers[min_idx] = newNumbers[i];
			newNumbers[i] = temp;
		}
		return newNumbers;
	}
	

	public int[] mergeSortMethod(int[] numbers) {
		int[] newNumbers = numbers.clone();
		int l = 0;
		int r = newNumbers.length - 1;
		mergeSort(newNumbers, l, r);
		return newNumbers;
	}

	private void mergeSort(int[] numbers, int l, int r) {
		if (l < r) {
			int m = (l + r) / 2;
			mergeSort(numbers, l, m);
			mergeSort(numbers, m + 1, r);
			merge(numbers, l, m, r);
		}
	}

	private void merge(int numbers[], int left, int mid, int right) {
		int n1 = mid - left + 1;
		int n2 = right - mid;

		int leftArray[] = new int[n1];
		int rightArray[] = new int[n2];

		for (int i = 0; i < n1; ++i)
			leftArray[i] = numbers[left + i];
		for (int j = 0; j < n2; ++j)
			rightArray[j] = numbers[mid + 1 + j];

		int i = 0, j = 0;

		int k = left;

		while (i < n1 && j < n2) {
			if (leftArray[i] <= rightArray[j]) {
				numbers[k] = leftArray[i];
				i++;
			} else {
				numbers[k] = rightArray[j];
				j++;
			}
			k++;
		}

		while (i < n1) {
			numbers[k] = leftArray[i];
			i++;
			k++;
		}

		while (j < n2) {
			numbers[k] = rightArray[j];
			j++;
			k++;
		}
	}

	public int[] quickSortMethod(int[] numbers) {
		int[] newNumbers = numbers.clone();
		int left = 0;
		int right = newNumbers.length - 1;
		quickSort(newNumbers, left, right);
		return newNumbers;
	}

	private void quickSort(int[] numbers, int low, int high) {

		if (low < high) {
			int pi = partition(numbers, low, high);
			quickSort(numbers, low, pi - 1);
			quickSort(numbers, pi + 1, high);
		}
	}

	private int partition(int numbers[], int low, int high) {
		int pivot = numbers[high];
		int i = (low - 1);
		for (int j = low; j < high; j++) {
			if (numbers[j] < pivot) {
				i++;
				int temp = numbers[i];
				numbers[i] = numbers[j];
				numbers[j] = temp;
			}
		}

		int temp = numbers[i + 1];
		numbers[i + 1] = numbers[high];
		numbers[high] = temp;

		return i + 1;
	}

}
