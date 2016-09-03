package molsen;

import molsen.auth.PartnerParameterFactoryProvider;
import molsen.auth.PartnerParameterInjectionResolver;
import molsen.auth.Secure;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.hk2.api.InjectionResolver;
import org.glassfish.hk2.api.TypeLiteral;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spi.internal.ValueFactoryProvider;
import org.glassfish.jersey.servlet.ServletContainer;

import javax.inject.Singleton;

public class App {
    public static void main(String[] args) throws Exception {
        ResourceConfig config = new ResourceConfig();
        config.packages("molsen");
        ServletHolder servlet = new ServletHolder(new ServletContainer(config));

        config.register(new AbstractBinder() {
            @Override
            protected void configure() {
                bind(PartnerParameterInjectionResolver.class)
                        .to(new TypeLiteral<InjectionResolver<Secure>>() {
                        }).in(Singleton.class);

                bind(PartnerParameterFactoryProvider.class)
                        .to(ValueFactoryProvider.class)
                        .in(Singleton.class);
            }
        });

        Server server = new Server(8080);
        ServletContextHandler context = new ServletContextHandler(server, "/*");
        context.addServlet(servlet, "/*");

        try {
            server.start();
            server.join();
        } finally {
            server.destroy();
        }
    }
}
