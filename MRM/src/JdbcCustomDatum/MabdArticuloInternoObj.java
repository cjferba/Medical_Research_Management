package JdbcCustomDatum;

import java.sql.SQLException;
import java.sql.Connection;
import oracle.jdbc.OracleTypes;
import oracle.sql.ORAData;
import oracle.sql.ORADataFactory;
import oracle.sql.Datum;
import oracle.sql.STRUCT;
import oracle.jpub.runtime.MutableStruct;

public class MabdArticuloInternoObj extends MabdArticuloObj implements ORAData, ORADataFactory
{
  public static final String _SQL_NAME = "X5927137.MABD_ARTICULO_INTERNO_OBJ";
  public static final int _SQL_TYPECODE = OracleTypes.STRUCT;

  protected static int[] _sqlType =  { 2,12,12,12,2,2,91,2003,2003,2003,2003,2006 };
  protected static ORADataFactory[] _factory = new ORADataFactory[12];
  static
  {
    _factory[7] = MabdLista.getORADataFactory();
    _factory[8] = MabdLista.getORADataFactory();
    _factory[9] = MabdLista.getORADataFactory();
    _factory[10] = MabdLista.getORADataFactory();
    _factory[11] = MabdContratoObjRef.getORADataFactory();
  }
  protected static final MabdArticuloInternoObj _MabdArticuloInternoObjFactory = new MabdArticuloInternoObj();

  public static ORADataFactory getORADataFactory()
  { return _MabdArticuloInternoObjFactory; }
  static
  { _map.put("X5927137.MABD_ARTICULO_INTERNO_OBJ", _MabdArticuloInternoObjFactory); }

  /* constructors */
  protected void _init_struct(boolean init)
  { if (init) _struct = new MutableStruct(new Object[12], _sqlType, _factory); }
  public MabdArticuloInternoObj()
  { _init_struct(true); }
  public MabdArticuloInternoObj(java.math.BigDecimal articulo, String titulo, String nombinstituto, String revista, java.math.BigDecimal vol, java.math.BigDecimal num, java.sql.Timestamp anio, MabdLista lvirus, MabdLista laut, MabdLista lref, MabdLista lcitas, MabdContratoObjRef cod) throws SQLException
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
    setCod(cod);
  }

  /* ORAData interface */
  public Datum toDatum(Connection c) throws SQLException
  {
    return _struct.toDatum(c, _SQL_NAME);
  }


  /* ORADataFactory interface */
  public ORAData create(Datum d, int sqlType) throws SQLException
  { return create(null, d, sqlType); }
  protected ORAData create(MabdArticuloInternoObj o, Datum d, int sqlType) throws SQLException
  {
    if (d == null) return null; 
    if (o == null) return createFromFactory("MabdArticuloInternoObj", d, sqlType);
    o._struct = new MutableStruct((STRUCT) d, _sqlType, _factory);
    return o;
  }
  protected ORAData createExact(Datum d, int sqlType) throws SQLException
  {
    MabdArticuloInternoObj o = new MabdArticuloInternoObj();
    o._struct = new MutableStruct((STRUCT) d, _sqlType, _factory);
    return o;
  }

  /* accessor methods */
  public MabdContratoObjRef getCod() throws SQLException
  { return (MabdContratoObjRef) _struct.getAttribute(11); }

  public void setCod(MabdContratoObjRef cod) throws SQLException
  { _struct.setAttribute(11, cod); }

}
