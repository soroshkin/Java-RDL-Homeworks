package io.humb1t.cache;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class URLCache {
    private final Map<String, URL> cache;
    private Path filePath = Paths.get("web\\pages");
    private URL url404 = new URL("404", "No data");

    public URLCache(final int maxSize) {
        this.cache = new LinkedHashMap<String, URL>(maxSize) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > maxSize;
            }
        };
    }

    /**
     * Читает данные из кэша, если они есть, иначе читает из файловой системы и добавляет в кэш.
     *
     * @param urlToSearch url, который требуется найти
     * @return возвращает найденный url или null, если ни в кэше, ни в файловой системе его нет
     */
    public Optional<URL> getFromCache(String urlToSearch) {
        return Optional.ofNullable(cache.computeIfAbsent(urlToSearch, value -> {
            StringBuilder urlData = new StringBuilder();
            try (FileReader fileReader = new FileReader(filePath + File.separator + urlToSearch);
                 Scanner scanner = new Scanner(fileReader)) {
                while (scanner.hasNext()) {
                    urlData.append(scanner.nextLine());
                }
                return new URL(urlToSearch, urlData.toString());
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
            return null;
        }));
    }

    /**
     * Заполняет кэш тестовыми данными
     */
    public void fillCacheWithTestData() {
        for (int i = 0; i < 5; i++) {
            URL url = new URL("webpage-" + i, "data-" + i);
            cache.put(url.getName(), url);
        }
    }

    public void testCache(String urlToSearch) {
        System.out.println("search in cache or filesystem... result: " + getFromCache(urlToSearch).orElse(url404));
        printCacheSize();
    }

    public void printCacheSize() {
        System.out.println("cache size is " + cache.size());
    }
}
