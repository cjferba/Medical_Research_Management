package JdbcCustomDatum;

import java.sql.SQLException;
import java.sql.Connection;
import oracle.jdbc.OracleTypes;
import oracle.sql.ORAData;
import oracle.sql.ORADataFactory;
import oracle.sql.Datum;
import oracle.sql.STRUCT;
import oracle.jpub.runtime.MutableStruct;

public class ContratoObjtyp implements ORAData, ORADataFactory
{
  public static final String _SQL_NAME = "X5927137.CONTRATO_OBJTYP";
  public static final int _SQL_TYPECODE = OracleTypes.STRUCT;

  protected MutableStruct _struct;

  protected static int[] _sqlType =  { 2,2,91,91 };
  protected static ORADataFactory[] _factory = new ORADataFactory[4];
  protected static final ContratoObjtyp _ContratoObjtypFactory = new ContratoObjtyp();

  public static ORADataFactory getORADataFactory()
  { return _ContratoObjtypFactory; }
  /* constructors */
  protected void _init_struct(boolean init)
  { if (init) _struct = new MutableStruct(new Object[4], _sqlType, _factory); }
  public ContratoObjtyp()
  { _init_struct(true); }
  public ContratoObjtyp(java.math.BigDecimal cod, java.math.BigDecimal cantidad, java.sql.Timestamp fecinicio, java.sql.Timestamp fecfin) throws SQLException
  { _init_struct(true);
    setCod(cod);
    setCantidad(cantidad);
    setFecinicio(fecinicio);
    setFecfin(fecfin);
  }

  /* ORAData interface */
  public Datum toDatum(Connection c) throws SQLException
  {
    return _struct.toDatum(c, _SQL_NAME);
  }


  /* ORADataFactory interface */
  public ORAData create(Datum d, int sqlType) throws SQLException
  { return create(null, d, sqlType); }
  protected ORAData create(ContratoObjtyp o, Datum d, int sqlType) throws SQLException
  {
    if (d == null) return null; 
    if (o == null) o = new ContratoObjtyp();
    o._struct = new MutableStruct((STRUCT) d, _sqlType, _factory);
    return o;
  }
  /* accessor methods */
  public java.math.BigDecimal getCod() throws SQLException
  { return (java.math.BigDecimal) _struct.getAttribute(0); }

  public void setCod(java.math.BigDecimal cod) throws SQLException
  { _struct.setAttribute(0, cod); }


  public java.math.BigDecimal getCantidad() throws SQLException
  { return (java.math.BigDecimal) _struct.getAttribute(1); }

  public void setCantidad(java.math.BigDecimal cantidad) throws SQLException
  { _struct.setAttribute(1, cantidad); }


  public java.sql.Timestamp getFecinicio() throws SQLException
  { return (java.sql.Timestamp) _struct.getAttribute(2); }

  public void setFecinicio(java.sql.Timestamp fecinicio) throws SQLException
  { _struct.setAttribute(2, fecinicio); }


  public java.sql.Timestamp getFecfin() throws SQLException
  { return (java.sql.Timestamp) _struct.getAttribute(3); }

  public void setFecfin(java.sql.Timestamp fecfin) throws SQLException
  { _struct.setAttribute(3, fecfin); }

}
