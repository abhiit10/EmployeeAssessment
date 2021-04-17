package employeeassesment

import grails.gorm.services.Service

@Service(SubSkills)
interface SubSkillsService {

    SubSkills get(Serializable id)

    List<SubSkills> list(Map args)

    Long count()

    void delete(Serializable id)

    SubSkills save(SubSkills subSkills)

}