package com.nel.chan.dsalgo.array.basic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LargestElementTest {
	private final LargestElement largestElement = new LargestElement();

	@DisplayName("LargestElementTestSuccess")
	@MethodSource("com.nel.chan.dsalgo.array.basic.LargestElementTest#successInputProvider")
	@ParameterizedTest
	public void testLargestElementTestSuccess(int[] arr, int result) {
		System.out.print("Input array ==> ");
		Arrays.stream(arr).forEach(System.out::print);
		System.out.println();

		int res = largestElement.largest(arr);

		assertEquals(res, result);
		System.out.println("=========testLargestElementTestSuccess=================");
	}

	@DisplayName("LargestElementTestFail")
	@MethodSource("com.nel.chan.dsalgo.array.basic.LargestElementTest#failureInputProvider")
	@ParameterizedTest
	public void testLargestElementTestFails(int[] arr, int result) {
		System.out.print("Input array ==> ");
		Arrays.stream(arr).forEach(System.out::print);
		System.out.println();

		int res = largestElement.largest(arr);

		assertNotEquals(res, result);
		System.out.println("=========testLargestElementTestFails=================");
	}

	public static Stream<Arguments> successInputProvider() {
		return Stream.of(Arguments.of(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 7), Arguments.of(new int[] { 1 }, 1));
	}

	public static Stream<Arguments> failureInputProvider() {
		return Stream.of(Arguments.of(new int[] { 1, 2, 4, 3, 5, 6, 7 }, 5));
	}

}
