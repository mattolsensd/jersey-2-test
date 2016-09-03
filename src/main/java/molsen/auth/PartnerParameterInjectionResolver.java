package molsen.auth;

import org.glassfish.jersey.server.internal.inject.ParamInjectionResolver;

/**
 * Informs Jersey that we require authentication on this API call and to inject the partner information into the API.
 */
public class PartnerParameterInjectionResolver extends ParamInjectionResolver<Secure> {

    public PartnerParameterInjectionResolver() {
        super(PartnerParameterFactoryProvider.class);
    }
}
