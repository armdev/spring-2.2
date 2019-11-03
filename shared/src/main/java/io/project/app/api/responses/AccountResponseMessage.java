package io.project.app.api.responses;

import io.project.app.domain.Notification;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author armena
 */
@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class AccountResponseMessage implements Serializable {

    private static final long serialVersionUID = 1L;
    private List<Notification> accounts = new ArrayList<>();

  
    

}
