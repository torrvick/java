package Calculator;

public final class Calculator implements Calculable {

    private ComplexNumber primaryArg;

    public Calculator(ComplexNumber primaryArg) {
        this.primaryArg = primaryArg;
    }

    @Override
    public Calculable add(ComplexNumber arg) {
        primaryArg = primaryArg.add(arg);
        return this;
    }

    @Override
    public Calculable sub(ComplexNumber arg) {
        primaryArg = primaryArg.sub(arg);
        return this;
    }

    @Override
    public ComplexNumber getResult() {
        return primaryArg;
    }
}
