
Oracle JDBC Drivers release 9.2.0 README
=============================================


What Is New In This Release Since 9.0.2 ?
-----------------------------------------

New classes file name for JDK 1.4 and beyond
    Beginning with this release the classes files for JDK 1.4 and
    beyond will be named ojdbc<jdk ver>.jar. So, the classes file for
    JDK 1.4 is named ojdbc14.jar.  The names for the JDK 1.1
    and 1.2 classes files will not be changed. We will not provide
    .zip versions of the classes files beyond JDK 1.2.

Direct support for LOBs in the Thin driver.
    The Thin driver now provides direct support for BFILEs, BLOBs, and
    CLOBs. Prior to this release it supported them via calls to PL/SQL
    routines. 

Statement Caching
    The Oracle statement caching API has been changed. There were
    substantial problems with the previous API and we were able to
    resolve them only by changing the API. The old API is still
    supported, but is deprecated. For details on the new API see the
    JavaDoc. 

Certified with RAC
    The Oracle JDBC drivers are certified to work correctly in an
    Oracle 9i RAC environment.

JDBC 3.0 feature support
    A few critical JDBC 3.0 features are supported.

    JDK 1.4--JDK 1.4 is supported with ojdbc14.jar and
    nls_charset12.jar. 

    Toggling between global and local transactions--When using an XA
    connection an application can toggle between global and local
    transactions. 

    Savepoints--Savepoints are supported in ojdbc14.jar. They are also
    supported in classes12 and classes11 via Oracle extensions. The
    extensions are forward compatible with ojdbc14.jar. See the
    JavaDoc for more details.

    Reuse of prepared statements--PreparedStatements can be used with
    different pooled connections. This is an important performance
    improvement for middle tier applications.

Connection wrapping
    It is now possible to seamlessly wrap an OracleConnection instance
    with a user defined class that implements
    oracle.jdbc.OracleConnection. Such a wrapper can be used where
    ever a Connection argument is needed (except CustomDatum) and will
    be returned as the value of getConnection. It is recommended that
    users subclass oracle.jdbc.OracleConnectionWrapper if
    possible. If not then base your implementation on the source for
    OracleConnectionWrapper which can be found in the samples
    directory. 

Deprecate RAW(Object) constructor
    The constructor RAW(Object) has been deprecated. It will not be
    removed, but its behavior will be changed in the next major
    release. At present it has a documented, but anomolous behavior
    when passed a String object. It constructs a RAW containing the
    byte representation of the String in the platform encoding. All
    other transformations between Strings and RAWs assume that the
    String is the hex character representation of the bytes in the
    RAW. In the next major release this constructor will be changed to
    conform to that convention. This will also impact ADTs with RAW
    fields constructed from Strings. Two static methods have been
    added to RAW. oldRAW(Object) will always have the current platform
    encoding behavior. newRAW(Object) will always have the hex
    character behavior. See the JavaDoc for more details.

DMS metrics
    The DMS metrics reported by JDBC when using classes12dms.jar have
    been reorganized. Additional metrics on Statements including
    execution and fetch time are reported.

defineColumnType(int, int) of CHAR or VARCHAR column
    Calling defineColumnType as CHAR or VARCHAR and not passing a size
    will now raise a SQLWarining. Beginning in the next major release
    it will throw a SQLException.

OracleLog
    Significant increase in the number of methods that include calls
    to OracleLog. Also, you can enable OracleLog tracing by setting
    system properties. Set oracle.jdbc.Trace to "true" to enable
    tracing. Set oracle.jdbc.LogFile to set the name of the trace
    output file. If this is not set trace output is sent to
    System.out. OracleLog tracing is only available in the debug
    classes files, classes111_g.*, classes12_g.*, and ojdbc_g.jar.

Support for services in URLs
    Oracle is replacing the SID mechanism for identifying databases
    with a new services approach. This has been available in the
    database since 8.1.7. JDBC now supports services in the connect
    URL for the Thin driver. We strongly encourage everyone to
    transition from SIDs to services as quickly as possible as SIDs
    will be cease to be supported in one of the next few releases of
    the database.

    The basic format of a service URL is:

      jdbc:oracle:thin:[<user>/<password>]@//<host>[:<port>]/<service>

    Example:

      jdbc:oracle:thin:@//myserver.com/customer_db

    For more info see the JDBC User Guide.



Major bugs fixed in since 9.0.2:
--------------------------------

BUG-1324918
    The JDBC OCI driver can consume temporary tablespace when it is
    used to update a CLOB with PreparedStatement.setCharacterStream()
    repeatedly.  In such situation, either the temp tablespace will
    continue to grow, or you may get this exception in thread "main":
    java.sql.SQLException: ORA-01652: unable to extend segment if
    you have a limit on the tablespace size.  The workaround is to 
    use oracle.sql.CLOB::setCharacterOutputStream() instead.

BUG-1591421 (since 9.0.0)
    A connection created from the connection cache fails to pass the
    default batch value to the statement object.

BUG-1630414 (since 9.0.0)
    After a type evolution is performed on an existing type, objects
    of the evolved type cannot be retrieved via JDBC.

BUG-1730903 (since 9.0.0)
    setFormOfUse() method must be put before blinding/definding SQL 
    NCHAR datatypes.  For example, setString() and 
    registerOutParameter() has to be called after setFormOfUse().
    Otherwise, unpredictable results will be received.  This 
    restriction applies to all JDBC drivers.

BUG-1714281 (since 9.0.1)
    The maximum number of characters can be inserted into NCHAR 
    datatypes using setString() is less than the database maximum 
    size if the database character set is neither US7ASCII nor 
    WE8ISO8859P1.  This restriction applies to JDBC Thin and Thin 
    Server-side drivers.  Workaround is to use setCharacterStream().

BUG-1720657 ( since 9.0.1)
    Java code runing on the server which uses the KPRB driver to execute
    multiple create type statements may cause server crashes. Similar
    problems exist if a PL/SQL block uses execute immediate to execute
    the same statements. The workaround is to use the thin driver or to
    perform the needed operations another way.

Bug-2100396 
    transaction isolation level is not reset when using JDBC api

Bug-2100385 
    JDBC cache does not handle inactivity timeout for xaconnections

Bug-2100350
    JDBC cache does not work for inactivity timeout

Bug-2018316 
    getConnection should ignore case for user/passwd, setCache should
    take string

Bug-2013416 
    JDBC connection cache does not have any timeouts

BUG 1868371 - setCHAR() does not convert from the CHAR object's
    charset to the db char set This JDBC limitation since 8.1.6 is
    removed in 9iR2. Previously constructing a Oracle.sql.CHAR data
    type with the following statement requires to use either UTF8,
    US7ASCII or WE8ISO8859P1 in the "char set" part for database SQL
    CHAR datatypes (limitation did apply to database object and SQL
    NCHAR datatypes) stmt.setCHAR(1, new CHAR(<bytes>, <char set>);

BUG 1730903 - data corruption with setFormOfUse() after
    registerOutParameter(). This JDBC limitation since 9.0.1 is removed
    in 9iR2

BUG 1714281 - SQLException with setString() of a long string to
    SQL NCHAR datatypes This THIN driver specific limitation since
    9.0.1 is removed in 9iR2.  setString() can now blind the same size
    of data as in database for SQL NCHAR datatypes

BUG 2012717 - AVOID THE RESETTING OF NLS_LANG IN JDBC-OCI DRIVER
    Since 7.3.4, JDBC-OCI driver reset NLS_LANG internally to ".UTF8" 
    when the client character set is neither US7ASCII nor
    WE8ISO8859P1.  This means that in a child process fork out from
    JDBC-OCI, UTF8 data is returned no matter what the NLS_LANG is set
    to. In 9iR2, this limitation is removed.  Data are returned in the
    same charset encoding as the client character set.

BUG-1018797
    Extra characters may be appended to the end of a CLOB value
    mistakenly under the following conditions:
    - setCharacterStream() is used to insert a CLOB value, and
    - The Oracle server uses multi-byte character set.


Driver Versions
---------------

These are the driver versions in the 9.2.0 release:

  - JDBC OCI Driver 9.2.0
    Client-side JDBC driver for use on a machine where OCI 9.2.0 is
    installed.

  - JDBC Thin Driver 9.2.0
    100% Java client-side JDBC driver for use in Java applets and
    applications.

  - JDBC Thin Server-side Driver 9.2.0
    JDBC driver for use by Java Stored Procedures or by Java CORBA 
    objects running in Oracle 9.0.1.  This driver is typically used
    in a middle tier server.

  - JDBC Server-side Internal Driver 9.2.0
    Server-side JDBC driver for use by Java Stored procedures. This
    This driver used to be called the "JDBC Kprb Driver".

For complete documentation, please refer to "JDBC Developer's Guide
and Reference".


Contents Of This Release
------------------------

The [ORACLE_HOME]/jdbc/lib directory contains:

  - classes111.zip & classes111.jar
    Classes for use with JDK 1.1.x.  It contains the JDBC driver
    classes except classes necessary for NLS support in Object and
    Collection types.

  - nls_charset11.zip & nls_charset11.jar
    NLS classes for use with JDK 1.1.x.  It contains classes necessary
    for NLS support in Object and Collection types.

  - classes111_g.zip & classes111_g.jar
    Same as classes111.zip, except that classes were compiled with
    "javac -g" and contain OracleLog traceing code.

  - classes12.zip & classes12.jar
    Classes for use with JDK 1.2.x.  It contains the JDBC driver
    classes except classes necessary for NLS support in Object and
    Collection types.

  - nls_charset12.zip & nls_charset12.jar
    NLS classes for use with JDK 1.2.x.  It contains classes necessary
    for NLS support in Object and Collection types.

  - classes12_g.zip & classes12_g.jar
    Same as classes12.zip, except that classes were compiled with
    "javac -g" and contain OracleLog tracing code.

  - classes12dms.jar
    Same as classes12.jar except contains additional code to support
    Oracle Dynamic Monitoring Service.

  - classes12dms_g.jar
    Same as classes12dms.jar except that classes were compiled with 
    "javac -g" and contain OracleLog traceing code.

  - ojdbc14.jar
    Classes for use with JDK 1.4. It contains the JDBC driver
    classes except classes necessary for NLS support in Object and
    Collection types. Use nls_charset12.jar if needed.

  - ojdbc14_g.jar
    Same as ojdbc14.jar except that classes were compiled with
    "javac -g" and contain OracleLog tracing code.

  In general, <file>.zip and <file>.jar are identical except for the
  format of the archive.  Both the .zip and .jar formats are provided
  for JDK 1.1 and JDK 1.2. Only .jar files will be provided for JDK
  1.4 and beyond. So far, there is no need for JDK 1.3 classes files;
  use classes12.jar with JDK 1.3.

  Note that most of the classes pertaining to specific character sets
  support in Oracle Object and Collection types are separated from the
  basic zip/jar files.  These NLS classes are packaged into the
  extension zip/jar files.  This allows the user to include the NLS
  classes only if necessary.  Please refer to the "NLS Extension Zip
  Files (for client-side only)" section for further details. Also
  note that the nls_charset files are much smaller than in prior
  releases. These .zip/.jar files now contain a more compact
  representation of the conversion information rather than actual
  .class files.

[ORACLE_HOME]/lib directory contains libocijdbc9.so, libocijdbc9_g.so
libheteroxa9.so and libheteroxa9_g.so (on Solaris), which are the
shared libraries used by the JDBC OCI driver. 

[ORACLE_HOME]/jdbc/doc/javadoc.tar contains the JDBC Javadoc.  This
release contains a beta release of the Javadoc files for the public
API of the public classes of Oracle JDBC.

[ORACLE_HOME]/jdbc/demo/demo.tar contains sample JDBC programs.
All of the sample programs have been rewritten to use JDK 1.2 and the
new Oracle standard sample schemas. They no longer use the old standby
scott/tiger schema. These new sample schemas are much more feature
rich and so make it easier to demonstrate Oracle features. All Oracle
sample code and training will be using these new schemas very
soon. Most already does.

NLS and NLS Extension Zip/Jar Files (for client-side only)
----------------------------------------------------------

The JDBC Server-side Internal Driver provides complete NLS support.
It does not require any NLS extension zip/jar files, nls_charset*.*.
Discussions in this section do not apply to the JDBC Server-side
Internal Driver.  You can skip this section if you only use the
Server-side Internal Driver.

The basic zip/jar files (classes111.zip, classes111.jar,
classes12.zip and classes12.jar, ojdbc14.jar) contain all the
necessary classes to provide complete NLS support for:

  - Oracle Character sets for CHAR/VARCHAR/LONGVARCHAR/CLOB type data
    that is not retrieved or inserted as a data member of an Oracle 8
    Object or Collection type.

  - NLS support for CHAR/VARCHAR data members of Objects and
    Collections for a few commonly used character sets.  These
    character sets are:  US7ASCII, WE8DEC, WE8ISO8859P1 and UTF8.

Users must include the appropriate extension zip in their CLASSPATH
if utilization of other character sets in CHAR/VARCHAR data members
of Objects/Collections is desired.  It is important to note that
extension zip files are large in size due to the requirement of
supporting a large number of character sets.  Users may choose to
include only the necessary classes from the extension zip/jar file.
To do so, users can first un-pack the extension zip/jar file, and
then put only the necessary files in the CLASSPATH.  The character
set extension files are named in the following format:

  CharacterConverter<OracleCharacterSetId>.glb

where <OracleCharacterSetId> is the hexadecimal representation of the
Oracle character set id of the corresponding character set.

In addition, users can also include internationalized Jdbc error
message files selectively.  The message files are included in
classes*.* with the name oracle/jdbc/dbaccess/Messages_*.properties.


-----------------------------------------------------------------------


Installation
------------

Please do not try to put multiple versions of the Oracle JDBC drivers
in your CLASSPATH.  The Oracle installer installs the JDBC Drivers in
the [ORACLE_HOME]/jdbc directory.


Setting Up Your Environment
---------------------------

On Win95/Win98/NT:
  - Add [ORACLE_HOME]\jdbc\lib\classes111.zip and
    [ORACLE_HOME]\jdbc\lib\nls_charset11.zip to your CLASSPATH.
    (Add classes12.zip and nls_charset12.zip if JDK 1.2.x or 1.3 is
    used. Add ojdbc14.jar and nls_charset12.zip if JDK 1.4 is used.)
  - Make sure [ORACLE_HOME]\bin is in your PATH.

On Solaris/Digital Unix:
  - Add [ORACLE_HOME]/jdbc/lib/classes111.zip and
    [ORACLE_HOME]/jdbc/lib/nls_charset11.zip to your CLASSPATH.
    (Add classes12.zip and nls_charset12.zip if JDK 1.2.x or 1.3 is
     used. Add ojdbc14.jar and nls_charset12.zip if JDK 1.4 is used.)
  - Add [ORACLE_HOME]/jdbc/lib to your LD_LIBRARY_PATH.

On HP/UX:
  - Add [ORACLE_HOME]/jdbc/lib/classes111.zip and
    [ORACLE_HOME]/jdbc/lib/nls_charset11.zip to your CLASSPATH.
    (Add classes12.zip and nls_charset12.zip if JDK 1.2.x or 1.3 is
    used. Add ojdbc14.jar and nls_charset12.zip if JDK 1.4 is used.)
  - Add [ORACLE_HOME]/jdbc/lib to your SHLIB_PATH and LD_LIBRARY_PATH.

On AIX:
  - Add [ORACLE_HOME]/jdbc/lib/classes111.zip and
    [ORACLE_HOME]/jdbc/lib/nls_charset11.zip to your CLASSPATH.
    (Add classes12.zip and nls_charset12.zip if JDK 1.2.x 1.3 is
     used.  Add ojdbc14.jar and nls_charset12.zip if JDK 1.4 is used.)
  - Add [ORACLE_HOME]/jdbc/lib to your LIBPATH and LD_LIBRARY_PATH.


Some Useful Hints In Using the JDBC Drivers
-------------------------------------------

Please refer to "JDBC Developer's Guide and Reference" for details
regarding usage of Oracle's JDBC Drivers.  This section only offers
useful hints.  These hints are not meant to be exhaustive.

These are a few simple things that you should do in your JDBC program:

 1. Import the necessary JDBC classes in your programs that use JDBC.
    For example:

      import java.sql.*;
      import java.math.*;

 2. Register the Oracle driver before before calling other JDBC APIs.
    (This is not needed if you are using the JDBC Server-side Internal
    Driver because registration is done automatically in the server.)
    To register the Oracle driver, make sure the following statement
    is executed at least once in your Java session:

      DriverManager.registerDriver(
        new oracle.jdbc.OracleDriver());

 3. Open a connection to the database with the getConnection call.
    Different connection URLs should be used for different JDBC
    drivers.  The following examples demonstrate the different URLs.

    For the JDBC OCI Driver:

      Connection conn = DriverManager.getConnection(
                          "jdbc:oracle:oci:@<database>",
                          "my_user", "my_password");

      where <database> is either an entry in tnsnames.ora or a SQL*net
      name-value pair.

    For the JDBC Thin Driver, or Server-side Thin Driver:

      Connection conn = DriverManager.getConnection(
                          "jdbc:oracle:thin:@<database>",
                          "my_user", "my_password");

      where <database> is either a string of the form
      <host>:<port>:<sid>,  a SQL*net name-value pair, or a service
      name. 

    For the JDBC Server-side Internal Driver:

      Connection conn = DriverManager.getConnection(
                          "jdbc:oracle:kprb:");

      Note that the trailing ':' character is necessary.  When you use
      the Server-side Internal Driver, you always connect to the
      database you are executing in.  You can also do this:

      Connection conn
        = new oracle.jdbc.OracleDriver().defaultConnection();


New Package oracle.jdbc
-----------------------

Beginning in Oracle 9i, the Oracle extensions to JDBC are captured in
the package oracle.jdbc. This package contains classes and interfaces
that specify the Oracle extensions in a manner similar to the way the
classes and interfaces in java.sql specify the public JDBC API.

Your code should use the package oracle.jdbc instead of the package
oracle.jdbc.driver used in earlier versions of Oracle. Use of the
package oracle.jdbc.driver is now deprecated, but will be supported
for backwards compatibility.

All that is required to covert your code is to replace
"oracle.jdbc.driver" with "oracle.jdbc" in the source and
recompile. This cannot be done piecewise. You must convert all classes
and interfaces that are referenced by an application. Conversion is
not required, but is highly recommended. Future releases of Oracle will
have features that are incompatible with use of the package
oracle.jdbc.driver.

The purpose of this change in to enable the Oracle JDBC drivers to
have multiple implementations. In all releases up to and including
Oracle 9i, all of the Oracle JDBC drivers have used the same top level
implementation classes, the classes in the package
oracle.jdbc.driver. By converting your code to use oracle.jdbc, you
will be able to take advantage of future enhancements that use
different implementation classes. There are no such enhancements in
Oracle 9i, but there are plans for such enhancements in the future.

Additionally, these interfaces permit the use of some code patterns
that are difficult to use when your code uses the package
oracle.jdbc.driver. For example, you can more easily develop wrapper
classes for the Oracle JDBC classes. If you wished to wrap the
OracleStatement class in order to log all SQL statements, you could
easily do so by creating a class that wraps OracleStatment. That class
would implement the interface oracle.jdbc.OracleStatement and hold an
oracle.jdbc.OracleStatement as an instance variable. This wrapping
pattern is much more difficult when your code uses the package
oracle.jdbc.driver as you cannot extend the class
oracle.jdbc.driver.OracleStatement. In implementing a Connection
wrapper class, you should either inherit from the class
oracle.jdbc.OracleConnectionWrapper, or base your class on that class.
The source for oracle.jdbc.OracleConnectionWrapper is included in the
demos directory.

Once again, your code should use the new package oracle.jdbc instead
of the package oracle.jdbc.driver. Conversion is not required as
oracle.jdbc.driver will continue to be supported for backwards
compatibility. Conversion is highly recommended as there will in later
releases be features that are not supported if your code uses
oracle.jdbc.driver.


Java Stored Procedures
----------------------

Please note that examples for callins and instance methods using Oracle
8 Object Types are provided in:

  [ORACLE_HOME]/javavm/demo/demo.zip

Once unzipped, the directory containing the examples is:

  [ORACLE_HOME]/javavm/demo/examples/jsp


Known Problems/Limitations In This Release
------------------------------------------

The following is a list of known problems/limitations:

 *  There is a limitation regarding the use of stream input for LOB
    types.  Stream input for LOB types can only be used for 8.1.7 or
    later JDBC OCI driver connecting to an 8.1.7 or later Oracle
    server.  The use of stream input for LOB types in all other
    configurations may result in data corruption.  PreparedStatement
    stream input APIs include: setBinaryStream(), setAsciiStream(),
    setUnicodeStream(), setCharacterStream() and setObject().

 *  Programs can fail to open 16 or more connections using our
    client-side drivers at any one time.  This is not a limitation 
    caused by the JDBC drivers.  It is most likely that the limit of
    per-process file descriptors is exceeded.  The solution is to 
    increase the limit. 

 *  The Server-side Internal Driver has the following limitation:
    - Data access for LONG and LONG RAW types is limited to 32K of
      data.
    - Inserts of Object Types (Oracle Objects, Collections and
      References) will not work when the database compatibility mode
      is set to 8.0.  This limitation does not apply when the
      compatibility mode is set to 8.1.
    - In a chain of SQLExceptions, only the first one in the chain
      will have a getSQLState value.
    - Batch updates with Oracle 8 Object, REF and Collection data
      types are not supported.

 *  The JDBC OCI driver on an SSL connection hangs when the Java
    Virtual Machine is running in green threads mode.  A work-around
    is to run the Java Virtual Machine in native threads mode.

 *  Date-time format, currency symbol and decimal symbols are always
    presented in American convention.

 *  When using OracleStatement.defineColumnType(), it is not necessary
    to define the column type to be the same as the column type
    declared in the database.  If the types are different, the
    retrieved values are converted to the type specified in
    defineColumnType.

    Note:  Most reasonable conversions work, but not all. If you find
    a conversion that you think is reasonable, but that does not work,
    please submit a TAR to Oracle Support.

 *  The utility dbms_java.set_output or dbms_java.set_stream that is
    used for redirecting the System.out.println() in JSPs to stdout
    SHOULD NOT be used when JDBC tracing is turned on.  This is
    because the current implementation of dbms_java.set_output and
    set_stream uses JDBC to write the output to stdout.  The result
    would be an infinite loop.

 *  The JDBC OCI and Thin drivers do not read CHAR data via binary
    streams correctly.  In other word, using getBinaryStream() to
    retrieve CHAR data may yield incorrect results.  A work-around is
    to use either getCHAR() or getAsciiStream() instead.  The other
    alternative is to use getUnicodeStream() although the method is
    deprecated.

BUG-899078 (since 8.1.6)
    The JDBC Server-side Internal driver has extra space padding with
    PL/SQL CHAR OUT (2 to 3 space depending on character set).
    Problem occurs in most of the multibyte database character set
    except UTF8.

 *  There is a limitation for Triggers implemented in Java and Object
    Types.  It only affects the IN argument types of triggers
    implemented using Java on the client-side.  The restriction does
    not apply to JDBC programs running inside the server.  Triggers
    implemented as Java methods cannot have IN arguments of Oracle 8
    Object or Collection type.  This means the Java methods used to
    implement triggers cannot have arguments of the following types:

    - java.sql.Struct
    - java.sql.Array
    - oracle.sql.STRUCT
    - oracle.sql.ARRAY
    - oracle.jdbc2.Struct
    - oracle.jdbc2.Array
    - any class implementing oracle.jdbc2.SQLData or
      oracle.sql.CustomDatum

 *  The scrollable result set implementation has the following
    limitation:

    - setFetchDirection() on ScrollableResultSet does not do anything.
    - refreshRow() on ScrollableResultSet does not support all
      combinations of sensitivity and concurrency.  The following
      table depicts the supported combinations.

        Support     Type                       Concurrency
        -------------------------------------------------------
        no          TYPE_FORWARD_ONLY          CONCUR_READ_ONLY
        no          TYPE_FORWARD_ONLY          CONCUR_UPDATABLE
        no          TYPE_SCROLL_INSENSITIVE    CONCUR_READ_ONLY
        yes         TYPE_SCROLL_INSENSITIVE    CONCUR_UPDATABLE
        yes         TYPE_SCROLL_SENSITIVE      CONCUR_READ_ONLY
        yes         TYPE_SCROLL_SENSITIVE      CONCUR_UPDATABLE

BUG-1516862 (since 9.0.0)
    Passing an OPAQUE type as an argument to a Java Stored Procedure
    does not work.

BUG-1542130 (since 9.0.0)
    The use of OciConnectionPool may cause a hang in a multi-threaded
    environment.

BUG-1640110 (since 9.0.0)
    The JDBC OCI driver may hang when executing a query with invalid
    double quotes in the query string.  This problem only occurs when
    the NLS_LANG environment variable is set.

 *  Access to the new Datetime datatypes is only supported in the
    Jdbc Thin driver with JDK 1.2, 1.3 and 1.4.  These Datetime data
    types inlcude: TIMESTAMP, TIMESTAMPTZ and TIMESTAMPLTZ.  In 
    addition, String APIs like PreparedStatement.setString() and
    Resultset.getString() do not work for these data types.  Users
    must use setTIMESTAMP*() and getTIMESTAMP*().

BUG-2171766 (since 9.2.0)
    When writing JDBC code that contains SQL method invocations,
    the syntax " ?.method(args,...) " results in the SQL error
    message: ORA-01036: illegal variable name/number. This message
    is somewhat misleading. What is required is that the ? must be
    followed by a " " (space) to avoid this issue.

BUG-2165794 (since 9.2.0)
    DBC XA applications needing to use TMSUSPEND & TMRESUME features
    need to use the TMNOMIGRATE FLAG. If this flag is not used, the
    application may @receive Error ORA 1002: fetch out of sequence.

BUG-2158394 (since 9.2.0)
    ORA-6505 when setting null to char column via stored procedure 
    using setNull() method with java.sql.Types.CHAR. Using
    java.sql.Types.VARCHAR, is ok. Only occurs with Thin driver and
    JA16SJIS or JA16EUC character sets. 

BUG-2148328 (since 9.2.0)
    On Linux, SJIS data in table names  are returned as replacement
    characters with JDK1.2 and JDK1.3 with both the Thin and OCI
    drivers. This is due to a bug in the JDKs. The workaround is to
    use JDK 1.1.8, which does not have this bug.

BUG-2144602 (since 8.1.7)
    When running Windows2000 with the locale set to Chinese (Taiwan)
    and the character set set to ZHT16DBT, all Chinese characters
    are displayed as "?".

BUG-2130384 (since 9.0.1)
    Does not raise ORA-22814 as it should when inserting too large
    of an element value into a VARRAY using setARRAY.

BUG-2249191
    In the Server Internal Driver, setting the query timeout does not
    (and likely will never) work. The query execution will not be
    canceled when the timeout expires, even if the query runs forever.
    Further, after the query returns, the execution of your code
    may pause for the length of the timeout.

BUG-2213820
    OracleConnectionCacheImpl cannot be serialized because it has a
    member that is not serializable. This causes some problems with
    JSPs that store the connection cache as a bean in session scope.

BUG-2180673
    When using OracleOCIConnectionPool, the methods getPoolSize and
    getActiveSize return the wrong results. getPoolSize always returns
    minLimit and getActiveSize always returns 0.

BUG-1910217
    TIMESTAMPs are not supported in ADTs.

BUG-2245502
    If you use the Thin driver to connect to an 8.1.7 database, and 
    then attempt to access a 7.3.4 database via DBLinks using bind
    variables, the values of the bind variables may be swapped.

BUG-2183691
    The insertRow method on an updateable result set inserts the row
    into the database, but does not insert it into the result set
    itself. 

BUG-2095829
    In the Server Internal Driver, calling a PL/SQL procedure and 
    passing a NULL value to an argument of a user defined type fails.
    In some cases the session hangs, in others you will get ora-3113, 
    ora-3114, or ora-24323.

BUG-1568923 
    Using the OCI driver, using setBytes to insert more than 50K into
    a LONG RAW truncates the inserted value.

BUG-2285052 (since 9.2.0.1)
    Extra space and null characters are returned by ResultSet.getString()
    and Scrollable ResultSet getString() for NCHAR column when the 
    database national character set is UTF8.  This behavior occurs only
    with JDBC THIN driver.
 