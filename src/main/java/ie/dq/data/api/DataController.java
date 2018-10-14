package ie.dq.data.api;

import ie.dq.data.domain.SampleData;
import ie.dq.data.service.impl.DataServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DataController {

    private static final Logger logger = LoggerFactory.getLogger(DataController.class);

    @Autowired
    private DataServiceImpl dataService;

    @RequestMapping("/data/setup")
    public List<SampleData> setup(@RequestParam(name = "amount") Integer amount) {
        logger.info("Setting up {} sample data records", amount);
        return dataService.createSampleData(amount);
    }

    @RequestMapping("/data")
    public List<SampleData> getData(@PageableDefault Pageable pageable) {
        logger.info("Fetching data page = {} size = {} sort = {}", pageable.getPageNumber(),pageable.getPageSize(), pageable.getSort());
        return dataService.getAllData(pageable).getContent();
    }

}
