package org.practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.practice.strings.StringUtils;

import java.util.Map;

public class MainTests {
    @Test
    public void repeatingCharactersTest() {
        Map<String, Integer> hello = StringUtils.repeatingCharacters("Hello");

        Assertions.assertEquals(4, hello.size());
        Assertions.assertEquals(2, hello.get("l"));
        Assertions.assertEquals(1, hello.get("H"));
    }

    @Test
    public void firstNotRepeatingCharactersTest() {
        String first = StringUtils.firstNotRepeatingCharacters("Hello");

        Assertions.assertEquals("H", first);
    }

    @Test
    public void checkOnlyNumberTest() {
       Assertions.assertTrue(StringUtils.checkOnlyNumber("123"));
       Assertions.assertFalse(StringUtils.checkOnlyNumber("123t"));
    }

    @Test
    public void numberVowelsAndConsonantsTest() {
        Map<String, Integer> hello = StringUtils.numberVowelsAndConsonants("Hello");

        Assertions.assertEquals(3, hello.get(StringUtils.CONSONANTS));
        Assertions.assertEquals(2, hello.get(StringUtils.VOWELS));
    }

    @Test
    public void revertTest() {
        Assertions.assertEquals("olleH", StringUtils.revert("Hello"));
    }
}
