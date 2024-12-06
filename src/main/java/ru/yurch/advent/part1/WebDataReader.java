package ru.yurch.advent.part1;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class WebDataReader {
    private final String url;
    private final String accessToken;

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
}
