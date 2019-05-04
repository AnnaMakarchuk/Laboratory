package org.study.services.Impl;

import org.study.models.Paragraph;
import org.study.models.Sentence;
import org.study.services.TextParser;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser implements TextParser {

    private static String SENTENCE_SEPARATOR_REGEX = "(?<=\\u002E)|(?<=\\u003f)|(?<=\\u0021)|\\n";
    private static String WORD_REGEX = "[a-zA-Z0-9\\u0027]";
    private static String SENTENCE_END = "[\u002E\u003f\u0021]";

    public List<Sentence> divisionSentences(Paragraph paragraph) {
        List<Sentence> sentenceList = new LinkedList<>();
        if (paragraph.getParagraph().isEmpty()) {
            sentenceList.add(new Sentence("\n"));
            return sentenceList;
        }
        Pattern pattern = Pattern.compile(SENTENCE_SEPARATOR_REGEX);
        String[] regexString = pattern.split(paragraph.getParagraph());
        convertArrayInSentence(sentenceList, regexString);
        return sentenceList;
    }

    public boolean findWords(String checkString) {
        Pattern pattern = Pattern.compile(WORD_REGEX);
        Matcher matcher = pattern.matcher(checkString);
        return matcher.matches();
    }

    public boolean checkSentenceEnd(String checkSentenceEnd) {
        Pattern pattern = Pattern.compile(SENTENCE_END);
        Matcher matcher = pattern.matcher(checkSentenceEnd);
        return matcher.matches();
    }

    private void convertArrayInSentence(List<Sentence> sentenceList, String[] array) {
        for (String anArray : array) {
            sentenceList.add(new Sentence(anArray));
        }
    }
}
