package JdbcCustomDatum;

import java.sql.SQLException;
import java.sql.Connection;
import oracle.jdbc.OracleTypes;
import oracle.sql.ORAData;
import oracle.sql.ORADataFactory;
import oracle.sql.Datum;
import oracle.sql.STRUCT;
import oracle.jpub.runtime.MutableStruct;

public class InstitutoObjtyp implements ORAData, ORADataFactory
{
  public static final String _SQL_NAME = "X5927137.INSTITUTO_OBJTYP";
  public static final int _SQL_TYPECODE = OracleTypes.STRUCT;

  protected MutableStruct _struct;

  protected static int[] _sqlType =  { 12,12,12 };
  protected static ORADataFactory[] _factory = new ORADataFactory[3];
  protected static final InstitutoObjtyp _InstitutoObjtypFactory = new InstitutoObjtyp();

  public static ORADataFactory getORADataFactory()
  { return _InstitutoObjtypFactory; }
  /* constructors */
  protected void _init_struct(boolean init)
  { if (init) _struct = new MutableStruct(new Object[3], _sqlType, _factory); }
  public InstitutoObjtyp()
  { _init_struct(true); }
  public InstitutoObjtyp(String nombre, String direccion, String tipo) throws SQLException
  { _init_struct(true);
    setNombre(nombre);
    setDireccion(direccion);
    setTipo(tipo);
  }

  /* ORAData interface */
  public Datum toDatum(Connection c) throws SQLException
  {
    return _struct.toDatum(c, _SQL_NAME);
  }


  /* ORADataFactory interface */
  public ORAData create(Datum d, int sqlType) throws SQLException
  { return create(null, d, sqlType); }
  protected ORAData create(InstitutoObjtyp o, Datum d, int sqlType) throws SQLException
  {
    if (d == null) return null; 
    if (o == null) o = new InstitutoObjtyp();
    o._struct = new MutableStruct((STRUCT) d, _sqlType, _factory);
    return o;
  }
  /* accessor methods */
  public String getNombre() throws SQLException
  { return (String) _struct.getAttribute(0); }

  public void setNombre(String nombre) throws SQLException
  { _struct.setAttribute(0, nombre); }


  public String getDireccion() throws SQLException
  { return (String) _struct.getAttribute(1); }

  public void setDireccion(String direccion) throws SQLException
  { _struct.setAttribute(1, direccion); }


  public String getTipo() throws SQLException
  { return (String) _struct.getAttribute(2); }

  public void setTipo(String tipo) throws SQLException
  { _struct.setAttribute(2, tipo); }

}
