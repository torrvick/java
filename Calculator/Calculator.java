package Calculator;

public final class Calculator implements Calculable {

    private ComplexNumber primaryArg;

    public Calculator(ComplexNumber primaryArg) {
        this.primaryArg = primaryArg;
    }

    private static ComplexNumber parseComplexNumber(String complex) {
        int plusIndex = complex.indexOf("+");
        int minusIndex = complex.indexOf("-");
        int iIndex = complex.indexOf("i");

        int realPart;
        int imaginaryPart;

        if (plusIndex != -1) {
            realPart = Integer.parseInt(complex.substring(0, plusIndex));
            imaginaryPart = Integer.parseInt(complex.substring(plusIndex + 1, iIndex));
        } else if (minusIndex != -1) {
            realPart = Integer.parseInt(complex.substring(0, minusIndex));
            imaginaryPart = Integer.parseInt(complex.substring(minusIndex, iIndex));
        } else {
            realPart = 0;
            imaginaryPart = Integer.parseInt(complex.substring(0, iIndex));
        }

        return new ComplexNumber(realPart, imaginaryPart);
    }


    @Override
    public Calculable add(ComplexNumber arg) {
        primaryArg.add(arg);
        return this;
    }

    @Override
    public Calculable sub(ComplexNumber arg) {
        primaryArg.sub(arg);
        return this;
    }

    @Override
    public ComplexNumber getResult() {
        return primaryArg;
    }
}
