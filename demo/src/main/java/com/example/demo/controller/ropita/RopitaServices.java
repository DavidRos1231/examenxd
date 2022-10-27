package com.example.demo.controller.ropita;
import com.example.demo.BeanRopa;
import com.example.demo.DaoRopa;
import com.example.demo.Response;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Path("/api/ropita")
public class RopitaServices {
    Map<String, Object> response = new HashMap<>();
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<BeanRopa> getAll(){
        System.out.println("jiijija");
        return  new DaoRopa().listacompleta();
    }
    @POST
    @Path("/hola")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String , Object> save(BeanRopa ropa){
        System.out.println(ropa.getNombre());
        Response<BeanRopa> result=new DaoRopa().save(ropa);
        response.put("result",result);
        return response;
    }

    @GET
    @Path("/find/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public BeanRopa getByid(@PathParam("id") long id){
        System.out.println("laides "+id);
        System.out.println(new DaoRopa().findone(id).getEstado());
        return new DaoRopa().findone(id);
    }
}
