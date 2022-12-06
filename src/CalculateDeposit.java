import java.util.Scanner;

public class CalculateDeposit {
    double calculateComplexPercentFunction(double depositAmount, double months, int depositPeriod) {
    double makePay = depositAmount * Math.pow((1 + months / 12), 12 * depositPeriod);
    return makeRound(makePay, 2);
    }

    double calculateSimplePercentFunction(double depositAmount, double yearRate, int depositPeriod) {
        return makeRound(depositAmount + depositAmount * yearRate * depositPeriod, 2);
    }

    double makeRound(double value, int places) {
        double scaLe = Math.pow(10, places);
        return Math.round(value * scaLe) / scaLe;
    }

    void printMenu() {
        int termOfDeposit;
        int action;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int depositAmount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:");
        termOfDeposit = scanner.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        double outResult = 0;

        if (action == 1) {
            outResult = calculateSimplePercentFunction(depositAmount, 0.06, termOfDeposit);
        } else if (action == 2){
            outResult = calculateComplexPercentFunction(depositAmount, 0.06, termOfDeposit);
        }

        System.out.println("Результат вклада: " + depositAmount + " за " + termOfDeposit + " лет превратятся в "
                + outResult);
    }
    public static void main(String[] args){ new CalculateDeposit().printMenu(); }




}
