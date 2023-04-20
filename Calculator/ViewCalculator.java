package Calculator;

import java.util.Scanner;

public class ViewCalculator {

    private ICalculableFactory calculableFactory;

    public ViewCalculator(ICalculableFactory calculableFactory) {
        this.calculableFactory = calculableFactory;
    }

    public void run() {
        while (true) {
            ComplexNumber primaryArg = promptComplex("Введите первый аргумент: ");
            Calculable calculator = calculableFactory.create(primaryArg);
            while (true) {
                String cmd = prompt("Введите команду (+, -, =) : ");
                if (cmd.equals("+")) {
                    ComplexNumber arg = promptComplex("Введите второй аргумент: ");
                    calculator.add(arg);
                    continue;
                }
                if (cmd.equals("-")) {
                    ComplexNumber arg = promptComplex("Введите второй аргумент: ");
                    calculator.sub(arg);
                    continue;
                }
                if (cmd.equals("=")) {
                    ComplexNumber result = calculator.getResult();
                    System.out.printf("Результат %s\n", result);
                    break;
                }
            }
            String cmd = prompt("Еще посчитать (Y/N)?");
            if (cmd.equals("Y")) {
                continue;
            }
            break;
        }
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

    // private int promptInt(String message) {
    //     Scanner in = new Scanner(System.in);
    //     System.out.print(message);
    //     return Integer.parseInt(in.nextLine());
    // }
    

    private ComplexNumber promptComplex(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        String complex = in.nextLine();
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
}
