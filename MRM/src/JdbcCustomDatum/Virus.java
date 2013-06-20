package JdbcCustomDatum;

import java.sql.SQLException;
import java.sql.Connection;
import oracle.jdbc.OracleTypes;
import oracle.sql.ORAData;
import oracle.sql.ORADataFactory;
import oracle.sql.Datum;
import oracle.sql.STRUCT;
import oracle.jpub.runtime.MutableStruct;

public class Virus implements ORAData, ORADataFactory
{
  public static final String _SQL_NAME = "X5927137.VIRUS";
  public static final int _SQL_TYPECODE = OracleTypes.STRUCT;

  protected MutableStruct _struct;

  protected static int[] _sqlType =  { 2,12,12,2003 };
  protected static ORADataFactory[] _factory = new ORADataFactory[4];
  static
  {
    _factory[3] = ListaNumber.getORADataFactory();
  }
  protected static final Virus _VirusFactory = new Virus();

  public static ORADataFactory getORADataFactory()
  { return _VirusFactory; }
  /* constructors */
  protected void _init_struct(boolean init)
  { if (init) _struct = new MutableStruct(new Object[4], _sqlType, _factory); }
  public Virus()
  { _init_struct(true); }
  public Virus(java.math.BigDecimal idVirus, String nombre, String descripcion, ListaNumber listaArticulos) throws SQLException
  { _init_struct(true);
    setIdVirus(idVirus);
    setNombre(nombre);
    setDescripcion(descripcion);
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
  protected ORAData create(Virus o, Datum d, int sqlType) throws SQLException
  {
    if (d == null) return null; 
    if (o == null) o = new Virus();
    o._struct = new MutableStruct((STRUCT) d, _sqlType, _factory);
    return o;
  }
  /* accessor methods */
  public java.math.BigDecimal getIdVirus() throws SQLException
  { return (java.math.BigDecimal) _struct.getAttribute(0); }

  public void setIdVirus(java.math.BigDecimal idVirus) throws SQLException
  { _struct.setAttribute(0, idVirus); }


  public String getNombre() throws SQLException
  { return (String) _struct.getAttribute(1); }

  public void setNombre(String nombre) throws SQLException
  { _struct.setAttribute(1, nombre); }


  public String getDescripcion() throws SQLException
  { return (String) _struct.getAttribute(2); }

  public void setDescripcion(String descripcion) throws SQLException
  { _struct.setAttribute(2, descripcion); }


  public ListaNumber getListaArticulos() throws SQLException
  { return (ListaNumber) _struct.getAttribute(3); }

  public void setListaArticulos(ListaNumber listaArticulos) throws SQLException
  { _struct.setAttribute(3, listaArticulos); }

}
