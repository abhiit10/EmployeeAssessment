package employeeassesment

import grails.gorm.services.Service

@Service(QuestionsAndAnswers)
interface QuestionsAndAnswersService {

    QuestionsAndAnswers get(Serializable id)

    List<QuestionsAndAnswers> list(Map args)

    Long count()

    void delete(Serializable id)

    QuestionsAndAnswers save(QuestionsAndAnswers questionsAndAnswers)

}