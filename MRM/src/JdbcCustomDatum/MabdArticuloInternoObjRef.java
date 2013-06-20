package JdbcCustomDatum;

import java.sql.SQLException;
import java.sql.Connection;
import oracle.jdbc.OracleTypes;
import oracle.sql.ORAData;
import oracle.sql.ORADataFactory;
import oracle.sql.Datum;
import oracle.sql.REF;
import oracle.sql.STRUCT;

public class MabdArticuloInternoObjRef implements ORAData, ORADataFactory
{
  public static final String _SQL_BASETYPE = "X5927137.MABD_ARTICULO_INTERNO_OBJ";
  public static final int _SQL_TYPECODE = OracleTypes.REF;

  REF _ref;

private static final MabdArticuloInternoObjRef _MabdArticuloInternoObjRefFactory = new MabdArticuloInternoObjRef();

  public static ORADataFactory getORADataFactory()
  { return _MabdArticuloInternoObjRefFactory; }
  /* constructor */
  public MabdArticuloInternoObjRef()
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
    MabdArticuloInternoObjRef r = new MabdArticuloInternoObjRef();
    r._ref = (REF) d;
    return r;
  }

  public static MabdArticuloInternoObjRef cast(ORAData o) throws SQLException
  {
     if (o == null) return null;
     try { return (MabdArticuloInternoObjRef) getORADataFactory().create(o.toDatum(null), OracleTypes.REF); }
     catch (Exception exn)
     { throw new SQLException("Unable to convert "+o.getClass().getName()+" to MabdArticuloInternoObjRef: "+exn.toString()); }
  }

  public MabdArticuloInternoObj getValue() throws SQLException
  {
     return (MabdArticuloInternoObj) MabdArticuloInternoObj.getORADataFactory().create(
       _ref.getSTRUCT(), OracleTypes.REF);
  }

  public void setValue(MabdArticuloInternoObj c) throws SQLException
  {
    _ref.setValue((STRUCT) c.toDatum(_ref.getJavaSqlConnection()));
  }
}
