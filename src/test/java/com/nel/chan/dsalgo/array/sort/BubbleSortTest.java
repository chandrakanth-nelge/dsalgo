package com.nel.chan.dsalgo.array.sort;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class BubbleSortTest {
	private BubbleSort bubbleSort = new BubbleSort();

	@DisplayName("BubbleLargestElementSuccess")
	@MethodSource("com.nel.chan.dsalgo.array.sort.SortingInputProvider#successInputProvider")
	@ParameterizedTest
	public void testBubbleLargestElementSuccess(int[] arr, int[] expectedArr) {
		System.out.print("Input array ==> ");
		Arrays.stream(arr).forEach(System.out::print);
		System.out.println();

		System.out.print("Expected array ==> ");
		Arrays.stream(expectedArr).forEach(System.out::print);
		System.out.println();

		int[] outArr = bubbleSort.bubbleLargestElement(arr);
		System.out.print("Output array ==> ");
		Arrays.stream(outArr).forEach(System.out::print);
		System.out.println();

		assertArrayEquals(expectedArr, outArr);
		System.out.println("=========BubbleLargestElementSuccess=================");
	}

	@DisplayName("BubbleLargestElementReverseSuccess")
	@MethodSource("com.nel.chan.dsalgo.array.sort.SortingInputProvider#successInputProviderReverse")
	@ParameterizedTest
	public void testBubbleLargestElementReverseSuccess(int[] arr, int[] expectedArr) {
		System.out.print("Input array ==> ");
		Arrays.stream(arr).forEach(System.out::print);
		System.out.println();

		System.out.print("Expected array ==> ");
		Arrays.stream(expectedArr).forEach(System.out::print);
		System.out.println();

		int[] outArr = bubbleSort.bubbleLargestElementReverse(arr);
		System.out.print("Output array ==> ");
		Arrays.stream(outArr).forEach(System.out::print);
		System.out.println();

		assertArrayEquals(expectedArr, outArr);
		System.out.println("=========BubbleLargestElementReverseSuccess=================");
	}

	@DisplayName("BubbleLargestElementFail")
	@MethodSource("com.nel.chan.dsalgo.array.sort.SortingInputProvider#failureInputProvider")
	@ParameterizedTest
	public void testBubbleLargestElementFails(int[] arr, int[] expectedArr) {
		System.out.print("Input array ==> ");
		Arrays.stream(arr).forEach(System.out::print);
		System.out.println();

		System.out.print("Expected array ==> ");
		Arrays.stream(expectedArr).forEach(System.out::print);
		System.out.println();

		int[] outArr = bubbleSort.bubbleLargestElement(arr);
		System.out.print("Output array == ");
		Arrays.stream(outArr).forEach(System.out::print);
		System.out.println();

		assertFalse(Arrays.equals(outArr, expectedArr));
		System.out.println("=========BubbleLargestElementFail=================");
	}

	@DisplayName("BubbleSmallestElementSuccess")
	@MethodSource("com.nel.chan.dsalgo.array.sort.SortingInputProvider#successInputProvider")
	@ParameterizedTest
	public void testBubbleSmallestElementSuccess(int[] arr, int[] expectedArr) {
		System.out.print("Input array ==> ");
		Arrays.stream(arr).forEach(System.out::print);
		System.out.println();

		System.out.print("Expected array ==> ");
		Arrays.stream(expectedArr).forEach(System.out::print);
		System.out.println();

		int[] outArr = bubbleSort.bubbleSmallestElement(arr);
		System.out.print("Output array == ");
		Arrays.stream(outArr).forEach(System.out::print);
		System.out.println();

		assertArrayEquals(expectedArr, outArr);
		System.out.println("=========BubbleSmallestElementSuccess=================");
	}

	@DisplayName("BubbleSmallestElementFail")
	@MethodSource("com.nel.chan.dsalgo.array.sort.SortingInputProvider#failureInputProvider")
	@ParameterizedTest
	public void testBubbleSmallestElementFails(int[] arr, int[] expectedArr) {
		System.out.print("Input array ==> ");
		Arrays.stream(arr).forEach(System.out::print);
		System.out.println();

		System.out.print("Expected array ==> ");
		Arrays.stream(expectedArr).forEach(System.out::print);
		System.out.println();

		int[] outArr = bubbleSort.bubbleSmallestElement(arr);
		System.out.print("Output array == ");
		Arrays.stream(outArr).forEach(System.out::print);
		System.out.println();

		assertFalse(Arrays.equals(expectedArr, outArr));
		System.out.println("==========BubbleSmallestElementFail================");
	}
}
