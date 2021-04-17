package employeeassesment

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SkillsController {

    SkillsService skillsService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond skillsService.list(params), model:[skillsCount: skillsService.count()]
    }

    def show(Long id) {
        respond skillsService.get(id)
    }

    def create() {
        respond new Skills(params)
    }

    def save(Skills skills) {
        if (skills == null) {
            notFound()
            return
        }

        try {
            skillsService.save(skills)
        } catch (ValidationException e) {
            respond skills.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'skills.label', default: 'Skills'), skills.id])
                redirect skills
            }
            '*' { respond skills, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond skillsService.get(id)
    }

    def update(Skills skills) {
        if (skills == null) {
            notFound()
            return
        }

        try {
            skillsService.save(skills)
        } catch (ValidationException e) {
            respond skills.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'skills.label', default: 'Skills'), skills.id])
                redirect skills
            }
            '*'{ respond skills, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        skillsService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'skills.label', default: 'Skills'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'skills.label', default: 'Skills'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
