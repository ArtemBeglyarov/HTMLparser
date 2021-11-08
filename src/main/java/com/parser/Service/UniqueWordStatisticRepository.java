package com.parser.Service;

import com.parser.entity.UniqueWordStatistics;
import com.parser.repository.UniqueWordStatisticsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UniqueWordStatisticRepository {

    private final UniqueWordStatisticsRepository uniqueWordStatisticsRepository;

    public UniqueWordStatistics createUrl(UniqueWordStatistics uniqueWordStatistics) {
        return  uniqueWordStatisticsRepository.save(uniqueWordStatistics);
    }
    public UniqueWordStatistics findUrl(Long ID) {
        return uniqueWordStatisticsRepository.getById(ID);
    }
    public void updateUrl(UniqueWordStatistics uniqueWordStatistics) {
        uniqueWordStatisticsRepository.save(uniqueWordStatistics);
    }
    public void deleteUrl(Long ID) {
        uniqueWordStatisticsRepository.deleteById(ID);
    }
    public List<UniqueWordStatistics> getAllUniqueWordStatistics() {
        return uniqueWordStatisticsRepository.findAll();
    }
}
