package pl.akademiakodu.pl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<Question> questionList = new ArrayList<>();

        questionList.add(new Question("Czy Polska leży w europie", true));
        questionList.add(new Question("Czy 2+2 = 4", true));
        questionList.add(new Question("Czy 2+5 = 10", true));
        questionList.add(new Question("Czy Chopin urodził się w Warszawie", true));
        questionList.add(new Question("Czy 2^10 = 20247", true));

        int numberOfPoint = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Milionerzy: Odpowiadaj tak bądź nie na pytania");

        for (Question question : questionList) {
            System.out.println(question.getContent());
            String answer = scanner.next();
            if ((answer.equals("tak") && question.isCorrect())
                    || (answer.equals("nie") && !question.isCorrect())) {
                numberOfPoint++;
            }
        }
        System.out.println("Zdobyłeś " + numberOfPoint + " punktów");
    }
}