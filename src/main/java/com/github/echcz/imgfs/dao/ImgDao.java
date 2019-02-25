package com.github.echcz.imgfs.dao;

import com.github.echcz.imgfs.domain.Img;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImgDao extends MongoRepository<Img, String> {
}
