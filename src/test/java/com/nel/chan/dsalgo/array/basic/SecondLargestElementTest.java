package com.nel.chan.dsalgo.array.basic;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SecondLargestElementTest {
	private final SecondLargestElement secondLargestElement = new SecondLargestElement();

	@DisplayName("SecondLargestElementTestSuccess")
	@MethodSource("com.nel.chan.dsalgo.array.basic.SecondLargestElementTest#successInputProvider")
	@ParameterizedTest
	public void testSecondLargestElementTestSuccess(int[] arr, int result) {
		System.out.print("Input array ==> ");
		Arrays.stream(arr).forEach(System.out::print);
		System.out.println();

		int res = secondLargestElement.secondLargest(arr);

		assertEquals(res, result);
		System.out.println("=========testSecondLargestElementTestSuccess=================");
	}

	public static Stream<Arguments> successInputProvider() {
		return Stream.of(Arguments.of(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 6),
				Arguments.of(new int[] { 1, 10, 76, 67 }, 67));
	}

}
