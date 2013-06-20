package JdbcCustomDatum;

import java.sql.SQLException;
import java.sql.Connection;
import oracle.jdbc.OracleTypes;
import oracle.sql.ORAData;
import oracle.sql.ORADataFactory;
import oracle.sql.Datum;
import oracle.sql.REF;
import oracle.sql.STRUCT;

public class InstitutoRef implements ORAData, ORADataFactory
{
  public static final String _SQL_BASETYPE = "X5927137.INSTITUTO";
  public static final int _SQL_TYPECODE = OracleTypes.REF;

  REF _ref;

private static final InstitutoRef _InstitutoRefFactory = new InstitutoRef();

  public static ORADataFactory getORADataFactory()
  { return _InstitutoRefFactory; }
  /* constructor */
  public InstitutoRef()
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
    InstitutoRef r = new InstitutoRef();
    r._ref = (REF) d;
    return r;
  }

  public static InstitutoRef cast(ORAData o) throws SQLException
  {
     if (o == null) return null;
     try { return (InstitutoRef) getORADataFactory().create(o.toDatum(null), OracleTypes.REF); }
     catch (Exception exn)
     { throw new SQLException("Unable to convert "+o.getClass().getName()+" to InstitutoRef: "+exn.toString()); }
  }

  public Instituto getValue() throws SQLException
  {
     return (Instituto) Instituto.getORADataFactory().create(
       _ref.getSTRUCT(), OracleTypes.REF);
  }

  public void setValue(Instituto c) throws SQLException
  {
    _ref.setValue((STRUCT) c.toDatum(_ref.getJavaSqlConnection()));
  }
}
