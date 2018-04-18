package org.web.core.service;

import org.web.core.exceptions.NoSubjectException;
import org.web.core.model.Subject;

import java.util.Collection;

public interface SubjectService {
    public Subject getSubject(int id) throws NoSubjectException;
    public Subject getSubject(Subject subject) throws NoSubjectException;
    public Collection<Subject> getAllSubject();

    public void addSubject(String subjectName);
}
