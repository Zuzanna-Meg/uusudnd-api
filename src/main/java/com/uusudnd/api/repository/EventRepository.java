package com.uusudnd.api.repository;

import com.uusudnd.api.entity.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Long> {
}
