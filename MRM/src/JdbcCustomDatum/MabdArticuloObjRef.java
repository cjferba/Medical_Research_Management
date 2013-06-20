package JdbcCustomDatum;

import java.sql.SQLException;
import java.sql.Connection;
import oracle.jdbc.OracleTypes;
import oracle.sql.ORAData;
import oracle.sql.ORADataFactory;
import oracle.sql.Datum;
import oracle.sql.REF;
import oracle.sql.STRUCT;

public class MabdArticuloObjRef implements ORAData, ORADataFactory
{
  public static final String _SQL_BASETYPE = "X5927137.MABD_ARTICULO_OBJ";
  public static final int _SQL_TYPECODE = OracleTypes.REF;

  REF _ref;

private static final MabdArticuloObjRef _MabdArticuloObjRefFactory = new MabdArticuloObjRef();

  public static ORADataFactory getORADataFactory()
  { return _MabdArticuloObjRefFactory; }
  /* constructor */
  public MabdArticuloObjRef()
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
    MabdArticuloObjRef r = new MabdArticuloObjRef();
    r._ref = (REF) d;
    return r;
  }

  public static MabdArticuloObjRef cast(ORAData o) throws SQLException
  {
     if (o == null) return null;
     try { return (MabdArticuloObjRef) getORADataFactory().create(o.toDatum(null), OracleTypes.REF); }
     catch (Exception exn)
     { throw new SQLException("Unable to convert "+o.getClass().getName()+" to MabdArticuloObjRef: "+exn.toString()); }
  }

  public MabdArticuloObj getValue() throws SQLException
  {
     return (MabdArticuloObj) MabdArticuloObj.getORADataFactory().create(
       _ref.getSTRUCT(), OracleTypes.REF);
  }

  public void setValue(MabdArticuloObj c) throws SQLException
  {
    _ref.setValue((STRUCT) c.toDatum(_ref.getJavaSqlConnection()));
  }
}
