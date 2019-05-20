package ${package}.validator;

import java.util.Arrays;
import java.util.stream.Collectors;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MyEnumValidator implements ConstraintValidator<MyEnum, String>
{
    private MyEnum annotation;
 
    @Override
    public void initialize(MyEnum annotation) {
        this.annotation = annotation;
    }
 
    @Override
    public boolean isValid(String valueForValidation, ConstraintValidatorContext constraintValidatorContext) {
        boolean result = false;
         
        Object[] enumValues = this.annotation.enumClass().getEnumConstants();
         
        if(enumValues != null) {
            for(Object enumValue:enumValues){
                if(valueForValidation.equals(enumValue.toString()) 
                   || (this.annotation.ignoreCase() && valueForValidation.equalsIgnoreCase(enumValue.toString()))) {
                    result = true; 
                    break;
                }
            }
        }                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
        if(!result) {
        	String enums = Arrays.stream(this.annotation.enumClass().getEnumConstants()).map(Enum::name)
        			.collect(Collectors.joining("," ));
        	
	        constraintValidatorContext.disableDefaultConstraintViolation();
	        constraintValidatorContext.buildConstraintViolationWithTemplate(constraintValidatorContext
	        		.getDefaultConstraintMessageTemplate()
	        		.concat(" [")
	        		.concat(enums)
	        		.concat("]"))
	        .addConstraintViolation();
        }
        return result;
    }
}