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

import static org.apiguardian.api.API.Status.STABLE;
import static org.tquadrat.foundation.config.ConfigUtil.getConfiguration;

import java.time.DayOfWeek;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apiguardian.api.API;
import org.tquadrat.foundation.annotation.ClassVersion;
import org.tquadrat.foundation.annotation.PropertyName;
import org.tquadrat.foundation.config.CLIBeanSpec;
import org.tquadrat.foundation.config.ConfigurationBeanSpecification;
import org.tquadrat.foundation.config.Option;

/**
 *  A configuration bean definition.
 *
 *  @extauthor Thomas Thrien - thomas.thrien@tquadrat.org
 *  @version $Id: CLIConfiguration.java 1054 2023-03-16 19:59:26Z tquadrat $
 *  @since 0.1.0
 *
 *  @UMLGraph.link
 */
@ClassVersion( sourceVersion = "$Id: CLIConfiguration.java 1054 2023-03-16 19:59:26Z tquadrat $" )
@API( status = STABLE, since = "0.1.0" )
@ConfigurationBeanSpecification( synchronizeAccess = true )
public interface CLIConfiguration extends CLIBeanSpec
{
        /*---------*\
    ====** Methods **==========================================================
        \*---------*/
    /**
     *  Returns the instance of the configuration bean.
     *
     *  @return The configuration bean instance.
     */
    public static CLIConfiguration getInstance()
    {
        final var retValue = getConfiguration( CLIConfiguration.class, configurationClass -> configurationClass.getConstructor().newInstance() );

        //---* Done *----------------------------------------------------------
        return retValue;
    }   //  getInstance()

    /**
     *  Returns the weekdays as set on the command line.
     *
     *  @return The weekdays.
     */
    @Option( name = "--day", required = true, metaVar = "DAY", usage = "The weekdays" )
    public Set<DayOfWeek> getDays();

    /**
     *  Returns the One-Two-Three as set on the command line.
     *
     *  @return The One-Two-Three.
     */
    @Option( name = "--ott", required = true, metaVar = "OTT", usage = "The One-Two-Three" )
    @PropertyName( "ott" )
    public Set<OneTwoThree> getOTT();

    /**
     *  Initialises the configuration bean.
     *
     *  @return The initialisation data.
     */
    @SuppressWarnings( "unused" )
    public default Map<String,Object> initData()
    {
        final Map<String,Object> retValue = new HashMap<>();
        retValue.put( "days", EnumSet.noneOf( DayOfWeek.class ) );
        retValue.put( "ott", EnumSet.noneOf( OneTwoThree.class ) );

        //---* Done *----------------------------------------------------------
        return retValue;
    }   //  initData()
}
//  interface CLIConfiguration

/*
 *  End of File
 */