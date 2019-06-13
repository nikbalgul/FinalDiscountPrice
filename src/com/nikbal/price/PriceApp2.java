package com.nikbal.price;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PriceApp2 {

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

		int priceSize = prices.size();

		int sumPrices = 0;

		Deque<Integer> deque = new ArrayDeque<>();

		List<Integer> indexList = new ArrayList<>();

		for (int i = priceSize - 1; i >= 0; --i) {
			while (!deque.isEmpty() && deque.peek() > prices.get(i)) {
				deque.pop();
			}

			if (!deque.isEmpty()) {
				sumPrices += prices.get(i) - deque.peek();
			} else {
				indexList.add(i);
				sumPrices += prices.get(i);
			}
			deque.push(prices.get(i));
		}

		indexList.sort(Comparator.naturalOrder());

		strBuilder.append(String.valueOf(sumPrices).concat(lineSeparator));

		strBuilder.append(indexList.stream().map(index -> String.valueOf(index)).collect(Collectors.joining(" ")));

		System.out.print(strBuilder.toString());
	}

}
