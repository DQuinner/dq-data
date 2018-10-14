package ie.dq.data.service;

import ie.dq.data.domain.SampleData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DataService {

    List<SampleData> createSampleData(int amount);

    Page<SampleData> getAllData(Pageable pageable);

}
