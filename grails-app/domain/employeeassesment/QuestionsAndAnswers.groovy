package employeeassesment

class QuestionsAndAnswers {

    String question
    String answer

    static constraints = {
    }

    @Override
    String toString() {
        return "Q : "+question + " - A : " + answer
    }
}
