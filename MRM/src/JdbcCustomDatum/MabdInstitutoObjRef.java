package JdbcCustomDatum;

import java.sql.SQLException;
import java.sql.Connection;
import oracle.jdbc.OracleTypes;
import oracle.sql.ORAData;
import oracle.sql.ORADataFactory;
import oracle.sql.Datum;
import oracle.sql.REF;
import oracle.sql.STRUCT;

public class MabdInstitutoObjRef implements ORAData, ORADataFactory
{
  public static final String _SQL_BASETYPE = "X5927137.MABD_INSTITUTO_OBJ";
  public static final int _SQL_TYPECODE = OracleTypes.REF;

  REF _ref;

private static final MabdInstitutoObjRef _MabdInstitutoObjRefFactory = new MabdInstitutoObjRef();

  public static ORADataFactory getORADataFactory()
  { return _MabdInstitutoObjRefFactory; }
  /* constructor */
  public MabdInstitutoObjRef()
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
    MabdInstitutoObjRef r = new MabdInstitutoObjRef();
    r._ref = (REF) d;
    return r;
  }

  public static MabdInstitutoObjRef cast(ORAData o) throws SQLException
  {
     if (o == null) return null;
     try { return (MabdInstitutoObjRef) getORADataFactory().create(o.toDatum(null), OracleTypes.REF); }
     catch (Exception exn)
     { throw new SQLException("Unable to convert "+o.getClass().getName()+" to MabdInstitutoObjRef: "+exn.toString()); }
  }

  public MabdInstitutoObj getValue() throws SQLException
  {
     return (MabdInstitutoObj) MabdInstitutoObj.getORADataFactory().create(
       _ref.getSTRUCT(), OracleTypes.REF);
  }

  public void setValue(MabdInstitutoObj c) throws SQLException
  {
    _ref.setValue((STRUCT) c.toDatum(_ref.getJavaSqlConnection()));
  }
}
