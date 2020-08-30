package com.zun.webservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping(path = "/filtering")
    public MappingJacksonValue retrieveSomeBean(){
        SomeBean someBean = new SomeBean("value1", "value2", "value3");
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1, field2");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        MappingJacksonValue mapper = new MappingJacksonValue(someBean);
        mapper.setFilters(filters);
        return mapper;
    }

    @GetMapping(path="/filtering-list")
    public MappingJacksonValue retrieveLostOfSomeBean(){
        List<SomeBean> someBeans = Arrays.asList(
                new SomeBean("value1", "value2", "value3"),
                new SomeBean("value1", "value2", "value3"),
                new SomeBean("value1", "value2", "value3"),
                new SomeBean("value1", "value2", "value3")
        );

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2, field3");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        MappingJacksonValue mapper = new MappingJacksonValue(someBeans);
        mapper.setFilters(filters);

        return mapper;
    }

}
