package com.parser.helper;

import lombok.Data;

@Data
public class DelimiterList {

    private String delimiter = "[ ,.!?'\";:()\n\r\t\\[\\]-]+";

    public DelimiterList() {

    }
    private DelimiterList(String delimiter) {
        this.delimiter = delimiter;
    }
}
