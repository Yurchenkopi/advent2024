package ru.yurch.advent.day1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class Task1Test {

    @Test
    void whenSixSizeListThenFour() {
        List<Integer> data = List.of(5, 10, 4, 18, 30, 15);
        var expected = 4;
        var task1 = new Task1();
        assertThat(task1.sumOfDifference(data)).isEqualTo(expected);
    }

    @Test
    void whenTenSizeListThenFour() {
        List<Integer> data = List.of(5, 10, 4, 18, 30, 15, 351, 456, 45, 1);
        var expected = 65;
        var task1 = new Task1();
        assertThat(task1.sumOfDifference(data)).isEqualTo(expected);
    }

    @Test
    void whenDivideByTwo() {
        List<Integer> data = List.of(5, 10, 4, 18, 30, 15, 351, 456, 45, 1);
        List<Integer> expectedOne = List.of(5, 4, 30, 351, 45);
        List<Integer> expectedTwo = List.of(10, 18, 15, 456, 1);
        var task1 = new Task1();
        task1.divideByTwo(data);
        assertThat(task1.getOne()).isEqualTo(expectedOne);
        assertThat(task1.getTwo()).isEqualTo(expectedTwo);
    }

    @Test
    void whenSort() {
        List<Integer> one = new ArrayList<>(List.of(5, 4, 30, 351, 45));
        List<Integer> two = new ArrayList<>(List.of(10, 18, 15, 456, 1));
        List<Integer> expectedOne = List.of(4, 5, 30, 45, 351);
        List<Integer> expectedTwo = List.of(1, 10, 15, 18, 456);
        var task1 = new Task1();
        task1.setOne(one);
        task1.setTwo(two);
        task1.sort();
        assertThat(task1.getOne()).isEqualTo(expectedOne);
        assertThat(task1.getTwo()).isEqualTo(expectedTwo);
    }
}