package org.study.utils;

import org.study.models.Paragraph;
import org.study.models.Sentence;

import java.util.List;

public class ConverterModels {

    public static String convertSentenceListInParagraph(List<Sentence> sentenceList) {
        StringBuilder paragraphBuilder = new StringBuilder();
        for (Sentence sentence : sentenceList) {
            paragraphBuilder.append(sentence.getSentence()).append(" ");
        }
        return paragraphBuilder.toString();
    }

    public static String convertParagraphListInDocument(List<Paragraph> paragraphList) {
        StringBuilder documentBuilder = new StringBuilder();
        for (Paragraph paragraph : paragraphList) {
            documentBuilder.append("\t").append(paragraph.getParagraph()).append("\n");
        }
        return documentBuilder.toString();
    }

}
