package com.pdfsummarizer.service;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Service
public class PdfService {

    public String summarizePdf(MultipartFile file) {
        try (InputStream inputStream = file.getInputStream();
             PDDocument document = PDDocument.load(inputStream)) {

            PDFTextStripper pdfStripper = new PDFTextStripper();
            String text = pdfStripper.getText(document);

            // For now, return first 500 characters as "summary"
            return "PDF Summary:\n\n" + text.substring(0, Math.min(text.length(), 500));

        } catch (IOException e) {
            return "Failed to read PDF: " + e.getMessage();
        }
    }
}
