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

import static java.lang.System.out;
import static java.lang.System.setProperty;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.tquadrat.foundation.i18n.I18nUtil.composeTextKey;
import static org.tquadrat.foundation.i18n.I18nUtil.loadResourceBundle;
import static org.tquadrat.foundation.i18n.I18nUtil.retrieveMessage;
import static org.tquadrat.foundation.lang.CommonConstants.ISO8859_1;
import static org.tquadrat.foundation.lang.CommonConstants.PROPERTY_RESOURCEBUNDLE_ENCODING;
import static org.tquadrat.foundation.showcase.i18n.ClassWithTexts.BASE_BUNDLE_NAME;
import static org.tquadrat.foundation.showcase.i18n.ClassWithTexts.MESSAGE_PREFIX;
import static org.tquadrat.foundation.showcase.i18n.ClassWithTexts.MSG_CannotOpenSocket;
import static org.tquadrat.foundation.showcase.i18n.ClassWithTexts.MSG_NoResponseFromHost;

import java.util.ResourceBundle;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.tquadrat.foundation.annotation.ClassVersion;
import org.tquadrat.foundation.i18n.I18nUtil;
import org.tquadrat.foundation.testutil.TestBaseClass;

/**
 *  Some tests for
 *  {@link I18nUtil}.
 *
 *  @extauthor Thomas Thrien - thomas.thrien@tquadrat.org
 */
@ClassVersion( sourceVersion = "$Id: TestI18nUtil.java 890 2021-04-01 21:15:48Z tquadrat $" )
@DisplayName( "org.tquadrat.foundation.showcase.i18n.TestI18nUtil" )
public class TestI18nUtil extends TestBaseClass
{
        /*---------*\
    ====** Methods **==========================================================
        \*---------*/
    /**
     *  Test the translations for an enum.
     *
     *  @param  value   The {@code enum} value to test with.
     *  @throws Exception   Something went wrong unexpectedly.
     */
    @ParameterizedTest
    @EnumSource( CaseType.class )
    final void testEnumTranslation( final CaseType value ) throws Exception
    {
        skipThreadTest();

        setProperty( PROPERTY_RESOURCEBUNDLE_ENCODING, ISO8859_1.name() );

        final var bundleName = BASE_BUNDLE_NAME;
        final var resourceBundle = loadResourceBundle( bundleName );
        assertNotNull( resourceBundle );
        assertTrue( resourceBundle.isPresent() );

        final var key = composeTextKey( value );
        final var expected = resourceBundle.get().getString( key );
        assertEquals( expected, value.toString() );
    }   //  testEnumTranslation()

    /**
     *  Test to load the resource bundle.
     *
     *  @throws Exception   Something went wrong unexpectedly.
     */
    @Test
    final void testLoadResourceBundle() throws Exception
    {
        skipThreadTest();

        setProperty( PROPERTY_RESOURCEBUNDLE_ENCODING, ISO8859_1.name() );

        var bundleName = "Dummy";
        final var dummyBundle = loadResourceBundle( bundleName );
        assertNotNull( dummyBundle );
        assertTrue( dummyBundle.isEmpty() );

        bundleName = "TestBundle";
        ResourceBundle.getBundle( bundleName );
        final var testBundle = loadResourceBundle( bundleName );
        assertNotNull( testBundle );
        assertTrue( testBundle.isPresent() );

        bundleName = BASE_BUNDLE_NAME;
        ResourceBundle.getBundle( bundleName );
        final var resourceBundle = loadResourceBundle( bundleName );
        assertNotNull( resourceBundle );
        assertTrue( resourceBundle.isPresent() );
    }   //  testLoadResourceBundle()

    /**
     *  Tests for
     *  {@link org.tquadrat.foundation.i18n.I18nUtil#retrieveMessage(ResourceBundle, String, int, Object...)}
     *  and
     *  {@link org.tquadrat.foundation.i18n.I18nUtil#retrieveMessage(ResourceBundle, String, String, Object...)}.
     *
     *  @throws Exception   Something went wrong unexpectedly.
     */
    @Test
    final void testRetrieveMessage() throws Exception
    {
        skipThreadTest();

        setProperty( PROPERTY_RESOURCEBUNDLE_ENCODING, ISO8859_1.name() );

        String message;

        final var bundleName = BASE_BUNDLE_NAME;
        ResourceBundle.getBundle( bundleName );
        final var resourceBundle = loadResourceBundle( bundleName ).orElseThrow();
        assertNotNull( resourceBundle );

        message = retrieveMessage( resourceBundle, MESSAGE_PREFIX, MSG_CannotOpenSocket, true, 12345 );
        assertNotNull( message );
        assertFalse( message.isEmpty() );
        out.printf( "TestOutput: %s%n", message );

        message = retrieveMessage( resourceBundle, MESSAGE_PREFIX, MSG_NoResponseFromHost, false, "host", 150 );
        assertNotNull( message );
        assertFalse( message.isEmpty() );
        out.printf( "TestOutput: %s%n", message );
    }   //  testRetrieveMessage()

    /**
     *  Validates whether the class is static.
     */
    @Test
    final void validateClass()
    {
        assertTrue( validateAsStaticClass( I18nUtil.class ) );
    }   //  validateClass()
}
//  class TestI18nUtil

/*
 *  End of File
 */