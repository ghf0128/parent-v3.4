package org.neo4j.server.enterprise;

import org.neo4j.causalclustering.core.CausalClusterConfigurationValidator;
import org.neo4j.configuration.HaConfigurationValidator;
import org.neo4j.kernel.GraphDatabaseDependencies;
import org.neo4j.kernel.configuration.Config;
import org.neo4j.kernel.configuration.ConfigurationValidator;
import org.neo4j.logging.LogProvider;
import org.neo4j.server.CommunityBootstrapper;
import org.neo4j.server.NeoServer;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Collection;

public class OpenEnterpriseBootstrapper extends CommunityBootstrapper
{

    @Override
    protected NeoServer createNeoServer( Config configurator, GraphDatabaseDependencies dependencies,
                                        LogProvider userLogProvider )
    {
        return new OpenEnterpriseNeoServer( configurator, dependencies, userLogProvider );
    }

    @Override
    @Nonnull
    protected Collection<ConfigurationValidator> configurationValidators()
    {
        ArrayList<ConfigurationValidator> validators = new ArrayList<>();
        validators.addAll( super.configurationValidators() );
        validators.add( new HaConfigurationValidator() );
        validators.add( new CausalClusterConfigurationValidator() );
        return validators;
    }

}
