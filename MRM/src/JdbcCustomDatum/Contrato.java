package JdbcCustomDatum;

import java.sql.SQLException;
import java.sql.Connection;
import oracle.jdbc.OracleTypes;
import oracle.sql.ORAData;
import oracle.sql.ORADataFactory;
import oracle.sql.Datum;
import oracle.sql.STRUCT;
import oracle.jpub.runtime.MutableStruct;

public class Contrato implements ORAData, ORADataFactory
{
  public static final String _SQL_NAME = "X5927137.CONTRATO";
  public static final int _SQL_TYPECODE = OracleTypes.STRUCT;

  protected MutableStruct _struct;

  protected static int[] _sqlType =  { 2,2,91,91,2003 };
  protected static ORADataFactory[] _factory = new ORADataFactory[5];
  static
  {
    _factory[4] = ListaNumber.getORADataFactory();
  }
  protected static final Contrato _ContratoFactory = new Contrato();

  public static ORADataFactory getORADataFactory()
  { return _ContratoFactory; }
  /* constructors */
  protected void _init_struct(boolean init)
  { if (init) _struct = new MutableStruct(new Object[5], _sqlType, _factory); }
  public Contrato()
  { _init_struct(true); }
  public Contrato(java.math.BigDecimal cod, java.math.BigDecimal cantidad, java.sql.Timestamp fechaInicio, java.sql.Timestamp fechaFin, ListaNumber listaArticulos) throws SQLException
  { _init_struct(true);
    setCod(cod);
    setCantidad(cantidad);
    setFechaInicio(fechaInicio);
    setFechaFin(fechaFin);
    setListaArticulos(listaArticulos);
  }

  /* ORAData interface */
  public Datum toDatum(Connection c) throws SQLException
  {
    return _struct.toDatum(c, _SQL_NAME);
  }


  /* ORADataFactory interface */
  public ORAData create(Datum d, int sqlType) throws SQLException
  { return create(null, d, sqlType); }
  protected ORAData create(Contrato o, Datum d, int sqlType) throws SQLException
  {
    if (d == null) return null; 
    if (o == null) o = new Contrato();
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


  public java.sql.Timestamp getFechaInicio() throws SQLException
  { return (java.sql.Timestamp) _struct.getAttribute(2); }

  public void setFechaInicio(java.sql.Timestamp fechaInicio) throws SQLException
  { _struct.setAttribute(2, fechaInicio); }


  public java.sql.Timestamp getFechaFin() throws SQLException
  { return (java.sql.Timestamp) _struct.getAttribute(3); }

  public void setFechaFin(java.sql.Timestamp fechaFin) throws SQLException
  { _struct.setAttribute(3, fechaFin); }


  public ListaNumber getListaArticulos() throws SQLException
  { return (ListaNumber) _struct.getAttribute(4); }

  public void setListaArticulos(ListaNumber listaArticulos) throws SQLException
  { _struct.setAttribute(4, listaArticulos); }

}
