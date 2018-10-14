package ie.dq.data.repository;

import ie.dq.data.domain.SampleData;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SampleDataRepository extends PagingAndSortingRepository<SampleData, Long> {
}
