package org.study.models;

public class Document {
    private String document;

    public Document(String document) {
        this.document = document;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Document)) return false;

        Document document1 = (Document) o;

        return document != null ? document.equals(document1.document) : document1.document == null;
    }

    @Override
    public int hashCode() {
        return document != null ? document.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Document: " + document;
    }
}
