package com.github.echcz.imgfs.service;

import com.github.echcz.imgfs.domain.Img;

public interface ImgService {
    Img find(String id);

    String save(Img img);

    void delete(String id);

    boolean exist(String id);
}
