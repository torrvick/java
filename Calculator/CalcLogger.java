package Calculator;

public class CalcLogger implements Calculable{

    private Calculable calculable;
    private Loggable loggable;

    public CalcLogger(Calculable calculable, Loggable loggable) {
        this.calculable = calculable;
        this.loggable = loggable;
        loggable.log(String.format("Число %s \n", calculable.getResult()));
    }

    @Override
    public Calculable add(ComplexNumber arg) {
        loggable.log(String.format("Прибавляем %s \n",arg));
        return calculable.add(arg);
    }

    @Override
    public Calculable sub(ComplexNumber arg) {
        loggable.log(String.format("Вычитаем %s \n",arg));
        return calculable.sub(arg);
    }


    @Override
    public ComplexNumber getResult() {
        ComplexNumber res = calculable.getResult();
        loggable.log(String.format("Получили результат: %s \n", res));
        return res;
    }

}
