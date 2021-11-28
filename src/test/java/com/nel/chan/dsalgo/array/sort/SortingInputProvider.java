package com.nel.chan.dsalgo.array.sort;

import java.util.stream.Stream;

import org.junit.jupiter.params.provider.Arguments;

public class SortingInputProvider {

	public static Stream<Arguments> successInputProvider() {
		return Stream.of(Arguments.of(new int[] { 0, 2, 1, 5, 3, 4 }, new int[] { 0, 1, 2, 3, 4, 5 }),
				Arguments.of(new int[] { 5, 0, 1, 2, 3, 4 }, new int[] { 0, 1, 2, 3, 4, 5 }));
	}

	public static Stream<Arguments> successInputProviderReverse() {
		return Stream.of(Arguments.of(new int[] { 0, 2, 1, 5, 3, 4 }, new int[] { 5, 4, 3, 2, 1, 0 }),
				Arguments.of(new int[] { 5, 0, 1, 2, 3, 4 }, new int[] { 5, 4, 3, 2, 1, 0 }));
	}

	public static Stream<Arguments> failureInputProvider() {
		return Stream.of(Arguments.of(new int[] { 0, 2, 1, 5, 3, 4 }, new int[] { 3, 1, 2, 4, 5, 0 }),
				Arguments.of(new int[] { 5, 0, 1, 2, 3, 4 }, new int[] { 3, 5, 0, 1, 2, 4 }));
	}
}