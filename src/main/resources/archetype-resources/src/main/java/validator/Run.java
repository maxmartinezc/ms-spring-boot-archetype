package ${package}.validator;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ FIELD, ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { RunValidator.class })
/**
 * RUN annotation
 * @author max.martinez
 *
 */
public @interface Run {

	String message() default "Run no valido";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
