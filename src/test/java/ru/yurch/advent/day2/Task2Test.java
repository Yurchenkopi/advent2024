package ru.yurch.advent.day2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class Task2Test {
    @Test
    void whenIsAscThenTrue() {
        var task2 = new Task2();
        assertThat(task2.isAsc(List.of(5, 7, 9, 10, 12, 14))).isTrue();
        assertThat(task2.isAsc(List.of(1, 3, 6, 7, 9))).isTrue();
    }

    @Test
    void whenIsAscThenFalse() {
        var task2 = new Task2();
        assertThat(task2.isAsc(List.of(5, 7, 9, 10, 12, 16))).isFalse();
        assertThat(task2.isAsc(List.of(5, 7, 7, 10, 12, 16))).isFalse();
        assertThat(task2.isAsc(List.of(5, 7, 3, 10, 12, 16))).isFalse();
    }

    @Test
    void whenIsAscWithOneMistakeThenTrue() {
        var task2 = new Task2();
        var data1 = new ArrayList<>(List.of(5, 7, 7, 9, 11, 12));
        var data2 = new ArrayList<>(List.of(1, 3, 8, 5, 8));
        assertThat(task2.isAsc(task2.convertToAscSeqWithOneMistake(data1))).isTrue();
        assertThat(task2.isAsc(task2.convertToAscSeqWithOneMistake(data2))).isTrue();
    }

    @Test
    void whenIsAscWithOneMistakeThenFalse() {
        var task2 = new Task2();
        var data1 = new ArrayList<>(List.of(5, 7, 9, 9, 9, 13));
        var data2 = new ArrayList<>(List.of(5, 6, 6, 10, 11, 14));
        assertThat(task2.isAsc(task2.convertToAscSeqWithOneMistake(data1))).isFalse();
        assertThat(task2.isAsc(task2.convertToAscSeqWithOneMistake(data2))).isFalse();
    }

    @Test
    void whenIsDescThenTrue() {
        var task2 = new Task2();
        assertThat(task2.isDesc(List.of(12, 10, 9, 8, 6, 4))).isTrue();
        assertThat(task2.isDesc(List.of(7, 6, 4, 2, 1))).isTrue();

    }

    @Test
    void whenIsDescThenFalse() {
        var task2 = new Task2();
        assertThat(task2.isDesc(List.of(12, 10, 9, 8, 1, 6))).isFalse();
        assertThat(task2.isDesc(List.of(12, 10, 9, 9, 9, 6))).isFalse();
        assertThat(task2.isDesc(List.of(12, 10, 9, 15, 8, 6))).isFalse();
    }

    @Test
    void whenIsDescWithOneMistakeThenTrue() {
        var task2 = new Task2();
        var data1 = new ArrayList<>(List.of(12, 10, 9, 9, 6, 4));
        var data2 = new ArrayList<>(List.of(7, 6, 10, 4, 3));
        assertThat(task2.isDesc(task2.convertToDescSeqWithOneMistake(data1))).isTrue();
        assertThat(task2.isDesc(task2.convertToDescSeqWithOneMistake(data2))).isTrue();
    }

    @Test
    void whenIsDescWithOneMistakeThenFalse() {
        var task2 = new Task2();
        var data1 = new ArrayList<>(List.of(12, 10, 10, 6, 4, 2));
        var data2 = new ArrayList<>(List.of(12, 10, 9, 12, 11, 9));
        var data3 = new ArrayList<>(List.of(12, 10, 9, 15, 15, 6));
        assertThat(task2.isDesc(task2.convertToDescSeqWithOneMistake(data1))).isFalse();
        assertThat(task2.isDesc(task2.convertToDescSeqWithOneMistake(data2))).isFalse();
        assertThat(task2.isDesc(task2.convertToDescSeqWithOneMistake(data3))).isFalse();
    }


    @Test
    void whenSafeSequencesThenTwo() {
        List<List<Integer>> data = List.of(
                List.of(7, 6, 4, 2, 1),
                List.of(1, 2, 7, 8, 9),
                List.of(9, 7, 6, 2, 1),
                List.of(1, 3, 2, 4, 5),
                List.of(8, 6, 4, 4, 1),
                List.of(1, 3, 6, 7, 9)
                );
        var expected = 2;
        var task2 = new Task2();
        assertThat(task2.safeSequences(data)).isEqualTo(expected);
    }

    @Test
    void whenSafeSequencesWithOneMistakeThenFour() {
        List<List<Integer>> data = List.of(
               new ArrayList<>(List.of(7, 6, 4, 2, 1)),
               new ArrayList<>(List.of(1, 2, 7, 8, 9)),
               new ArrayList<>(List.of(9, 7, 6, 2, 1)),
               new ArrayList<>(List.of(1, 3, 2, 4, 5)),
               new ArrayList<>(List.of(8, 6, 4, 4, 1)),
               new ArrayList<>(List.of(1, 3, 6, 7, 9)),
               new ArrayList<>(List.of(1, 1, 4, 7, 9)),
               new ArrayList<>(List.of(10, 1, 4, 7, 9)),
               new ArrayList<>(List.of(10, 3, 9, 6, 5))
        );
        var expected = 7;
        var task2 = new Task2();
        assertThat(task2.safeSequencesWithOneMistake(data)).isEqualTo(expected);
    }
}