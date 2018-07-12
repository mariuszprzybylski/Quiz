package pl.akademiakodu.pl;

import java.util.ArrayList;
import java.util.List;

/*
Klasa która implementuje interfejs
Dzięki temu może byc traktowana jako typ SimpleQuestion
ale też jako typ QuestionGenerator
 */

public class SimpleQuestionGenerator implements QuestionGenerator {

    @Override
    public List<Question> generateQuestions() {

        List<Question> questionList = new ArrayList<>();

        questionList.add(new Question("Czy Polska leży w Europie", true));
        questionList.add(new Question("Czy 2+2 = 4", true));
        questionList.add(new Question("Czy 2+5 = 10", false));
        questionList.add(new Question("Czy Chopin urodził się w Warszawie", true));
        questionList.add(new Question("Czy 2^10 = 20247", true));


        return questionList;
    }
}