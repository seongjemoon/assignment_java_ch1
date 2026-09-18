package assignment.ch1;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                int num1 = scanner.nextInt();
                System.out.print("두 번째 숫자를 입력하세요: ");
                int num2 = scanner.nextInt();
                System.out.print("사칙연산 기호를 입력하세요 : ");
                char operator = scanner.next().charAt(0);

                double result = calculator.calculate(num1, num2, operator);
                System.out.println(" 연산 결과: " + result);

                List<Double> currentResults = calculator.getResults();
                System.out.println(" 현재까지 저장된 전체 결과 : " + currentResults);

            } catch (InputMismatchException e) {
                System.out.println("[입력 오류] 정수(예: 1, 2, 10)만 입력할 수 있습니다.");
                scanner.nextLine();
                System.out.println("처음부터 다시 입력해주세요.");
                continue;

            } catch (Exception e) {
                System.out.println("[연산 오류] " + e.getMessage());
                System.out.println("처음부터 다시 입력해주세요.");
                continue;
            }

            System.out.println("다음으로 넘어가시겠습니까? 종료하려면 exit 입력, 계속 하시겠습니까? ok 입력 ");
            System.out.print("기록 수정은 update, 첫 결과 삭제는 remove를 입력해주세요: ");
            String confirm = scanner.next();

            if (confirm.equals("exit")) {
                System.out.println("계산기 종료.");
                break;
            }
            else if (confirm.equals("ok")) {
                System.out.println();
            }
            else if (confirm.equals("update")) {
                List<Double> list = calculator.getResults();

                if (list.isEmpty()) {
                    System.out.println(" 수정할 연산 기록이 없습니다.");
                } else {
                    System.out.println("----------------------------------------------");
                    try {
                        System.out.print(" 몇 번째 기록을 수정하시겠습니까? (배열은 0부터 시작이므로 수정할 기록을 0 부터 입력해주세요) : ");
                        int index = scanner.nextInt();

                        if (index >= 0 && index < list.size()) {
                            System.out.print(" 어떤 숫자로 수정하시겠습니까?: ");
                            double newValue = scanner.nextDouble();

                            list.set(index, newValue);
                            calculator.setResults(list);

                            System.out.println(" [수정 완료] " + index + "번 기록이 " + newValue + "(으)로 변경되었습니다.");
                        } else {
                            System.out.println(" [수정 실패] 올바르지 않은 번호입니다.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println(" [수정 실패] 올바른 번호와 숫자를 입력해야 합니다.");
                        scanner.nextLine();
                    }
                    System.out.println(" 현재 결과 목록: " + calculator.getResults());
                    System.out.println("----------------------------------------------");
                }
            }
            else if (confirm.equals("remove")) {
                System.out.println("----------------------------------------------");
                calculator.removeFirstResult();
                System.out.println(" 현재 남은 결과 목록 : " + calculator.getResults());
                System.out.println("----------------------------------------------");
            }
            else {
                System.out.println("잘못된 입력값입니다, 강제 종료합니다.");
                break;
            }
        }
        scanner.close();
    }
}
