package pl.akademiakodu.pl;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main extends JFrame {

    /*
    public Main - tworzy okna do wpisywania danych
    private JLabel - zawiera pytanie
    private JButton - zawiera przyciski tak i nie
     */

    private JButton buttonYes;
    private JButton buttonNo;
    private JLabel labelQuestions;

    public Main() {
        super("Milionerzy"); //ustawia tytuł okna
        setSize(500, 500); //ustawia wielkość okna
        setDefaultCloseOperation(1);//sprawia, że działa przycisk exit
        setVisible(true);//pokazuje widoczność okna
    buttonYes = new JButton("Tak");
    buttonNo = new JButton("Nie");
    labelQuestions = new JLabel("Czy Polska leży w Europie?", 0);
    add(labelQuestions);
    add(buttonYes);
    add(buttonNo);

    setLayout(new GridLayout(3,1));
    }


    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Main main = new Main();

            }
        });


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