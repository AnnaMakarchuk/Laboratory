package org.study.services.Impl;

import org.study.services.WriteArticle;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteArticleImpl implements WriteArticle {

    private static final String FILE_SOURCE_WRITE =
            "D:/workspace/cources/Laboratory/Lab_2/src/main/resources/ArticleCopy.txt";

    @Override
    public void saveTextInFile(String documentResult) {
        File file = new File(FILE_SOURCE_WRITE);
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(documentResult);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

