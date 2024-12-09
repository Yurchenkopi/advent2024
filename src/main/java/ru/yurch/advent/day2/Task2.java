package ru.yurch.advent.day2;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.lineSeparator;

@Data
public class Task2 {
    private int countOfMistakes = 0;

    public boolean isAsc(List<Integer> data) {
        boolean rsl = true;
        for (int i = 0; i < data.size() - 1; i++) {
            if ((data.get(i + 1) - data.get(i) <= 0) || (data.get(i + 1) - data.get(i) > 3)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }

    public List<Integer> convertToAscSeqWithOneMistake(List<Integer> data) {
        var temp = new ArrayList<>(data);
        for (int i = 0; i < temp.size() - 1; i++) {
            if ((temp.get(i + 1) - temp.get(i) <= 0) || (temp.get(i + 1) - temp.get(i) > 3)) {
                temp.remove(i + 1);
                break;
            }
        }
        if (isAsc(temp)) {
            return temp;
        }
        temp = new ArrayList<>(data);
        for (int i = 0; i < temp.size() - 1; i++) {
            if ((temp.get(i + 1) - temp.get(i) <= 0) || (temp.get(i + 1) - temp.get(i) > 3)) {
                temp.remove(i);
                break;
            }
        }
        return temp;
    }

    public boolean isDesc(List<Integer> data) {
        boolean rsl = true;
        for (int i = 0; i < data.size() - 1; i++) {
            if ((data.get(i + 1) - data.get(i) >= 0) || (data.get(i) - data.get(i + 1) > 3)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
    public List<Integer> convertToDescSeqWithOneMistake(List<Integer> data) {
        var temp = new ArrayList<>(data);
        for (int i = 0; i < temp.size() - 1; i++) {
            if ((temp.get(i + 1) - temp.get(i) >= 0) || (temp.get(i) - temp.get(i + 1) > 3)) {
                temp.remove(i + 1);
                break;
            }
        }
        if (isDesc(temp)) {
            return temp;
        }
        temp = new ArrayList<>(data);
        for (int i = 0; i < temp.size() - 1; i++) {
            if ((temp.get(i + 1) - temp.get(i) >= 0) || (temp.get(i) - temp.get(i + 1) > 3)) {
                temp.remove(i);
                break;
            }
        }
        return temp;
    }

    public Integer safeSequences(List<List<Integer>> data) {
        int sum = 0;
        for (List<Integer> list : data) {
            if (isAsc(list) || isDesc(list)) {
                sum++;
            }
        }
        return sum;
    }

    public Integer safeSequencesWithOneMistake(List<List<Integer>> data) {
        int sum = 0;
        for (List<Integer> list : data) {
           var tempAsc = new ArrayList<>(list);
           var convertTempAsc = convertToAscSeqWithOneMistake(tempAsc);
           var tempDesc = new ArrayList<>(list);
           var convertTempDesc = convertToDescSeqWithOneMistake(tempDesc);
           if (isAsc(convertTempAsc)) {
               sum++;
           }
           if (isDesc(convertTempDesc)) {
               sum++;
           }
        }
        return sum;
    }

    public static void main(String[] args) {
        String url = "https://adventofcode.com/2024/day/2/input";
        SeleniumTableReader reader = new SeleniumTableReader(url, "53616c7465645f5fe41a1eebd4d5db4bdfbcf280d56ec5bcbc711797f380869485fb710b17dd3304b736e1fee9a19681487f0d24bfcdeccb3dce0dae0de6d98a");
        Task2 task2 = new Task2();
        List<List<Integer>> numbers = reader.readTable();
        System.out.println("Extracted lists: ");
        numbers.forEach(System.out::println);
        System.out.println(lineSeparator() + "-".repeat(20));
        System.out.println("Number of safe sequences: " + task2.safeSequences(numbers));
        System.out.println(lineSeparator() + "-".repeat(20));
        System.out.println("Number of safe sequences with one mistake: " + task2.safeSequencesWithOneMistake(numbers));
    }
}
