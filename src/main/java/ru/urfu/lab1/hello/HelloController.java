package ru.urfu.lab1.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class HelloController {

    private ArrayList<String> arrayList;
    private HashMap<Integer, String>hashMap;

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }
    @GetMapping("/update-array")
    public Integer updateArrayList(@RequestParam(value = "name", defaultValue = "World") String name) {
        (arrayList == null ? arrayList = new ArrayList<>() : arrayList).add(name);
        return arrayList.size();
    }
    @GetMapping("/show-array")
    public String showArrayList() {
        var sb = new StringBuilder();
        if (arrayList != null) {
            for (var item: arrayList) {
                sb.append(item);
                sb.append(System.lineSeparator());
            }
        }
        return sb.toString();
    }
    @GetMapping("/update-map")
    public Integer updateHashMap(@RequestParam(value = "name", defaultValue = "World") String name) {
        if (hashMap == null) {
            hashMap = new HashMap<>();
        }
        hashMap.put(hashMap.size(), name);
        return hashMap.size();
    }
    @GetMapping("/show-map")
    public String showHashMap() {
        var sb = new StringBuilder();
        if (hashMap != null) {
            for (var key: hashMap.keySet()) {
                sb.append(key);
                sb.append(": ");
                sb.append(hashMap.get(key));
                sb.append(System.lineSeparator());
            }
        }
        return sb.toString();
    }
    @GetMapping("show-all-length")
    public String showAllLength() {
        return "ArrayList: " +
                (arrayList == null ? 0 : arrayList.size()) +
                System.lineSeparator() +
                "HashMap: " +
                (hashMap == null ? 0 : hashMap.size());
    }
}
