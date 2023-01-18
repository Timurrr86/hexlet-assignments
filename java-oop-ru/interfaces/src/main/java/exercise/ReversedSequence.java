package exercise;

// BEGIN
class ReversedSequence implements CharSequence {
    String text;

    public ReversedSequence(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder(text);
        return sb.reverse().toString();
    }

    @Override
    public int length() {
        return toString().length();
    }

    @Override
    public char charAt(int i) {
        return toString().charAt(i);
    }

    @Override
    public CharSequence subSequence(int i, int i1) {
        return toString().subSequence(i, i1);
    }
}
// END
