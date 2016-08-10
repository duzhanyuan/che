/*******************************************************************************
 * Copyright (c) 2012-2016 Codenvy, S.A.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Codenvy, S.A. - initial API and implementation
 *******************************************************************************/
package org.eclipse.che.api.factory.server.model.impl;

import org.eclipse.che.api.core.model.factory.Author;
import org.eclipse.che.api.user.server.model.impl.UserImpl;

import javax.persistence.Basic;
import javax.persistence.Embeddable;
import java.util.Objects;

/**
 * Data object for {@link Author}.
 *
 * @author Anton Korneta
 */
@Embeddable
public class AuthorImpl implements Author {

    @Basic
    private Long created;

    @Basic
    private String userId;

    public AuthorImpl() {}

    public AuthorImpl(String userId, Long created) {
        this.created = created;
        this.userId = userId;
    }

    public AuthorImpl(Author creator) {
        this(creator.getUserId(), creator.getCreated());
    }

    @Override
    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    @Override
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AuthorImpl)) return false;
        final AuthorImpl other = (AuthorImpl)obj;
        return Objects.equals(userId, other.userId)
               && Objects.equals(created, other.created);
    }

    @Override
    public int hashCode() {
        int result = 7;
        result = 31 * result + Objects.hashCode(userId);
        result = 31 * result + Long.hashCode(created);
        return result;
    }

    @Override
    public String toString() {
        return "AuthorImpl{" +
               "created=" + created +
               ", userId='" + userId + '\'' +
               '}';
    }
}