package edu.bbte.softeng.hexa.product.adapter.out.persistence;

public class RepositoryException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public RepositoryException() {
        super();
    }

    public RepositoryException(final String message) {
        super(message);
    }

    public RepositoryException(final String message, final Throwable cause) {
        super(message, cause);
    }
}

