package project;

import java.util.function.BiFunction;

public class Result {
	float time;
	int[] numbers;

	public Result() {
	}

	public Result(float time, int[] result) {
		this.time = time;
		this.numbers = result;
	}

	public Result TestSortingAlgorithm(BiFunction<int[], Order, int[]> algorithms, Order o, int[] data) {
		long startTime = System.nanoTime();
		int[] result = algorithms.apply(data, o);
		long endTime = System.nanoTime();
		float time = (endTime - startTime) / 1000000.0f;
		return new Result(time, result);
	}
}