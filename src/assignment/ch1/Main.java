package assignment.ch1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int num1 = scanner.nextInt();

            System.out.print("두 번째 숫자를 입력하세요: ");
            int num2 = scanner.nextInt();

            System.out.print("사칙연산 기호를 입력하세요 : ");
            String operator = scanner.next();

            switch (operator) {
                case "+":
                    System.out.println("결과: " + (num1 + num2));
                    break;
                case "-":
                    System.out.println("결과: " + (num1 - num2));
                    break;
                case "*":
                    System.out.println("결과: " + (num1 * num2));
                    break;
                case "/":
                    if(num2 !=0) {
                        System.out.println("결과: " + (num1 / num2));
                        break;
                    }
                    else {
                        System.out.println("양의 정수만 입력 받을 수 있습니다 처음으로 돌아갑니다. ");
                        continue;
                    }
                default:
                    System.out.println("잘못된 연산자 기호입니다. 다시 입력해주세요");
                    break;
            }

            System.out.print("다음으로 넘어가시겠습니까? (종료하려면 exit 입력, 계속 하시겠습니까? ok 입력): ");
            String confirm = scanner.next();

            if (confirm.equals("exit")) {
                System.out.println("계산기 종료.");
                break;
            } else if (confirm.equals("ok")) {
                System.out.println();
            }
            else {
                System.out.println("잘못된 입력값입니다, 강제 종료합니다.");
                break;
            }
        }
        scanner.close();
    }
}