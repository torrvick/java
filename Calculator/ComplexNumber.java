package Calculator;

public class ComplexNumber {
    private int realPart;
    private int imaginaryPart;

    public ComplexNumber(int realPart, int imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    public ComplexNumber add(ComplexNumber other) {
        int real = this.realPart + other.realPart;
        int imaginary = this.imaginaryPart + other.imaginaryPart;
        ComplexNumber temp = new ComplexNumber(real, imaginary);
        return temp;
    }

    public ComplexNumber sub(ComplexNumber other) {
        int real = this.realPart - other.realPart;
        int imaginary = this.imaginaryPart - other.imaginaryPart;
        return new ComplexNumber(real, imaginary);
    }

    @Override
    public String toString() {
        if (this.imaginaryPart == 0) {
            return Integer.toString(this.realPart);
        } else if (this.realPart == 0) {
            return Integer.toString(this.imaginaryPart) + "i";
        } else if (this.imaginaryPart > 0) {
            return Integer.toString(this.realPart) + "+" + Integer.toString(this.imaginaryPart) + "i";
        } else {
            return Integer.toString(this.realPart) + Integer.toString(this.imaginaryPart) + "i";
        }
    }
}
