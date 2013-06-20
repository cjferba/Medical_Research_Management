package JdbcCustomDatum;

import java.sql.SQLException;
import java.sql.Connection;
import oracle.jdbc.OracleTypes;
import oracle.sql.ORAData;
import oracle.sql.ORADataFactory;
import oracle.sql.Datum;
import oracle.sql.STRUCT;
import oracle.jpub.runtime.MutableStruct;

public class MabdArticuloObj implements ORAData, ORADataFactory
{
  public static final String _SQL_NAME = "X5927137.MABD_ARTICULO_OBJ";
  public static final int _SQL_TYPECODE = OracleTypes.STRUCT;

  protected MutableStruct _struct;

  protected static int[] _sqlType =  { 2,12,12,12,2,2,91,2003,2003,2003,2003 };
  protected static ORADataFactory[] _factory = new ORADataFactory[11];
  static
  {
    _factory[7] = MabdLista.getORADataFactory();
    _factory[8] = MabdLista.getORADataFactory();
    _factory[9] = MabdLista.getORADataFactory();
    _factory[10] = MabdLista.getORADataFactory();
  }
  protected static final MabdArticuloObj _MabdArticuloObjFactory = new MabdArticuloObj();

  public static ORADataFactory getORADataFactory()
  { return _MabdArticuloObjFactory; }

  protected static java.util.Hashtable _map = new java.util.Hashtable();
  protected static boolean _initialized = false;
  protected static synchronized void init()
  { if (!_initialized)
    { _initialized=true;
      _map.put("X5927137.MABD_ARTICULO_OBJ",JdbcCustomDatum.MabdArticuloObj.getORADataFactory());
      _map.put("X5927137.MABD_ARTICULO_INTERNO_OBJ",JdbcCustomDatum.MabdArticuloInternoObj.getORADataFactory());
  } }

  /* constructors */
  protected void _init_struct(boolean init)
  { if (init) _struct = new MutableStruct(new Object[11], _sqlType, _factory); }
  public MabdArticuloObj()
  { _init_struct(true); }
  public MabdArticuloObj(java.math.BigDecimal articulo, String titulo, String nombinstituto, String revista, java.math.BigDecimal vol, java.math.BigDecimal num, java.sql.Timestamp anio, MabdLista lvirus, MabdLista laut, MabdLista lref, MabdLista lcitas) throws SQLException
  { _init_struct(true);
    setArticulo(articulo);
    setTitulo(titulo);
    setNombinstituto(nombinstituto);
    setRevista(revista);
    setVol(vol);
    setNum(num);
    setAnio(anio);
    setLvirus(lvirus);
    setLaut(laut);
    setLref(lref);
    setLcitas(lcitas);
  }

  /* ORAData interface */
  public Datum toDatum(Connection c) throws SQLException
  {
    return _struct.toDatum(c, _SQL_NAME);
  }


  /* ORADataFactory interface */
  public ORAData create(Datum d, int sqlType) throws SQLException
  { return create(null, d, sqlType); }
  protected ORAData create(MabdArticuloObj o, Datum d, int sqlType) throws SQLException
  {
    if (d == null) return null; 
    if (o == null) return createFromFactory("MabdArticuloObj", d, sqlType);
    o._struct = new MutableStruct((STRUCT) d, _sqlType, _factory);
    return o;
  }
  protected ORAData createExact(Datum d, int sqlType) throws SQLException
  {
    MabdArticuloObj o = new MabdArticuloObj();
    o._struct = new MutableStruct((STRUCT) d, _sqlType, _factory);
    return o;
  }
  protected ORAData createFromFactory(String s, Datum d, int sqlType) throws SQLException
  {
    String sql = ((STRUCT) d).getSQLTypeName();
    init();
    MabdArticuloObj factory = (MabdArticuloObj)_map.get(sql);
    if (factory == null) {
       int p;
       if ((p=sql.indexOf(".")) >= 0) {
          factory = (MabdArticuloObj)_map.get(sql.substring(p+1));
          if (factory!=null) _map.put(sql,factory); }
       if (factory == null) throw new SQLException
          ("Unable to convert a "+sql+" to a "+s+" or a subclass of "+s);
    }
    return factory.createExact(d,sqlType);
  }

  /* accessor methods */
  public java.math.BigDecimal getArticulo() throws SQLException
  { return (java.math.BigDecimal) _struct.getAttribute(0); }

  public void setArticulo(java.math.BigDecimal articulo) throws SQLException
  { _struct.setAttribute(0, articulo); }


  public String getTitulo() throws SQLException
  { return (String) _struct.getAttribute(1); }

  public void setTitulo(String titulo) throws SQLException
  { _struct.setAttribute(1, titulo); }


  public String getNombinstituto() throws SQLException
  { return (String) _struct.getAttribute(2); }

  public void setNombinstituto(String nombinstituto) throws SQLException
  { _struct.setAttribute(2, nombinstituto); }


  public String getRevista() throws SQLException
  { return (String) _struct.getAttribute(3); }

  public void setRevista(String revista) throws SQLException
  { _struct.setAttribute(3, revista); }


  public java.math.BigDecimal getVol() throws SQLException
  { return (java.math.BigDecimal) _struct.getAttribute(4); }

  public void setVol(java.math.BigDecimal vol) throws SQLException
  { _struct.setAttribute(4, vol); }


  public java.math.BigDecimal getNum() throws SQLException
  { return (java.math.BigDecimal) _struct.getAttribute(5); }

  public void setNum(java.math.BigDecimal num) throws SQLException
  { _struct.setAttribute(5, num); }


  public java.sql.Timestamp getAnio() throws SQLException
  { return (java.sql.Timestamp) _struct.getAttribute(6); }

  public void setAnio(java.sql.Timestamp anio) throws SQLException
  { _struct.setAttribute(6, anio); }


  public MabdLista getLvirus() throws SQLException
  { return (MabdLista) _struct.getAttribute(7); }

  public void setLvirus(MabdLista lvirus) throws SQLException
  { _struct.setAttribute(7, lvirus); }


  public MabdLista getLaut() throws SQLException
  { return (MabdLista) _struct.getAttribute(8); }

  public void setLaut(MabdLista laut) throws SQLException
  { _struct.setAttribute(8, laut); }


  public MabdLista getLref() throws SQLException
  { return (MabdLista) _struct.getAttribute(9); }

  public void setLref(MabdLista lref) throws SQLException
  { _struct.setAttribute(9, lref); }


  public MabdLista getLcitas() throws SQLException
  { return (MabdLista) _struct.getAttribute(10); }

  public void setLcitas(MabdLista lcitas) throws SQLException
  { _struct.setAttribute(10, lcitas); }

}
