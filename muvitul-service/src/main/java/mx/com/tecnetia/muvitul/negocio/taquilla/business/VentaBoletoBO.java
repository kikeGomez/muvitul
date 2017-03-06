package mx.com.tecnetia.muvitul.negocio.taquilla.business;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.BoletosXTicketDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.PagoDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.PromocionesXTicketDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.TicketVentaDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.BoletosXTicket;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Pago;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.PromocionesXTicket;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.TicketVenta;
import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.negocio.taquilla.assembler.BoletoXTicketAssembler;
import mx.com.tecnetia.muvitul.negocio.taquilla.assembler.PagoAssembler;
import mx.com.tecnetia.muvitul.negocio.taquilla.assembler.PromocionXTicketAssembler;
import mx.com.tecnetia.muvitul.negocio.taquilla.assembler.TicketVentaAssembler;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.VentaVO;

@Service
@Transactional
public class VentaBoletoBO {
	final static Log log = LogFactory.getLog(PeliculaBO.class);

	@Autowired
	private TicketVentaDAOI ticketVentaDAO;

	@Autowired
	private PagoDAOI pagoDAO;

	@Autowired
	private BoletosXTicketDAOI boletoXTicketDAO;

	@Autowired
	private PromocionesXTicketDAOI promocionXTicketDAO;

	public Object createVenta(VentaVO ventaVO) throws BusinessGlobalException {

		TicketVenta ticketVenta = ticketVentaDAO.save(TicketVentaAssembler.getTicketVenta(ventaVO.getTicketVentaVO()));

		List<BoletosXTicket> boletosXTicket = BoletoXTicketAssembler.getBoletosXTicket(ventaVO.getBoletosXTicketVO());

		for (BoletosXTicket boletoXTicket : boletosXTicket) {
			boletoXTicket.setTicketVenta(ticketVenta);
			boletoXTicketDAO.save(boletoXTicket);
		}

		List<Pago> pagos = PagoAssembler.getPagos(ventaVO.getPagosVO());
		for (Pago pago : pagos) {
			pago.setTicketVenta(ticketVenta);
			pagoDAO.save(pago);
		}

		List <PromocionesXTicket>  promocionesXTicket= PromocionXTicketAssembler.getPromocionesXTicket(ventaVO.getPromocionesXTicketVO());
		for (PromocionesXTicket promocionXTicket : promocionesXTicket) {
			promocionXTicket.setTicketVenta(ticketVenta);
			promocionXTicketDAO.save(promocionXTicket);
		}
		
		return ventaVO;
	}

}
