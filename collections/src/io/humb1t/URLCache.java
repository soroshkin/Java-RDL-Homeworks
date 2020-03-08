package io.humb1t;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class URLCache {
    private static Map<String, URL> cache = new ConcurrentHashMap<>();

    private URLCache() {
    }

    /**
     * Читает данные из кеша, если они есть, иначе читает из файловой системы и добавляет в кэш.
     * @param urlToSearch url, который требуется найти
     * @return возвращает найденный url
     */
    public static URL getFromCache(String urlToSearch) {
        return cache.computeIfAbsent(urlToSearch, value -> {
            StringBuilder urlData = new StringBuilder();
            try (FileReader fileReader = new FileReader("url\\pages\\" + urlToSearch);
                 Scanner scanner = new Scanner(fileReader)) {

                while (scanner.hasNext()) {
                    urlData.append(scanner.nextLine());
                }
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
            return new URL(urlToSearch, urlData.toString());
        });
    }

    /**
     * Заполняет кэш тестовыми данными
     */
    public static void fillCacheWithTestData() {
        for (int i = 0; i < 100; i++) {
            URL url = new URL("http://" + i, "data" + i);
            cache.put(url.getName(), url);
        }
    }
}
