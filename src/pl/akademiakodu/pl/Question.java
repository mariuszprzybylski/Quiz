package pl.akademiakodu.pl;

public class Question {

    private String content;
    private boolean isCorrect;

    public Question(String content, boolean isCorrect) {
        this.content = content;
        this.isCorrect = isCorrect;
    }
    //pobiera wartosc danej zmiennej
    public String getContent() {
        return content;
    }
    //ustawia wartość danej zmiennej
    public void setContent(String content) {
        this.content = content;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    @Override
    public String toString() {
        return "Question{" +
                "content='" + content + '\'' +
                ", isCorrect=" + isCorrect +
                '}';
    }
}

