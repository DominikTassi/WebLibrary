package org.web.core.service;

import org.web.core.exceptions.NoSubjectException;
import org.web.core.model.Subject;

public interface SubjectService {
    public Subject getSubject(int id) throws NoSubjectException;
    public Subject getSubject(Subject subject) throws NoSubjectException;

    public void addSubject(Subject subject);
}
