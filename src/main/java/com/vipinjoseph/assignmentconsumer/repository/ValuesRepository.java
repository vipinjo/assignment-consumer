package com.vipinjoseph.assignmentconsumer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vipinjoseph.assignmentconsumer.entity.Values;

@Repository
public interface ValuesRepository extends CrudRepository<Values, Long> {

}
