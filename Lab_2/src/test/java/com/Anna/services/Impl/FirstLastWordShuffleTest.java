package com.Anna.services.Impl;

import org.study.models.Sentence;
import org.study.services.Impl.FirstLastWordShuffle;
import org.study.services.Shuffle;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class FirstLastWordShuffleTest {

    private Shuffle shuffle;
    private List<Sentence> sentenceList = new LinkedList<>();

    @Before
    public void setUp() {
        shuffle = new FirstLastWordShuffle();
        sentenceList.add(new Sentence("Study interesting story"));
        sentenceList.add(new Sentence("Wow, study lives in Ukraine."));
        sentenceList.add(new Sentence("It's short!"));
    }

    @Test
    public void shouldCheckSwapMethodForListSentence() {
        List<Sentence> sentenceListResult = shuffle.createShuffleSentenceList(sentenceList);
        List<Sentence> sentenceListExpected = new LinkedList<>();
        sentenceListExpected.add(new Sentence("story interesting Study"));
        sentenceListExpected.add(new Sentence("Ukraine, study lives in Wow."));
        sentenceListExpected.add(new Sentence("short It's!"));
        assertThat(sentenceListResult, equalTo(sentenceListExpected));
    }

    @Test
    public void shouldCheckNullSentence() {
        List<Sentence> sentenceListResult= new LinkedList<>();
        sentenceListResult.add(new Sentence(" "));
        List<Sentence> sentenceListExpected = new LinkedList<>();
        sentenceListExpected.add(new Sentence(" "));
        assertThat(sentenceListResult, equalTo(sentenceListExpected));
    }
}