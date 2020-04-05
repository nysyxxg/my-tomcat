package org.apache.jasper;

public class JasperException extends jakarta.servlet.ServletException {

    private static final long serialVersionUID = 1L;

    public JasperException(String reason) {
        super(reason);
    }

    /**
     * Creates a JasperException with the embedded exception and the reason for
     * throwing a JasperException.
     * @param reason The exception message
     * @param exception The root cause
     */
    public JasperException(String reason, Throwable exception) {
        super(reason, exception);
    }

    /**
     * Creates a JasperException with the embedded exception.
     * @param exception The root cause
     */
    public JasperException(Throwable exception) {
        super(exception);
    }
}
