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

package org.tquadrat.foundation.showcase.javadoc;

import static org.apiguardian.api.API.Status.STABLE;

import org.apiguardian.api.API;
import org.tquadrat.foundation.annotation.ClassVersion;

/**
 *  <p>{@summary A record.}</p>
 *  <p>{@include ${source}/org/tquadrat/foundation/showcase/javadoc/doc-files/SimpleInclude.txt}</p>
 *
 *  @param  value   A value.<br>
 *      <br>{@include ${source}/org/tquadrat/foundation/showcase/javadoc/doc-files/SimpleInclude.txt}
 *
 *  @version $Id: ARecord.java 934 2021-12-06 15:19:40Z tquadrat $
 *
 *  @extauthor Thomas Thrien - thomas.thrien@tquadrat.org
 *  @UMLGraph.link
 *  @since 0.1.0
 */
@ClassVersion( sourceVersion = "$Id: ARecord.java 934 2021-12-06 15:19:40Z tquadrat $" )
@API( status = STABLE, since = "0.1.0" )
public record ARecord( int value )
{
        /*-----------*\
    ====** Constants **========================================================
        \*-----------*/

        /*------------------------*\
    ====** Static Initialisations **===========================================
        \*------------------------*/

        /*--------------*\
    ====** Constructors **=====================================================
        \*--------------*/

        /*---------*\
    ====** Methods **==========================================================
        \*---------*/
}
//  record ARecord

/*
 *  End of File
 */