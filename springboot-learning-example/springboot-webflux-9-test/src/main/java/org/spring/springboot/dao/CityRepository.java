package org.spring.springboot.dao;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import org.spring.springboot.domain.City;
import org.springframework.stereotype.Repository;


@Repository
public class CityRepository {

    private ConcurrentMap<Long, City> repository = new ConcurrentHashMap<>();

    private static final AtomicLong idGenerator = new AtomicLong(0);

    public City save(City city) {
        Long id = idGenerator.incrementAndGet();
        city.setId(id);
        repository.put(id, city);
        return city;
    }

    public Collection<City> findAll() {
        return repository.values();
    }


    public City findCityById(Long id) {
        return repository.get(id);
    }

    public City updateCity(City city) {
        repository.put(city.getId(), city);
        return city;
    }

    public Long deleteCity(Long id) {
        repository.remove(id);
        return id;
    }
}