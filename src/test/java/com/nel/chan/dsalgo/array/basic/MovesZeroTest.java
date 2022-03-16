package com.nel.chan.dsalgo.array.basic;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MovesZeroTest {

	private final MovesZero movesZero = new MovesZero();

	@DisplayName("MovesZeroSuccess")
	@MethodSource("com.nel.chan.dsalgo.array.basic.MovesZeroTest#successInputProvider")
	@ParameterizedTest
	public void testMovesZeroSuccess(int[] arr, int[] expected) {
		System.out.print("Input array ==> ");
		Arrays.stream(arr).forEach(System.out::print);
		System.out.println();

		int[] res = movesZero.move(arr);

		assertArrayEquals(res, expected);
		System.out.println("=========testMovesZeroSuccess=================");
	}

	public static Stream<Arguments> successInputProvider() {
		return Stream.of(Arguments.of(new int[] { 8, 5, 0, 10, 0, 20 }, new int[] { 8, 5, 10, 20, 0, 0 }),
				Arguments.of(new int[] { 0, 0, 0, 0, 0 }, new int[] { 0, 0, 0, 0, 0 }),
				Arguments.of(new int[] { 0, 8, 0, 0, 1 }, new int[] { 8, 1, 0, 0, 0 }));
	}

}