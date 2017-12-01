package site.site8.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.site8.springboot.model.LearnResource;
import site.site8.springboot.service.LearnResouceService;

import java.util.List;

@RestController
public class LearnResourceController {
    @Autowired
    LearnResouceService learnResouceService;

    @RequestMapping("/queryLearnResouceById")
    public LearnResource queryLearnResouceById(long id){
        return  learnResouceService.queryLearnResouceById(id);
    }

    @RequestMapping("/queryLearnResouce")
    public List<LearnResource> queryLearnResouce(int pageNum, int pageSize){
        return  learnResouceService.queryLearnResouce(pageNum,pageSize);
    }
}
