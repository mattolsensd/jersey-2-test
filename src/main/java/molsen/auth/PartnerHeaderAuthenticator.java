package molsen.auth;

import org.glassfish.jersey.server.ContainerRequest;

import javax.inject.Singleton;
import java.util.Optional;

@Singleton
public class PartnerHeaderAuthenticator {

    public Optional<SecurePartnerDTO> authenticate(ContainerRequest request) {
        return Optional.of(new SecurePartnerDTO(1L, "PartnerName"));
    }

}
