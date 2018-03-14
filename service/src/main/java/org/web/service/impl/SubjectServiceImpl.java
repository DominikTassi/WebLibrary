package org.web.service.impl;
import org.web.core.exceptions.NoSubjectException;
import org.web.core.model.Subject;
import org.web.core.service.SubjectService;
import org.web.service.dao.SubjectDAO;

import java.util.Collection;

public class SubjectServiceImpl implements SubjectService{
    private SubjectDAO subjectDAO = null;

    public SubjectServiceImpl(SubjectDAO subjectDAO) {
        this.subjectDAO = subjectDAO;
    }

    public Subject getSubject(int id) throws NoSubjectException {
        return subjectDAO.getSubject(id);
    }

    public Subject getSubject(Subject subject) throws NoSubjectException {
        return subjectDAO.getSubject(subject);
    }

    public Collection<Subject> getAllSubject() {
        return subjectDAO.getAllSubject();
    }

    public void addSubject(Subject subject) {
        subjectDAO.addSubject(subject);
    }
}
