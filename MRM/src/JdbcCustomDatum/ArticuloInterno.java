package JdbcCustomDatum;

import java.sql.SQLException;
import java.sql.Connection;
import oracle.jdbc.OracleTypes;
import oracle.sql.ORAData;
import oracle.sql.ORADataFactory;
import oracle.sql.Datum;
import oracle.sql.STRUCT;
import oracle.jpub.runtime.MutableStruct;

public class ArticuloInterno extends Articulo implements ORAData, ORADataFactory
{
  public static final String _SQL_NAME = "X5927137.ARTICULO_INTERNO";
  public static final int _SQL_TYPECODE = OracleTypes.STRUCT;

  protected static int[] _sqlType =  { 2,12,12,2,2,2,2,2003,2003,2003,2003,2 };
  protected static ORADataFactory[] _factory = new ORADataFactory[12];
  static
  {
    _factory[7] = ListaNumber.getORADataFactory();
    _factory[8] = ListaNumber.getORADataFactory();
    _factory[9] = ListaNumber.getORADataFactory();
    _factory[10] = ListaNumber.getORADataFactory();
  }
  protected static final ArticuloInterno _ArticuloInternoFactory = new ArticuloInterno();

  public static ORADataFactory getORADataFactory()
  { return _ArticuloInternoFactory; }
  static
  { _map.put("X5927137.ARTICULO_INTERNO", _ArticuloInternoFactory); }

  /* constructors */
  protected void _init_struct(boolean init)
  { if (init) _struct = new MutableStruct(new Object[12], _sqlType, _factory); }
  public ArticuloInterno()
  { _init_struct(true); }
  public ArticuloInterno(java.math.BigDecimal articulo, String titulo, String revista, java.math.BigDecimal vol, java.math.BigDecimal num, java.math.BigDecimal anio, java.math.BigDecimal institutoRef, ListaNumber listaVirus, ListaNumber listaAutores, ListaNumber referencia, ListaNumber esReferenciado, java.math.BigDecimal contrato) throws SQLException
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
    setContrato(contrato);
  }

  /* ORAData interface */
  public Datum toDatum(Connection c) throws SQLException
  {
    return _struct.toDatum(c, _SQL_NAME);
  }


  /* ORADataFactory interface */
  public ORAData create(Datum d, int sqlType) throws SQLException
  { return create(null, d, sqlType); }
  protected ORAData create(ArticuloInterno o, Datum d, int sqlType) throws SQLException
  {
    if (d == null) return null; 
    if (o == null) return createFromFactory("ArticuloInterno", d, sqlType);
    o._struct = new MutableStruct((STRUCT) d, _sqlType, _factory);
    return o;
  }
  protected ORAData createExact(Datum d, int sqlType) throws SQLException
  {
    ArticuloInterno o = new ArticuloInterno();
    o._struct = new MutableStruct((STRUCT) d, _sqlType, _factory);
    return o;
  }

  /* accessor methods */
  public java.math.BigDecimal getContrato() throws SQLException
  { return (java.math.BigDecimal) _struct.getAttribute(11); }

  public void setContrato(java.math.BigDecimal contrato) throws SQLException
  { _struct.setAttribute(11, contrato); }

}
