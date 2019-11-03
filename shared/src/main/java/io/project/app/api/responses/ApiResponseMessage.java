package io.project.app.api.responses;

import java.io.Serializable;
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
public class ApiResponseMessage implements Serializable {

    private static final long serialVersionUID = 4140121893514750179L;
    private String message;

}