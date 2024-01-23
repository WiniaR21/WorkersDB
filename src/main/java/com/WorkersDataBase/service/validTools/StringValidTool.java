package com.WorkersDataBase.service.validTools;

import org.springframework.stereotype.Component;

@Component
public class StringValidTool {
    public boolean isStringLetters(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
                return false;
            }
        }
        return true;
    }
    public boolean isStringDigits(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}

