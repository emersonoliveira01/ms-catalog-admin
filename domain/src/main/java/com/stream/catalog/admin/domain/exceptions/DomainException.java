package com.stream.catalog.admin.domain.exceptions;

import com.stream.catalog.admin.domain.validation.Error;

import java.util.List;

public class DomainException extends NoStackTraceException {

    private final List<Error> errors;

    private DomainException (final String aMessage, final List<Error> anErrors) {
        super(aMessage);
        this.errors = anErrors;
    }

    public static DomainException with(final List<Error> anErrors) {
        return new DomainException("'name' should not be null", anErrors);

    }

    public static DomainException with(final Error anErrors) {
        return new DomainException(anErrors.message(), List.of(anErrors));

    }
    public List<Error> getErrors() {
        return errors;
    }
}
