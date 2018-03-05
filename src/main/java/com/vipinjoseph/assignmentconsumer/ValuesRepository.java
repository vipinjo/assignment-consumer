package com.vipinjoseph.assignmentconsumer;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValuesRepository extends CrudRepository<Values, Long> {

}
