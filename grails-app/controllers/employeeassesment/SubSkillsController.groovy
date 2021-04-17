package employeeassesment

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SubSkillsController {

    SubSkillsService subSkillsService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond subSkillsService.list(params), model:[subSkillsCount: subSkillsService.count()]
    }

    def show(Long id) {
        respond subSkillsService.get(id)
    }

    def create() {
        respond new SubSkills(params)
    }

    def save(SubSkills subSkills) {
        if (subSkills == null) {
            notFound()
            return
        }

        try {
            subSkillsService.save(subSkills)
        } catch (ValidationException e) {
            respond subSkills.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'subSkills.label', default: 'SubSkills'), subSkills.id])
                redirect subSkills
            }
            '*' { respond subSkills, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond subSkillsService.get(id)
    }

    def update(SubSkills subSkills) {
        if (subSkills == null) {
            notFound()
            return
        }

        try {
            subSkillsService.save(subSkills)
        } catch (ValidationException e) {
            respond subSkills.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'subSkills.label', default: 'SubSkills'), subSkills.id])
                redirect subSkills
            }
            '*'{ respond subSkills, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        subSkillsService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'subSkills.label', default: 'SubSkills'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'subSkills.label', default: 'SubSkills'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
