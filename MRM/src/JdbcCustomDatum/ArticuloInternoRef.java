package JdbcCustomDatum;

import java.sql.SQLException;
import java.sql.Connection;
import oracle.jdbc.OracleTypes;
import oracle.sql.ORAData;
import oracle.sql.ORADataFactory;
import oracle.sql.Datum;
import oracle.sql.REF;
import oracle.sql.STRUCT;

public class ArticuloInternoRef implements ORAData, ORADataFactory
{
  public static final String _SQL_BASETYPE = "X5927137.ARTICULO_INTERNO";
  public static final int _SQL_TYPECODE = OracleTypes.REF;

  REF _ref;

private static final ArticuloInternoRef _ArticuloInternoRefFactory = new ArticuloInternoRef();

  public static ORADataFactory getORADataFactory()
  { return _ArticuloInternoRefFactory; }
  /* constructor */
  public ArticuloInternoRef()
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
    ArticuloInternoRef r = new ArticuloInternoRef();
    r._ref = (REF) d;
    return r;
  }

  public static ArticuloInternoRef cast(ORAData o) throws SQLException
  {
     if (o == null) return null;
     try { return (ArticuloInternoRef) getORADataFactory().create(o.toDatum(null), OracleTypes.REF); }
     catch (Exception exn)
     { throw new SQLException("Unable to convert "+o.getClass().getName()+" to ArticuloInternoRef: "+exn.toString()); }
  }

  public ArticuloInterno getValue() throws SQLException
  {
     return (ArticuloInterno) ArticuloInterno.getORADataFactory().create(
       _ref.getSTRUCT(), OracleTypes.REF);
  }

  public void setValue(ArticuloInterno c) throws SQLException
  {
    _ref.setValue((STRUCT) c.toDatum(_ref.getJavaSqlConnection()));
  }
}
