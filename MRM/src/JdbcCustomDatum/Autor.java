package JdbcCustomDatum;

import java.sql.SQLException;
import java.sql.Connection;
import oracle.jdbc.OracleTypes;
import oracle.sql.ORAData;
import oracle.sql.ORADataFactory;
import oracle.sql.Datum;
import oracle.sql.STRUCT;
import oracle.jpub.runtime.MutableStruct;

public class Autor implements ORAData, ORADataFactory
{
  public static final String _SQL_NAME = "X5927137.AUTOR";
  public static final int _SQL_TYPECODE = OracleTypes.STRUCT;

  protected MutableStruct _struct;

  protected static int[] _sqlType =  { 2,12,12,91,2003 };
  protected static ORADataFactory[] _factory = new ORADataFactory[5];
  static
  {
    _factory[4] = ListaNumber.getORADataFactory();
  }
  protected static final Autor _AutorFactory = new Autor();

  public static ORADataFactory getORADataFactory()
  { return _AutorFactory; }
  /* constructors */
  protected void _init_struct(boolean init)
  { if (init) _struct = new MutableStruct(new Object[5], _sqlType, _factory); }
  public Autor()
  { _init_struct(true); }
  public Autor(java.math.BigDecimal idAutor, String nombre, String nacionalidad, java.sql.Timestamp fechaNac, ListaNumber listaArticulos) throws SQLException
  { _init_struct(true);
    setIdAutor(idAutor);
    setNombre(nombre);
    setNacionalidad(nacionalidad);
    setFechaNac(fechaNac);
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
  protected ORAData create(Autor o, Datum d, int sqlType) throws SQLException
  {
    if (d == null) return null; 
    if (o == null) o = new Autor();
    o._struct = new MutableStruct((STRUCT) d, _sqlType, _factory);
    return o;
  }
  /* accessor methods */
  public java.math.BigDecimal getIdAutor() throws SQLException
  { return (java.math.BigDecimal) _struct.getAttribute(0); }

  public void setIdAutor(java.math.BigDecimal idAutor) throws SQLException
  { _struct.setAttribute(0, idAutor); }


  public String getNombre() throws SQLException
  { return (String) _struct.getAttribute(1); }

  public void setNombre(String nombre) throws SQLException
  { _struct.setAttribute(1, nombre); }


  public String getNacionalidad() throws SQLException
  { return (String) _struct.getAttribute(2); }

  public void setNacionalidad(String nacionalidad) throws SQLException
  { _struct.setAttribute(2, nacionalidad); }


  public java.sql.Timestamp getFechaNac() throws SQLException
  { return (java.sql.Timestamp) _struct.getAttribute(3); }

  public void setFechaNac(java.sql.Timestamp fechaNac) throws SQLException
  { _struct.setAttribute(3, fechaNac); }


  public ListaNumber getListaArticulos() throws SQLException
  { return (ListaNumber) _struct.getAttribute(4); }

  public void setListaArticulos(ListaNumber listaArticulos) throws SQLException
  { _struct.setAttribute(4, listaArticulos); }

}
