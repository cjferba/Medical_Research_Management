package JdbcCustomDatum;

import java.sql.SQLException;
import java.sql.Connection;
import oracle.jdbc.OracleTypes;
import oracle.sql.ORAData;
import oracle.sql.ORADataFactory;
import oracle.sql.Datum;
import oracle.sql.REF;
import oracle.sql.STRUCT;

public class InstitutoObjtypRef implements ORAData, ORADataFactory
{
  public static final String _SQL_BASETYPE = "X5927137.INSTITUTO_OBJTYP";
  public static final int _SQL_TYPECODE = OracleTypes.REF;

  REF _ref;

private static final InstitutoObjtypRef _InstitutoObjtypRefFactory = new InstitutoObjtypRef();

  public static ORADataFactory getORADataFactory()
  { return _InstitutoObjtypRefFactory; }
  /* constructor */
  public InstitutoObjtypRef()
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
    InstitutoObjtypRef r = new InstitutoObjtypRef();
    r._ref = (REF) d;
    return r;
  }

  public static InstitutoObjtypRef cast(ORAData o) throws SQLException
  {
     if (o == null) return null;
     try { return (InstitutoObjtypRef) getORADataFactory().create(o.toDatum(null), OracleTypes.REF); }
     catch (Exception exn)
     { throw new SQLException("Unable to convert "+o.getClass().getName()+" to InstitutoObjtypRef: "+exn.toString()); }
  }

  public InstitutoObjtyp getValue() throws SQLException
  {
     return (InstitutoObjtyp) InstitutoObjtyp.getORADataFactory().create(
       _ref.getSTRUCT(), OracleTypes.REF);
  }

  public void setValue(InstitutoObjtyp c) throws SQLException
  {
    _ref.setValue((STRUCT) c.toDatum(_ref.getJavaSqlConnection()));
  }
}
