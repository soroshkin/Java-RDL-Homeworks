package io.humb1t.cache;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class URLCache {
    private  Map<String, URL> cache = new ConcurrentHashMap<>();
    private  Path filePath = Paths.get("web\\pages");

    public Map<String, URL> getCache() {
        return cache;
    }

    /**
     * Читает данные из кэша, если они есть, иначе читает из файловой системы и добавляет в кэш.
     *
     * @param urlToSearch url, который требуется найти
     * @return возвращает найденный url или null, если ни в кэше, ни в файловой системе его нет
     */
    public URL getFromCache(String urlToSearch) {
        return cache.computeIfAbsent(urlToSearch, value -> {
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
        });
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

    public String getCacheSize() {
        return "cache size is " + getCache().size();
    }

    public void testCache(String urlToSearch) {
        System.out.println("search in cache or filesystem... result: " + getFromCache(urlToSearch));
        System.out.println(getCacheSize());
    }
}
