package Calculator;

public class CalcLoggerFactory implements ICalculableFactory{
    private Loggable loggable;

    public CalcLoggerFactory(Loggable loggable) {
        this.loggable = loggable;
    }

    @Override
    public Calculable create(ComplexNumber primaryArg) {
        return new CalcLogger(new Calculator(primaryArg), loggable);
    }
}
