package com.nel.chan.dsalgo.array.sort;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class InsertionSortTest {
	final InsertionSort insertionSort = new InsertionSort();
	
	@DisplayName("InsertionSortSuccess")
	@MethodSource("com.nel.chan.dsalgo.array.sort.SortingInputProvider#successInputProvider")
	@ParameterizedTest
	public void testSortSuccess(int[] arr, int[] expectedArr) {
		System.out.print("Input array ==> ");
		Arrays.stream(arr).forEach(System.out::print);
		System.out.println();

		System.out.print("Expected array ==> ");
		Arrays.stream(expectedArr).forEach(System.out::print);
		System.out.println();

		int[] outArr = insertionSort.sort(arr);
		System.out.print("Output array ==> ");
		Arrays.stream(outArr).forEach(System.out::print);
		System.out.println();

		assertArrayEquals(expectedArr, outArr);
		System.out.println("=========InsertionSortSuccess=================");
	}

	@DisplayName("InsertionSortFail")
	@MethodSource("com.nel.chan.dsalgo.array.sort.SortingInputProvider#failureInputProvider")
	@ParameterizedTest
	public void testSortFail(int[] arr, int[] expectedArr) {
		System.out.print("Input array ==> ");
		Arrays.stream(arr).forEach(System.out::print);
		System.out.println();

		System.out.print("Expected array ==> ");
		Arrays.stream(expectedArr).forEach(System.out::print);
		System.out.println();

		int[] outArr = insertionSort.sort(arr);
		System.out.print("Output array == ");
		Arrays.stream(outArr).forEach(System.out::print);
		System.out.println();

		assertFalse(Arrays.equals(outArr, expectedArr));
		System.out.println("=========InsertionSortFail=================");
	}

}
