package molsen.auth;

import org.glassfish.jersey.server.internal.inject.AbstractContainerRequestValueFactory;

public class PartnerParameterFactory extends AbstractContainerRequestValueFactory<SecurePartnerDTO> {

    private final PartnerHeaderAuthenticator partnerHeaderAuthenticator = new PartnerHeaderAuthenticator();

    @Override
    public SecurePartnerDTO provide() {
        return partnerHeaderAuthenticator.authenticate(getContainerRequest()).get();
    }

}
