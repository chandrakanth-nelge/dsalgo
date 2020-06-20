package com.nel.chan.dsalgo.graph.factory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.nel.chan.dsalgo.graph.Graph;

public interface GraphFactory {

	@SuppressWarnings("unchecked")
	public static <V> Graph<V> getInstance(String graphTypeStr, int noOfVertexes) throws ClassNotFoundException,
			NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {

		GraphType graphType = GraphType.valueOf(graphTypeStr.toUpperCase());
		Class<?> clazz = Class.forName(graphType.value());
		Constructor<?> cons = clazz.getConstructor(String.class);
		cons.setAccessible(true);

		return (Graph<V>) cons.newInstance(noOfVertexes);
	}
}