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
        return new ComplexNumber(real, imaginary);
    }

    public ComplexNumber sub(ComplexNumber other) {
        int real = this.realPart - other.realPart;
        int imaginary = this.imaginaryPart - other.imaginaryPart;
        return new ComplexNumber(real, imaginary);
    }

    public ComplexNumber multiply(ComplexNumber other) {
        int real = (this.realPart * other.realPart) - (this.imaginaryPart * other.imaginaryPart);
        int imaginary = (this.realPart * other.imaginaryPart) + (this.imaginaryPart * other.realPart);
        return new ComplexNumber(real, imaginary);
    }

    @Override
    public String toString() {
        if (imaginaryPart == 0) {
            return Integer.toString(realPart);
        } else if (realPart == 0) {
            return Integer.toString(imaginaryPart) + "i";
        } else if (imaginaryPart > 0) {
            return Integer.toString(realPart) + "+" + Integer.toString(imaginaryPart) + "i";
        } else {
            return Integer.toString(realPart) + Integer.toString(imaginaryPart) + "i";
        }
    }
}
