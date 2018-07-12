package pl.akademiakodu.pl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Main extends JFrame implements ActionListener {

    /*
    public Main - tworzy okna do wpisywania danych
    private JLabel - zawiera pytanie
    private JButton - zawiera przyciski tak i nie
    public void setQuestionGenerator - odnosi się do interfejsu, daje mozliwość uniwersalności aplikacji
     */

    private JButton buttonYes;
    private JButton buttonNo;
    private JLabel labelQuestions;


    //zmienna, która jest typu interfejsowego
    //co oznacza, ze musi to tej zmiennej przekazać klasę
    //która będzie implementowała interfejs Question Generator
    //mówimy ogólnie o typie, ale nie mówmy konkretnie o klasie
    //podajemy kategorie do kótórej będzie należała klasa
    private QuestionGenerator questionGenerator;
    private int currentQuestion = 0;
    private int numberOfPoints = 0;

    //lista pytań
    private List<Question> questionList = new ArrayList<>();//zmienna

    public void setQuestionGenerator(QuestionGenerator questionGenerator) {
        // ustawiamy z mienną z 27 linijki na tą, która jest podana w argumencie metody
        this.questionGenerator = questionGenerator;
        //tutaj zakładamy, że już mamy onbiekt jakieś klasy
        // na etapie pisania kodu nie wiemy jakmpletnie jaka będzie to klasa
        //tylko wiemy, że musi implementować interfejs QuestionGenerator
        //wypełniemy listę pytaniami, ktore są generowane za pomocą metody generateQuestiona
        questionList = questionGenerator.generateQuestions();
    }


    public Main() {//konstruktor
        super("Milionerzy"); //ustawia tytuł okna
        createDefaultComponents();//jest to metoda stworzona z refaktoringu.

    }

    private void createDefaultComponents() {
        setSize(500, 500); //ustawia wielkość okna
        setDefaultCloseOperation(1);//sprawia, że działa przycisk exit
        setVisible(true);//pokazuje widoczność okna
        setQuestionGenerator(new FileGenerator());//wywołanie setera/ pod new możemy wstawić dowolny plik z pytaniami
        //ustawiamy komkretną klasę, która będzie nam generować pytania
        //za pomocą new NazwaKlasu mozemy podmienić nasz generator za pomoca jednej liniki kodu!
        buttonYes = new JButton("Tak");
        buttonNo = new JButton("Nie");
        labelQuestions = new JLabel(questionList.get(0).getContent(), 0);
        //label ustawia na 1 pytanie, które zosyało wygenerowane przez questionGenerator
        add(labelQuestions);
        add(buttonYes);
        add(buttonNo);
        setLayout(new GridLayout(3, 1)); //układ naszego okna, 3 w pionie, 1 w poziomie
        buttonYes.addActionListener(this);
        buttonNo.addActionListener(this);
        //--komentarz do linijki 60 i 61
        //this wskazuje na obiekt w którym jest,
        //na rzecz, którego w tym momencie wywołany jest konstruktor
        //Listener ma być obiekt Main, czyli okno
    }


    public static void main(String[] args) {
//odpalenie okan w wątku
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
//stworzenie nowej zmiennnej typu Main = nowego okna
                Main main = new Main();

            }
        });
    }

    //ta metoda jest wywołana gdy klikniemy na button tak, nie
    @Override
    public void actionPerformed(ActionEvent e) {
        //kolejne pytanie musi się mieścić w liście
        if (currentQuestion < questionList.size()) {
            JButton clikedButton = (JButton) e.getSource();
            Question currentQuestion = questionList.get(this.currentQuestion);
            if (clikedButton == buttonYes
                    && currentQuestion.isCorrect()
                    ) {
                numberOfPoints++;
            }
            if (clikedButton == buttonNo
                    && !currentQuestion.isCorrect()
            ) {
                numberOfPoints++;
            }
        }
        if (currentQuestion + 1 < questionList.size()) {
            labelQuestions.setText(questionList.get(++currentQuestion).getContent());
        } else

        {
            JOptionPane.showMessageDialog(this, "Koniec quizu zdobyłeś " + numberOfPoints + " punktów");
            buttonNo.setEnabled(false);
            buttonYes.setEnabled(false);

        }
    }
}