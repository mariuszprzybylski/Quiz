package pl.akademiakodu.pl;

public enum AnswerEnum {

    TAK(true), YES(true),
    NIE(false), nie(false),
    no(false), yes(true), tak(true);

    //automatycznie Enum na name
    //natomiast dodatkowe atybuty trzeba dorzucić
    private boolean isCorrect;


    AnswerEnum(boolean isCorrect) {
        this.isCorrect = isCorrect;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }
}

