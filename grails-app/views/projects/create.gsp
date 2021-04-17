<%@ page import="employeeassesment.SubSkills; employeeassesment.Skills" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'projects.label', default: 'Projects')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>

    </head>
    <body>
        <a href="#create-projects" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="create-projects" class="content scaffold-create" role="main">
            <h1><g:message code="default.create.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.projects}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.projects}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form resource="${this.projects}" method="POST">
                <fieldset class="form">
                    <div class="fieldcontain required">
                        <label for="projectName"><b>Project Name</b> </label>
                        <input type="text" name="projectName" value="" />
                    </div>
                    <div class="fieldcontain required">
                        <label for="description"><b>Description</b> </label>
                        <input type="text" name="description" value="" />
                    </div>
                    <div class="fieldcontain required">
                        <label for="question"><b>Question</b> </label>
                            <input type="text" name="question" value="" />
                    </div>
                    <div class="fieldcontain required">
                        <label for="answer"><b>Answer</b> </label>
                            <input type="text" name="answer" value="" />
                    </div>
                    <div class="fieldcontain required">
                        <label for="skill"><b>Skill</b> </label>
                    <g:select id="skill" name='type.id' value=""
                              noSelection="${['null':'Select One...']}"
                              from='${Skills.list()}'
                              optionKey="id" optionValue="skillName" onchange="updateSubSkills(this.value)"></g:select>
                    </div>

                    <div class="fieldcontain required">
                        <label for="skill"><b>Sub Skill</b> </label>
                        <g:select id="skill" name='type.id' value=""
                                  noSelection="${['null':'Select One...']}"
                                  from='${employeeassesment.SubSkills.list()}'
                                  optionKey="id" optionValue="name"></g:select>
                    </div>
                    %{--<f:all bean="projects"/>--}%
                </fieldset>
                <fieldset class="buttons">
                    <g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
