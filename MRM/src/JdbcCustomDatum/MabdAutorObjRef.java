package JdbcCustomDatum;

import java.sql.SQLException;
import java.sql.Connection;
import oracle.jdbc.OracleTypes;
import oracle.sql.ORAData;
import oracle.sql.ORADataFactory;
import oracle.sql.Datum;
import oracle.sql.REF;
import oracle.sql.STRUCT;

public class MabdAutorObjRef implements ORAData, ORADataFactory
{
  public static final String _SQL_BASETYPE = "X5927137.MABD_AUTOR_OBJ";
  public static final int _SQL_TYPECODE = OracleTypes.REF;

  REF _ref;

private static final MabdAutorObjRef _MabdAutorObjRefFactory = new MabdAutorObjRef();

  public static ORADataFactory getORADataFactory()
  { return _MabdAutorObjRefFactory; }
  /* constructor */
  public MabdAutorObjRef()
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
    MabdAutorObjRef r = new MabdAutorObjRef();
    r._ref = (REF) d;
    return r;
  }

  public static MabdAutorObjRef cast(ORAData o) throws SQLException
  {
     if (o == null) return null;
     try { return (MabdAutorObjRef) getORADataFactory().create(o.toDatum(null), OracleTypes.REF); }
     catch (Exception exn)
     { throw new SQLException("Unable to convert "+o.getClass().getName()+" to MabdAutorObjRef: "+exn.toString()); }
  }

  public MabdAutorObj getValue() throws SQLException
  {
     return (MabdAutorObj) MabdAutorObj.getORADataFactory().create(
       _ref.getSTRUCT(), OracleTypes.REF);
  }

  public void setValue(MabdAutorObj c) throws SQLException
  {
    _ref.setValue((STRUCT) c.toDatum(_ref.getJavaSqlConnection()));
  }
}
