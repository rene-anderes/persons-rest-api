package org.anderes.persons.domain;

import javax.inject.Inject;

import org.anderes.persons.rest.StatisticsService;

public class StatisticsServiceMem implements StatisticsService {

    private final Statistics statistics;
    
    @Inject
    public StatisticsServiceMem() {
        statistics = new Statistics();
    }

    @Override
    public void incrementRequest() {
        final var counter = statistics.getValidRequests() + 1;
        statistics.setValidRequests(counter); 
        
    }

    @Override
    public Statistics getStatistics() {
        return statistics;
    }

    @Override
    public void incrementAdd() {
        final var counter = statistics.getAddRequests() + 1;
        statistics.setAddRequests(counter);
    }

    @Override
    public void addError(int code, String message) {
        final var isNewCode = statistics.getStatisticsError().stream().noneMatch(error -> error.getCode() == code);
        if (isNewCode) {
            final var newError = new StatisticsError().setCode(code);
            statistics.getStatisticsError().add(newError);
        }
        statistics.getStatisticsError().stream().filter(error -> error.getCode() == code).forEach(error -> error.addMessage(message));
      
    }
    
}
