package molsen.auth;

import org.glassfish.hk2.api.Factory;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.jersey.server.internal.inject.AbstractValueFactoryProvider;
import org.glassfish.jersey.server.internal.inject.MultivaluedParameterExtractorProvider;
import org.glassfish.jersey.server.model.Parameter;

import javax.inject.Inject;

public class PartnerParameterFactoryProvider extends AbstractValueFactoryProvider {

    @Inject
    public PartnerParameterFactoryProvider(MultivaluedParameterExtractorProvider mpep, ServiceLocator locator) {
        super(mpep, locator, Parameter.Source.UNKNOWN);
    }

    @Override
    protected Factory<?> createValueFactory(Parameter parameter) {
        if (!parameter.isAnnotationPresent(Secure.class)
                || !SecurePartnerDTO.class.equals(parameter.getRawType())) {
            return null;
        }
//        return new AbstractContainerRequestValueFactory<String>() {
//            @Override
//            public String provide() {
//                //return getContainerRequest().getHeaderString();
//                return "Hello";
//            }
//        };
        return new PartnerParameterFactory();
    }
}
