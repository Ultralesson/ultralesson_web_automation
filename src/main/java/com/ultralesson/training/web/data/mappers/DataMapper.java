package com.ultralesson.training.web.data.mappers;

public interface DataMapper {

    /**
     * A mapping function to map a data to object based on a key.
     * @return T
     */
     <T> T map(String filename, String key, Class<T> tClass);
}
