package JdbcCustomDatum;

import java.sql.SQLException;
import java.sql.Connection;
import oracle.jdbc.OracleTypes;
import oracle.sql.ORAData;
import oracle.sql.ORADataFactory;
import oracle.sql.Datum;
import oracle.sql.REF;
import oracle.sql.STRUCT;

public class ArticuloRef implements ORAData, ORADataFactory
{
  public static final String _SQL_BASETYPE = "X5927137.ARTICULO";
  public static final int _SQL_TYPECODE = OracleTypes.REF;

  REF _ref;

private static final ArticuloRef _ArticuloRefFactory = new ArticuloRef();

  public static ORADataFactory getORADataFactory()
  { return _ArticuloRefFactory; }
  /* constructor */
  public ArticuloRef()
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
    ArticuloRef r = new ArticuloRef();
    r._ref = (REF) d;
    return r;
  }

  public static ArticuloRef cast(ORAData o) throws SQLException
  {
     if (o == null) return null;
     try { return (ArticuloRef) getORADataFactory().create(o.toDatum(null), OracleTypes.REF); }
     catch (Exception exn)
     { throw new SQLException("Unable to convert "+o.getClass().getName()+" to ArticuloRef: "+exn.toString()); }
  }

  public Articulo getValue() throws SQLException
  {
     return (Articulo) Articulo.getORADataFactory().create(
       _ref.getSTRUCT(), OracleTypes.REF);
  }

  public void setValue(Articulo c) throws SQLException
  {
    _ref.setValue((STRUCT) c.toDatum(_ref.getJavaSqlConnection()));
  }
}
