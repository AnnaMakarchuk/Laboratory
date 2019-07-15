package org.study.services;

import org.study.models.Sentence;

import java.util.List;

public interface Shuffle {

    List<Sentence> createShuffleSentenceList(List<Sentence> sentenceList);
}
