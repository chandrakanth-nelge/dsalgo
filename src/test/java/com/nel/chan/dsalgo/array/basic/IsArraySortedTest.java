package com.nel.chan.dsalgo.array.basic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class IsArraySortedTest {
	private final IsArraySorted isArraySortedTest = new IsArraySorted();

	@DisplayName("IsArraySortingSuccess")
	@MethodSource("com.nel.chan.dsalgo.array.basic.IsArraySortedTest#successInputProvider")
	@ParameterizedTest
	public void testIsArraySortingSuccess(int[] arr, Boolean result) {
		System.out.print("Input array ==> ");
		Arrays.stream(arr).forEach(System.out::print);
		System.out.println();

		boolean res = isArraySortedTest.isSorted(arr);

		assertEquals(res, result);
		System.out.println("=========testIsArraySortingSuccess=================");
	}
	
	@DisplayName("IsArraySortingIsArraySortingSuccessFail")
	@MethodSource("com.nel.chan.dsalgo.array.basic.IsArraySortedTest#failureInputProvider")
	@ParameterizedTest
	public void testIsArraySortingFails(int[] arr, Boolean result) {
		System.out.print("Input array ==> ");
		Arrays.stream(arr).forEach(System.out::print);
		System.out.println();

		boolean res = isArraySortedTest.isSorted(arr);

		assertEquals(res, result);
		System.out.println("=========testIsArraySortingFails=================");
	}

	public static Stream<Arguments> successInputProvider() {
		return Stream.of(Arguments.of(new int[] { 1, 2, 3, 4, 5, 6, 7 }, Boolean.valueOf(true)),
				Arguments.of(new int[] { 1 }, Boolean.valueOf(true)),Arguments.of(new int[] { }, Boolean.valueOf(true)));
	}
	
	public static Stream<Arguments> failureInputProvider() {
		return Stream.of(Arguments.of(new int[] { 1, 2, 4, 3, 5, 6, 7 }, Boolean.valueOf(false)));
	}

}
