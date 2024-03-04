package org.anderes.persons.rest;

import org.anderes.persons.domain.Statistics;

public interface StatisticsService {

    void incrementRequest();

    Statistics getStatistics();

    void incrementAdd();

    void addError(int code, String message);

}
