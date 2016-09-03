package molsen.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Used with {@link PartnerParameterInjectionResolver}, informs Jersey that we require authentication on this API call
 * and to inject the partner information into the API.
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface Secure {
}
