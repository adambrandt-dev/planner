package daily.planner.exception.User;

public class ContentTypeException extends RuntimeException {

    public ContentTypeException(String fileFormat) {
        super(String.format(
                "Format '%s' is wrong, we provide image",
                fileFormat
        ));
    }
}
