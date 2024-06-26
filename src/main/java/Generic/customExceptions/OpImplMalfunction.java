package Generic.customExceptions;

public class OpImplMalfunction extends CustomE2eException {

    /**
     * Contructor.
     *
     * @param errorMessage Error Message
     */
    public OpImplMalfunction(String errorMessage) {
        super(errorMessage);
    }
}
