package employeeassesment

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SubSkillsServiceSpec extends Specification {

    SubSkillsService subSkillsService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SubSkills(...).save(flush: true, failOnError: true)
        //new SubSkills(...).save(flush: true, failOnError: true)
        //SubSkills subSkills = new SubSkills(...).save(flush: true, failOnError: true)
        //new SubSkills(...).save(flush: true, failOnError: true)
        //new SubSkills(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //subSkills.id
    }

    void "test get"() {
        setupData()

        expect:
        subSkillsService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SubSkills> subSkillsList = subSkillsService.list(max: 2, offset: 2)

        then:
        subSkillsList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        subSkillsService.count() == 5
    }

    void "test delete"() {
        Long subSkillsId = setupData()

        expect:
        subSkillsService.count() == 5

        when:
        subSkillsService.delete(subSkillsId)
        sessionFactory.currentSession.flush()

        then:
        subSkillsService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SubSkills subSkills = new SubSkills()
        subSkillsService.save(subSkills)

        then:
        subSkills.id != null
    }
}
