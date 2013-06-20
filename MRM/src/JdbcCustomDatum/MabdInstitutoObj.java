package JdbcCustomDatum;

import java.sql.SQLException;
import java.sql.Connection;
import oracle.jdbc.OracleTypes;
import oracle.sql.ORAData;
import oracle.sql.ORADataFactory;
import oracle.sql.Datum;
import oracle.sql.STRUCT;
import oracle.jpub.runtime.MutableStruct;

public class MabdInstitutoObj implements ORAData, ORADataFactory
{
  public static final String _SQL_NAME = "X5927137.MABD_INSTITUTO_OBJ";
  public static final int _SQL_TYPECODE = OracleTypes.STRUCT;

  protected MutableStruct _struct;

  protected static int[] _sqlType =  { 12,12,12,2003 };
  protected static ORADataFactory[] _factory = new ORADataFactory[4];
  static
  {
    _factory[3] = MabdLista.getORADataFactory();
  }
  protected static final MabdInstitutoObj _MabdInstitutoObjFactory = new MabdInstitutoObj();

  public static ORADataFactory getORADataFactory()
  { return _MabdInstitutoObjFactory; }
  /* constructors */
  protected void _init_struct(boolean init)
  { if (init) _struct = new MutableStruct(new Object[4], _sqlType, _factory); }
  public MabdInstitutoObj()
  { _init_struct(true); }
  public MabdInstitutoObj(String nombinstituto, String direccion, String tipo, MabdLista larticulos) throws SQLException
  { _init_struct(true);
    setNombinstituto(nombinstituto);
    setDireccion(direccion);
    setTipo(tipo);
    setLarticulos(larticulos);
  }

  /* ORAData interface */
  public Datum toDatum(Connection c) throws SQLException
  {
    return _struct.toDatum(c, _SQL_NAME);
  }


  /* ORADataFactory interface */
  public ORAData create(Datum d, int sqlType) throws SQLException
  { return create(null, d, sqlType); }
  protected ORAData create(MabdInstitutoObj o, Datum d, int sqlType) throws SQLException
  {
    if (d == null) return null; 
    if (o == null) o = new MabdInstitutoObj();
    o._struct = new MutableStruct((STRUCT) d, _sqlType, _factory);
    return o;
  }
  /* accessor methods */
  public String getNombinstituto() throws SQLException
  { return (String) _struct.getAttribute(0); }

  public void setNombinstituto(String nombinstituto) throws SQLException
  { _struct.setAttribute(0, nombinstituto); }


  public String getDireccion() throws SQLException
  { return (String) _struct.getAttribute(1); }

  public void setDireccion(String direccion) throws SQLException
  { _struct.setAttribute(1, direccion); }


  public String getTipo() throws SQLException
  { return (String) _struct.getAttribute(2); }

  public void setTipo(String tipo) throws SQLException
  { _struct.setAttribute(2, tipo); }


  public MabdLista getLarticulos() throws SQLException
  { return (MabdLista) _struct.getAttribute(3); }

  public void setLarticulos(MabdLista larticulos) throws SQLException
  { _struct.setAttribute(3, larticulos); }

}
