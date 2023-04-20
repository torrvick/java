package Calculator;

public interface Calculable {
    Calculable add(ComplexNumber arg);
    Calculable sub(ComplexNumber arg);
    ComplexNumber getResult();
}
