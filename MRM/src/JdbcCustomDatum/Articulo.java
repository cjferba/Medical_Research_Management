package JdbcCustomDatum;

import java.sql.SQLException;
import java.sql.Connection;
import oracle.jdbc.OracleTypes;
import oracle.sql.ORAData;
import oracle.sql.ORADataFactory;
import oracle.sql.Datum;
import oracle.sql.STRUCT;
import oracle.jpub.runtime.MutableStruct;

public class Articulo implements ORAData, ORADataFactory
{
  public static final String _SQL_NAME = "X5927137.ARTICULO";
  public static final int _SQL_TYPECODE = OracleTypes.STRUCT;

  protected MutableStruct _struct;

  protected static int[] _sqlType =  { 2,12,12,2,2,2,2,2003,2003,2003,2003 };
  protected static ORADataFactory[] _factory = new ORADataFactory[11];
  static
  {
    _factory[7] = ListaNumber.getORADataFactory();
    _factory[8] = ListaNumber.getORADataFactory();
    _factory[9] = ListaNumber.getORADataFactory();
    _factory[10] = ListaNumber.getORADataFactory();
  }
  protected static final Articulo _ArticuloFactory = new Articulo();

  public static ORADataFactory getORADataFactory()
  { return _ArticuloFactory; }

  protected static java.util.Hashtable _map = new java.util.Hashtable();
  protected static boolean _initialized = false;
  protected static synchronized void init()
  { if (!_initialized)
    { _initialized=true;
      _map.put("X5927137.ARTICULO",JdbcCustomDatum.Articulo.getORADataFactory());
      _map.put("X5927137.ARTICULO_INTERNO",JdbcCustomDatum.ArticuloInterno.getORADataFactory());
  } }

  /* constructors */
  protected void _init_struct(boolean init)
  { if (init) _struct = new MutableStruct(new Object[11], _sqlType, _factory); }
  public Articulo()
  { _init_struct(true); }
  public Articulo(java.math.BigDecimal articulo, String titulo, String revista, java.math.BigDecimal vol, java.math.BigDecimal num, java.math.BigDecimal anio, java.math.BigDecimal institutoRef, ListaNumber listaVirus, ListaNumber listaAutores, ListaNumber referencia, ListaNumber esReferenciado) throws SQLException
  { _init_struct(true);
    setArticulo(articulo);
    setTitulo(titulo);
    setRevista(revista);
    setVol(vol);
    setNum(num);
    setAnio(anio);
    setInstitutoRef(institutoRef);
    setListaVirus(listaVirus);
    setListaAutores(listaAutores);
    setReferencia(referencia);
    setEsReferenciado(esReferenciado);
  }

  /* ORAData interface */
  public Datum toDatum(Connection c) throws SQLException
  {
    return _struct.toDatum(c, _SQL_NAME);
  }


  /* ORADataFactory interface */
  public ORAData create(Datum d, int sqlType) throws SQLException
  { return create(null, d, sqlType); }
  protected ORAData create(Articulo o, Datum d, int sqlType) throws SQLException
  {
    if (d == null) return null; 
    if (o == null) return createFromFactory("Articulo", d, sqlType);
    o._struct = new MutableStruct((STRUCT) d, _sqlType, _factory);
    return o;
  }
  protected ORAData createExact(Datum d, int sqlType) throws SQLException
  {
    Articulo o = new Articulo();
    o._struct = new MutableStruct((STRUCT) d, _sqlType, _factory);
    return o;
  }
  protected ORAData createFromFactory(String s, Datum d, int sqlType) throws SQLException
  {
    String sql = ((STRUCT) d).getSQLTypeName();
    init();
    Articulo factory = (Articulo)_map.get(sql);
    if (factory == null) {
       int p;
       if ((p=sql.indexOf(".")) >= 0) {
          factory = (Articulo)_map.get(sql.substring(p+1));
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


  public String getRevista() throws SQLException
  { return (String) _struct.getAttribute(2); }

  public void setRevista(String revista) throws SQLException
  { _struct.setAttribute(2, revista); }


  public java.math.BigDecimal getVol() throws SQLException
  { return (java.math.BigDecimal) _struct.getAttribute(3); }

  public void setVol(java.math.BigDecimal vol) throws SQLException
  { _struct.setAttribute(3, vol); }


  public java.math.BigDecimal getNum() throws SQLException
  { return (java.math.BigDecimal) _struct.getAttribute(4); }

  public void setNum(java.math.BigDecimal num) throws SQLException
  { _struct.setAttribute(4, num); }


  public java.math.BigDecimal getAnio() throws SQLException
  { return (java.math.BigDecimal) _struct.getAttribute(5); }

  public void setAnio(java.math.BigDecimal anio) throws SQLException
  { _struct.setAttribute(5, anio); }


  public java.math.BigDecimal getInstitutoRef() throws SQLException
  { return (java.math.BigDecimal) _struct.getAttribute(6); }

  public void setInstitutoRef(java.math.BigDecimal institutoRef) throws SQLException
  { _struct.setAttribute(6, institutoRef); }


  public ListaNumber getListaVirus() throws SQLException
  { return (ListaNumber) _struct.getAttribute(7); }

  public void setListaVirus(ListaNumber listaVirus) throws SQLException
  { _struct.setAttribute(7, listaVirus); }


  public ListaNumber getListaAutores() throws SQLException
  { return (ListaNumber) _struct.getAttribute(8); }

  public void setListaAutores(ListaNumber listaAutores) throws SQLException
  { _struct.setAttribute(8, listaAutores); }


  public ListaNumber getReferencia() throws SQLException
  { return (ListaNumber) _struct.getAttribute(9); }

  public void setReferencia(ListaNumber referencia) throws SQLException
  { _struct.setAttribute(9, referencia); }


  public ListaNumber getEsReferenciado() throws SQLException
  { return (ListaNumber) _struct.getAttribute(10); }

  public void setEsReferenciado(ListaNumber esReferenciado) throws SQLException
  { _struct.setAttribute(10, esReferenciado); }

}
