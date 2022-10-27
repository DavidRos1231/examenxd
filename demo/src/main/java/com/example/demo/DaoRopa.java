package com.example.demo;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoRopa {
    Connection connection;
    ResultSet rs;
    PreparedStatement ps;
    MySQLConnection MySQL=new MySQLConnection();

    public List<BeanRopa> listacompleta(){
        List<BeanRopa> listaropa=new ArrayList<>();
        BeanRopa ropa =null;
        BeanTipo tipo=null;
        BeanCategoria categoria=null;
        try{
            connection=MySQL.getConnection();
            ps=connection.prepareStatement("SELECT * FROM shop.listacompleta;");
            rs=ps.executeQuery();
            while (rs.next()){
            ropa=new BeanRopa();
            tipo=new BeanTipo();
            categoria=new BeanCategoria();
            ropa.setId(rs.getLong("id"));
            ropa.setNombre(rs.getString("name"));
            ropa.setPrecio(rs.getDouble("price"));
            ropa.setTalla(rs.getString("size"));
            ropa.setMarca(rs.getString("brand"));
            ropa.setStock(rs.getInt("stock"));
            ropa.setTela(rs.getString("cloth_type"));
            ropa.setFechregistro(rs.getString("created_at"));
            ropa.setEstado(rs.getString("status"));
            tipo.setNombre(rs.getString("type"));
            categoria.setName(rs.getString("category"));
            ropa.setCategoria(categoria);
            ropa.setTipo(tipo);
            listaropa.add(ropa);
                    }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            MySQL.close(connection,ps,rs);
        }
        return listaropa;
    }
    public Response<BeanRopa> save(BeanRopa ropa){
        try {
            connection=MySQL.getConnection();
            String query="INSERT INTO `shop`.`clothes` (`name`, `price`, `size`, `brand`, `stock`, `cloth_type`, `created_at`, `status`, `category_id`, `clothe_type_id`) VALUES (?, ?, ?, ?, ?, ?, now(), ?, ?, ?);";
            ps=connection.prepareStatement(query);
            ps.setString(1,ropa.getNombre());
            ps.setDouble(2,ropa.getPrecio());
            ps.setString(3,ropa.getTalla());
            ps.setString(4,ropa.getMarca());
            ps.setInt(5,ropa.getStock());
            ps.setString(6,ropa.getTela());
            ps.setString(7,ropa.getEstado());
            ps.setLong(8,ropa.getCategoria().getId());
            ps.setLong(9,ropa.getCategoria().getId());
            if(ps.executeUpdate()==1) {
                return new Response<>(200, "Registrado correctamente", ropa, false);

            }else{
                    return new Response<>(200,"Error al registrar",ropa,false);
                }
            }
        catch (SQLException e){
            Logger.getLogger(DaoRopa.class.getCanonicalName())
                    .log(Level.SEVERE,"Error ->Save:"+e.getMessage());
            return new Response<>(400,"Error al registrar",ropa,true);
        }
    }

    public BeanRopa findone(long id) {
        BeanRopa ropa =null;
        BeanTipo tipo=null;
        BeanCategoria categoria=null;
        try{
            connection=MySQL.getConnection();
            ps=connection.prepareStatement("SELECT * FROM shop.listacompleta where id=?;");
            ps.setLong(1,id);
            rs=ps.executeQuery();
            while (rs.next()){
                ropa=new BeanRopa();
                tipo=new BeanTipo();
                categoria=new BeanCategoria();
                ropa.setId(rs.getLong("id"));
                ropa.setNombre(rs.getString("name"));
                ropa.setPrecio(rs.getDouble("price"));
                ropa.setTalla(rs.getString("size"));
                ropa.setMarca(rs.getString("brand"));
                ropa.setStock(rs.getInt("stock"));
                ropa.setTela(rs.getString("cloth_type"));
                ropa.setFechregistro(rs.getString("created_at"));
                ropa.setEstado(rs.getString("status"));
                tipo.setNombre(rs.getString("type"));
                categoria.setName(rs.getString("category"));
                ropa.setCategoria(categoria);
                ropa.setTipo(tipo);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            MySQL.close(connection,ps,rs);
        }
        return ropa;
    }
}
