package exercise;

// BEGIN
class NegativeRadiusException extends Exception {
    public NegativeRadiusException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "NegativeRadiusException{}";
    }
}
// END
