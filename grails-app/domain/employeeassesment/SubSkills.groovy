package employeeassesment

class SubSkills {

    String name
    String description

    static belongsTo = [skill : Skills]
    static constraints = {
    }
}
