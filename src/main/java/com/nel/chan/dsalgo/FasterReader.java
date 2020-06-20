package com.nel.chan.dsalgo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FasterReader {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCases = Integer.parseInt(br.readLine());
		for (int t = 0; t < testCases; t++) {
			int n;
			int k;
			String[] inp = br.readLine().split(" ");
			n = Integer.parseInt(inp[0]);
			k = Integer.parseInt(inp[1]);
			inp = br.readLine().split(" ");
			int[] ar = new int[n];
			for (int j = 0; j < n; j++)
				ar[j] = Integer.parseInt(inp[j]);

			// logic goes here
			System.out.println(k);
			int ans = 0;
			bw.write(ans + "\n");
		}
		bw.flush();
	}
}
