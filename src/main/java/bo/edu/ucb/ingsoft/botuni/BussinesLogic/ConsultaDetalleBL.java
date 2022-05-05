package bo.edu.ucb.ingsoft.botuni.BussinesLogic;
import bo.edu.ucb.ingsoft.botuni.DAO.DetalleDAO;
import bo.edu.ucb.ingsoft.botuni.DTO.DetalleDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component


public class ConsultaDetalleBL {






        private DetalleDAO DetalleDAO;

        @Autowired
        public ConsultaDetalleBL(DetalleDAO DetalleDAO) {
            this.DetalleDAO = DetalleDAO;
        }

        public List<DetalleDTO> findDetalleByBotChatId(Long chatId) {
            return DetalleDAO.findDetalleByBotChatId(chatId+"");
        }


    }



