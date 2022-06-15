/*
 * Copyright (c) 2002-2020 "Neo4j,"
 * Neo4j Sweden AB [http://neo4j.com]
 *
 * This file is part of Neo4j Enterprise Edition. The included source
 * code can be redistributed and/or modified under the terms of the
 * GNU AFFERO GENERAL PUBLIC LICENSE Version 3
 * (http://www.fsf.org/licensing/licenses/agpl-3.0.html) with the
 * Commons Clause, as found in the associated LICENSE.txt file.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * Neo4j object code can be licensed independently from the source
 * under separate terms from the AGPL. Inquiries can be directed to:
 * licensing@neo4j.com
 *
 * More information is also available at:
 * https://neo4j.com/licensing/
 */
package org.neo4j.com;

import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;

public class ServerUtil
{

    private ServerUtil()
    {
    }

    /**
     * Figure out the host string of a given socket address, similar to the Java 7 InetSocketAddress.getHostString().
     *
     * Calls to this should be replace once Neo4j is Java 7 only.
     *
     * @param socketAddress
     * @return
     */
    public static String getHostString( InetSocketAddress socketAddress )
    {
        if ( socketAddress.isUnresolved() )
        {
            return socketAddress.getHostName();
        }
        else
        {
            return socketAddress.getAddress().getHostAddress();
        }
    }

    /**
     * The method is used in the {@link org.neo4j.com.storecopy.StoreCopyServer} for getting the absolute file of the storeDirectory.
     *
     * @param file
     * @return
     */
    public static File getMostCanonicalFile(File file )
    {
        try
        {
            return file.getCanonicalFile().getAbsoluteFile();
        }
        catch ( IOException e )
        {
            return file.getAbsoluteFile();
        }
    }
}
