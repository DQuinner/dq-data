package ie.dq.data.service.impl;

import ie.dq.data.domain.SampleData;
import ie.dq.data.repository.SampleDataRepository;
import ie.dq.data.service.DataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataServiceImpl implements DataService {

    private static final Logger logger = LoggerFactory.getLogger(DataServiceImpl.class);

    @Autowired
    private SampleDataRepository sampleDataRepository;

    @Override
    public List<SampleData> createSampleData(int amount) {
        for(int i = 1; i<=amount; i++){
            sampleDataRepository.save(createSampleTransaction(i));
            logger.info("Saved sample data {}", i);
        }
        return (List<SampleData>) sampleDataRepository.findAll();
    }

    @Override
    public Page<SampleData> getAllData(Pageable pageable) {
        return sampleDataRepository.findAll(pageable);
    }

    private SampleData createSampleTransaction(int i){
        SampleData sampleData = new SampleData();
        sampleData.setDescription("Sample data number "+i);
        sampleData.setAmount(Integer.valueOf(i+"0000"));
        return sampleData;
    }
}
