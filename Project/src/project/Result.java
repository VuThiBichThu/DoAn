package project;

import java.util.function.Function;

public class Result {
	float time;
	int[] numbers;

	public Result() {
	}

	public Result(float time, int[] result) {
		this.time = time;
		this.numbers = result;
	}

	public Result TestSortingAlgorithm(Function<int[], int[]> algorithms, int[] data) {
		long startTime = System.nanoTime();
		int[] result = algorithms.apply(data);
		long endTime = System.nanoTime();

		float time = (endTime - startTime) / 1000000.0f;

		return new Result(time, result);
	}
}