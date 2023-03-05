package com.pdd.wiki.service;

import com.pdd.wiki.domian.Animal;
import com.pdd.wiki.mapper.AnimalMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AnimalService {

    @Resource
    private AnimalMapper animalMapper;

    public List<Animal> animalList(){
        return animalMapper.animalList();
    }
}
