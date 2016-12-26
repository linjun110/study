package com.linjun.java.spring.model;

import com.linjun.java.spring.annotation.Operation;
import com.linjun.java.spring.exception.DispatchException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by linjun on 17/1/16.
 */
public class Applier {
    private final static String INPUT = "Input";
    private final static String CLIENT_MODEL_NAME_SPACE = "com.linjun.java.spring.ClientModel";
    private final static String DOT = ".";

    // instance to trigger method
    private Object obj;
    private Method method;

    private String operation;
    private ObjectMapper mapper = new ObjectMapper();
    private Class<?> inputModel;

    public Applier(Object obj, Method method) throws ClassNotFoundException {
        this.obj = obj;
        this.method = method;
        this.operation = this.method.getAnnotation(Operation.class).value();
        this.inputModel = getInputModel(operation);
    }

    public String apply(String json) throws DispatchException {
        try {
            return mapper.writeValueAsString(method.invoke(obj, generateModel(json)));
        } catch (IllegalAccessException e) {
            throw new DispatchException(e);
        } catch (InvocationTargetException e) {
            throw new DispatchException(e);
        } catch (JsonParseException e) {
            throw new DispatchException(e);
        } catch (JsonMappingException e) {
            throw new DispatchException(e);
        } catch (IOException e) {
            throw new DispatchException(e);
        }
    }

    private Class<?> getInputModel(String operation) throws ClassNotFoundException {
        String input = CLIENT_MODEL_NAME_SPACE + DOT + operation + INPUT;
        return Class.forName(input);
    }

    private Object generateModel(String json) throws IOException {
        return mapper.readValue(json, inputModel);
    }

    // setter & getter
    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }
}
