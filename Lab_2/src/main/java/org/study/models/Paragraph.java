package org.study.models;

public class Paragraph {

    private String paragraph;

    public Paragraph(String paragraph) {
        this.paragraph = paragraph.trim();
    }

    public String getParagraph() {
        return paragraph;
    }

    public void setParagraph(String paragraph) {
        this.paragraph = paragraph.trim();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Paragraph)) return false;

        Paragraph paragraph1 = (Paragraph) o;

        return paragraph != null ? paragraph.equals(paragraph1.paragraph) : paragraph1.paragraph == null;
    }

    @Override
    public int hashCode() {
        return paragraph != null ? paragraph.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "\nParagraph number = " + paragraph;
    }
}
