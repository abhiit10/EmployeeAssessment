package employeeassesment

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SkillsServiceSpec extends Specification {

    SkillsService skillsService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Skills(...).save(flush: true, failOnError: true)
        //new Skills(...).save(flush: true, failOnError: true)
        //Skills skills = new Skills(...).save(flush: true, failOnError: true)
        //new Skills(...).save(flush: true, failOnError: true)
        //new Skills(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //skills.id
    }

    void "test get"() {
        setupData()

        expect:
        skillsService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Skills> skillsList = skillsService.list(max: 2, offset: 2)

        then:
        skillsList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        skillsService.count() == 5
    }

    void "test delete"() {
        Long skillsId = setupData()

        expect:
        skillsService.count() == 5

        when:
        skillsService.delete(skillsId)
        sessionFactory.currentSession.flush()

        then:
        skillsService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Skills skills = new Skills()
        skillsService.save(skills)

        then:
        skills.id != null
    }
}
