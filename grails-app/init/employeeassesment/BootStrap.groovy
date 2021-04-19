package employeeassesment

class BootStrap {

    def init = { servletContext ->

        Skills skills = new Skills("skillName":"Backend", "description": "Backend Developer")
        skills.save()

        SubSkills subSkills = new SubSkills(skill:skills, name: "Core Java", description: "Core Java developer")
        subSkills.save()

        SubSkills subSkills1 = new SubSkills(skill:skills, name: "Sql", description: "SQL developer")
        subSkills1.save()

        SubSkills subSkills2 = new SubSkills(skill:skills, name: "Python", description: "Python developer")
        subSkills2.save()

        Skills skills1 = new Skills("skillName":"Frontend", "description": "Frontend Developer")
        skills1.save()

        SubSkills subSkills3 = new SubSkills(skill:skills1, name: "Javascript", description: "JavaScript")
        subSkills3.save()

        SubSkills subSkills4 = new SubSkills(skill:skills1, name: "React", description: "React")
        subSkills3.save()
    }
    def destroy = {
    }
}
