package org.anderes.persons.domain;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Statistics {

    @XmlElement
    private int addRequests;
    @XmlElement
    private int validRequests;
    @XmlElement
    private int numberOfPersons;
    @XmlElement(name="notValidRequests")
    private final Set<StatisticsError> statisticsError;
    
    public Statistics() {
        statisticsError = new HashSet<>();
    }
    
    public int getAddRequests() {
        return addRequests;
    }
    
    public void setAddRequests(int addRequests) {
        this.addRequests = addRequests;
    }
    
    public int getValidRequests() {
        return validRequests;
    }
    
    public void setValidRequests(int validRequests) {
        this.validRequests = validRequests;
    }
    
    public int getNumberOfPersons() {
        return numberOfPersons;
    }
    
    public void setNumberOfPersons(int numberOfPersons) {
        this.numberOfPersons = numberOfPersons;
    }
    
    public Set<StatisticsError> getStatisticsError() {
        return statisticsError;
    }
}
