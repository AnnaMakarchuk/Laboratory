package org.study.services.Impl;

import org.study.models.Document;
import org.study.models.Paragraph;
import org.study.models.Sentence;
import org.study.services.ReadArticle;
import org.study.services.Shuffle;
import org.study.services.TextParser;
import org.study.services.WriteArticle;
import org.study.utils.ConverterModels;

import java.util.List;

public class DocumentService {

    private TextParser parser;
    private Shuffle shuffle;
    private ReadArticle readArticle;
    private WriteArticle writeArticle;

    public DocumentService(TextParser parser, Shuffle shuffle, ReadArticle readArticle, WriteArticle writeArticle) {
        this.parser = parser;
        this.shuffle = shuffle;
        this.readArticle = readArticle;
        this.writeArticle = writeArticle;
    }

    public void saveArticleIFile(Document document) {
        writeArticle.saveTextInFile(document.getDocument());
    }

    public Document createDocument() {
        List<Paragraph> paragraphList = readArticle.readText();
        return new Document(ConverterModels.convertParagraphListInDocument(getShuffleSentences(paragraphList)));
    }

    private List<Paragraph> getShuffleSentences(List<Paragraph> paragraphList) {
        for (Paragraph paragraph : paragraphList) {
            if (paragraph.getParagraph().isEmpty()) {
                paragraph.setParagraph(" ");
            } else {
                List<Sentence> sentenceList = getSentenceList(paragraph);
                shuffle.createShuffleSentenceList(sentenceList);
                paragraph.setParagraph(ConverterModels.convertSentenceListInParagraph(sentenceList));
            }
        }
        return paragraphList;
    }

    private List<Sentence> getSentenceList(Paragraph paragraph) {
        return parser.divisionSentences(paragraph);
    }
}
