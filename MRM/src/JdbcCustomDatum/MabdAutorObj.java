package JdbcCustomDatum;

import java.sql.SQLException;
import java.sql.Connection;
import oracle.jdbc.OracleTypes;
import oracle.sql.ORAData;
import oracle.sql.ORADataFactory;
import oracle.sql.Datum;
import oracle.sql.STRUCT;
import oracle.jpub.runtime.MutableStruct;

public class MabdAutorObj implements ORAData, ORADataFactory
{
  public static final String _SQL_NAME = "X5927137.MABD_AUTOR_OBJ";
  public static final int _SQL_TYPECODE = OracleTypes.STRUCT;

  protected MutableStruct _struct;

  protected static int[] _sqlType =  { 2,12,12,91,2003 };
  protected static ORADataFactory[] _factory = new ORADataFactory[5];
  static
  {
    _factory[4] = MabdLista.getORADataFactory();
  }
  protected static final MabdAutorObj _MabdAutorObjFactory = new MabdAutorObj();

  public static ORADataFactory getORADataFactory()
  { return _MabdAutorObjFactory; }
  /* constructors */
  protected void _init_struct(boolean init)
  { if (init) _struct = new MutableStruct(new Object[5], _sqlType, _factory); }
  public MabdAutorObj()
  { _init_struct(true); }
  public MabdAutorObj(java.math.BigDecimal autor, String nombre, String nacionalidad, java.sql.Timestamp fechaNac, MabdLista lart) throws SQLException
  { _init_struct(true);
    setAutor(autor);
    setNombre(nombre);
    setNacionalidad(nacionalidad);
    setFechaNac(fechaNac);
    setLart(lart);
  }

  /* ORAData interface */
  public Datum toDatum(Connection c) throws SQLException
  {
    return _struct.toDatum(c, _SQL_NAME);
  }


  /* ORADataFactory interface */
  public ORAData create(Datum d, int sqlType) throws SQLException
  { return create(null, d, sqlType); }
  protected ORAData create(MabdAutorObj o, Datum d, int sqlType) throws SQLException
  {
    if (d == null) return null; 
    if (o == null) o = new MabdAutorObj();
    o._struct = new MutableStruct((STRUCT) d, _sqlType, _factory);
    return o;
  }
  /* accessor methods */
  public java.math.BigDecimal getAutor() throws SQLException
  { return (java.math.BigDecimal) _struct.getAttribute(0); }

  public void setAutor(java.math.BigDecimal autor) throws SQLException
  { _struct.setAttribute(0, autor); }


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


  public MabdLista getLart() throws SQLException
  { return (MabdLista) _struct.getAttribute(4); }

  public void setLart(MabdLista lart) throws SQLException
  { _struct.setAttribute(4, lart); }

}
