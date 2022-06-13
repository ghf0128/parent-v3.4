package org.neo4j.server.enterprise;

import org.neo4j.server.BlockingBootstrapper;
import org.neo4j.server.Bootstrapper;
import org.neo4j.server.ServerBootstrapper;

/**
 * This class is copied from neo4j3.3 that used as the EntryPoint for enterprise edition.
 */

public class OpenEnterpriseEntryPoint
{

    private static Bootstrapper bootstrapper;

    private OpenEnterpriseEntryPoint()
    {
    }

    public static void main( String[] args )
    {
        int status = ServerBootstrapper.start( new OpenEnterpriseBootstrapper(), args );
        if ( status != 0 )
        {
            System.exit( status );
        }
    }

    public static void start( String[] args )
    {
        bootstrapper = new BlockingBootstrapper( new OpenEnterpriseBootstrapper() );
        System.exit( ServerBootstrapper.start( bootstrapper, args ) );
    }

    public static void stop( @SuppressWarnings( "UnusedParameters" ) String[] args )
    {
        if ( bootstrapper != null )
        {
            bootstrapper.stop();
        }
    }

}
