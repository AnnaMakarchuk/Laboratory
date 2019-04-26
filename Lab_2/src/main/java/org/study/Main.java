package org.study;

import org.study.models.Document;
import com.Anna.services.Impl.*;
import org.study.services.Impl.*;

public class Main {
    public static void main(String[] args) {
        DocumentService documentService = new DocumentService(new Parser(), new FirstLastWordShuffle(),
                new ReadArticleImpl(), new WriteArticleImpl());
        Document document = documentService.createDocument();
        System.out.println(document.getDocument());
        documentService.saveArticleIFile();
    }
}
