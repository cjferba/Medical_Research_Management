package JdbcCustomDatum;

import java.sql.SQLException;
import java.sql.Connection;
import oracle.jdbc.OracleTypes;
import oracle.sql.ORAData;
import oracle.sql.ORADataFactory;
import oracle.sql.Datum;
import oracle.sql.STRUCT;
import oracle.jpub.runtime.MutableStruct;

public class Instituto implements ORAData, ORADataFactory
{
  public static final String _SQL_NAME = "X5927137.INSTITUTO";
  public static final int _SQL_TYPECODE = OracleTypes.STRUCT;

  protected MutableStruct _struct;

  protected static int[] _sqlType =  { 2,12,12,12,2003 };
  protected static ORADataFactory[] _factory = new ORADataFactory[5];
  static
  {
    _factory[4] = ListaNumber.getORADataFactory();
  }
  protected static final Instituto _InstitutoFactory = new Instituto();

  public static ORADataFactory getORADataFactory()
  { return _InstitutoFactory; }
  /* constructors */
  protected void _init_struct(boolean init)
  { if (init) _struct = new MutableStruct(new Object[5], _sqlType, _factory); }
  public Instituto()
  { _init_struct(true); }
  public Instituto(java.math.BigDecimal idInstituto, String nombre, String direccion, String tipo, ListaNumber listaArticulos) throws SQLException
  { _init_struct(true);
    setIdInstituto(idInstituto);
    setNombre(nombre);
    setDireccion(direccion);
    setTipo(tipo);
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
  protected ORAData create(Instituto o, Datum d, int sqlType) throws SQLException
  {
    if (d == null) return null; 
    if (o == null) o = new Instituto();
    o._struct = new MutableStruct((STRUCT) d, _sqlType, _factory);
    return o;
  }
  /* accessor methods */
  public java.math.BigDecimal getIdInstituto() throws SQLException
  { return (java.math.BigDecimal) _struct.getAttribute(0); }

  public void setIdInstituto(java.math.BigDecimal idInstituto) throws SQLException
  { _struct.setAttribute(0, idInstituto); }


  public String getNombre() throws SQLException
  { return (String) _struct.getAttribute(1); }

  public void setNombre(String nombre) throws SQLException
  { _struct.setAttribute(1, nombre); }


  public String getDireccion() throws SQLException
  { return (String) _struct.getAttribute(2); }

  public void setDireccion(String direccion) throws SQLException
  { _struct.setAttribute(2, direccion); }


  public String getTipo() throws SQLException
  { return (String) _struct.getAttribute(3); }

  public void setTipo(String tipo) throws SQLException
  { _struct.setAttribute(3, tipo); }


  public ListaNumber getListaArticulos() throws SQLException
  { return (ListaNumber) _struct.getAttribute(4); }

  public void setListaArticulos(ListaNumber listaArticulos) throws SQLException
  { _struct.setAttribute(4, listaArticulos); }

}
