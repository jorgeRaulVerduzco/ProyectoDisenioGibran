
package IDAO;

import Dominio.Pago;
import Excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author Bell
 */
public interface ICompraDAO {
    
    public List<Pago> BuscarUsuario (String Usuario) throws PersistenciaException;
}
