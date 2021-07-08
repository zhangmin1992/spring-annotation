package day54forRetry;


public class BaseException extends RuntimeException {

    /**
     * 异常提示信息
     **/
    private String errorMessage;

    public BaseException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    @Override
    public String getMessage() {
        return errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
