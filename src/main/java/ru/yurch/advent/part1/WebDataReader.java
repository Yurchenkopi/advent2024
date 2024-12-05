package ru.yurch.advent.part1;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class WebDataReader {
    private String url;
    private String accessToken;

    public WebDataReader(String url, String accessToken) {
        this.url = url;
        this.accessToken = accessToken;
    }

    public List<Integer> readData() {
        try {
            Document doc = Jsoup.connect(url)
                    .header("Cookie", "session=" + accessToken)
                    .get();
            Element preElement = doc.select("body").first();
            if (preElement != null) {
                String text = preElement.text();
                return Arrays.stream(text.split(" "))
                        .map(Integer::parseInt)
                        .toList();
            } else {
                System.out.println("Element not found.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Error parsing numbers: " + e.getMessage());
        }
        return List.of();
    }

    public static void main(String[] args) {
        String url = "https://adventofcode.com/2024/day/1/input";
        WebDataReader reader = new WebDataReader(url, "53616c7465645f5fe41a1eebd4d5db4bdfbcf280d56ec5bcbc711797f380869485fb710b17dd3304b736e1fee9a19681487f0d24bfcdeccb3dce0dae0de6d98a");
        List<Integer> numbers = reader.readData();

        System.out.println("Extracted numbers: " + numbers);
    }
}
