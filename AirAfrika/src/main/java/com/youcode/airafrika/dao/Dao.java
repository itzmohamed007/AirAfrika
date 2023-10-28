package com.youcode.airafrika.dao;

import java.util.List;
import java.util.UUID;

// O stand for object (this is a generic interface)
public interface Dao<O> {
    public boolean create(O o);
    public O get(UUID uuid);
    public List<O> getAll();
    public boolean update(O o);
    public boolean delete(UUID uuid);
}
