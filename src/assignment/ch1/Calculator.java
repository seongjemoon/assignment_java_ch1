package assignment.ch1;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private List<Double> results = new ArrayList<>();

    public double calculate(int num1, int num2, char operator) {
        double result = 0;

        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 == 0) {
                    throw new ArithmeticException("나눗셈 연산에서 분모(0)는 입력할 수 없습니다.");
                }
                result = (double) num1 / num2;
                break;
            default:
                throw new IllegalArgumentException("올바른 연산 기호(+, -, *, /)를 입력해주세요.");
        }

        results.add(result);
        return result;
    }
    public void removeFirstResult() {
        if (!results.isEmpty()) {
            double removed = results.remove(0);
            System.out.println("  [삭제 완료] 가장 오래된 결과인 " + removed + " 데이터가 삭제되었습니다.");
        } else {
            System.out.println("  [삭제 실패] 저장된 연산 결과가 없습니다.");
        }
    }

    public List<Double> getResults() {

        return results;
    }

    public void setResults(List<Double> results) {

        this.results = results;
    }
}