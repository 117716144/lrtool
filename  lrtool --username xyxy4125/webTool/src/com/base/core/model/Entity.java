package com.base.core.model;

import java.io.Serializable;

public class Entity implements Serializable{
    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Entity entity = (Entity) o;
        return !(id != null ? !id.equals(entity.id) : entity.id != null);
    }

    public int hashCode() {
        return (id != null ? id.hashCode() : 0);
    }
}
