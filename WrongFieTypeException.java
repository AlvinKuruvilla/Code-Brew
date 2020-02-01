public class WrongFieTypeException extends Exception{
    /**
     * Exception Class to handle the incorrect selection of file type as per the parseExtension method of the FileParser.jvav file
     * Supported File typrs include :
     * .java
     * -.py
     * -.txt
     * TODO: Make sure to update this as new file extensions are supported
     */
    private static final long serialVersionUID = 1L;

    public WrongFieTypeException(String message) {
        super(message);
    }
} 