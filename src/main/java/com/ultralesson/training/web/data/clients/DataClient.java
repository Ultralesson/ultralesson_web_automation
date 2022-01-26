package com.ultralesson.training.web.data.clients;

import com.ultralesson.training.web.data.mappers.DataMapper;
import com.ultralesson.training.web.data.mappers.JSONDataMapper;

import java.util.Objects;

public abstract class DataClient {

    protected DataMapper dataMapper;
    public DataClient() {
        dataMapper = new JSONDataMapper();
    }

    protected String getFilePath(String relativePath) {
        return Objects.requireNonNull(this.getClass()
                .getClassLoader()
                .getResource(String.format("data_sets/%s",relativePath)))
                .getPath();
    }

}
