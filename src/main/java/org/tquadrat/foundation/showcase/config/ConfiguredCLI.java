/*
 * ============================================================================
 *  Copyright © 2002-2023 by Thomas Thrien.
 *  All Rights Reserved.
 * ============================================================================
 *  Licensed to the public under the agreements of the GNU Lesser General Public
 *  License, version 3.0 (the "License"). You may obtain a copy of the License at
 *
 *       http://www.gnu.org/licenses/lgpl.html
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 *  WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 *  License for the specific language governing permissions and limitations
 *  under the License.
 */

package org.tquadrat.foundation.showcase.config;

import static java.lang.System.err;
import static java.lang.System.out;
import static org.apiguardian.api.API.Status.STABLE;

import org.apiguardian.api.API;
import org.tquadrat.foundation.annotation.ClassVersion;
import org.tquadrat.foundation.annotation.ProgramClass;

/**
 *  Shows the use of the configure CLI.
 *
 *  @extauthor Thomas Thrien - thomas.thrien@tquadrat.org
 *  @version $Id: ConfiguredCLI.java 1075 2023-10-02 12:37:07Z tquadrat $
 *  @since 0.1.0
 *
 *  @UMLGraph.link
 */
@ClassVersion( sourceVersion = "$Id: ConfiguredCLI.java 1075 2023-10-02 12:37:07Z tquadrat $" )
@API( status = STABLE, since = "0.1.0" )
@ProgramClass
public final class ConfiguredCLI
{
        /*--------------*\
    ====** Constructors **=====================================================
        \*--------------*/
    /**
     *  No instance allowed for this class.
     */
    private ConfiguredCLI() { /* Just exists */ }

        /*---------*\
    ====** Methods **==========================================================
        \*---------*/
    /**
     *  The program entry point.
     *
     *  @param  args    The command line arguments.
     */
    @SuppressWarnings( "UseOfSystemOutOrSystemErr" )
    public static final void main( final String... args )
    {
        //noinspection OverlyBroadCatchBlock
        try
        {
            final var configuration = CLIConfiguration.getInstance();
            if( configuration.parseCommandLine( args ) )
            {
                out.println( configuration.getDays() );
            }
            else
            {
                configuration.retrieveParseErrorMessage().ifPresent( err::println );
                configuration.printUsage( err, ConfiguredCLI.class.getSimpleName() );
            }
        }
        catch( final Throwable t )
        {
            t.printStackTrace( err );
        }
    }   //  main()
}
//  class ConfiguredCLI

/*
 *  End of File
 */