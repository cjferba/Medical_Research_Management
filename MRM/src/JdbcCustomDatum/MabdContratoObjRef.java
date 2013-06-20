package JdbcCustomDatum;

import java.sql.SQLException;
import java.sql.Connection;
import oracle.jdbc.OracleTypes;
import oracle.sql.ORAData;
import oracle.sql.ORADataFactory;
import oracle.sql.Datum;
import oracle.sql.REF;
import oracle.sql.STRUCT;

public class MabdContratoObjRef implements ORAData, ORADataFactory
{
  public static final String _SQL_BASETYPE = "X5927137.MABD_CONTRATO_OBJ";
  public static final int _SQL_TYPECODE = OracleTypes.REF;

  REF _ref;

private static final MabdContratoObjRef _MabdContratoObjRefFactory = new MabdContratoObjRef();

  public static ORADataFactory getORADataFactory()
  { return _MabdContratoObjRefFactory; }
  /* constructor */
  public MabdContratoObjRef()
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
    MabdContratoObjRef r = new MabdContratoObjRef();
    r._ref = (REF) d;
    return r;
  }

  public static MabdContratoObjRef cast(ORAData o) throws SQLException
  {
     if (o == null) return null;
     try { return (MabdContratoObjRef) getORADataFactory().create(o.toDatum(null), OracleTypes.REF); }
     catch (Exception exn)
     { throw new SQLException("Unable to convert "+o.getClass().getName()+" to MabdContratoObjRef: "+exn.toString()); }
  }

  public MabdContratoObj getValue() throws SQLException
  {
     return (MabdContratoObj) MabdContratoObj.getORADataFactory().create(
       _ref.getSTRUCT(), OracleTypes.REF);
  }

  public void setValue(MabdContratoObj c) throws SQLException
  {
    _ref.setValue((STRUCT) c.toDatum(_ref.getJavaSqlConnection()));
  }
}
