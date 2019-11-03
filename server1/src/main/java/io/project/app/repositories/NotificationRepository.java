package io.project.app.repositories;

import io.project.app.domain.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author armena
 */
@Transactional
@Repository
public interface NotificationRepository extends MongoRepository<Notification, String> {
   

}
