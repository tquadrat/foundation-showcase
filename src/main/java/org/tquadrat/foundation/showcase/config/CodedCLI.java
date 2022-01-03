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

import static java.lang.System.err;
import static java.lang.System.out;
import static java.util.Locale.ROOT;
import static org.apiguardian.api.API.Status.STABLE;
import static org.tquadrat.foundation.config.ConfigUtil.parseCommandLine;
import static org.tquadrat.foundation.config.ConfigUtil.printUsage;
import static org.tquadrat.foundation.util.StringUtils.format;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;

import org.apiguardian.api.API;
import org.tquadrat.foundation.annotation.ClassVersion;
import org.tquadrat.foundation.annotation.PlaygroundClass;
import org.tquadrat.foundation.config.CmdLineException;
import org.tquadrat.foundation.config.cli.BooleanValueHandler;
import org.tquadrat.foundation.config.cli.CmdLineValueHandler;
import org.tquadrat.foundation.config.cli.SimpleCmdLineValueHandler;
import org.tquadrat.foundation.config.cli.StringValueHandler;
import org.tquadrat.foundation.config.spi.CLIArgumentDefinition;
import org.tquadrat.foundation.config.spi.CLIDefinition;
import org.tquadrat.foundation.config.spi.CLIOptionDefinition;
import org.tquadrat.foundation.lang.StringConverter;

/**
 *  This class uses the programmatic approach for the CLI feature from the
 *  config project.
 *
 *  @version $Id: CodedCLI.java 934 2021-12-06 15:19:40Z tquadrat $
 *  @extauthor Thomas Thrien - thomas.thrien@tquadrat.org
 *  @UMLGraph.link
 *  @since 0.1.0
 */
@ClassVersion( sourceVersion = "$Id: CodedCLI.java 934 2021-12-06 15:19:40Z tquadrat $" )
@API( status = STABLE, since = "0.1.0" )
@PlaygroundClass
public final class CodedCLI
{
        /*------------*\
    ====** Attributes **=======================================================
        \*------------*/
    /**
     *  TODO Add a useful comment.
     */
    private BigDecimal m_BigDecimalArg;

    /**
     *  TODO Add a useful comment.
     */
    private BigDecimal m_BigDecimalOpt;

    /**
     *  TODO Add a useful comment.
     */
    private BigInteger m_BigIntegerArg;

    /**
     *  TODO Add a useful comment.
     */
    private BigInteger m_BigIntegerOpt;

    /**
     *  TODO Add a useful comment.
     */
    private boolean m_BooleanPrimitiveArg;

    /**
     *  TODO Add a useful comment.
     */
    private boolean m_BooleanPrimitiveOpt;

    /**
     *  TODO Add a useful comment.
     */
    private Boolean m_BooleanArg;

    /**
     *  TODO Add a useful comment.
     */
    private Boolean m_BooleanOpt;

    /**
     *  TODO Add a useful comment.
     */
    private byte m_BytePrimitiveArg;

    /**
     *  TODO Add a useful comment.
     */
    private byte m_BytePrimitiveOpt;

    /**
     *  TODO Add a useful comment.
     */
    private Byte m_ByteArg;

    /**
     *  TODO Add a useful comment.
     */
    private Byte m_ByteOpt;

    /**
     *  TODO Add a useful comment.
     */
    private char m_CharArg;

    /**
     *  TODO Add a useful comment.
     */
    private char m_CharOpt;

    /**
     *  TODO Add a useful comment.
     */
    private Character m_CharacterArg;

    /**
     *  TODO Add a useful comment.
     */
    private Character m_CharacterOpt;

    /**
     *  TODO Add a useful comment.
     */
    private Charset m_CharsetArg;

    /**
     *  TODO Add a useful comment.
     */
    private Charset m_CharsetOpt;

/*
org.tquadrat.foundation.util.stringconverter.ClassStringConverter
org.tquadrat.foundation.util.stringconverter.DayOfWeekStringConverter
org.tquadrat.foundation.util.stringconverter.DoubleStringConverter
org.tquadrat.foundation.util.stringconverter.DurationStringConverter
org.tquadrat.foundation.util.stringconverter.FileStringConverter
org.tquadrat.foundation.util.stringconverter.FloatStringConverter
org.tquadrat.foundation.util.stringconverter.InetAddressStringConverter
org.tquadrat.foundation.util.stringconverter.InstantStringConverter
org.tquadrat.foundation.util.stringconverter.IntegerStringConverter
org.tquadrat.foundation.util.stringconverter.LocalDateStringConverter
org.tquadrat.foundation.util.stringconverter.LocalDateTimeStringConverter
org.tquadrat.foundation.util.stringconverter.LocaleStringConverter
org.tquadrat.foundation.util.stringconverter.LocalTimeStringConverter
org.tquadrat.foundation.util.stringconverter.LongStringConverter
org.tquadrat.foundation.util.stringconverter.MonthStringConverter
org.tquadrat.foundation.util.stringconverter.PathStringConverter
org.tquadrat.foundation.util.stringconverter.PatternStringConverter
org.tquadrat.foundation.util.stringconverter.PeriodStringConverter
org.tquadrat.foundation.util.stringconverter.ShortStringConverter
org.tquadrat.foundation.util.stringconverter.StringStringConverter
org.tquadrat.foundation.util.stringconverter.TimeUnitStringConverter
org.tquadrat.foundation.util.stringconverter.TimeZoneStringConverter
org.tquadrat.foundation.util.stringconverter.URIStringConverter
org.tquadrat.foundation.util.stringconverter.URLStringConverter
org.tquadrat.foundation.util.stringconverter.UUIDStringConverter
org.tquadrat.foundation.util.stringconverter.YearMonthStringConverter
org.tquadrat.foundation.util.stringconverter.YearStringConverter
org.tquadrat.foundation.util.stringconverter.ZonedDateTimeStringConverter
org.tquadrat.foundation.util.stringconverter.ZoneIdStringConverter
 */

    /**
     *  TODO Add a useful comment.
     */
    private String m_StringArg;

    /**
     *  TODO Add a useful comment.
     */
    private String m_StringOpt;

        /*--------------*\
    ====** Constructors **=====================================================
        \*--------------*/
    /**
     *  Create an instance of {@code CodedCLI}.
     */
    @SuppressWarnings( "RedundantNoArgConstructor" )
    public CodedCLI() { /* Does nothing */ }

        /*---------*\
    ====** Methods **==========================================================
        \*---------*/
    /**
     *  Adds a CLI definition to the list.
     *
     *  @param  <T> The property type.
     *  @param  cliDefinitions  The list of the CLI definitions.
     *  @param  currentIndex    The current value for the argument index.
     *  @param  propertyClass   The class of the property.
     *  @param  optSetter   The option setter.
     *  @param  argSetter   The argument setter.
     *  @return The next argument index.
     */
    private final <T> int addDefinition( final Collection<? super CLIDefinition> cliDefinitions, final int currentIndex, final Class<? extends T> propertyClass, final BiConsumer<String,T> optSetter, final BiConsumer<String,T> argSetter )
    {
        final var stringConverter = StringConverter.forClass( propertyClass ).orElseThrow( () -> new IllegalArgumentException( format( "No StringConverter for '%s'", propertyClass.getName()) ) );
        final CmdLineValueHandler<T> optHandler = new SimpleCmdLineValueHandler<>( optSetter, stringConverter );
        final CmdLineValueHandler<T> argHandler = new SimpleCmdLineValueHandler<>( argSetter, stringConverter );

        final var propertyName = propertyClass.getSimpleName();
        final var optionName = format( "--o%s", propertyName );

        cliDefinitions.add(
            new CLIArgumentDefinition(
                propertyName, // The property name; not used in this context
                currentIndex, // The index for the argument
                format( "The argument %s", propertyName ), // The usage text for the help
                "MSGKEY_Argument", // The resource bundle key; not used here
                propertyName.toUpperCase( ROOT ), // The meta variable for the help
                true, // Arguments are usually required
                argHandler, // The value handler
                false, // The argument is not multi-value
                null   // No special format
            ) );

        cliDefinitions.add(
            new CLIOptionDefinition(
                propertyName, // The property name; not used in this context
                List.of( optionName ), // The option names
                format( "The option for %s", propertyName ), // The usage text for the help
               "MSGKEY_Option", // The resource bundle key; not used here
                format( "%S_VALUE", propertyName ), // The meta variable of the option value for the help
                false, // Options are usually optional …
                optHandler, // The value handler
                false, // The option value is not multi-value
                null// No special format
            ) );

        //---* Update the argument index *-------------------------------------
        final var retValue = currentIndex + 1;

        //---* Done *----------------------------------------------------------
        return retValue;
    }   //  addDefinition()

    /**
     *  Does the programs work.
     *
     *  @param  args    The command line arguments.
     *  @return {@code true} if the execution was successful, {@code false}
     *      otherwise.
     *  @throws IOException Cannot write the usage.
     */
    public final boolean execute( final String... args ) throws IOException
    {
        var argIndex = 0;
        final Collection<CLIDefinition> cliDefinitions = new ArrayList<>();

        //---* BigDecimal *----------------------------------------------------
        final BiConsumer<String,BigDecimal> bigDecimalArgSetter = ($,value) -> m_BigDecimalArg = value;
        final BiConsumer<String,BigDecimal> bigDecimalOptSetter = ($,value) -> m_BigDecimalOpt = value;
        argIndex = addDefinition( cliDefinitions, argIndex, BigDecimal.class, bigDecimalOptSetter, bigDecimalArgSetter );

        //---* BigInteger *----------------------------------------------------
        final BiConsumer<String,BigInteger> bigIntegerArgSetter = ($,value) -> m_BigIntegerArg = value;
        final BiConsumer<String,BigInteger> bigIntegerOptSetter = ($,value) -> m_BigIntegerOpt = value;
        argIndex = addDefinition( cliDefinitions, argIndex, BigInteger.class, bigIntegerOptSetter, bigIntegerArgSetter );

        //---* Byte *----------------------------------------------------------
        BiConsumer<String,Byte> byteArgSetter = ($,value) -> m_BytePrimitiveArg = value.byteValue();
        BiConsumer<String,Byte> byteOptSetter = ($,value) -> m_BytePrimitiveOpt = value.byteValue();
        argIndex = addDefinition( cliDefinitions, argIndex, byte.class, byteOptSetter, byteArgSetter );
        byteArgSetter = ($,value) -> m_ByteArg = value;
        byteOptSetter = ($,value) -> m_ByteOpt = value;
        argIndex = addDefinition( cliDefinitions, argIndex, Byte.class, byteOptSetter, byteArgSetter );

        //---* char and Character *--------------------------------------------
        BiConsumer<String,Character> charArgSetter = ($,value) -> m_CharArg = value.charValue();
        BiConsumer<String,Character> charOptSetter = ($,value) -> m_CharOpt = value.charValue();
        argIndex = addDefinition( cliDefinitions, argIndex, char.class, charOptSetter, charArgSetter );
        charArgSetter = ($,value) -> m_CharacterArg = value;
        charOptSetter = ($,value) -> m_CharacterOpt = value;
        argIndex = addDefinition( cliDefinitions, argIndex, Character.class, charOptSetter, charArgSetter );

        //---* Charset *-------------------------------------------------------
        final BiConsumer<String,Charset> charsetArgSetter = ($,value) -> m_CharsetArg = value;
        final BiConsumer<String,Charset> charsetOptSetter = ($,value) -> m_CharsetOpt = value;
        argIndex = addDefinition( cliDefinitions, argIndex, Charset.class, charsetOptSetter, charsetArgSetter );

        /*
         *  The types requiring special handling.
         */
        //---* Boolean *-------------------------------------------------------
        BiConsumer<String,Boolean> booleanArgSetter = ($,value) -> m_BooleanPrimitiveArg = value.booleanValue();
        BiConsumer<String,Boolean> booleanOptSetter = ($,value) -> m_BooleanPrimitiveOpt = value.booleanValue();
        CmdLineValueHandler<Boolean> booleanArgHandler = new BooleanValueHandler( booleanArgSetter );
        CmdLineValueHandler<Boolean> booleanOptHandler = new BooleanValueHandler( booleanOptSetter );
        cliDefinitions.add(
            new CLIArgumentDefinition(
                "boolean", // The property name; not used in this context
                argIndex++, // The index for the argument
                "The argument for boolean", // The usage text for the help
                "MSGKEY_Argument", // The resource bundle key; not used here
                "boolean", // The meta variable for the help
                true, // Arguments are usually required
                booleanArgHandler, // The value handler
                false, // The argument is not multi-value
                null // No special format
            ) );
        cliDefinitions.add(
            new CLIOptionDefinition(
                "boolean", // The property name; not used in this context
                List.of( "--oboolean" ), // The option names
                "The option for boolean", // The usage text for the help
                "MSGKEY_Option", // The resource bundle key; not used here
                "boolean_VALUE", // The meta variable of the option value for the help
                false, // Options are usually optional …
                booleanOptHandler, // The value handler
                false, // The option value is not multi-value
                null // No special format
            ) );
        cliDefinitions.add(
            new CLIOptionDefinition(
                "boolean", // The property name; not used in this context
                List.of( "--oboolean2" ), // The option names
                "The option for boolean", // The usage text for the help
                "MSGKEY_Option", // The resource bundle key; not used here
                "boolean_VALUE", // The meta variable of the option value for the help
                false, // Options are usually optional …
                booleanOptHandler, // The value handler
                false, // The option value is not multi-value
                null // No special format
            ) );
        booleanArgSetter = ($,value) -> m_BooleanArg = value;
        booleanOptSetter = ($,value) -> m_BooleanOpt = value;
        booleanArgHandler = new BooleanValueHandler( booleanArgSetter );
        booleanOptHandler = new BooleanValueHandler( booleanOptSetter );
        cliDefinitions.add(
            new CLIArgumentDefinition(
                "Boolean", // The property name; not used in this context
                argIndex++, // The index for the argument
                "The argument for boolean", // The usage text for the help
                "MSGKEY_Argument", // The resource bundle key; not used here
                "BOOLEAN", // The meta variable for the help
                true, // Arguments are usually required
                booleanArgHandler, // The value handler
                false, // The argument is not multi-value
                null // No special format
            ) );
        cliDefinitions.add(
            new CLIOptionDefinition(
                "Boolean", // The property name; not used in this context
                List.of( "--oBoolean" ), // The option names
                "The option for boolean", // The usage text for the help
                "MSGKEY_Option", // The resource bundle key; not used here
                "BOOLEAN_VALUE", // The meta variable of the option value for the help
                false, // Options are usually optional …
                booleanOptHandler, // The value handler
                false, // The option value is not multi-value
                null // No special format
            ) );
        cliDefinitions.add(
            new CLIOptionDefinition(
                "Boolean", // The property name; not used in this context
                List.of( "--oBoolean2" ), // The option names
                "The option for boolean", // The usage text for the help
                "MSGKEY_Option", // The resource bundle key; not used here
                "BOOLEAN_VALUE", // The meta variable of the option value for the help
                false, // Options are usually optional …
                booleanOptHandler, // The value handler
                false, // The option value is not multi-value
                null // No special format
            ) );

        //---* String *--------------------------------------------------------
        final BiConsumer<String,String> stringArgSetter = ($,value) -> m_StringArg = value;
        final BiConsumer<String,String> stringOptSetter = ($,value) -> m_StringOpt = value;
        final CmdLineValueHandler<String> stringArgHandler = new StringValueHandler( stringArgSetter );
        final CmdLineValueHandler<String> stringOptHandler = new StringValueHandler( stringOptSetter );
        cliDefinitions.add(
            new CLIArgumentDefinition(
                "String", // The property name; not used in this context
                argIndex++, // The index for the argument
                "The argument for String", // The usage text for the help
                "MSGKEY_Argument", // The resource bundle key; not used here
                "STRING", // The meta variable for the help
                true, // Arguments are usually required
                stringArgHandler, // The value handler
                false, // The argument is not multi-value
                null // No special format
            ) );
        cliDefinitions.add(
            new CLIOptionDefinition(
                "String", // The property name; not used in this context
                List.of( "--oString" ), // The option names
                "The option for String", // The usage text for the help
                "MSGKEY_Option", // The resource bundle key; not used here
                "STRING_VALUE", // The meta variable of the option value for the help
                false, // Options are usually optional …
                stringOptHandler, // The value handler
                false, // The option value is not multi-value
                null // No special format
            ) );

        //---* Parse the command line *----------------------------------------
        var retValue = false;
        try
        {
            parseCommandLine( cliDefinitions, args );
            retValue = true;
        }
        catch( final CmdLineException e )
        {
            err.println( e.getLocalizedMessage() );
            printUsage( err, Optional.empty(), getClass().getSimpleName(), cliDefinitions );
            retValue = false;
        }

        //---* Done *----------------------------------------------------------
        return retValue;
    }   //  execute()

    /**
     *  The program entry point.
     *
     *  @param  args    The command line arguments.
     */
    public static final void main( final String... args )
    {
        try
        {
            final var argfile = new File( "./org.tquadrat.foundation.showcase/src/test/resources/argfile" );
            assert argfile.exists() : "Cannot find file!";
            final var args1 = new String [] { format( "@%s", argfile.getCanonicalFile().getAbsolutePath() ) };
            final var application = new CodedCLI();
            application.execute( args1 );

            out.println( application.m_BigDecimalArg );
        }
        catch( @SuppressWarnings( "OverlyBroadCatchBlock" ) final Throwable t )
        {
            //---* Handle all previously unhandled exceptions here *-----------
            t.printStackTrace( err );
        }
    }   //  main()
}
//  class CodedCLI

/*
 *  End of File
 */