package ru.yurch.advent.part1;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

import static java.lang.System.lineSeparator;

@Data
public class Task1 {
    private List<Integer> one = new ArrayList<>();
    private List<Integer> two = new ArrayList<>();

    private Map<Integer,Integer> map = new HashMap<>();

    public Integer sumOfDifference(List<Integer> data) {
        int sum = 0;
        for (int i = 1; i <= data.size() ; i++) {
            sum = i % 2 != 0 ? sum - data.get(i - 1) : sum + data.get(i - 1);
        }
        return sum;
    }

    public Integer sumOfDifference() {
        int sum = 0;
        for (int i = 1; i <= one.size() ; i++) {
            sum += Math.abs(two.get(i - 1) - one.get(i - 1));
        }
        return sum;
    }

    public void divideByTwo(List<Integer> data) {
        for (int i = 1; i <= data.size() ; i++) {
            if (i % 2 != 0) {
                one.add(data.get(i - 1));
            } else {
                two.add(data.get(i - 1));
            }
        }
    }

    public void sort() {
        one.sort(Comparator.naturalOrder());
        two.sort(Comparator.naturalOrder());
    }

    public void repeatabilityCalc() {
        for(Integer i : two) {
            if (!map.containsKey(i)) {
                map.put(i, null);
            }
            map.computeIfPresent(i, (k, v) -> v = v + 1);
            map.putIfAbsent(i, 1);
        }
    }

    public Integer sumOfMultipliesWithRepeatability() {
        int sum = 0;
        for (Integer i : one) {
            if (map.containsKey(i)) {
                sum += i * map.get(i);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String url = "https://adventofcode.com/2024/day/1/input";
        WebDataReader reader = new WebDataReader(url, "53616c7465645f5fe41a1eebd4d5db4bdfbcf280d56ec5bcbc711797f380869485fb710b17dd3304b736e1fee9a19681487f0d24bfcdeccb3dce0dae0de6d98a");
        List<Integer> numbers = reader.readData();
        var task = new Task1();
        task.divideByTwo(numbers);
        task.sort();
        task.getOne().forEach(i -> System.out.print(i + " "));
        System.out.println(lineSeparator() + "-".repeat(20));
        task.getTwo().forEach(i -> System.out.print(i + " "));
        System.out.println(lineSeparator() + "-".repeat(20));
        System.out.println("Sum of distances: " + task.sumOfDifference());
        task.repeatabilityCalc();
        int sum = 0;
        for (Integer key : task.getMap().keySet()) {
            sum += task.getMap().get(key);
        }
        System.out.println("Printing repeatability by second list:");
        task.getMap().keySet().stream()
                        .filter( key -> task.getMap().get(key) > 1)
                                .forEach(key -> System.out.printf("%s; %s%s", key, task.getMap().get(key), System.lineSeparator()));
        System.out.println("Checking... size is: " + sum);
        System.out.println("Sum of multiplies with repeatability: " + task.sumOfMultipliesWithRepeatability());
        System.out.println("Extracted numbers: " + numbers);
    }
}
