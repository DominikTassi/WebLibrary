package org.web.service.dao;

import org.web.core.exceptions.NoSubjectException;
import org.web.core.model.Subject;

import java.util.Collection;

public interface SubjectDAO {
    public Subject getSubject(int id) throws NoSubjectException;
    public Subject getSubject(Subject subject) throws NoSubjectException;
    public Collection<Subject> getAllSubject();

    public void addSubject(String subjectName);
}
