package com.beegeworks.education.mentorme.util;

public class ApplicationException extends RuntimeException {
    public ApplicationException(String userFacingErrorText) {
        super(userFacingErrorText);
    }
}
