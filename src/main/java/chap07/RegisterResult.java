package chap07;

public class RegisterResult {
    boolean result;
    CardValidity validity;

    public RegisterResult(boolean result) {
        this.result = result;
    }

    public RegisterResult(boolean result, CardValidity validity) {
        this.result = result;
        this.validity = validity;
    }

    public static RegisterResult error(CardValidity validity) {
        return new RegisterResult(false, validity);
    }

    public static RegisterResult success() {
        return new RegisterResult(true);
    }

    public boolean isResult() {
        return result;
    }

    public CardValidity getValidity() {
        return validity;
    }
}
