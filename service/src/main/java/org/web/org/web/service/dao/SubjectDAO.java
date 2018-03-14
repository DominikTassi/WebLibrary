package org.web.org.web.service.dao;

import org.web.core.exceptions.NoSubjectException;
import org.web.core.model.Subject;

public interface SubjectDAO {
    public Subject getSubject(int id) throws NoSubjectException;
    public Subject getSubject(Subject subject) throws NoSubjectException;

    public void addSubject(Subject subject);
}
