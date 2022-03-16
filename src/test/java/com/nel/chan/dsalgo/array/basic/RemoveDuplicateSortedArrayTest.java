package com.nel.chan.dsalgo.array.basic;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class RemoveDuplicateSortedArrayTest {

	private final RemoveDuplicateSortedArray removeDuplicateSortedArray = new RemoveDuplicateSortedArray();

	@DisplayName("RemoveDuplicateSortedArraySuccess")
	@MethodSource("com.nel.chan.dsalgo.array.basic.RemoveDuplicateSortedArrayTest#successInputProvider")
	@ParameterizedTest
	public void testRemoveDuplicateSortedArraySuccess(int[] arr, int[] expected) {
		System.out.print("Input array ==> ");
		Arrays.stream(arr).forEach(System.out::print);
		System.out.println();

		int[] res = removeDuplicateSortedArray.remove(arr);

		assertArrayEquals(res, expected);
		System.out.println("=========testRemoveDuplicateSortedArraySuccess=================");
	}

	public static Stream<Arguments> successInputProvider() {
		return Stream.of(Arguments.of(new int[] { 10, 10, 20, 30, 30, 30, 30 }, new int[] { 10, 20, 30, 0, 0, 0, 0 }),
				Arguments.of(new int[] { 10, 20, 30, 30, 35, 35 }, new int[] { 10, 20, 30, 35, 0, 0 }));
	}
}
