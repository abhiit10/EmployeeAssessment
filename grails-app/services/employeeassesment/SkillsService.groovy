package employeeassesment

import grails.gorm.services.Service

@Service(Skills)
interface SkillsService {

    Skills get(Serializable id)

    List<Skills> list(Map args)

    Long count()

    void delete(Serializable id)

    Skills save(Skills skills)

}