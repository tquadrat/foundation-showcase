/*
 * ============================================================================
 *  Copyright © 2002-2024 by Thomas Thrien.
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

import java.io.Serializable;
import java.util.EventListener;

import org.apiguardian.api.API;
import org.tquadrat.foundation.annotation.ClassVersion;

/**
 *  <p>{@summary This class serves a sample for the Foundation Library Javadoc
 *  extension.}</p>
 *  <p>The comments will make use of all the various custom taglets defined
 *  in that Javadoc extension. Between the brackets, there is ignored text:
 *  [{@ignore This text <i>is ignored</i>! And it runs over multiple lines, not
 *  just one! Unfortunately, Eclipse as significant problems with this kind of
 *  comment.}]
 *  {@underline So is this underlined text}. And {@anchor #anchor this} an
 *  anchor.</p>
 *  <p>And {@href #anchor this} is the link to the anchor above.</p>
 *
 *  @note   This class does not anything useful, anything it contains is just
 *      used input to Javadoc.
 *  @note   This is {@literal literal text in a <note>}.
 *  @note   This is {@code code} in a note.
 *  @note   We refer here to
 *      {@link java.lang.String}! Unfortunately, {@code @link} tags don't work
 *      in a {@code @node} block.
 *
 *  @extauthor Thomas Thrien - thomas.thrien@tquadrat.org
 *  @modified  Thomas Thrien - thomas.thrien@tquadrat.org
 *  @thanks  Thomas Thrien - thomas.thrien@tquadrat.org
 *  @inspired Several Java books and some open source projects.
 *
 *  @version $Id: Sample.java 1105 2024-02-28 12:58:46Z tquadrat $
 *
 *  @UMLGraph.link
 *  @since 0.1.0
 */
@ClassVersion( sourceVersion = "$Id: Sample.java 1105 2024-02-28 12:58:46Z tquadrat $" )
@API( status = STABLE, since = "0.1.0" )
public class Sample implements Serializable, EventListener, AnInterface
{
        /*------------*\
    ====** Attributes **=======================================================
        \*------------*/
/*SNIP_START*/
    /**
     *  <p>{@summary A field.}</p>
     *  <p>{ include {source}/org/tquadrat/foundation/showcase/javadoc/doc-files/SimpleInclude.txt}</p>
     *
     *  @serial
     */
    @SuppressWarnings( "unused" )
    private String m_Field;
/*SNIP_END*/

        /*--------------*\
    ====** Constructors **=====================================================
        \*--------------*/
    /**
     *  Creates a new instance of {@code Sample}.
     */
    public Sample() { /* Just exists. */ }

        /*---------*\
    ====** Methods **==========================================================
        \*---------*/
/*SNIP_START*/
    /**
     *  <p>{@summary A method.}</p>
     *  <p>{@include ${source}/org/tquadrat/foundation/showcase/javadoc/doc-files/SimpleInclude.txt}</p>
     *
     *  @return A value.<br>
     *      <br>{@include ${source}/org/tquadrat/foundation/showcase/javadoc/doc-files/SimpleInclude.txt}
     */
    @Override
    public final String method() { return m_Field; }
    /*SNIP_END*/

    /**
     *  {@inheritDoc}
     */
    @Override
    public final void oneMoreMethod() { /* Does nothing! */  }
}
//  class Sample

/*
 *  End of File
 */