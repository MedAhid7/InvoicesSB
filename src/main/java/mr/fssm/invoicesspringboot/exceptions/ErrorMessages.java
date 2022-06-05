package mr.fssm.invoicesspringboot.exceptions;

public enum ErrorMessages {
    MISSING_REQUIRED_FIELD("Missing required field."),
    RECORD_ALREADY_EXISTS("Record already exists."),
    INTERNAL_SERVER_ERROR("Internal Invoice App server error."),
    NO_RECORD_FOUND("Record with provided id is not found.");
    private String errorMessage;
    private ErrorMessages(String errorMessage){
        this.errorMessage=errorMessage;
    }
    private String getErrorMessages(){
        return errorMessage;
    }
    private void setErrorMessages(String errorMessage){
        this.errorMessage=errorMessage;
    }
}
