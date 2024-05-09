
package DAO;
import Conexion.ConexionBD;
import Dominio.Pago;
import Dominio.Producto;
import Excepciones.PersistenciaException;
import IDAO.ICompraDAO;
import IDAO.IPagoDAO;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import java.util.ArrayList;
import java.util.List;
import org.bson.conversions.Bson;

/**
 *
 * @author Bell
 */
public class CompraDAO implements ICompraDAO {

    
    
    
    private final MongoCollection<Pago> coleccionPago;

    public CompraDAO() {
        this.coleccionPago = ConexionBD.getDatabase().getCollection("Pago", Pago.class);
    }
  
    public List<Pago> BuscarUsuario (String Usuario) throws PersistenciaException{
        List<Pago> Pago = new ArrayList<>();
        try {
             Bson filtro = Filters.regex("nombreUsuario", Usuario, "i");
            FindIterable<Pago> resultados = coleccionPago.find(filtro);
            for (Pago pago : resultados) {
                Pago.add(pago);
            }
        } catch (MongoException e) {
            throw new PersistenciaException("NO HAY" + e.getMessage());
        }
        return null;
        
    }
    
}
