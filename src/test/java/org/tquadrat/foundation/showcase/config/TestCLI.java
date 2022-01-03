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

package org.tquadrat.foundation.showcase.config;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.tquadrat.foundation.util.StringUtils.format;

import java.io.File;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.tquadrat.foundation.annotation.ClassVersion;
import org.tquadrat.foundation.testutil.TestBaseClass;

/**
 *  Performs tests related to the CLI feature from the config project.
 *
 *  @extauthor Thomas Thrien - thomas.thrien@tquadrat.org
 *  @version $Id: TestCLI.java 898 2021-04-06 23:19:36Z tquadrat $
 */
@ClassVersion( sourceVersion = "$Id: TestCLI.java 898 2021-04-06 23:19:36Z tquadrat $" )
@DisplayName( "org.tquadrat.foundation.showcase.config.TestCLI" )
public class TestCLI extends TestBaseClass
{
        /*---------*\
    ====** Methods **==========================================================
        \*---------*/
    /**
     *  Uses the coded CLI.
     *
     *  @throws Exception   Something went wrong unexpectedly.
     */
    @Test
    final void testCodedCLI() throws Exception
    {
        skipThreadTest();

        final var argfile = new File( "./src/test/resources/argfile" );
        assertTrue( argfile.exists() );
        final var candidate = new CodedCLI();
        final var args = new String [] { format( "@%s", argfile.getCanonicalFile().getAbsolutePath() ) };
        assertTrue( candidate.execute( args ) );
    }   //  testCodedCLI()
}
//  class TestCLI

/*
 *  End of File
 */