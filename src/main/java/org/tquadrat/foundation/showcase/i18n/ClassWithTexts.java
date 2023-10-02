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

package org.tquadrat.foundation.showcase.i18n;

import static org.apiguardian.api.API.Status.STABLE;

import org.apiguardian.api.API;
import org.tquadrat.foundation.annotation.ClassVersion;
import org.tquadrat.foundation.annotation.UtilityClass;
import org.tquadrat.foundation.exception.PrivateConstructorForStaticClassCalledError;
import org.tquadrat.foundation.i18n.BaseBundleName;
import org.tquadrat.foundation.i18n.I18nUtil;
import org.tquadrat.foundation.i18n.Message;
import org.tquadrat.foundation.i18n.MessagePrefix;
import org.tquadrat.foundation.i18n.Text;
import org.tquadrat.foundation.i18n.TextUse;
import org.tquadrat.foundation.i18n.Translation;
import org.tquadrat.foundation.i18n.UseAdditionalTexts;

/**
 *  A class with texts and message for the text of the I18N annotation
 *  processor.
 *
 *  @version $Id: ClassWithTexts.java 1075 2023-10-02 12:37:07Z tquadrat $
 *
 *  @extauthor Thomas Thrien - thomas.thrien@tquadrat.org
 *  @UMLGraph.link
 *  @since 0.1.0
 */
@ClassVersion( sourceVersion = "$Id: ClassWithTexts.java 1075 2023-10-02 12:37:07Z tquadrat $" )
@API( status = STABLE, since = "0.1.0" )
@UseAdditionalTexts
@UtilityClass
public final class ClassWithTexts
{
        /*-----------*\
    ====** Constants **========================================================
        \*-----------*/
    /**
     *  Caption for the title of the book.
     */
    @SuppressWarnings( "unused" )
    @Text
    (
        description = "The caption for the input field that takes the title of a book",
        id = "BookTitle1",
        use = TextUse.CAPTION,
        translations =
        {
            @Translation( language = "en", text = "Book Title" ),
            @Translation( language = "de", text = "Buchtitel" )
        }
    )
    private static final String m_BookTitleCaption = I18nUtil.composeTextKey( ClassWithTexts.class, TextUse.CAPTION, "BookTitle1" );

    /**
     *  Caption for the title of the book.
     */
    @SuppressWarnings( "unused" )
    @Text
    (
        description = "The caption for the input field that takes the title of a book",
        translations =
        {
            @Translation( language = "en", text = "Book Title" ),
            @Translation( language = "de", text = "Buchtitel" )
        }
    )
    private static final String CAPTION_BookTitle2 = I18nUtil.composeTextKey( ClassWithTexts.class, TextUse.CAPTION, "BookTitle2" );

    /**
     *  The name of the base bundle: {@value}.
     */
    @SuppressWarnings( "DefaultAnnotationParam" )
    @BaseBundleName( defaultLanguage = "de_DE" )
    public static final String BASE_BUNDLE_NAME = "org.tquadrat.foundation.showcase.TxtAndMsg";

    /**
     *  The message prefix: {@value}.
     */
    @MessagePrefix
    public static final String MESSAGE_PREFIX = "SHOWCASE";

    /**
     *  Message: Cannot open socket.
     */
    @Message
    (
        description = "This message indicates that the socket could not be opened to listen on the given port",
        translations =
        {
            @Translation( language = "en", text = "Cannot open socket on port '%d'" ),
            @Translation( language = "de", text = "Socket kann auf Port '%d' nicht geöffnet werden" )
        }
    )
    public static final int MSG_CannotOpenSocket = 1704;

    /**
     *  Message: No response from host.
     */
    @Message
    (
        description = "This message indicates that the host with the given name does not respond in time",
        translations =
        {
            @Translation( language = "en", text = "Host '%1$s' does not respond within %2$d milliseconds" ),
            @Translation( language = "de", text = "Der Host '%1$s' hat nicht innerhalb von %2$d ms geantwortet" )
        }
    )
    public static final String MSG_NoResponseFromHost = "NoResponseFromHost";

        /*------------*\
    ====** Attributes **=======================================================
        \*------------*/

        /*------------------------*\
    ====** Static Initialisations **===========================================
        \*------------------------*/

        /*--------------*\
    ====** Constructors **=====================================================
        \*--------------*/
    /**
     *  No instance allowed for this class.
     */
    private ClassWithTexts() { throw new PrivateConstructorForStaticClassCalledError( ClassWithTexts.class ); }

        /*---------*\
    ====** Methods **==========================================================
        \*---------*/
    /**
     *  Returns the owner.
     *
     *  @return The owner.
     */
    @Text
    (
        description = "The name of the property 'owner'",
        translations =
        {
            @Translation( language = "en", text = "Proprietor/Proprietress" ),
            @Translation( language = "de", text = "Eigentümer/Eigentümerin" )
        }
    )
    @Text
    (
        description = "The caption for the property 'owner'",
        use = TextUse.CAPTION,
        translations =
        {
            @Translation( language = "en", text = "Proprietor (Lastname, Firstname): " ),
            @Translation( language = "de", text = "Eigentümer (Hausname, Vorname): " )
        }
    )
    @Text
    (
        description = "The tooltip for the property 'owner'",
        use = TextUse.TOOLTIP,
        translations =
        {
            @Translation( language = "en", text = "The name of the proprietor" ),
            @Translation( language = "de", text = "Der Name des Eigentümers" )
        }
    )
    @Text
    (
        description = "The usage text for the property 'owner'",
        use = TextUse.USAGE,
        translations =
        {
            @Translation( language = "en", text = "The name of the proprietor" ),
            @Translation( language = "de", text = "Der Name des Eigentümers" )
        }
    )
    public String getOwner() { return "Owner"; }
}
//  class ClassWithTexts

/*
 *  End of File
 */