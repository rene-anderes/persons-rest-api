package org.anderes.persons.domain;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class StatisticsError {

    @XmlElement
    private int code;
    @XmlElement
    private int counter;
    @XmlElement
    private final List<String> message;
    
    public StatisticsError() {
        message = new ArrayList<>();
    }
    
    public int getCode() {
        return code;
    }
    
    public StatisticsError setCode(int code) {
        this.code = code;
        return this;
    }
    
    public List<String> getMessage() {
        return message;
    }
    
    public StatisticsError addMessage(String message) {
        this.message.add(message);
        counter++;
        return this;
    }
    
    public int getCounter() {
        return counter;
    }
}
