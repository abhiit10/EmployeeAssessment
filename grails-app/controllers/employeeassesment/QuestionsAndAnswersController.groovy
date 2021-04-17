package employeeassesment

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class QuestionsAndAnswersController {

    QuestionsAndAnswersService questionsAndAnswersService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond questionsAndAnswersService.list(params), model:[questionsAndAnswersCount: questionsAndAnswersService.count()]
    }

    def show(Long id) {
        respond questionsAndAnswersService.get(id)
    }

    def create() {
        respond new QuestionsAndAnswers(params)
    }

    def save(QuestionsAndAnswers questionsAndAnswers) {
        if (questionsAndAnswers == null) {
            notFound()
            return
        }

        try {
            questionsAndAnswersService.save(questionsAndAnswers)
        } catch (ValidationException e) {
            respond questionsAndAnswers.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'questionsAndAnswers.label', default: 'QuestionsAndAnswers'), questionsAndAnswers.id])
                redirect questionsAndAnswers
            }
            '*' { respond questionsAndAnswers, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond questionsAndAnswersService.get(id)
    }

    def update(QuestionsAndAnswers questionsAndAnswers) {
        if (questionsAndAnswers == null) {
            notFound()
            return
        }

        try {
            questionsAndAnswersService.save(questionsAndAnswers)
        } catch (ValidationException e) {
            respond questionsAndAnswers.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'questionsAndAnswers.label', default: 'QuestionsAndAnswers'), questionsAndAnswers.id])
                redirect questionsAndAnswers
            }
            '*'{ respond questionsAndAnswers, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        questionsAndAnswersService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'questionsAndAnswers.label', default: 'QuestionsAndAnswers'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'questionsAndAnswers.label', default: 'QuestionsAndAnswers'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
