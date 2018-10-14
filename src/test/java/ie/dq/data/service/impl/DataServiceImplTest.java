package ie.dq.data.service.impl;

import ie.dq.data.repository.SampleDataRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DataServiceImplTest {

    @Mock
    SampleDataRepository sampleDataRepository;

    @InjectMocks
    DataServiceImpl transactionService = new DataServiceImpl();

    @Test
    public void createSampleData(){
        transactionService.createSampleData(10);
    }

}
