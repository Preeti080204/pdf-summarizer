package com.pdfsummarizer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

@Controller
public class PdfController {

    @PostMapping("/summarize")
    public String summarizePdf(@RequestParam("file") MultipartFile file, Model model) {
        try {
            String pdfText = extractTextFromPdf(file);
            String summary = summarizeText(pdfText);
            model.addAttribute("summary", summary);
        } catch (IOException e) {
            model.addAttribute("error", "Error reading PDF: " + e.getMessage());
        }
        return "result";  // This should match "result.html" in the templates folder
    }

    // Method to extract text from PDF
    private String extractTextFromPdf(MultipartFile file) throws IOException {
        PDDocument document = PDDocument.load(file.getInputStream());
        PDFTextStripper stripper = new PDFTextStripper();
        return stripper.getText(document);
    }

    // Simple text summarization logic
    private String summarizeText(String text) {
        String[] sentences = text.split("(?<=\\.)");
        List<String> sentenceList = Arrays.asList(sentences);
        List<SentenceScore> scoredSentences = sentenceList.stream()
                .map(sentence -> new SentenceScore(sentence, sentence.length()))
                .collect(Collectors.toList());
        scoredSentences.sort((s1, s2) -> Integer.compare(s2.score, s1.score));

        int summaryLength = Math.min(5, scoredSentences.size());
        return scoredSentences.subList(0, summaryLength).stream()
                .map(sentenceScore -> sentenceScore.sentence)
                .collect(Collectors.joining(" "));
    }

    private static class SentenceScore {
        String sentence;
        int score;

        public SentenceScore(String sentence, int score) {
            this.sentence = sentence;
            this.score = score;
        }
    }
}
