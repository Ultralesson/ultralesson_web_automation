package com.ultralesson.training.web.data.mappers;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.ultralesson.training.web.models.Customer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;
import java.util.Objects;

public class JSONDataMapper implements DataMapper {

    @Override
    public <T> T map(String file, String key, Class<T> tClass) {
        Gson gson = new Gson();
        try {
            Map<String, LinkedTreeMap> jsonMap = gson.fromJson(new FileReader(file), Map.class);
            LinkedTreeMap jsonElement = jsonMap.get(key);
            if(Objects.isNull(jsonElement)) throw new FileNotFoundException();
            return gson.fromJson(jsonElement.toString(), tClass);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(String.format("Failed to find a data for key %s in file %s or filepath %s itself is wrong", key, file, file));
        }

    }

  public static void main(String[] args) {
    //
      JSONDataMapper jsonMapper = new JSONDataMapper();
      String path = Objects.requireNonNull(jsonMapper.getClass().getClassLoader().getResource("data_sets/customers/valid_customers.json")).getPath();
      Customer customerWithActiveItemsInCart = jsonMapper.map(path, "customerWithActiveItemsInCart1", Customer.class);
    System.out.println(customerWithActiveItemsInCart);
  }
}
