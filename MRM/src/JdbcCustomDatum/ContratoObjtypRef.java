package JdbcCustomDatum;

import java.sql.SQLException;
import java.sql.Connection;
import oracle.jdbc.OracleTypes;
import oracle.sql.ORAData;
import oracle.sql.ORADataFactory;
import oracle.sql.Datum;
import oracle.sql.REF;
import oracle.sql.STRUCT;

public class ContratoObjtypRef implements ORAData, ORADataFactory
{
  public static final String _SQL_BASETYPE = "X5927137.CONTRATO_OBJTYP";
  public static final int _SQL_TYPECODE = OracleTypes.REF;

  REF _ref;

private static final ContratoObjtypRef _ContratoObjtypRefFactory = new ContratoObjtypRef();

  public static ORADataFactory getORADataFactory()
  { return _ContratoObjtypRefFactory; }
  /* constructor */
  public ContratoObjtypRef()
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
    ContratoObjtypRef r = new ContratoObjtypRef();
    r._ref = (REF) d;
    return r;
  }

  public static ContratoObjtypRef cast(ORAData o) throws SQLException
  {
     if (o == null) return null;
     try { return (ContratoObjtypRef) getORADataFactory().create(o.toDatum(null), OracleTypes.REF); }
     catch (Exception exn)
     { throw new SQLException("Unable to convert "+o.getClass().getName()+" to ContratoObjtypRef: "+exn.toString()); }
  }

  public ContratoObjtyp getValue() throws SQLException
  {
     return (ContratoObjtyp) ContratoObjtyp.getORADataFactory().create(
       _ref.getSTRUCT(), OracleTypes.REF);
  }

  public void setValue(ContratoObjtyp c) throws SQLException
  {
    _ref.setValue((STRUCT) c.toDatum(_ref.getJavaSqlConnection()));
  }
}
