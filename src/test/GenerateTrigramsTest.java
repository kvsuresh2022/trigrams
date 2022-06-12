package test;

import static org.junit.Assert.*;

import java.util.Map;

import com.trigram.GenerateTrigrams;
import com.trigram.TrigramValidator;
import org.junit.Before;
import org.junit.Test;

public class GenerateTrigramsTest {

    GenerateTrigrams generator;

    TrigramValidator trigramValidator;

    @Before
    public void setup() {
        generator = new GenerateTrigrams();
    }

    @Test
    public void should_generate_trigrams_from_input() {

        Map<String, TrigramValidator> trigrams = generator.generateTrigrams("I wish I may I wish I might I try to crack program");

        assertEquals(9, trigrams.keySet().size());

        assertTrue(trigrams.containsKey("i wish"));
        assertTrue(trigrams.containsKey("wish i"));
        assertTrue(trigrams.containsKey("i may"));
        assertTrue(trigrams.containsKey("may i"));

        assertEquals("I", trigrams.get("i may").getNext());
        assertEquals(2, trigrams.get("wish i").values().size());
        assertEquals("may", trigrams.get("wish i").values().get(0));
        assertEquals("might", trigrams.get("wish i").values().get(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_if_less_than_three_words_are_used() {
        trigramValidator =   new TrigramValidator(new String[] { "I", "test" });
    }
}
