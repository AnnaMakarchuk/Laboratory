package com.Anna.services.Impl;

import org.study.models.Document;
import org.study.models.Paragraph;
import org.study.services.Impl.*;
import org.study.services.ReadArticle;
import org.study.utils.ConverterModels;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DocumentServiceTest {

    @Mock
    private ReadArticle readArticle = new ReadArticleImpl();

    private DocumentService documentService;
    private List<Paragraph> paragraphList;
    private List<Paragraph> paragraphListNull;
    private List<Paragraph> paragraphListExpected;

    @Before
    public void setUp() {
        documentService = new DocumentService
                (new Parser(), new FirstLastWordShuffle(), readArticle, new WriteArticleImpl());
        paragraphList = new LinkedList<>();
        paragraphList.add(new Paragraph("\tOur Country\n"));
        paragraphList.add(new Paragraph("   Kiev is the capital of Ukraine. I like Kiev."));
        paragraphList.add(new Paragraph("   Our country is very beautiful! Wow wow wow? "));
        paragraphListExpected = new LinkedList<>();
        paragraphListExpected.add(new Paragraph("Country Our "));
        paragraphListExpected.add(new Paragraph("Ukraine is the capital of Kiev. Kiev like I."));
        paragraphListExpected.add(new Paragraph("beautiful country is very Our! wow wow Wow?"));
        paragraphListNull = new LinkedList<>();
        paragraphListNull.add(new Paragraph(" "));
    }

    @Test
    public void shouldReturnDocumentWithShuffle() {
        when(readArticle.readText()).thenReturn(paragraphList);
        Document resultDocument = documentService.createDocument();
        Document expectedDocument = new Document(ConverterModels.convertParagraphListInDocument(paragraphListExpected));
        assertThat(resultDocument, equalTo(expectedDocument));
    }

    @Test
    public void shouldCheckNullSentence() {
        when(readArticle.readText()).thenReturn(paragraphListNull);
        Document resultDocument = documentService.createDocument();
        String result = resultDocument.getDocument().trim();
        assertTrue(result.isEmpty());
    }
}