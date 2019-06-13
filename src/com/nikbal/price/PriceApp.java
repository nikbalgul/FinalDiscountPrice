package com.nikbal.price;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PriceApp {

	public static void main(String[] args) {

		List<Integer> prices = new ArrayList<>();

		prices.add(Integer.valueOf(1));
		prices.add(Integer.valueOf(3));
		prices.add(Integer.valueOf(3));
		prices.add(Integer.valueOf(2));
		prices.add(Integer.valueOf(5));

		finalPrice(prices);
	}

	private static void finalPrice(List<Integer> prices) {
		String lineSeparator = System.getProperty("line.separator");

		StringBuilder strBuilder = new StringBuilder();

		int sumPrices = 0;

		List<Integer> indexList = new ArrayList<>();

		for (int i = 0; i < prices.size(); i++) {

			boolean isLowerRight = false;

			for (int j = i + 1; j < prices.size(); j++) {

				if (prices.get(i) >= prices.get(j)) {

					isLowerRight = true;

					sumPrices += prices.get(i) - prices.get(j);

					break;
				}
			}

			if (!isLowerRight) {
				sumPrices += prices.get(i);
				indexList.add(i);
			}
		}

		indexList.sort(Comparator.naturalOrder());

		strBuilder.append(String.valueOf(sumPrices).concat(lineSeparator));

		strBuilder.append(indexList.stream().map(index -> String.valueOf(index)).collect(Collectors.joining(" ")));

		System.out.println(strBuilder.toString());
	}

}
