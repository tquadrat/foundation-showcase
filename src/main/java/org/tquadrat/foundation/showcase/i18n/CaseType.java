/*
 * ============================================================================
 *  Copyright © 2002-2021 by Thomas Thrien.
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

package org.tquadrat.foundation.showcase.i18n;

import static org.apiguardian.api.API.Status.STABLE;
import static org.tquadrat.foundation.i18n.I18nUtil.loadResourceBundle;
import static org.tquadrat.foundation.i18n.I18nUtil.resolveText;
import static org.tquadrat.foundation.showcase.i18n.ClassWithTexts.BASE_BUNDLE_NAME;

import org.apiguardian.api.API;
import org.tquadrat.foundation.annotation.ClassVersion;
import org.tquadrat.foundation.i18n.Text;
import org.tquadrat.foundation.i18n.Translation;

/**
 *  An {@code enum} that is used to demonstrate how {@code enum} values will be
 *  localised.
 *
 *  @version $Id: CaseType.java 889 2021-03-30 21:21:32Z tquadrat $
 *  @extauthor Thomas Thrien - thomas.thrien@tquadrat.org
 *  @UMLGraph.link
 *  @since 0.1.0
 */
@ClassVersion( sourceVersion = "$Id: CaseType.java 889 2021-03-30 21:21:32Z tquadrat $" )
@API( status = STABLE, since = "0.1.0" )
public enum CaseType
{
        /*------------------*\
    ====** Enum Definitions **=================================================
        \*------------------*/
    /**
     *  A case.
     */
    @Text( description = "A case",
        translations =
        {
            @Translation( language = "de", text = "Fall" ),
            @Translation( language = "en", text = "Case" )
        }
    )
    CASE,

    /**
     *  An event.
     */
    @Text( description = "An event",
        translations =
        {
            @Translation( language = "de", text = "Ereignis" ),
            @Translation( language = "en", text = "Event" )
        }
    )
    EVENT,

    /**
     *  An incident.
     */
    @Text( description = "An incident",
        translations =
        {
            @Translation( language = "de", text = "Störung" ),
            @Translation( language = "en", text = "Incident" )
        }
    )
    INCIDENT;

        /*---------*\
    ====** Methods **==========================================================
        \*---------*/
    /**
     *  {@inheritDoc}
     */
    @Override
    public final String toString()
    {
        /*
         * Usually, we will not pull the resource bundle for each call; instead
         * it should be loaded once and be kept in a public constant, or alike.
         */
        final var resourceBundle = loadResourceBundle( BASE_BUNDLE_NAME );
        final var retValue = resolveText( resourceBundle, this );

        //---* Done *----------------------------------------------------------
        return retValue;
    }   //  toString()
}
//  enum CaseType

/*
 *  End of File
 */