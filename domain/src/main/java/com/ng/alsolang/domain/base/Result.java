package com.ng.alsolang.domain.base;


import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * 服务处理结果
 * User: zhangxuegang
 * Date: 2016/1/21
 * Time: 18:04
 */
public class Result<T> implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    /* ExecuteResult Success Flag  */
    private boolean success;

    /**
     * Return One Value
     */
    private T value;
    /**
     * Return  List More Value
     */
    private List<T> values;

    /**
     * ExecuteResult Message
     */
    private String message;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @XmlElement
    public List<T> getValues() {
        return values;
    }

    public void setValues(List<T> values) {
        this.values = values;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ExecuteResult{" +
                "success=" + success +
                ", value=" + value +
                ", values=" + values +
                ", message='" + message + '\'' +
                '}';
    }
}
