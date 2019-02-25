package com.github.echcz.imgfs.service.impl;

import com.github.echcz.imgfs.dao.ImgDao;
import com.github.echcz.imgfs.domain.Img;
import com.github.echcz.imgfs.service.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ImgServiceImpl implements ImgService {
    private ImgDao imgDao;

    @Autowired
    public ImgServiceImpl(ImgDao imgDao) {
        this.imgDao = imgDao;
    }

    @Cacheable(value = "imgs", key = "#id", sync = true, unless = "#result == null")
    @Override
    public Img find(String id) {
        return imgDao.findById(id).orElse(null);
    }

    @Override
    public String save(Img img) {
        return imgDao.save(img).getId();
    }

    @CacheEvict(value = "imgs", key = "#id")
    @Override
    public void delete(String id) {
        imgDao.deleteById(id);
    }

    @Override
    public boolean exist(String id) {
        return imgDao.existsById(id);
    }
}
