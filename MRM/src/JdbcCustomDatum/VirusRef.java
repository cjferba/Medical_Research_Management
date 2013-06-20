package JdbcCustomDatum;

import java.sql.SQLException;
import java.sql.Connection;
import oracle.jdbc.OracleTypes;
import oracle.sql.ORAData;
import oracle.sql.ORADataFactory;
import oracle.sql.Datum;
import oracle.sql.REF;
import oracle.sql.STRUCT;

public class VirusRef implements ORAData, ORADataFactory
{
  public static final String _SQL_BASETYPE = "X5927137.VIRUS";
  public static final int _SQL_TYPECODE = OracleTypes.REF;

  REF _ref;

private static final VirusRef _VirusRefFactory = new VirusRef();

  public static ORADataFactory getORADataFactory()
  { return _VirusRefFactory; }
  /* constructor */
  public VirusRef()
  {
  }

  /* ORAData interface */
  public Datum toDatum(Connection c) throws SQLException
  {
    return _ref;
  }

  /* ORADataFactory interface */
  public ORAData create(Datum d, int sqlType) throws SQLException
  {
    if (d == null) return null; 
    VirusRef r = new VirusRef();
    r._ref = (REF) d;
    return r;
  }

  public static VirusRef cast(ORAData o) throws SQLException
  {
     if (o == null) return null;
     try { return (VirusRef) getORADataFactory().create(o.toDatum(null), OracleTypes.REF); }
     catch (Exception exn)
     { throw new SQLException("Unable to convert "+o.getClass().getName()+" to VirusRef: "+exn.toString()); }
  }

  public Virus getValue() throws SQLException
  {
     return (Virus) Virus.getORADataFactory().create(
       _ref.getSTRUCT(), OracleTypes.REF);
  }

  public void setValue(Virus c) throws SQLException
  {
    _ref.setValue((STRUCT) c.toDatum(_ref.getJavaSqlConnection()));
  }
}
