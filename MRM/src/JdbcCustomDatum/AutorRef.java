package JdbcCustomDatum;

import java.sql.SQLException;
import java.sql.Connection;
import oracle.jdbc.OracleTypes;
import oracle.sql.ORAData;
import oracle.sql.ORADataFactory;
import oracle.sql.Datum;
import oracle.sql.REF;
import oracle.sql.STRUCT;

public class AutorRef implements ORAData, ORADataFactory
{
  public static final String _SQL_BASETYPE = "X5927137.AUTOR";
  public static final int _SQL_TYPECODE = OracleTypes.REF;

  REF _ref;

private static final AutorRef _AutorRefFactory = new AutorRef();

  public static ORADataFactory getORADataFactory()
  { return _AutorRefFactory; }
  /* constructor */
  public AutorRef()
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
    AutorRef r = new AutorRef();
    r._ref = (REF) d;
    return r;
  }

  public static AutorRef cast(ORAData o) throws SQLException
  {
     if (o == null) return null;
     try { return (AutorRef) getORADataFactory().create(o.toDatum(null), OracleTypes.REF); }
     catch (Exception exn)
     { throw new SQLException("Unable to convert "+o.getClass().getName()+" to AutorRef: "+exn.toString()); }
  }

  public Autor getValue() throws SQLException
  {
     return (Autor) Autor.getORADataFactory().create(
       _ref.getSTRUCT(), OracleTypes.REF);
  }

  public void setValue(Autor c) throws SQLException
  {
    _ref.setValue((STRUCT) c.toDatum(_ref.getJavaSqlConnection()));
  }
}
