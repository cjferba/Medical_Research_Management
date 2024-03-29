package JdbcCustomDatum;

import java.sql.SQLException;
import java.sql.Connection;
import oracle.jdbc.OracleTypes;
import oracle.sql.ORAData;
import oracle.sql.ORADataFactory;
import oracle.sql.Datum;
import oracle.sql.REF;
import oracle.sql.STRUCT;

public class MabdVirusObjRef implements ORAData, ORADataFactory
{
  public static final String _SQL_BASETYPE = "X5927137.MABD_VIRUS_OBJ";
  public static final int _SQL_TYPECODE = OracleTypes.REF;

  REF _ref;

private static final MabdVirusObjRef _MabdVirusObjRefFactory = new MabdVirusObjRef();

  public static ORADataFactory getORADataFactory()
  { return _MabdVirusObjRefFactory; }
  /* constructor */
  public MabdVirusObjRef()
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
    MabdVirusObjRef r = new MabdVirusObjRef();
    r._ref = (REF) d;
    return r;
  }

  public static MabdVirusObjRef cast(ORAData o) throws SQLException
  {
     if (o == null) return null;
     try { return (MabdVirusObjRef) getORADataFactory().create(o.toDatum(null), OracleTypes.REF); }
     catch (Exception exn)
     { throw new SQLException("Unable to convert "+o.getClass().getName()+" to MabdVirusObjRef: "+exn.toString()); }
  }

  public MabdVirusObj getValue() throws SQLException
  {
     return (MabdVirusObj) MabdVirusObj.getORADataFactory().create(
       _ref.getSTRUCT(), OracleTypes.REF);
  }

  public void setValue(MabdVirusObj c) throws SQLException
  {
    _ref.setValue((STRUCT) c.toDatum(_ref.getJavaSqlConnection()));
  }
}
