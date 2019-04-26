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
        int i = 0;
        StringBuilder firstWord = new StringBuilder();
        while (parser.findWords(String.valueOf(oneSentence.charAt(i)))) {
            firstWord.append(String.valueOf(oneSentence.charAt(i)));
            i++;
        }
        int k = oneSentence.length() - 2;
        StringBuilder lastWord = new StringBuilder();
        while (parser.findWords(String.valueOf(oneSentence.charAt(k)))) {
            lastWord.append(String.valueOf(oneSentence.charAt(k)));
            k--;
        }
        return new StringBuilder()
                .append(lastWord.reverse())
                .append(oneSentence.substring(i, k))
                .append(" ")
                .append(firstWord)
                .append(String.valueOf(oneSentence.charAt(oneSentence.length() - 1)))
                .toString();
    }

    private String swapWordsHeadline(Sentence sentence) {
        String oneSentence = sentence.getSentence();
        int i = 0;
        StringBuilder firstWord = new StringBuilder();
        while (parser.findWords(String.valueOf(oneSentence.charAt(i)))) {
            firstWord.append(String.valueOf(oneSentence.charAt(i)));
            i++;
        }
        int k = oneSentence.length() - 1;
        StringBuilder lastWord = new StringBuilder();
        while (parser.findWords(String.valueOf(oneSentence.charAt(k)))) {
            lastWord.append(String.valueOf(oneSentence.charAt(k)));
            k--;
        }
        return new StringBuilder()
                .append(lastWord.reverse())
                .append(oneSentence.substring(i, k))
                .append(" ")
                .append(firstWord)
                .toString();
    }
}
