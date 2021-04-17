package employeeassesment

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class QuestionsAndAnswersServiceSpec extends Specification {

    QuestionsAndAnswersService questionsAndAnswersService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new QuestionsAndAnswers(...).save(flush: true, failOnError: true)
        //new QuestionsAndAnswers(...).save(flush: true, failOnError: true)
        //QuestionsAndAnswers questionsAndAnswers = new QuestionsAndAnswers(...).save(flush: true, failOnError: true)
        //new QuestionsAndAnswers(...).save(flush: true, failOnError: true)
        //new QuestionsAndAnswers(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //questionsAndAnswers.id
    }

    void "test get"() {
        setupData()

        expect:
        questionsAndAnswersService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<QuestionsAndAnswers> questionsAndAnswersList = questionsAndAnswersService.list(max: 2, offset: 2)

        then:
        questionsAndAnswersList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        questionsAndAnswersService.count() == 5
    }

    void "test delete"() {
        Long questionsAndAnswersId = setupData()

        expect:
        questionsAndAnswersService.count() == 5

        when:
        questionsAndAnswersService.delete(questionsAndAnswersId)
        sessionFactory.currentSession.flush()

        then:
        questionsAndAnswersService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        QuestionsAndAnswers questionsAndAnswers = new QuestionsAndAnswers()
        questionsAndAnswersService.save(questionsAndAnswers)

        then:
        questionsAndAnswers.id != null
    }
}
