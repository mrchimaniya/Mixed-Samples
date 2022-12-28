package com.divergentsl.controller;

import com.divergentsl.entity.Sorting;
import com.divergentsl.repo.SortingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sort")
public class SortingController {

    @Autowired
    SortingRepository sortingRepository;

    @RequestMapping("/")
    @ResponseBody
    public String sayHello()
    {
        return "Hello";
    }

    @GetMapping("/add")
    @ResponseBody
    public String addRecord()
    {
        for(int i=1;i<=50; i++)
        {
            Sorting sort=new Sorting();
            sort.setId(i);
            sort.setRollno(100+1);
            sort.setName(String.valueOf(500-i));

            sortingRepository.save(sort);

        }
      return "Added Sucessfully";
    }

    @GetMapping("/showAll")
    public List<Sorting> showAll()
    {
        List<Sorting> sortData = sortingRepository.findAll();
        return sortData;

    }

    @GetMapping("/showAllSort/{name}")
    public List<Sorting> showAllSort(@PathVariable String  name)
    {
        List<Sorting> sortData = sortingRepository.findAll(Sort.by(Sort.Direction.ASC,name));
        return sortData;
    }
    
}
