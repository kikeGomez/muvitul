package mx.com.tecnetia.muvitul.negocio.taquilla.business;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo.UsuarioFirmadoVO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.BoletosXTicketDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.ExistenciaBoletoDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.ImpuestoBoletoDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.ImpuestosXTicketTaquillaDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.PagoDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.PromocionesXTicketDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.TicketVentaDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.BoletosXTicket;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.ExistenciaBoletos;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.ImpuestoBoleto;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.ImpuestosXTicketTaquilla;
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

	@Autowired
	private ExistenciaBoletoDAOI existenciaBoletoDAO;

	@Autowired
	private ImpuestosXTicketTaquillaDAOI impuestosXTicketTaquillaDAO;

	@Autowired
	private ImpuestoBoletoDAOI impuestoBoletoDAO;

	public Object createVenta(VentaVO ventaVO, UsuarioFirmadoVO usuarioVO) throws BusinessGlobalException {

		TicketVenta ticketVenta = ticketVentaDAO.save(TicketVentaAssembler.getTicketVenta(ventaVO.getTicketVentaVO()));

		// OK
		List<BoletosXTicket> boletosXTicket = BoletoXTicketAssembler.getBoletosXTicket(ventaVO.getBoletosXTicketVO());
		for (BoletosXTicket boletoXTicket : boletosXTicket) {
			boletoXTicket.setTicketVenta(ticketVenta);
			boletoXTicketDAO.save(boletoXTicket);
		}

		// OK
		List<PromocionesXTicket> promocionesXTicket = PromocionXTicketAssembler
				.getPromocionesXTicket(ventaVO.getPromocionesXTicketVO());
		for (PromocionesXTicket promocionXTicket : promocionesXTicket) {
			promocionXTicket.setTicketVenta(ticketVenta);
			promocionXTicketDAO.save(promocionXTicket);
		}

		// OK
		List<Pago> pagos = PagoAssembler.getPagos(ventaVO.getPagosVO());
		for (Pago pago : pagos) {
			pago.setTicketVenta(ticketVenta);
			pagoDAO.save(pago);
		}

		List<ImpuestoBoleto> impuestosBoletos = impuestoBoletoDAO.findByIdCine(usuarioVO.getCineVO().getIdCine());

		for (ImpuestoBoleto impuestoBoleto : impuestosBoletos) {
			ImpuestosXTicketTaquilla impuestosXTicketTaquilla = new ImpuestosXTicketTaquilla();
			impuestosXTicketTaquilla.setImpuestoBoleto(impuestoBoleto);
			impuestosXTicketTaquilla.setTicketVenta(ticketVenta);
			impuestosXTicketTaquilla.setImporte(new BigDecimal(0));
			impuestosXTicketTaquillaDAO.update(impuestosXTicketTaquilla);
		}

		ExistenciaBoletos existenciaBoletos = existenciaBoletoDAO.findByIdProgramacion(
				ventaVO.getBoletosXTicketVO().get(0).getPagramacionVO().getIdProgramacion(),
				ventaVO.getBoletosXTicketVO().get(0).getFechaExhibicion());
		existenciaBoletos.setBoletosReservados(ventaVO.getBoletosXTicketVO().size());
		existenciaBoletoDAO.update(existenciaBoletos);

		return ventaVO;
	}

}
