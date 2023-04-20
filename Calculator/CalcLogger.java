package Calculator;

public class CalcLogger implements Calculable{

    private Calculable calculable;
    private Loggable loggable;

    public CalcLogger(Calculable calculable, Loggable loggable) {
        this.calculable = calculable;
        this.loggable = loggable;
        loggable.log(String.format("Число %d \n", calculable.getResult()));
    }

    @Override
    public Calculable add(ComplexNumber arg) {
        loggable.log(String.format("Прибавляем %d \n",arg));
        return calculable.add(arg);
    }

    @Override
    public Calculable sub(ComplexNumber arg) {
        loggable.log(String.format("Умножаем на %d \n",arg));
        return calculable.sub(arg);
    }


    @Override
    public ComplexNumber getResult() {
        ComplexNumber res = calculable.getResult();
        loggable.log(String.format("Получили результат: %d \n", res));
        return res;
    }

}
