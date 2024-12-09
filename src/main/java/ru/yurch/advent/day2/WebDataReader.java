package ru.yurch.advent.day2;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WebDataReader {
    private final String url;
    private final String accessToken;

    public WebDataReader(String url, String accessToken) {
        this.url = url;
        this.accessToken = accessToken;
    }

    public List<List<Integer>> readTable() {
        List<List<Integer>> rsl = new ArrayList<>();
        try {
            Document doc = Jsoup.connect(url)
                    .header("Cookie", "session=" + accessToken)
                    .get();
            for (Element element : doc.getAllElements()) {
                System.out.println("Тег: " + element.tagName());
                System.out.println("Классы: " + element.className());
                System.out.println("Атрибуты: ");
                for (Attribute key : element.attributes().asList()) {
                    System.out.println("  " + key + ": " + element.attr(key.toString()));
                }
                System.out.println("-----");
            }

            Element preElement = doc.select(".pre").first();
            if (preElement != null) {
                String text = preElement.text();
                String[] rows = text.split("\\n");
                for (String row : rows) {
                    String[] numbers = row.trim().split(" ");
                    List<Integer> data = new ArrayList<>();
                    for (String str : numbers) {
                        data.add(Integer.parseInt(str));
                    }
                    rsl.add(data);
                }
                return rsl;
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
