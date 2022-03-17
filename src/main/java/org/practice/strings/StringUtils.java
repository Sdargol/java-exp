package org.practice.strings;

import java.util.*;

public class StringUtils {
    private static final List<String> VOWELS_ARRAY = Arrays.asList("a", "e", "i", "o", "u");
    public static final String VOWELS = "VOWELS";
    public static final String CONSONANTS = "CONSONANTS";

    public static Map<String, Integer> repeatingCharacters(String str) {
        return Arrays.stream(str.split(""))
                .collect(
                        HashMap::new,
                        (map, val) -> map.merge(val, 1, Integer::sum),
                        HashMap::putAll
                );
    }

    public static String firstNotRepeatingCharacters(String str) {
        return Arrays.stream(str.split(""))
                .collect(
                        LinkedHashMap<String, Integer>::new,
                        (map, val) -> map.merge(val, 1, Integer::sum),
                        LinkedHashMap::putAll
                ).entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse("");
    }

    public static Boolean checkOnlyNumber(String str) {
        return Arrays.stream(str.split("")).allMatch(el -> {
            try {
                var val = Integer.parseInt(el);
                return true;
            } catch (Exception ex) {
                return false;
            }
        });
    }

    public static Map<String, Integer> numberVowelsAndConsonants(String str) {
        return Arrays.stream(str.split(""))
                .collect(
                        HashMap::new,
                        (map, val) -> map.merge(VOWELS_ARRAY.contains(val) ? VOWELS : CONSONANTS, 1, Integer::sum),
                        HashMap::putAll
                );
    }

    public static String revert(String str) {
        return Arrays.stream(str.split(""))
                .reduce("", (el, acc) -> acc + el);
    }
}
