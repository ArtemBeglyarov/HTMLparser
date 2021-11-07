package com.parser;

import com.parser.helper.ParserHtml;

import java.io.IOException;

public class AppParser {
    public static void main(String[] args) throws IOException {

    ParserHtml parserHtml = new ParserHtml("https://jsoup.org/apidocs/org/jsoup/nodes/Document.html#text(java.lang.String)");
    parserHtml.splitString(parserHtml.getTextFromPage());
    parserHtml.outputSortedUniqueWords();

    }
}
