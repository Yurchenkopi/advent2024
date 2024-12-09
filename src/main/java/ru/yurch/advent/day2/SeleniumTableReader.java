package ru.yurch.advent.day2;
import lombok.AllArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
public class SeleniumTableReader {
    private final String url;
    private final String accessToken;

    public List<List<Integer>> readTable() {
        List<List<Integer>> rsl = new ArrayList<>();
        System.setProperty("webdriver.chrome.driver", "C:/Tools/chromedriver-win64/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);
        try {
            driver.get(url);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            String script = "document.cookie = 'session=" + accessToken + "; path=/';";
            ((JavascriptExecutor) driver).executeScript(script);

            driver.navigate().to(url);
            String preText = driver.findElement(By.tagName("pre")).getText();

            String[] rows = preText.split("\\n");
            for (String row : rows) {
                String[] numbers = row.trim().split(" ");
                List<Integer> data = new ArrayList<>();
                for (String str : numbers) {
                    data.add(Integer.parseInt(str));
                }
                rsl.add(data);
            }
        } finally {
            driver.quit();
        }
        return rsl;
    }

}