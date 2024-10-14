package com.assignment.question;

public class DocumentProcessorFactory {

  public static DocumentProcessor getDocumentProcessor(DocumentType docType, String documentName) {
    DocumentProcessor processor = null;
    switch (docType) {
      case PRESENTATION -> processor = new PresentationDocumentProcessor(documentName);
      case TEXT -> processor = new TextDocumentProcessor(documentName);
      case  SPREAD_SHEET -> processor = new SpreadsheetDocumentProcessor(documentName);
      default -> throw new IllegalArgumentException("Unknown DocumentType: " + docType);
    }
    return processor;
  }
}