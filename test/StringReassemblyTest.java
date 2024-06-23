import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.set.Set;
import components.set.Set1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

public class StringReassemblyTest {

    //test for overlap with explosion
    @Test
    public void testOverlapExplosion() {
        String str1 = "explos";
        String str2 = "osion";
        int overlap = StringReassembly.overlap(str1, str2);
        assertEquals(2, overlap);
    }

    //test for overlap with Acknowledgment
    @Test
    public void testOverlapAcknowledgment() {
        String str1 = "Acknowle";
        String str2 = "owledgment";
        int overlap = StringReassembly.overlap(str1, str2);
        assertEquals(4, overlap);
    }

    //test for overlap with apple
    @Test
    public void testOverlapApple() {
        String str1 = "Apple";
        String str2 = "Banana";
        int overlap = StringReassembly.overlap(str1, str2);
        assertEquals(0, overlap);
    }

    //test for combination explosion
    @Test
    public void testCombinationExplosion() {
        String str1 = "explos";
        String str2 = "osion";
        int overlap = 2;
        String combine = StringReassembly.combination(str1, str2, overlap);
        assertEquals("explosion", combine);
    }

    //test for combination Acknowledgment
    @Test
    public void testCombinationAcknowledgment() {
        String str1 = "Acknowle";
        String str2 = "owledgment";
        int overlap = 4;
        String combine = StringReassembly.combination(str1, str2, overlap);
        assertEquals("Acknowledgment", combine);
    }

    //test 1 for AddtoSetAvoidingSubstring
    @Test
    public void testAddToSetAvoidingSubstrings1() {
        Set<String> strSet = new Set1L<>();
        strSet.add("extra");
        strSet.add("super");
        strSet.add("word");
        String str = "buzzword";
        Set<String> expect = new Set1L<>();
        expect.add("extra");
        expect.add("super");
        expect.add("buzzword");
        StringReassembly.addToSetAvoidingSubstrings(strSet, str);
        assertEquals(expect, strSet);
    }

    //test 2 for AddtoSetAvoidingSubstring
    @Test
    public void testAddToSetAvoidingSubstrings2() {
        Set<String> strSet = new Set1L<>();
        strSet.add("cool");
        strSet.add("awesome");
        strSet.add("bananas");
        String str = "banana";
        Set<String> expect = new Set1L<>();
        expect.add("cool");
        expect.add("awesome");
        expect.add("bananas");
        StringReassembly.addToSetAvoidingSubstrings(strSet, str);
        assertEquals(expect, strSet);
    }

    //test 1 for printWithLineSeparators
    @Test
    public void testPrintWithLineSeparators1() {
        SimpleWriter out = new SimpleWriter1L("test.txt");
        SimpleReader in = new SimpleReader1L("test.txt");
        String text = "This is~a 1 2 3~test";
        String expect = "This is" + "\n" + "a 1 2 3" + "\n" + "test";
        StringReassembly.printWithLineSeparators(text, out);
        String test = in.nextLine();
        String test2 = in.nextLine();
        String test3 = in.nextLine();
        in.close();
        out.close();
        assertEquals(expect, test + "\n" + test2 + "\n" + test3);
    }

    //test 2 for printWithLineSeparators
    @Test
    public void testPrintWithLineSeparators2() {
        SimpleWriter out = new SimpleWriter1L("test.txt");
        SimpleReader in = new SimpleReader1L("test.txt");
        String text = "I ate 1 2 3 4~watermelons";
        String expect = "I ate 1 2 3 4" + "\n" + "watermelons";
        StringReassembly.printWithLineSeparators(text, out);
        String test = in.nextLine();
        String test2 = in.nextLine();
        in.close();
        out.close();
        assertEquals(expect, test + "\n" + test2);
    }

    //test 3 for printWithLineSeparators
    @Test
    public void testPrintWithLineSeparators3() {
        SimpleWriter out = new SimpleWriter1L("test.txt");
        SimpleReader in = new SimpleReader1L("test.txt");
        String text = "I'm taking~Software 1~Spring 2023";
        String expect = "I'm taking" + "\n" + "Software 1" + "\n"
                + "Spring 2023";
        StringReassembly.printWithLineSeparators(text, out);
        String test = in.nextLine();
        String test2 = in.nextLine();
        String test3 = in.nextLine();
        in.close();
        out.close();
        assertEquals(expect, test + "\n" + test2 + "\n" + test3);
    }

    //test 1 for Assemble
    @Test
    public void testAssemble1() {
        Set<String> strSet = new Set1L<>();
        strSet.add("Hello my");
        strSet.add("o my na");
        strSet.add("name is Wi");
        strSet.add("Will");
        Set<String> expect = new Set1L<>();
        expect.add("Hello my name is Will");
        StringReassembly.assemble(strSet);
        assertEquals(expect, strSet);
    }

    //test 2 for Assemble
    @Test
    public void testAssemble2() {
        Set<String> strSet = new Set1L<>();
        strSet.add("Apples a");
        strSet.add("es are pr");
        strSet.add("banana");
        strSet.add("pretty g");
        strSet.add("AVOCADO");
        strSet.add("y good");
        Set<String> expect = new Set1L<>();
        expect.add("Apples are pretty good");
        expect.add("banana");
        expect.add("AVOCADO");
        StringReassembly.assemble(strSet);
        assertEquals(expect, strSet);
    }

}