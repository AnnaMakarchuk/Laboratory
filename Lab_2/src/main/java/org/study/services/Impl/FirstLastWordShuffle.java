package org.study.services.Impl;

import org.study.models.Sentence;
import org.study.services.Shuffle;
import org.study.services.TextParser;

import java.util.List;

public class FirstLastWordShuffle implements Shuffle {

    private TextParser parser;

    public FirstLastWordShuffle() {
        this.parser = new Parser();
    }

    public List<Sentence> createShuffleSentenceList(List<Sentence> sentenceList) {
        for (Sentence sentence : sentenceList) {
            String sentenceConvert = sentence.getSentence();
            char sentenceEnd = sentenceConvert.charAt(sentenceConvert.length() - 1);
            if (parser.checkSentenceEnd(String.valueOf(sentenceEnd))) {
                sentence.setSentence(swapWordsWithPunctuation(sentence));
            } else sentence.setSentence(swapWordsHeadline(sentence));
        }
        return sentenceList;
    }

    private String swapWordsWithPunctuation(Sentence sentence) {
        String oneSentence = sentence.getSentence();
        StringBuilder firstWord = findFirstWord(oneSentence);
        StringBuilder lastWord = findLastWordWithPunctuation(oneSentence);
        String middle = findSentenceMiddleWithPunctuation(oneSentence, firstWord, lastWord);
        return createNewSentence(firstWord, lastWord, middle)
                .append(String.valueOf(oneSentence.charAt(oneSentence.length() - 1)))
                .toString();
    }


    private String swapWordsHeadline(Sentence sentence) {
        String oneSentence = sentence.getSentence();
        StringBuilder firstWord = findFirstWord(oneSentence);
        StringBuilder lastWord = findLastWordHeadline(oneSentence);
        String middle = findSentenceMiddleHeadline(oneSentence, firstWord, lastWord);
        return createNewSentence(firstWord, lastWord, middle)
                .toString();
    }

    private StringBuilder findFirstWord(String sentence) {
        int i = 0;
        StringBuilder firstWord = new StringBuilder();
        while (parser.findWords(String.valueOf(sentence.charAt(i)))) {
            firstWord.append(String.valueOf(sentence.charAt(i)));
            i++;
        }
        return firstWord;
    }

    private StringBuilder findLastWordWithPunctuation(String sentence) {
        int k = sentence.length() - 2;
        StringBuilder lastWord = new StringBuilder();
        while (parser.findWords(String.valueOf(sentence.charAt(k)))) {
            lastWord.append(String.valueOf(sentence.charAt(k)));
            k--;
        }
        return lastWord;
    }

    private StringBuilder findLastWordHeadline(String oneSentence) {
        int k = oneSentence.length() - 1;
        StringBuilder lastWord = new StringBuilder();
        while (parser.findWords(String.valueOf(oneSentence.charAt(k)))) {
            lastWord.append(String.valueOf(oneSentence.charAt(k)));
            k--;
        }
        return lastWord;
    }

    private String findSentenceMiddleWithPunctuation(String oneSentence, StringBuilder firstWord, StringBuilder lastWord) {
        int firstIndex = firstWord.length();
        int secondIndex = oneSentence.length() - lastWord.length() - 2;
        return oneSentence.substring(firstIndex, secondIndex);
    }

    private String findSentenceMiddleHeadline(String oneSentence, StringBuilder firstWord, StringBuilder lastWord) {
        int firstIndex = firstWord.length();
        int secondIndex = oneSentence.length() - lastWord.length() - 1;
        return oneSentence.substring(firstIndex, secondIndex);
    }

    private StringBuilder createNewSentence(StringBuilder firstWord, StringBuilder lastWord, String middle) {
        return new StringBuilder()
                .append(lastWord.reverse())
                .append(middle)
                .append(" ")
                .append(firstWord);
    }
}
