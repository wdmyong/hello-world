package com.wdm.reflect.rmi;

import java.io.Serializable;
import java.util.Arrays;

public class Call implements Serializable {

    private static final long serialVersionUID = 1L;

    private String className;
    private String methodName;
    private Class<?>[] paramTypes;
    private Object[] params;
    private Object result;

    public Call(){}
    public Call(String className, String methodName, Class<?>[] paramTypes, Object[] params) {
        this.className = className;
        this.methodName = methodName;
        this.paramTypes = paramTypes;
        this.params = params;
    }

    public String getClassName() {
        return className;
    }
    public void setClassName(String className) {
        this.className = className;
    }
    public String getMethodName() {
        return methodName;
    }
    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }
    public Class<?>[] getParamTypes() {
        return paramTypes;
    }
    public void setParamTypes(Class<?>[] paramTypes) {
        this.paramTypes = paramTypes;
    }
    public Object[] getParams() {
        return params;
    }
    public void setParams(Object[] params) {
        this.params = params;
    }
    public Object getResult() {
        return result;
    }
    public void setResult(Object result) {
        this.result = result;
    }
    @Override
    public String toString() {
        return "Call [className=" + className + ", methodName=" + methodName + ", paramTypes="
                + Arrays.toString(paramTypes) + ", params=" + Arrays.toString(params) + ", result=" + result + "]";
    }
}
