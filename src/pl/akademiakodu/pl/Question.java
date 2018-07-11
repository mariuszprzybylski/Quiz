package pl.akademiakodu.pl;

//klasa question, która jest odpowiedzialan za przechowywanie konkretnego pytania
//pytanie ma tylko opcję tak i nie
public class Question {

    //treść pytania
    private String content;
    //czy tak jest poprawne
    private boolean isCorrect;

    //konstruktor 2 parametrowy
    public Question(String content, boolean isCorrect) {
        this.content = content;
        this.isCorrect = isCorrect;
    }

    //getter otrzymuje dane
    public String getContent() {
        return content;
    }

    //setter zmienia treść pytania
    public void setContent(String content) {
        this.content = content;
    }

    //getter dla boolean
    public boolean isCorrect() {
        return isCorrect;
    }

    //setter dla boolean
    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    @Override//podpowiedź dla kompilatora
    //wyświetla czytelną treść pytania, wygenerował Inelijej
    public String toString() {
        return "Question{" +
                "content='" + content + '\'' +
                ", isCorrect=" + isCorrect +
                '}';
    }
}