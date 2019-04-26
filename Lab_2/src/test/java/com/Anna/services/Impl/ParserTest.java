package com.Anna.services.Impl;

import org.study.models.Paragraph;
import org.study.models.Sentence;
import org.study.services.Impl.Parser;
import org.study.services.TextParser;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class ParserTest {

    private TextParser parser;
    private List<Paragraph> paragraphList;

    @Before
    public void setUp() {
        parser = new Parser();
        paragraphList = new LinkedList<>();
        paragraphList.add(new Paragraph("\tOur Country\n"));
        paragraphList.add(new Paragraph("   Our country is very beautiful! Wow wow wow? "));
    }

    @Test
    public void shouldCreateSentenceListFromParagrapherWithHeadline() {
        List<Sentence> sentenceListResult = parser.divisionSentences(paragraphList.get(0));
        List<Sentence> sentenceListExpected = new LinkedList<>();
        sentenceListExpected.add(new Sentence("Our Country"));
        assertThat(sentenceListResult, equalTo(sentenceListExpected));
    }

    @Test
    public void shouldCreateSentenceListFromParagrapher2() {
        List<Sentence> sentenceListResult = parser.divisionSentences(paragraphList.get(1));
        List<Sentence> sentenceListExpected = new LinkedList<>();
        sentenceListExpected.add(new Sentence("Our country is very beautiful!"));
        sentenceListExpected.add(new Sentence("Wow wow wow?"));
        assertThat(sentenceListResult, equalTo(sentenceListExpected));
    }

    @Test
    public void shouldCheckLetter() {
        String check = "w";
        assertTrue(parser.findWords(check));
    }

    @Test
    public void shouldCheckDigit() {
        String check = "4";
        assertTrue(parser.findWords(check));
    }

    @Test
    public void shouldCheckSpace() {
        String check = " ";
        assertFalse(parser.findWords(check));
    }

    @Test
    public void shouldCheckPunctuation() {
        String check = ",";
        assertFalse(parser.findWords(check));
    }

    @Test
    public void shouldCheckApostrophe() {
        String check = "'";
        assertTrue(parser.findWords(check));
    }

    @Test
    public void shouldCheckDotInEnd() {
        String end = ".";
        assertTrue(parser.checkSentenceEnd(end));
    }

    @Test
    public void shouldCheckExclamationInEnd() {
        String end = "!";
        assertTrue(parser.checkSentenceEnd(end));
    }

    @Test
    public void shouldCheckQuestionInEnd() {
        String end = "?";
        assertTrue(parser.checkSentenceEnd(end));
    }

    @Test
    public void shouldCheckLetterInEnd() {
        String end = "F";
        assertFalse(parser.checkSentenceEnd(end));
    }
}
