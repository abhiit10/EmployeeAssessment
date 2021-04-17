package employeeassesment

class Projects {

    String projectName
    Skills skills
    SubSkills subSkills
    QuestionsAndAnswers questionsAndAnswers

    static hasMany = [skills: Skills, subSkills: SubSkills, questionsAndAnswers: QuestionsAndAnswers]



    static constraints = {
        skills (nullable: true, blank:true)
        subSkills(nullable: true, blank:true)
        questionsAndAnswers(nullable: true, blank:true)
    }
}
