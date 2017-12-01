package site.site8.springboot.service;

import site.site8.springboot.model.LearnResource;

import java.util.List;

public interface LearnResouceService {
    LearnResource queryLearnResouceById(Long learnResouce);
    List<LearnResource> queryLearnResouce(int pageNum, int pageSize);
}
