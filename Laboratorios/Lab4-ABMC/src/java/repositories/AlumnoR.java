package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import connectors.AdministradorDeConexiones;
import entities.Alumno;

/**
 *
 * @author Facundo
 */
public class AlumnoR {
    
    private Connection conn;

    public AlumnoR() throws Exception {
        this.conn = AdministradorDeConexiones.getConnection();
    }
    
    public AlumnoR(Connection conn) {
        this.conn = conn;
    }
    
    public boolean save(Alumno alumno) {
        String sql = "insert into alumnos (nombre,apellido) values (?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, alumno.getNombre());
            ps.setString(2, alumno.getApellido());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                alumno.setId(rs.getInt(1));
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }
    
    public boolean update(Alumno alumno) {
        String sql = "update alumnos set nombre = ?, apellido = ? where alumno_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, alumno.getNombre());
            ps.setString(2, alumno.getApellido());
            ps.setInt(3,alumno.getId());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }
    
    public boolean eliminar(int id) throws SQLException {
        String sql = "delete from alumnos where alumno_id = " + id;
        Statement eliminacion = conn.createStatement();
        if(eliminacion.execute(sql)){
            eliminacion.close();
            return true;
        }
        eliminacion.close();
        return false;
    }
    
    public ArrayList<Alumno> getAll(){
        return getByFiltro("where 1=1");
    }
    
    public Alumno getById(int id) throws SQLException{
        String sql = "select * from alumnos where alumno_id = " + id;
        Alumno retorno = new Alumno();
        retorno.setId(id);
        ResultSet rs = conn.createStatement().executeQuery(sql);
        if(rs.next()){
            retorno.setNombre(rs.getString("nombre"));
            retorno.setApellido(rs.getString("apellido"));
        }
        return retorno;
    }
    
    public ArrayList<Alumno> getByName(String nombre){
        return getByFiltro("where nombre like '%"+nombre+ "%'");
    }
    
    public ArrayList<Alumno> getByApellido(String apellido){
        return getByFiltro("where apellido like '%"+apellido+"%'");
    }
    
    public ArrayList<Alumno> getAlumno(Alumno alumno) {
        return getByFiltro("where alumno_id = "+alumno.getId()+" and nombre = "+alumno.getNombre()+
                " and apellido = " +alumno.getApellido());
    }
    
    private ArrayList<Alumno> getByFiltro(String filtro){
        String sql = "select * from alumnos "+ filtro;
        ArrayList<Alumno> lista = new ArrayList<>();
        try {
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while(rs.next()){
                lista.add(new Alumno(
                        rs.getInt("alumno_id"),
                        rs.getString("nombre"),
                        rs.getString("apellido")
                ));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return lista;
    }
}
