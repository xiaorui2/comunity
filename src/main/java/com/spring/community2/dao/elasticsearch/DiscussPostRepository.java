package com.spring.community2.dao.elasticsearch;

import com.spring.community2.entity.DiscussPost;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @ClassName DiscussPostRepository
 * @Author ruizhou
 * @Date 2020/5/30 10:00
 **/
@Repository
public interface DiscussPostRepository extends ElasticsearchRepository<DiscussPost, Integer> {

}