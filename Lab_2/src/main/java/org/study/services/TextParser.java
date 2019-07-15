package org.study.services;

import org.study.models.Paragraph;
import org.study.models.Sentence;

import java.util.List;

public interface TextParser {

    List<Sentence> divisionSentences(Paragraph paragraph);

    boolean findWords(String checkString);

    boolean checkSentenceEnd(String checkSentenceEnd);
}
