package JdbcCustomDatum;

import java.sql.SQLException;
import java.sql.Connection;
import oracle.jdbc.OracleTypes;
import oracle.sql.ORAData;
import oracle.sql.ORADataFactory;
import oracle.sql.Datum;
import oracle.sql.REF;
import oracle.sql.STRUCT;

public class ContratoRef implements ORAData, ORADataFactory
{
  public static final String _SQL_BASETYPE = "X5927137.CONTRATO";
  public static final int _SQL_TYPECODE = OracleTypes.REF;

  REF _ref;

private static final ContratoRef _ContratoRefFactory = new ContratoRef();

  public static ORADataFactory getORADataFactory()
  { return _ContratoRefFactory; }
  /* constructor */
  public ContratoRef()
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
    ContratoRef r = new ContratoRef();
    r._ref = (REF) d;
    return r;
  }

  public static ContratoRef cast(ORAData o) throws SQLException
  {
     if (o == null) return null;
     try { return (ContratoRef) getORADataFactory().create(o.toDatum(null), OracleTypes.REF); }
     catch (Exception exn)
     { throw new SQLException("Unable to convert "+o.getClass().getName()+" to ContratoRef: "+exn.toString()); }
  }

  public Contrato getValue() throws SQLException
  {
     return (Contrato) Contrato.getORADataFactory().create(
       _ref.getSTRUCT(), OracleTypes.REF);
  }

  public void setValue(Contrato c) throws SQLException
  {
    _ref.setValue((STRUCT) c.toDatum(_ref.getJavaSqlConnection()));
  }
}
