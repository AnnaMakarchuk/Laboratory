package org.study.services.Impl;

import org.study.models.Paragraph;
import org.study.services.ReadArticle;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class ReadArticleImpl implements ReadArticle {

    private static final String FILE_SOURCE_READ = "./src/main/resources/JUnitArticle.txt";

    @Override
    public List<Paragraph> readText() {
        List<Paragraph> paragraphList = new LinkedList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_SOURCE_READ))) {
            int i = 1;
            while ((i = bufferedReader.read()) != -1) {
                String line = bufferedReader.readLine();
                paragraphList.add(new Paragraph(line));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return paragraphList;
    }
}
